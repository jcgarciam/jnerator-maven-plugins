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

/**
 * @author Loiez
 */
public interface IDoNameCreator {
	public abstract String class2attribute(String className);

	/**
	 * Retourne le nom d'un do en fonction du nom d'une table
	 * 
	 * @return String
	 */
	public abstract String createDoName(String tableName);

	/**
	 * Retourne le nom d'un do en fonction du nom d'une table
	 * 
	 * @return String
	 */
	public abstract String createDoName(String tableName, String prefix,
			int nameOffset);

	public abstract String createJavaAttName(String sqlName);

	/**
	 * Cr�ation du nom d'une constance � partir du nom d'un attribut
	 * L'algorithme est bas� sur les r�gles de nommage java: Les constantes sont
	 * en majuscules Les diff�rents mots sont s�par�s par des '_' Date de
	 * cr�ation : (7/02/01 17:55:57)
	 * 
	 * @param javaName
	 *            java.lang.String nom de l'attribut java
	 */
	public abstract String createJavaCteName(String javaName);

	/**
	 * Retourne le nom de la constante java en fonction du nom de la colonne du
	 * SGBD
	 * 
	 * @return String
	 */
	public abstract String dbName2javaCteName(String dbName);

	public int getDefaultNameOffset();

	public void setDefaultNameOffset(int defaultNameOffset);

	/**
	 * 
	 * @param doPrefix
	 */
	public abstract void setPrefix(String doPrefix);

}