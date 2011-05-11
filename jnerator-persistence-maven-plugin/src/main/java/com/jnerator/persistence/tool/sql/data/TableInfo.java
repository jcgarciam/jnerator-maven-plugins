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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jnerator.persistence.tool.sql.ConnectionInfo;
import com.jnerator.persistence.tool.sql.DatabaseInfo;

/**
 * Objet de donn�e repr�sentant la description d'une table
 * 
 * @author : eloiez@salto-consulting.com
 */
public class TableInfo {
	/*
	 * TABLE_CAT String => table catalog (may be null) TABLE_SCHEM String =>
	 * table schema (may be null) TABLE_NAME String => table name TABLE_TYPE
	 * String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE",
	 * "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM". REMARKS String
	 * => explanatory comment on the table
	 */
	/**
	 * le catalogue
	 */
	protected String tableCat;

	/**
	 * le sch�ma
	 */
	protected String tableShem;

	/**
	 * nom de la table
	 */
	protected String tableName;

	/**
	 * type de table. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL
	 * TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
	 */
	protected String tableType;

	/**
	 * commentaire
	 */
	protected String tableRemarks;

	/**
	 * information de connection
	 */
	protected ConnectionInfo connInfo;

	/**
	 * description des colonnes
	 */
	protected TableColInfo[] colInfos;

	/**
	 * les colonnes de la cl� primaire
	 */
	protected TablePK[] pk = null;

	/**
	 * les cl�s �trang�res
	 */
	protected TableFK[][] importedFk = null;

	/**
	 * les cl�s �trang�res (la table est ma�tre)
	 */
	protected TableFK[][] exportedFk = null;

	private Connection conn;

	private ShemaInfo shemaInfo;

	/**
	 * Commentaire relatif au constructeur TableInfo.
	 */
	public TableInfo() {
		super();
	}

	/**
	 * @param conn
	 */
	public TableInfo(ShemaInfo shemaInfo) {
		this.shemaInfo = shemaInfo;
		this.conn = shemaInfo.getConn();
		this.connInfo = shemaInfo.getConnInfo();
	}

	public TableInfo(TableInfo tableInfo) {
		this();
		tableCat = tableInfo.tableCat;
		tableShem = tableInfo.tableShem;
		tableName = tableInfo.tableName;
		tableType = tableInfo.tableType;
		tableRemarks = tableInfo.tableRemarks;
		connInfo = tableInfo.connInfo;
		colInfos = tableInfo.colInfos;
		pk = tableInfo.pk;
		importedFk = tableInfo.importedFk;
		exportedFk = tableInfo.exportedFk;

	}

	@Override
	public boolean equals(Object object) {
		return this.tableName.equals(((TableInfo) object).tableName);
	}

	/**
	 * retourne les colonnes qui sont autoincr�ment�s
	 * 
	 * @return
	 */
	public List getAutoIncrementCols() {
		ArrayList list = new ArrayList();
		for (int i = 0; i < colInfos.length; i++) {
			if (colInfos[i].isAutoIncrement()) {
				list.add(colInfos[i]);
			}
		}
		return list;
		// return (TableColInfo[]) list.toArray(new TableColInfo[list.size()]);
	}

	public TableColInfo[] getColInfos() {
		return getColInfos(true);
	}

	/**
	 * @return
	 */
	public TableColInfo[] getColInfos(boolean find) {
		if (find && (colInfos == null)) {
			colInfos = DatabaseInfo.getColumns(this);
		}
		return colInfos;
	}

	public int getColNum(String colName) {
		for (int i = 0; i < colInfos.length; i++) {
			if (colInfos[i].getColName().equals(colName)) {
				return colInfos[i].getColPosition();
			}
		}
		return -1;
	}

	/**
	 * @return Returns the conn.
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Gets the connInfo.
	 * 
	 * @return Returns a ConnectionInfo
	 */
	public ConnectionInfo getConnInfo() {
		return connInfo;
	}

	/**
	 * Gets the exported foreign keys.
	 * 
	 * @return Returns a TableFK[][]
	 */
	public TableFK[][] getExportedFk() {
		if (exportedFk == null)
			exportedFk = DatabaseInfo.getExportedFK(this);
		return exportedFk;
	}

	public TableFK[][] getFK() {
		try {
			ArrayList list = new ArrayList();
			Object[] obj = getImportedFk();
			if (obj != null)
				list.addAll(Arrays.asList(obj));
			obj = getExportedFk();
			if (obj != null)
				list.addAll(Arrays.asList(obj));
			return (TableFK[][]) list.toArray(new TableFK[list.size()][]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TableFK[0][0];
	}

	/**
	 * Gets the imported foreign keys.
	 * 
	 * @return Returns a TableFK[][]
	 */
	public TableFK[][] getImportedFk() {
		if (importedFk == null)
			importedFk = DatabaseInfo.getImportedFK(this);
		return importedFk;
	}

	/**
	 * Gets the primary key.
	 * 
	 * @return Returns a TablePK[]
	 */
	public TablePK[] getPk() {
		if (pk == null)
			pk = DatabaseInfo.getPK(this);
		return pk;
	}

	/**
	 * @return Returns the shemaInfo.
	 */
	public ShemaInfo getShemaInfo() {
		return shemaInfo;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableCat() {
		return tableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return tableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableRemarks() {
		return tableRemarks;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableShem() {
		return tableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableType() {
		return tableType;
	}

	@Override
	public int hashCode() {
		return this.tableName.hashCode();
	}

	/**
	 * @param infos
	 */
	public void setColInfos(TableColInfo[] infos) {
		colInfos = infos;
	}

	/**
	 * @param conn
	 *            The conn to set.
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Sets the connInfo.
	 * 
	 * @param connInfo
	 *            The connInfo to set
	 */
	public void setConnInfo(ConnectionInfo connInfo) {
		this.connInfo = connInfo;
	}

	/**
	 * @param shemaInfo
	 *            The shemaInfo to set.
	 */
	public void setShemaInfo(ShemaInfo shemaInfo) {
		this.shemaInfo = shemaInfo;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @param newTableCat
	 *            java.lang.String
	 */
	public void setTableCat(java.lang.String newTableCat) {
		tableCat = newTableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @param newTableName
	 *            java.lang.String
	 */
	public void setTableName(java.lang.String newTableName) {
		tableName = newTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @param newTableRemarks
	 *            java.lang.String
	 */
	public void setTableRemarks(java.lang.String newTableRemarks) {
		tableRemarks = newTableRemarks;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @param newTableShem
	 *            java.lang.String
	 */
	public void setTableShem(java.lang.String newTableShem) {
		tableShem = newTableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:21:29)
	 * 
	 * @param newTableType
	 *            java.lang.String
	 */
	public void setTableType(java.lang.String newTableType) {
		tableType = newTableType;
	}

}