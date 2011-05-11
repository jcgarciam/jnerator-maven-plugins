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

import com.jnerator.persistence.tool.sql.ConnectionInfo;
import com.jnerator.persistence.tool.sql.DatabaseInfo;

/**
 * @author eloiez@salto-consulting.com
 */
public class CatalogInfo {
	protected String catalog;

	protected ShemaInfo[] shemaInfos;

	protected ConnectionInfo connInfo;

	private TableInfo[] tableInfos;

	/**
	 * @param string
	 */
	public CatalogInfo(ConnectionInfo info, String catalog) {
		this.catalog = catalog;
		this.connInfo = info;
	}

	/**
	 * @return Returns the catalog.
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * @return Returns the conn.
	 */
	public ConnectionInfo getConnInfo() {
		return connInfo;
	}

	/**
	 * @return Returns the shemaInfos.
	 */
	public ShemaInfo[] getShemaInfos() {
		// shemaInfos = null;
		// if (shemaInfos == null) {
		// shemaInfos = DatabaseInfo.getShemas(this);
		// if (shemaInfos.length == 0) {
		// shemaInfos = new ShemaInfo[1];
		// shemaInfos[0] = new ShemaInfo(connInfo.getConn(),this);
		// shemaInfos[0].setName("");
		// shemaInfos[0].setCatalog(catalog);
		// }
		// }
		return shemaInfos;
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
	 * @param conn
	 *            The conn to set.
	 */
	public void setConnInfo(ConnectionInfo conn) {
		this.connInfo = conn;
	}

	/**
	 * @param shemaInfos
	 *            The shemaInfos to set.
	 */
	public void setShemaInfos(ShemaInfo[] shemaInfos) {
		this.shemaInfos = shemaInfos;
	}
}
