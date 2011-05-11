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

package com.jnerator.persistence.db.ant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.jnerator.persistence.db.plugin.IGeneratorPlugin;
import com.jnerator.persistence.db.plugin.Plugins;
import com.jnerator.persistence.tool.jdo.DataObjectCreate;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.sql.ConnectionInfo;
import com.jnerator.persistence.tool.sql.DatabaseInfo;
import com.jnerator.persistence.tool.sql.data.TableInfo;

/**
 * 
 * Ant task to generate Salto-DB DataObjects.
 * 
 * 
 * @author rflament
 * 
 */
public class DOGeneratorTask /* extends Task */{

	private String outputDir;

	private String packageName;

	private String driverClassName;

	private String jdbcUrl;

	private String login;

	private String password;

	private String tablesNames;

	private String schema;

	private String plugin;

	private String prefix;

	private String nameOffset;

	private String generateView = "true";

	private String followForeignKeys;

	private String maxDepth;

	private static final String DEFAULT_PLUGIN = "Salto-db";

	public void execute() /* throws BuildException */{

		log("Salto-DB ANT Generator - Salto Consulting");
		listPlugins();
		Connection defaultConn = null;

		String tmpl = DEFAULT_PLUGIN;

		if (plugin != null) {
			tmpl = plugin;
		}

		try {

			ConnectionInfo connectionInfo = new ConnectionInfo(driverClassName,
					jdbcUrl, login, password, schema);

			Class.forName(driverClassName);
			defaultConn = DriverManager.getConnection(jdbcUrl, login, password);

			connectionInfo.setConn(defaultConn);

			log("Successfully connected to database");

			String tableNames[] = tablesNames.split(",");

			Set set = new HashSet();
			for (int k = 0; k < tableNames.length; k++) {
				TableInfo[] tableInfos = DatabaseInfo.getTables(defaultConn,
						null, schema, tableNames[k]);
				log(tableInfos.length + " table(s) found for table name '"
						+ tableNames[k] + "'");

				set.addAll(Arrays.asList(tableInfos));
			}

			TableInfo[] tableInfos = (TableInfo[]) set
					.toArray(new TableInfo[set.size()]);

			IGeneratorPlugin p = Plugins.getInstance().getPlugin(plugin);
			if (p == null) {
				throw new Exception("Cannot find plugin " + plugin);
			}

			log("******************************************");
			log(p.getShortDescription());
			log("******************************************");

			if (prefix == null) {
				prefix = p.getDefaultPrefix();
			}

			int nameOffsetInt = 0;

			if (this.nameOffset != null) {
				nameOffsetInt = Integer.parseInt(nameOffset);
			}

			// JdoInfo[] jdoInfos = new JdoInfo[tableInfos.length];

			List jdoInfos = new ArrayList();
			boolean genView = Boolean.parseBoolean(generateView);

			for (int j = 0; j < tableInfos.length; j++) {

				if (!tableInfos[j].getTableType().equalsIgnoreCase("VIEW")
						&& !tableInfos[j].getTableType().equalsIgnoreCase(
								"TABLE")) {
					continue;
				}
				if (!genView && tableInfos[j].getTableType().equals("VIEW")) {
					log("Not applying plugin '"
							+ tmpl
							+ "' to "
							+ tableInfos[j].getTableType()
							+ " '"
							+ tableInfos[j].getTableName()
							+ "' because it's a view and generateView is set to false.");
				} else {
					try {
						log("Applying plugin '" + tmpl + "' to "
								+ tableInfos[j].getTableType() + " '"
								+ tableInfos[j].getTableName() + "'");

						tableInfos[j].setConnInfo(connectionInfo);

						JdoInfo jdoInfo = DataObjectCreate
								.createJdoInfoFromTableInfo(tableInfos[j]);
						jdoInfos.add(jdoInfo);
					} catch (Exception e) {
						log("Skipping " + tableInfos[j].getTableType() + " '"
								+ tableInfos[j].getTableName()
								+ "' because it throws an error " + e);
					}
				}
			}
			if (jdoInfos.size() > 0) {
				Integer maxDepthf = null;
				if ((followForeignKeys != null)
						&& Boolean.valueOf(followForeignKeys).booleanValue()) {
					log("followForeignKeys enabled");
					if (maxDepth != null) {
						maxDepthf = Integer.valueOf(this.maxDepth);
						log("maxDepth = " + maxDepthf);
					}

				} else {
					maxDepthf = new Integer(0);
				}

				new DataObjectCreate().creerDoSimple(prefix, nameOffsetInt,
						getBaseDir() + "/" + outputDir, packageName,
						(JdoInfo[]) jdoInfos.toArray(new JdoInfo[jdoInfos
								.size()]), tmpl, maxDepthf);
			}

		} catch (Exception e) {
			log(e.getMessage());
			/* throw new BuildException(e); */
		}

		finally {
			try {
				log("Closing connection to database");
				defaultConn.close();
			} catch (Exception e) {

			}

		}

	}

	private String getBaseDir() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getFollowForeignKeys() {
		return followForeignKeys;
	}

	public String getGenerateView() {
		return generateView;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getLogin() {
		return login;
	}

	public String getMaxDepth() {
		return maxDepth;
	}

	public String getNameOffset() {
		return nameOffset;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getPassword() {
		return password;
	}

	public String getPlugin() {
		return plugin;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSchema() {
		return schema;
	}

	public String getTablesNames() {
		return tablesNames;
	}

	public void listPlugins() {
		log("-----------------------------------------");
		log("Loaded Plugins : ");
		for (Iterator i = Plugins.getInstance().getPlugins().entrySet()
				.iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry) i.next();
			log((String) entry.getKey());
		}
		log("-----------------------------------------");
	}

	private void log(String msg) {
	}

	private void log(String msg, Object o) {
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setFollowForeignKeys(String followForeignKeys) {
		this.followForeignKeys = followForeignKeys;
	}

	public void setGenerateView(String generateView) {
		this.generateView = generateView;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMaxDepth(String maxDepth) {
		this.maxDepth = maxDepth;
	}

	public void setNameOffset(String nameOffset) {
		this.nameOffset = nameOffset;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setTablesNames(String tablesNames) {
		this.tablesNames = tablesNames;
	}

}
