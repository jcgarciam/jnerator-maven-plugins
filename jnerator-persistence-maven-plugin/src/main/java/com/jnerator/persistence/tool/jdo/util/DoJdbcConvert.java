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

package com.jnerator.persistence.tool.jdo.util;

import java.sql.Types;


import com.jnerator.persistence.tool.jdo.data.JdoColInfo;
import com.jnerator.persistence.tool.sql.data.TableColInfo;

/**
 * Ins�rez la description du type � cet endroit. Date de cr�ation : (20/10/01
 * 09:09:16)
 * 
 * @author : Administrator
 */
public class DoJdbcConvert implements IJdbcConvert {

	public static boolean booleanValue(String val) {
		if (val == null)
			return false;
		if (val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("O")
				|| val.equalsIgnoreCase("true") || val.equalsIgnoreCase("1")) {
			return true;
		}
		return false;
	}

	/**
	 * Commentaire relatif au constructeur DoJdbcConvert.
	 */
	public DoJdbcConvert() {
		super();
	}

	/**
	 * Cette m�thode permet de retourner la fonction du ResultSet qui sera
	 * utilis� pour r�cup�rer les donn�es. Cette m�thode a un impact sur les
	 * performances de la base de donn�e et cela d�pend de la mani�re dont est
	 * cr�� le driver JDBC Voici quelques informations concernant les
	 * diff�rentes fonctions possibles //non g�r� par les do Array getArray(int
	 * i) throws SQLException; Ref getRef(int i) throws SQLException;
	 * 
	 * les fonctions suivantes ne seront � priori jamais g�r� par les do car il
	 * est important de fermer les flux or ceci ne peut pas �tre fait
	 * automatiquement. Ces m�thodes sont donc r�serv�s � du travail
	 * d'expertise, l'invers des DO!!!! java.io.InputStream getAsciiStream(int
	 * columnIndex) throws SQLException; java.io.InputStream getBinaryStream(int
	 * columnIndex) throws SQLException; java.io.Reader getCharacterStream(int
	 * columnIndex) throws SQLException; java.io.InputStream
	 * getUnicodeStream(int columnIndex) throws SQLException;
	 * 
	 * 
	 * boolean getBoolean(int columnIndex) throws SQLException; byte getByte(int
	 * columnIndex) throws SQLException;
	 * 
	 * //stockage d'objet voir le package byte[] getBytes(int columnIndex)
	 * throws SQLException; Blob getBlob(int i) throws SQLException; Clob
	 * getClob(int i) throws SQLException;
	 * 
	 * //type primitif Ces m�thodes sont en r�gle g�n�rale les plus performantes
	 * short getShort(int columnIndex) throws SQLException; int getInt(int
	 * columnIndex) throws SQLException; long getLong(int columnIndex) throws
	 * SQLException; double getDouble(int columnIndex) throws SQLException;
	 * float getFloat(int columnIndex) throws SQLException;
	 * 
	 * String getString(int columnIndex) throws SQLException;
	 * 
	 * Seul un nombre exceptionnel justifie l'utilisation de ces m�thodes D'une
	 * mani�re g�n�rale, il faut essayer d'�viter ces m�thodes car 1 - Ces
	 * nombres sont peu pratiques � g�rer pour les d�veloppeurs 2 - ce n'est
	 * pas, en r�gle g�n�ral, les m�thodes les plus performantes pour les
	 * drivers
	 * 
	 * BigDecimal getBigDecimal(int columnIndex) throws SQLException; BigDecimal
	 * getBigDecimal(int columnIndex, int scale) throws SQLException;
	 * 
	 * A �viter pour des probl�mes de performance Cette m�thode est justement
	 * cr�� pour �viter l'utilisation de cette M�thode
	 * 
	 * Object getObject(int columnIndex) throws SQLException;
	 * 
	 * 
	 * 
	 * Attention aux types Time et Date qui comportent �norm�ment de m�thodes
	 * d�pr�ci�s Il est donc pr�f�rable de g�rer toutes les dates de mani�re
	 * uniforme avec le type Timestamp
	 * 
	 * java.sql.Time getTime(int columnIndex) throws SQLException;
	 * java.sql.Timestamp getTimestamp(int columnIndex) throws SQLException;
	 * java.sql.Date getDate(int columnIndex) throws SQLException;
	 * 
	 * Date de cr�ation : (20/10/01 09:10:54)
	 * 
	 * @return java.lang.String
	 * @param attInfo
	 *            salto.tool.jdo.JdoInfo
	 */
	public String convert(JdoColInfo attInfo) {
		/*
		 * BIT = -7; TINYINT = -6; SMALLINT = 5; INTEGER = 4; BIGINT = -5; FLOAT
		 * = 6; REAL = 7; DOUBLE = 8; NUMERIC = 2; DECIMAL = 3; CHAR = 1;
		 * VARCHAR = 12; LONGVARCHAR = -1; DATE = 91; TIME = 92; TIMESTAMP = 93;
		 * BINARY = -2; VARBINARY = -3; LONGVARBINARY = -4;
		 * 
		 * NULL = 0;
		 * 
		 * OTHER = 1111; JAVA_OBJECT = 2000; DISTINCT = 2001; STRUCT = 2002;
		 * ARRAY = 2003; BLOB = 2004; CLOB = 2005; REF = 2006;
		 */
		String result = null;
		switch (attInfo.getColTyp()) {
		case Types.TINYINT:
			result = "Byte";
			break;
		case Types.SMALLINT:
			result = "Short";
			break;
		case Types.INTEGER:
			result = "Integer";
			break;
		case Types.BIGINT:
			result = "Long";
			break;
		case Types.REAL:
			result = "Float";
			break;
		case Types.FLOAT:
		case Types.DOUBLE:
			result = "Double";
			break;
		case Types.DECIMAL:
		case Types.NUMERIC:
			if (attInfo.getDecDigit() == 0) {
				if (attInfo.getColSize() < 4)
					result = "Short";
				else if (attInfo.getColSize() < 10)
					result = "Integer";
				// else if (attInfo.getColSize() < 19) result = "Long";
				else
					result = "Long";

			} else {
				result = "Double";
			}
			break;
		case Types.BIT:
			result = "Boolean";
			break;
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			result = "String";
			break;
		case Types.BINARY:
		case Types.VARBINARY:
		case Types.LONGVARBINARY:
		case Types.BLOB:
			result = "byte[]";
			break;
		case Types.DATE:
		case Types.TIME:
		case Types.TIMESTAMP:
			result = "Timestamp";
			break;
		}
		if (result == null)
			result = "Object";
		if (attInfo.getColNullable() == 0) {
			if ("Integer".equals(result)) {
				result = "int";
			} else if ("String".equals(result)) {
				// ne rien faire
			} else {
				try {
					Class.forName("java.lang." + result);
					result = result.toLowerCase();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seesalto.tool.jdo.util.IJdbcConvert#getJavaPossTyp(salto.tool.sql.data.
	 * TableColInfo)
	 */
	public String[] getJavaPossTyp(TableColInfo attInfo) {
		switch (attInfo.getColTyp()) {
		case Types.TINYINT:
		case Types.SMALLINT:
		case Types.INTEGER:
		case Types.BIGINT:
		case Types.REAL:
		case Types.FLOAT:
		case Types.DOUBLE:
		case Types.DECIMAL:
		case Types.NUMERIC:
		case Types.BIT:
			if (booleanValue(attInfo.getColIsNullable())) {
				return new String[] { "byte", "short", "int", "long", "float",
						"double", "BigDecimal", "boolean", "String" };
			} else {
				return new String[] { "Byte", "Short", "Integer", "Long",
						"Float", "Double", "BigDecimal", "Boolean", "String" };
			}
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			if (booleanValue(attInfo.getColIsNullable())) {
				return new String[] { "byte", "short", "int", "long", "float",
						"double", "BigDecimal", "boolean", "String",
						"Timestamp" };
			} else {
				return new String[] { "Byte", "Short", "Integer", "Long",
						"Float", "Double", "BigDecimal", "Boolean", "String",
						"Timestamp" };
			}
		case Types.BINARY:
		case Types.VARBINARY:
		case Types.LONGVARBINARY:
			return new String[] { "String", "byte[]" };
		case Types.DATE:
		case Types.TIME:
		case Types.TIMESTAMP:
			return new String[] { "Time", "Date", "Timestamp" };
		}
		return null;
	}

}
