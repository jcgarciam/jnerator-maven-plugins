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

import com.jnerator.persistence.tool.jdo.util.CreatorUtil;

/**
 * Descriptionde la cl� primaire d'une table. Date de cr�ation : (10/02/01
 * 11:32:02)
 * 
 * @author : Administrator
 */
public class TablePK {
	/*
	 * PKTABLE_CAT String => primary key table catalog being imported (may be
	 * null) PKTABLE_SCHEM String => primary key table schema being imported
	 * (may be null) PKTABLE_NAME String => primary key table name being
	 * imported PKCOLUMN_NAME String => primary key column name being imported
	 * KEY_SEQ short => sequence number within foreign key PK_NAME String =>
	 * primary key name (may be null)
	 */
	private String cat = null;
	private String shem = null;
	private String table = null;
	private String col = null;

	private String javaAttName;

	private short keySeq = 0;
	private String pkName = null;

	/**
	 * Commentaire relatif au constructeur TablePK.
	 */
	public TablePK() {
		super();
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCat() {
		return cat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCol() {
		return col;
	}

	/**
	 * @return Returns the javaAttName.
	 */
	public String getJavaAttName() {
		if (javaAttName == null)
			javaAttName = CreatorUtil.getDoNameCreator().createJavaAttName(col);
		return javaAttName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 10:47:17)
	 * 
	 * @return short
	 */
	public short getKeySeq() {
		return keySeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 10:47:17)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkName() {
		return pkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getShem() {
		return shem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTable() {
		return table;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @param newCat
	 *            java.lang.String
	 */
	public void setCat(java.lang.String newCat) {
		cat = newCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @param newCol
	 *            java.lang.String
	 */
	public void setCol(java.lang.String newCol) {
		col = newCol;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 10:47:17)
	 * 
	 * @param newKeySeq
	 *            short
	 */
	public void setKeySeq(short newKeySeq) {
		keySeq = newKeySeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (30/09/01 10:47:17)
	 * 
	 * @param newPkName
	 *            java.lang.String
	 */
	public void setPkName(java.lang.String newPkName) {
		pkName = newPkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @param newShem
	 *            java.lang.String
	 */
	public void setShem(java.lang.String newShem) {
		shem = newShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (10/02/01 11:35:13)
	 * 
	 * @param newTable
	 *            java.lang.String
	 */
	public void setTable(java.lang.String newTable) {
		table = newTable;
	}
}