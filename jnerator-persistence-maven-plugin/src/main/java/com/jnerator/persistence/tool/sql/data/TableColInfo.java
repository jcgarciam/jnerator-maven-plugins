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

import java.sql.Types;

/**
 * Ins�rez la description du type � cet endroit. Date de cr�ation : (28/01/01
 * 17:01:21)
 * 
 * @author : Administrator
 */
public class TableColInfo {
	protected TableInfo tableInfo = null;
	protected String tableCat;
	protected String tableShem;
	protected String tableName;
	/**
	 * nom de la colonne
	 */
	protected String colName;
	/**
	 * type de colonne
	 */
	protected short colTyp;

	protected String typName;
	protected int colSize;
	protected int decDigit;
	protected int numPrecRadix;
	protected int colNullable;
	protected String colRemarks;
	protected String colDefaultVal;
	protected int colCharOctetLength;
	protected int colPosition;
	protected String colIsNullable;
	protected boolean autoIncrement;
	protected int pkColSeq = -1;

	public TableColInfo() {
	}

	/**
	 * Construction d'un colonne � partir d'un objet d�j� initialis� Ce
	 * constructeur doit normalement servir uniquement � construire une instance
	 * d'une superclasse de TableColInfo
	 */
	public TableColInfo(TableColInfo colInfo) {
		tableInfo = colInfo.tableInfo;
		tableCat = colInfo.tableCat;
		tableShem = colInfo.tableShem;
		tableName = colInfo.tableName;
		colName = colInfo.colName;
		colTyp = colInfo.colTyp;
		typName = colInfo.typName;
		colSize = colInfo.colSize;
		decDigit = colInfo.decDigit;
		numPrecRadix = colInfo.numPrecRadix;
		colNullable = colInfo.colNullable;
		colRemarks = colInfo.colRemarks;
		colDefaultVal = colInfo.colDefaultVal;
		colCharOctetLength = colInfo.colCharOctetLength;
		colPosition = colInfo.colPosition;
		colIsNullable = colInfo.colIsNullable;
	}

	/**
	 * Constructeur par d�faut de TableColInfo.
	 */
	public TableColInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

	public String createJavaTypName() {
		if ((colTyp == java.sql.Types.DATE) || (colTyp == java.sql.Types.TIME)
				|| (colTyp == java.sql.Types.TIMESTAMP)) {
			return "Timestamp";
		}
		if ((colTyp == java.sql.Types.NUMERIC)
				|| (colTyp == java.sql.Types.FLOAT)
				|| (colTyp == java.sql.Types.DECIMAL)
				|| (colTyp == java.sql.Types.REAL)) {
			if (decDigit > 0)
				return "Double";
			else
				return "Integer";
		}
		if ((colTyp == java.sql.Types.CHAR)
				|| (colTyp == java.sql.Types.LONGVARCHAR)
				|| (colTyp == java.sql.Types.VARCHAR)
				|| typName.equalsIgnoreCase("nvarchar"))
			return "String";
		if (colTyp == java.sql.Types.BIT)
			return "Boolean";
		if (colTyp == java.sql.Types.TINYINT)
			return "Byte";
		if (colTyp == java.sql.Types.SMALLINT)
			return "Short";
		if (colTyp == java.sql.Types.INTEGER)
			return "Integer";
		if (colTyp == java.sql.Types.BIGINT)
			return "Long";
		if ((colTyp == java.sql.Types.REAL) || (colTyp == java.sql.Types.FLOAT))
			return "Float";
		if (colTyp == java.sql.Types.DOUBLE)
			return "Double";
		if ((colTyp == java.sql.Types.BINARY)
				|| (colTyp == java.sql.Types.VARBINARY)
				|| (colTyp == java.sql.Types.LONGVARBINARY))
			return "byte[]";
		return typName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getColCharOctetLength() {
		return colCharOctetLength;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getColDefaultVal() {
		return colDefaultVal;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getColIsNullable() {
		return colIsNullable;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getColName() {
		return colName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getColNullable() {
		return colNullable;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getColPosition() {
		return colPosition;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getColRemarks() {
		return colRemarks;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getColSize() {
		return colSize;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return short
	 */
	public short getColTyp() {
		return colTyp;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return short
	 */
	public String getColTypName() {
		if (colTyp == Types.ARRAY) {
			return "ARRAY";
		} else if (colTyp == Types.BIGINT) {
			return "BIGINT";
		} else if (colTyp == Types.BINARY) {
			return "BINARY";
		} else if (colTyp == Types.BIT) {
			return "BIT";
		} else if (colTyp == Types.BLOB) {
			return "BLOB";
		} else if (colTyp == Types.BOOLEAN) {
			return "BOOLEAN";
		} else if (colTyp == Types.CHAR) {
			return "CHAR";
		} else if (colTyp == Types.CLOB) {
			return "CLOB";
		} else if (colTyp == Types.DATALINK) {
			return "DATALINK";
		} else if (colTyp == Types.DATE) {
			return "DATE";
		} else if (colTyp == Types.DECIMAL) {
			return "DECIMAL";
		} else if (colTyp == Types.DISTINCT) {
			return "DISTINCT";
		} else if (colTyp == Types.DOUBLE) {
			return "DOUBLE";
		} else if (colTyp == Types.FLOAT) {
			return "FLOAT";
		} else if (colTyp == Types.INTEGER) {
			return "INTEGER";
		} else if (colTyp == Types.JAVA_OBJECT) {
			return "JAVA_OBJECT";
		} else if (colTyp == Types.LONGVARBINARY) {
			return "LONGVARBINARY";
		} else if (colTyp == Types.LONGVARCHAR) {
			return "LONGVARCHAR";
		} else if (colTyp == Types.NULL) {
			return "NULL";
		} else if (colTyp == Types.NUMERIC) {
			return "NUMERIC";
		} else if (colTyp == Types.REAL) {
			return "REAL";
		} else if (colTyp == Types.REF) {
			return "REF";
		} else if (colTyp == Types.TIME) {
			return "TIME";
		} else if (colTyp == Types.TIMESTAMP) {
			return "TIMESTAMP";
		} else if (colTyp == Types.TINYINT) {
			return "TINYINT";
		} else if (colTyp == Types.VARBINARY) {
			return "VARBINARY";
		} else if (colTyp == Types.VARCHAR) {
			return "VARCHAR";
		}
		return "OTHER";
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getDecDigit() {
		return decDigit;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return int
	 */
	public int getNumPrecRadix() {
		return numPrecRadix;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 11:00:16)
	 * 
	 * @return int
	 */
	public int getPkColSeq() {
		return pkColSeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableCat() {
		return tableCat;
	}

	/**
	 * Gets the tableInfo.
	 * 
	 * @return Returns a TableInfo
	 */
	public TableInfo getTableInfo() {
		return tableInfo;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return tableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTableShem() {
		return tableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTypName() {
		return typName;
	}

	/**
	 * @return
	 */
	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	/**
	 * @param b
	 */
	public void setAutoIncrement(boolean b) {
		autoIncrement = b;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColCharOctetLength
	 *            int
	 */
	public void setColCharOctetLength(int newColCharOctetLength) {
		colCharOctetLength = newColCharOctetLength;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColDefaultVal
	 *            java.lang.String
	 */
	public void setColDefaultVal(java.lang.String newColDefaultVal) {
		colDefaultVal = newColDefaultVal;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColIsNullable
	 *            java.lang.String
	 */
	public void setColIsNullable(java.lang.String newColIsNullable) {
		colIsNullable = newColIsNullable;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColName
	 *            java.lang.String
	 */
	public void setColName(java.lang.String newColName) {
		colName = newColName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColNullable
	 *            int
	 */
	public void setColNullable(int newColNullable) {
		colNullable = newColNullable;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColPosition
	 *            int
	 */
	public void setColPosition(int newColPosition) {
		colPosition = newColPosition;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColRemarks
	 *            java.lang.String
	 */
	public void setColRemarks(java.lang.String newColRemarks) {
		colRemarks = newColRemarks;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColSize
	 *            int
	 */
	public void setColSize(int newColSize) {
		colSize = newColSize;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newColTyp
	 *            short
	 */
	public void setColTyp(short newColTyp) {
		colTyp = newColTyp;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newDecDigit
	 *            int
	 */
	public void setDecDigit(int newDecDigit) {
		decDigit = newDecDigit;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newNumPrecRadix
	 *            int
	 */
	public void setNumPrecRadix(int newNumPrecRadix) {
		numPrecRadix = newNumPrecRadix;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 11:00:16)
	 * 
	 * @param newPkColSeq
	 *            int
	 */
	public void setPkColSeq(int newPkColSeq) {
		pkColSeq = newPkColSeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newTableCat
	 *            java.lang.String
	 */
	public void setTableCat(java.lang.String newTableCat) {
		tableCat = newTableCat;
	}

	/**
	 * Sets the tableInfo.
	 * 
	 * @param tableInfo
	 *            The tableInfo to set
	 */
	public void setTableInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newTableName
	 *            java.lang.String
	 */
	public void setTableName(java.lang.String newTableName) {
		tableName = newTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newTableShem
	 *            java.lang.String
	 */
	public void setTableShem(java.lang.String newTableShem) {
		tableShem = newTableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 17:06:36)
	 * 
	 * @param newTypName
	 *            java.lang.String
	 */
	public void setTypName(java.lang.String newTypName) {
		typName = newTypName;
	}

}