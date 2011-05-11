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
 * Ins�rez la description du type � cet endroit. Date de cr�ation : (3/02/01
 * 11:30:41)
 * 
 * @author : Administrator
 */
public class TableFK {
	String pkTableCat;

	String pkTableShem;

	String pkTableName;

	String pkColumnName;

	String fkTableCat;

	String fkTableShem;

	String fkTableName;

	String fkColumnName;

	short keySeq;

	String pkName;

	String fkName;

	private String javaAttName;

	/**
	 * Commentaire relatif au constructeur TableFK.
	 */
	public TableFK() {
		super();
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFkColumnName() {
		return fkColumnName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFkName() {
		return fkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFkTableCat() {
		return fkTableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFkTableName() {
		return fkTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFkTableShem() {
		return fkTableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return short
	 */
	public short getKeySeq() {
		return keySeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkColumnName() {
		return pkColumnName;
	}

	/**
	 * @return Returns the javaAttName.
	 */
	public String getPkJavaAttName() {
		if (javaAttName == null)
			javaAttName = CreatorUtil.getDoNameCreator().createJavaAttName(
					pkColumnName);
		return javaAttName;
	}

	public String getPkJavaClassName() {
		return CreatorUtil.getDoNameCreator().createDoName(pkTableName);
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkName() {

		return pkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkTableCat() {
		return pkTableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkTableName() {
		return pkTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPkTableShem() {
		return pkTableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newFkColumnName
	 *            java.lang.String
	 */
	public void setFkColumnName(java.lang.String newFkColumnName) {
		fkColumnName = newFkColumnName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newFkName
	 *            java.lang.String
	 */
	public void setFkName(java.lang.String newFkName) {
		fkName = newFkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newFkTableCat
	 *            java.lang.String
	 */
	public void setFkTableCat(java.lang.String newFkTableCat) {
		fkTableCat = newFkTableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newFkTableName
	 *            java.lang.String
	 */
	public void setFkTableName(java.lang.String newFkTableName) {
		fkTableName = newFkTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newFkTableShem
	 *            java.lang.String
	 */
	public void setFkTableShem(java.lang.String newFkTableShem) {
		fkTableShem = newFkTableShem;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newKeySeq
	 *            short
	 */
	public void setKeySeq(short newKeySeq) {
		keySeq = newKeySeq;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newPkColumnName
	 *            java.lang.String
	 */
	public void setPkColumnName(java.lang.String newPkColumnName) {
		pkColumnName = newPkColumnName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newPkName
	 *            java.lang.String
	 */
	public void setPkName(java.lang.String newPkName) {
		pkName = newPkName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newPkTableCat
	 *            java.lang.String
	 */
	public void setPkTableCat(java.lang.String newPkTableCat) {
		pkTableCat = newPkTableCat;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newPkTableName
	 *            java.lang.String
	 */
	public void setPkTableName(java.lang.String newPkTableName) {
		pkTableName = newPkTableName;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:33:40)
	 * 
	 * @param newPkTableShem
	 *            java.lang.String
	 */
	public void setPkTableShem(java.lang.String newPkTableShem) {
		pkTableShem = newPkTableShem;
	}

}