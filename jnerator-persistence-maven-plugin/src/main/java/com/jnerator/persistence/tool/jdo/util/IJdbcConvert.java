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


import com.jnerator.persistence.tool.jdo.data.JdoColInfo;
import com.jnerator.persistence.tool.sql.data.TableColInfo;

/**
 * @author Loiez
 */
public interface IJdbcConvert {
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
	public String convert(JdoColInfo attInfo);

	/**
	 * Retourne les types java possibles pour le type SQL pass� en param�tre
	 * 
	 * @return
	 */
	public String[] getJavaPossTyp(TableColInfo attInfo);
}