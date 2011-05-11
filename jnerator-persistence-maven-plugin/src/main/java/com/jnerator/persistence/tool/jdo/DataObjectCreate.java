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

package com.jnerator.persistence.tool.jdo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.jnerator.persistence.db.plugin.IGeneratorPlugin;
import com.jnerator.persistence.db.plugin.Plugins;
import com.jnerator.persistence.tool.jdo.data.JdoColInfo;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.jdo.util.CreatorUtil;
import com.jnerator.persistence.tool.sql.DatabaseInfo;
import com.jnerator.persistence.tool.sql.data.TableColInfo;
import com.jnerator.persistence.tool.sql.data.TableFK;
import com.jnerator.persistence.tool.sql.data.TableInfo;

/**
 * Object capable de générer les codes des DataObject et de les réfléchir (i.e.
 * extraire et interpréter leurs propriétés) Date de création : (7/02/01
 * 17:55:05)
 * 
 * @author : E.Loiez
 */
public class DataObjectCreate {
	public static final String NEW_LINE = "\r\n";

	/**
	 * @exception
	 * @author
	 * @deprecated Insérez la description de la méthode à cet endroit. Date de
	 *             création : (20/03/01 17:09:16)
	 * @return int
	 * @param sqlTyp
	 *            int
	 * @roseuid 3C025B6D030E
	 */
	@Deprecated
	public static String convert(int sqlTyp) {
		String result = null;
		switch (sqlTyp) {
		case java.sql.Types.BIGINT: {
			result = "Long";
			break;
		}
		case java.sql.Types.NUMERIC:
		case java.sql.Types.DECIMAL: {
			result = "BigDecimal";
			break;
		}
		case java.sql.Types.CHAR:
		case java.sql.Types.VARCHAR:
		case java.sql.Types.LONGVARCHAR: {
			result = "String";
			break;
		}
		case java.sql.Types.DATE:
		case java.sql.Types.TIME:
		case java.sql.Types.TIMESTAMP: {
			result = "Timestamp";
			break;
		}
		case java.sql.Types.DOUBLE: {
			result = "Double";
			break;
		}
		case java.sql.Types.FLOAT: {
			result = "Float";
			break;
		}
		case java.sql.Types.INTEGER: {
			result = "Integer";
			break;
		}
		case java.sql.Types.SMALLINT: {
			result = "Short";
			break;
		}
		default: {
			// a compl�ter
			// System.out.println(tbi[i].getTypName());
		}
		}
		return result;
	}

	/**
	 * @exception
	 * @author
	 * @deprecated Retourne la conversion pour . Date de création : (20/03/01
	 *             17:09:16)
	 * @return int
	 * @param sqlTyp
	 *            int
	 * @roseuid 3C025B6D0313
	 */
	@Deprecated
	public static String convertSet(int sqlTyp) {
		String result = "";
		switch (sqlTyp) {
		case java.sql.Types.BIGINT:
		case java.sql.Types.DECIMAL: {
			result = "setBigDecimal";
			break;
		}
		case java.sql.Types.CHAR:
		case java.sql.Types.VARCHAR: {
			result = "setString";
			break;
		}
		case java.sql.Types.DATE:
		case java.sql.Types.TIME:
		case java.sql.Types.TIMESTAMP: {
			result = "setTimestamp";
			break;
		}
		case java.sql.Types.DOUBLE: {
			result = "setDouble";
			break;
		}
		case java.sql.Types.FLOAT:
		case java.sql.Types.NUMERIC: {
			result = "setFloat";
			break;
		}
		case java.sql.Types.INTEGER: {
			result = "setInt";
			break;
		}
		case java.sql.Types.SMALLINT: {
			result = "setShort";
			break;
		}
		default: {
			// a compl�ter
			// System.out.println(tbi[i].getTypName());
		}
		}

		return result;
	}

	public static JdoInfo createJdoInfoFromTableInfo(TableInfo tableInfo) {

		TableColInfo[] colInfos = DatabaseInfo.getColumns(tableInfo);
		if (colInfos != null) {
			tableInfo.setColInfos(colInfos);
			JdoInfo jdoInfo = new JdoInfo(tableInfo);
			JdoColInfo[] infos = new JdoColInfo[colInfos.length];
			for (int i = 0; i < colInfos.length; i++) {
				infos[i] = new JdoColInfo(colInfos[i]);
			}

			return jdoInfo;
		} else {
			System.out.println("Skipping " + tableInfo.getTableType() + " '"
					+ tableInfo.getTableName()
					+ "' because it was not possible to read it.");
			return null;
		}

	}

	/**
	 * Constructeur implicite
	 */
	public DataObjectCreate() {
		super();
	}

	/**
	 * Méthode permettant de générer les dataobjects Date de création : (7/02/01
	 * 17:55:57)
	 * 
	 * @param compName
	 *            java.lang.String le nom du composant
	 * @param infos
	 *            salto.tool.jdo.JdoInfo[] informations sur les attributs java
	 *            et le mappage de la base de donn�e
	 * @return void
	 * @exception JdoCreateException
	 *                ,IdeException
	 */
	public void creerDoSimple(String doPrefix, int defaultNameOffset,
			String srcPath, String pckName, JdoInfo[] jdoInfos,
			String pluginName, Integer maxExtendIteration)
			throws JdoCreateException {

		int size = jdoInfos.length;
		int previousSize = 0;
		int i = 0;

		while ((size > previousSize)
				&& (((maxExtendIteration != null) && (i < maxExtendIteration
						.intValue())) || (maxExtendIteration == null))) {
			jdoInfos = extend(jdoInfos);
			previousSize = size;
			size = jdoInfos.length;
			i++;
		}

		IGeneratorPlugin plugin = null;
		try {
			plugin = Plugins.getInstance().getPlugin(pluginName);
			if (plugin != null) {
				plugin.init(doPrefix, defaultNameOffset, srcPath, pckName);
				for (int j = 0; j < jdoInfos.length; j++) {

					String doName = CreatorUtil.getDoNameCreator()
							.createDoName(jdoInfos[j].getTableName(), doPrefix,
									defaultNameOffset);
					plugin.execute(doName, jdoInfos[j]);
				}

				plugin.postExecute(jdoInfos);

			} else
				System.out.println("Cannot find plugin " + pluginName);
		} catch (Exception e) {
			if (plugin != null) {
				try {
					plugin.abort();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}

	}

	/**
	 * TODO : this code is ugly
	 * 
	 * @param jdoInfos
	 * @return
	 */
	private JdoInfo[] extend(JdoInfo[] jdoInfos) {
		Set tablesNames = new HashSet();
		Set addedTablesNames = new HashSet();

		try {
			List jdo = new ArrayList();

			for (int j = 0; j < jdoInfos.length; j++) {
				tablesNames.add(jdoInfos[j].getTableName());
			}

			for (int j = 0; j < jdoInfos.length; j++) {

				TableFK[][] fks = jdoInfos[j].getFK();
				for (int i = 0; i < fks.length; i++) {
					for (int k = 0; k < fks[i].length; k++) {

						String newTableName = fks[i][k].getPkTableName();

						if (fks[i][k].getPkTableName().equals(
								jdoInfos[j].getTableName())) {
							newTableName = fks[i][k].getFkTableName();
						}

						boolean already = tablesNames.contains(newTableName);
						if (!already) {
							addedTablesNames.add(newTableName);
							System.out.println("Adding table " + newTableName
									+ " as it is needed by table "
									+ jdoInfos[j].getTableName());

						}
					}

				}

			}

			ArrayList list = new ArrayList();
			for (Iterator iterator = addedTablesNames.iterator(); iterator
					.hasNext();) {
				String string = (String) iterator.next();
				TableInfo[] tableInfos = DatabaseInfo.getTables(jdoInfos[0]
						.getConnInfo().getConn(), null, jdoInfos[0]
						.getTableShem(), string);
				list.addAll(Arrays.asList(tableInfos));
			}

			TableInfo[] tableInfos = (TableInfo[]) list
					.toArray(new TableInfo[list.size()]);

			for (int f = 0; f < tableInfos.length; f++) {
				tableInfos[f].setConnInfo(jdoInfos[0].getConnInfo());
				JdoInfo jdoInfo = DataObjectCreate
						.createJdoInfoFromTableInfo(tableInfos[f]);
				jdo.add(jdoInfo);
			}

			if (!jdo.isEmpty()) {
				jdo.addAll(Arrays.asList(jdoInfos));
				jdoInfos = (JdoInfo[]) jdo.toArray(new JdoInfo[jdo.size()]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return jdoInfos;

	}

}
