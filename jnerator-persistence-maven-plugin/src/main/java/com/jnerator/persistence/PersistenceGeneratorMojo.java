/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jnerator.persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.jnerator.persistence.db.plugin.IGeneratorPlugin;
import com.jnerator.persistence.db.plugin.Plugins;
import com.jnerator.persistence.tool.jdo.DataObjectCreate;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.sql.ConnectionInfo;
import com.jnerator.persistence.tool.sql.DatabaseInfo;
import com.jnerator.persistence.tool.sql.data.TableInfo;

/**
 * Generate persistence layer code based on the specified plugin
 * 
 * @goal generate
 * 
 * @phase generate-sources
 */
public class PersistenceGeneratorMojo extends AbstractMojo {
    /**
     * Location of the generated persistence artifacts.
     * 
     * @parameter expression="${basedir}/src/main/persistence-generator/"
     *            alias="outputDirectory"
     * @required
     */
    private File    outputDirectory;

    /**
     * Package base name for generated artifacts.
     * 
     * @parameter expression="${project.groupId}.persistence"
     *            alias="packageName"
     * @required
     */
    private String  packageName;

    /**
     * Class name of the jdbc driver to use (i.e. com.mysql.jdbc.Driver for
     * MySQL, oracle.jdbc.OracleDriver for Oracle, org.postgresql.Driver for
     * Postgresql, etc.)
     * 
     * @parameter alias="driverClassName"
     * @required
     */
    private String  driverClassName;

    /**
     * The jdbc url to extract database model information
     * 
     * @parameter alias="jdbcUrl"
     * @required
     */
    private String  jdbcUrl;

    /**
     * The user login to connect to the underlying database
     * 
     * @parameter alias="login"
     * @required
     */
    private String  login;

    /**
     * The user password to connect to the underlying database
     * 
     * @parameter default-value="" alias="password"
     */
    private String  password;

    /**
     * A pattern to search for tables. You can use the joker character '%'. If
     * you want to generate DataObjects for every tables, just set '%'
     * 
     * @parameter expression="" default-value="%" alias="tablesNames"
     * @required
     */
    private String  tablesNames;

    /**
     * The name of your database schema
     * 
     * @parameter expression="" default-value="" alias="schema"
     */
    private String  schema;

    /**
     * The plugin to use for the artifacts generation.
     * 
     * @parameter expression="EJB3AndHibernateDao"
     *            default-value="EJB3AndHibernateDao" alias="plugin"
     * @required
     */
    private String  plugin;

    /**
     * You can choose a prefix that will be added to every classes that the
     * plugin considers as a table. As an example if you run the Hibernate
     * plugin on a table named "PERSON", a pojo mapping this table will be
     * generated. By default its name would be "Person" but if you set a prefix
     * the generated name will be prefix+"Person".
     * 
     * @parameter alias="prefix" alias="prefix"
     */
    private String  prefix;

    /**
     * You can set an offset to ignore first characters of table names. As an
     * example if you run the Hibernate plugin on a table named "TB_PERSON", a
     * pojo mapping this table will be generated. By default its name would be
     * "TbPerson" but if you set nameOffset to 3, the generated name will be
     * "Person" because the first characters "TB_" have been ignored.
     * 
     * 
     * @parameter expression="0" default-value="0" alias="nameOffset"
     */
    private int     nameOffset;

    /**
     * If set to true, the Generator will follow foreign keys on table to
     * retrieve dependants tables to execute plugin on them as well. It is
     * recursive (see maxDepth).
     * 
     * @parameter expression="false" alias="followForeignKeys"
     */
    private boolean followForeignKeys;

    /**
     * When you set followForeignKeys to true, you need to set a max depth to
     * retrieve dependants table, otherwise you will retrieve the whole
     * database.
     * 
     * @parameter expression="0" default-value="0" alias="maxDepth"
     */
    private int     maxDepth;

    /**
     * If set to false, views will be ignored by the Generator. Default is true.
     * 
     * @parameter expression="true" default-value="true" alias="generateView"
     */
    private boolean generateView;

    public void execute() throws MojoExecutionException {
        getLog().info("Salto-DB ANT Generator - Salto Consulting");
        getLog().info("Generating artifacts in: " + outputDirectory);
        listPlugins();
        Connection defaultConn = null;

        try {

            ConnectionInfo connectionInfo = new ConnectionInfo(driverClassName, jdbcUrl, login, password, schema);

            try {
                getLog().debug("Loading driver: " + driverClassName);
                Class.forName(driverClassName);
            } catch (Exception e) {
                throw new MojoExecutionException("Unable to load JDBC driver=" + driverClassName);
            }
            defaultConn = DriverManager.getConnection(jdbcUrl, login, password);

            connectionInfo.setConn(defaultConn);

            getLog().info("Successfully connected to database");

            String tableNames[] = tablesNames.split(",");

            Set set = new HashSet();
            for (int k = 0; k < tableNames.length; k++) {
                TableInfo[] tableInfos = DatabaseInfo.getTables(defaultConn, null, schema, tableNames[k]);
                getLog().info(tableInfos.length + " table(s) found for table name '" + tableNames[k] + "'");

                set.addAll(Arrays.asList(tableInfos));
            }

            TableInfo[] tableInfos = (TableInfo[]) set.toArray(new TableInfo[set.size()]);

            IGeneratorPlugin p = Plugins.getInstance().getPlugin(plugin);
            if (p == null) {
                throw new Exception("Cannot find plugin " + plugin);
            }

            getLog().info("******************************************");
            getLog().info(p.getShortDescription());
            getLog().info("******************************************");

            if (prefix == null) {
                prefix = p.getDefaultPrefix();
            }

            // JdoInfo[] jdoInfos = new JdoInfo[tableInfos.length];

            List jdoInfos = new ArrayList();

            for (int j = 0; j < tableInfos.length; j++) {

                if (!tableInfos[j].getTableType().equalsIgnoreCase("VIEW")
                        && !tableInfos[j].getTableType().equalsIgnoreCase("TABLE")) {
                    continue;
                }
                if (!generateView && tableInfos[j].getTableType().equals("VIEW")) {

                    getLog().info(
                            "Not applying plugin '" + plugin + "' to " + tableInfos[j].getTableType() + " '"
                                    + tableInfos[j].getTableName() + "' because it's a view and generateView is set to false.");
                } else {

                    try {

                        getLog().info(
                                "Applying plugin '" + plugin + "' to " + tableInfos[j].getTableType() + " '"
                                        + tableInfos[j].getTableName() + "'");

                        tableInfos[j].setConnInfo(connectionInfo);

                        JdoInfo jdoInfo = DataObjectCreate.createJdoInfoFromTableInfo(tableInfos[j]);
                        jdoInfos.add(jdoInfo);
                    } catch (Exception e) {
                        getLog().info(
                                "Skipping " + tableInfos[j].getTableType() + " '" + tableInfos[j].getTableName()
                                        + "' because it throws an error " + e);
                    }
                }
            }

            if (jdoInfos.size() > 0) {
                if (followForeignKeys) {
                    getLog().info("followForeignKeys enabled");
                    if (this.maxDepth > 0) {
                        getLog().info("maxDepth = " + this.maxDepth);
                    }

                } else {
                    this.maxDepth = 0;
                }

                new DataObjectCreate().creerDoSimple(prefix, nameOffset, outputDirectory.getPath(), packageName,
                        (JdoInfo[]) jdoInfos.toArray(new JdoInfo[jdoInfos.size()]), plugin, maxDepth);
            }

        } catch (Exception e) {
            getLog().error("Unexpected error: " + e.getMessage());
            throw new MojoExecutionException(e.getMessage(), e);
        }

        finally {
            try {
                getLog().info("Closing connection to database");
                defaultConn.close();
            } catch (Exception e) {

            }

        }
    }

    public void listPlugins() {
        getLog().info("-----------------------------------------");
        getLog().info("Loaded Plugins : ");
        for (Iterator i = Plugins.getInstance().getPlugins().entrySet().iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry) i.next();
            getLog().info((String) entry.getKey());
        }
        getLog().info("-----------------------------------------");
    }
}
