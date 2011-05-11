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

package com.jnerator.persistence.tool.jdo.data;


import com.jnerator.persistence.tool.jdo.util.CreatorUtil;
import com.jnerator.persistence.tool.sql.data.TableColInfo;

/**
 * @author Loiez
 */
public class JdoColInfo extends TableColInfo {
	/**
	 * classe java de l'attribut
	 */
	private String javaAttClass;
	/**
	 * classes java possible pour l'attribut
	 */
	private String[] javaPossTyp;
	/**
	 * Nom de la constante java
	 */
	private String javaAttCteName;
	/**
	 * nom de l'attribut java (d�duit du nom de la colonne)
	 */
	private String javaAttName;

	public JdoColInfo() {
	}

	public JdoColInfo(TableColInfo colInfo) {
		autoIncrement = colInfo.isAutoIncrement();
		tableCat = colInfo.getTableCat();
		tableShem = colInfo.getTableShem();
		tableName = colInfo.getTableName();
		colName = colInfo.getColName();
		colTyp = colInfo.getColTyp();
		typName = colInfo.getTypName();
		colSize = colInfo.getColSize();
		decDigit = colInfo.getDecDigit();
		numPrecRadix = colInfo.getNumPrecRadix();
		colNullable = colInfo.getColNullable();
		colRemarks = colInfo.getColRemarks();
		colDefaultVal = colInfo.getColDefaultVal();
		colCharOctetLength = colInfo.getColCharOctetLength();
		colPosition = colInfo.getColPosition();
		colIsNullable = colInfo.getColIsNullable();
	}

	/**
	 * @return Returns the javaTypName.
	 */
	public String getJavaAttClass() {
		if (javaAttClass == null)
			javaAttClass = CreatorUtil.getJdbcConvert().convert(this);
		return javaAttClass;
	}

	/**
	 * retourne le nom de la constante java
	 * 
	 * @return Returns the javaAttCteName.
	 */
	public String getJavaAttCteName() {
		if (javaAttCteName == null)
			javaAttCteName = CreatorUtil.getDoNameCreator().createJavaCteName(
					getJavaAttName());

		return javaAttCteName;
	}

	/**
	 * @return Returns the javaAttName.
	 */
	public String getJavaAttName() {
		if (javaAttName == null)
			javaAttName = CreatorUtil.getDoNameCreator().createJavaAttName(
					colName);
		return javaAttName;
	}

	/**
	 * @return Returns the javaPossTyp.
	 */
	public String[] getJavaPossTyp() {
		if (javaPossTyp == null)
			javaPossTyp = CreatorUtil.getJdbcConvert().getJavaPossTyp(this);
		return javaPossTyp;
	}

	public String getNonPrimitifClass() {
		if (getJavaAttClass().equals("byte"))
			return "Byte";
		if (getJavaAttClass().equals("boolean"))
			return "Boolean";
		if (getJavaAttClass().equals("short"))
			return "Short";
		if (getJavaAttClass().equals("int"))
			return "Integer";
		if (getJavaAttClass().equals("long"))
			return "Long";
		if (getJavaAttClass().equals("float"))
			return "Float";
		if (getJavaAttClass().equals("double"))
			return "Double";
		return getJavaAttClass();
	}

	public String getterMethod() {
		return "get" + Character.toUpperCase(getJavaAttName().charAt(0))
				+ getJavaAttName().substring(1);
	}

	public boolean isPrimitif() {
		if (getJavaAttClass().equals("byte"))
			return true;
		if (getJavaAttClass().equals("boolean"))
			return true;
		if (getJavaAttClass().equals("short"))
			return true;
		if (getJavaAttClass().equals("int"))
			return true;
		if (getJavaAttClass().equals("long"))
			return true;
		if (getJavaAttClass().equals("float"))
			return true;
		if (getJavaAttClass().equals("double"))
			return true;
		return false;
	}

	public String setterMethod() {
		return "set" + Character.toUpperCase(getJavaAttName().charAt(0))
				+ getJavaAttName().substring(1);
	}
}
