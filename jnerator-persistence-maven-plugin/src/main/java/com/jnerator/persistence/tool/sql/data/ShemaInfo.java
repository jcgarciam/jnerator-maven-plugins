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

package com.jnerator.persistence.tool.sql.data;

import java.sql.Connection;

import com.jnerator.persistence.tool.sql.ConnectionInfo;
import com.jnerator.persistence.tool.sql.DatabaseInfo;

/**
 * @author eloiez@salto-consulting.com
 */
public class ShemaInfo {
	public String catalog;
	public String name;
	public TableInfo[] tableInfos;

	private final ConnectionInfo connInfo;

	/**
	 * @param connection
	 * @param info
	 */
	public ShemaInfo(ConnectionInfo connInfo) {
		this.connInfo = connInfo;
	}

	/**
	 * @return Returns the catalog.
	 */
	public String getCatalog() {
		return catalog;
	}

	public Connection getConn() {
		return connInfo.getConn();
	}

	/**
	 * @return Returns the connInfo.
	 */
	public ConnectionInfo getConnInfo() {
		return connInfo;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	public TableInfo[] getTableInfos() {
		return getTableInfos(true);
	}

	/**
	 * @return Returns the tableInfos.
	 */
	public TableInfo[] getTableInfos(boolean find) {
		if (find && (tableInfos == null)) {
			tableInfos = DatabaseInfo.getTables(this);
		}
		return tableInfos;
	}

	/**
	 * @param catalog
	 *            The catalog to set.
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param tableInfos
	 *            The tableInfos to set.
	 */
	public void setTableInfos(TableInfo[] tableInfos) {
		this.tableInfos = tableInfos;
	}

}
