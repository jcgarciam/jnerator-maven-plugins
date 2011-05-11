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
 * Interface permettant de cr�er les noms des attributs des composants Plusieurs
 * algorithmes sont d�finies � partir des r�gles de nommage les plus courantes
 * des bases de donn�es Date de cr�ation : (20/10/01 05:17:16)
 * 
 * @author : E. Loiez
 */
public class DoNameCreator implements IDoNameCreator {

	private static final String DEFAULT_PREFIX = "Do";

	private static final int DEFAULT_NAME_OFFSET = 0;

	private String prefix = DEFAULT_PREFIX;

	private int defaultNameOffset = DEFAULT_NAME_OFFSET;

	public DoNameCreator() {
	}

	public String attribute2class(String attributeName) {
		if (attributeName == null)
			return null;
		return attributeName.substring(0, 1).toUpperCase()
				+ attributeName.substring(1);
	}

	public String class2attribute(String className) {
		/*
		 * if (className == null) return null;
		 */
		if (className.length() > 1) {
			return className.substring(0, 1).toLowerCase()
					+ className.substring(1);
		} else
			return className.toLowerCase();
	}

	/**
	 * Retourne le nom d'un do en fonction du nom d'une table
	 * 
	 * @return String
	 */
	public String createDoName(String tableName) {

		return createDoName(tableName, prefix, defaultNameOffset);
	}

	public String createDoName(String tableName, String prefix, int nameOffset) {

		if (tableName.length() > nameOffset)
			tableName = tableName.substring(nameOffset);

		int len = tableName.length();
		int offset = 0;
		char c;
		char[] javaName = new char[len];

		for (int i = (len - 1); i >= 0; i--) {
			c = tableName.charAt(i);
			if (c == '_') {
				javaName[i + 1 + offset] = Character.toUpperCase(javaName[i + 1
						+ offset]);
				offset++;
			} else {
				javaName[i + offset] = Character.toLowerCase(c);
			}
		}
		javaName[offset] = Character.toUpperCase(javaName[offset]);

		return prefix + new String(javaName, offset, len - offset);
	}

	public String createJavaAttName(String sqlName) {

		if ((sqlName.indexOf("_") > 0) || sqlName.toUpperCase().equals(sqlName)
				|| sqlName.toLowerCase().equals(sqlName)) {

			int len = sqlName.length();
			int offset = 0;
			char c;
			char[] javaName = new char[len];
			for (int i = (len - 1); i >= 0; i--) {
				c = sqlName.charAt(i);
				if ((c == '_') && (i + 1 + offset < len)) {
					javaName[i + 1 + offset] = Character.toUpperCase(javaName[i
							+ 1 + offset]);
					offset++;
				} else {
					javaName[i + offset] = Character.toLowerCase(c);
				}
			}
			return new String(javaName, offset, len - offset);
		}
		return class2attribute(sqlName);
	}

	/**
	 * Cr�ation du nom d'une constance � partir du nom d'un attribut
	 * L'algorithme est bas� sur les r�gles de nommage java: Les constantes sont
	 * en majuscules Les diff�rents mots sont s�par�s par des '_' Date de
	 * cr�ation : (7/02/01 17:55:57)
	 * 
	 * @param javaName
	 *            java.lang.String nom de l'attribut java
	 */

	public String createJavaCteName(String javaName) {
		int len = javaName.length();
		char[] cteName = new char[len * 2];
		int offset = 0;
		char c;
		for (int i = 0; i < len; i++) {
			c = javaName.charAt(i);
			if (Character.isUpperCase(c)) {
				cteName[i + offset] = '_';
				cteName[i + 1 + offset] = c;
				offset++;
			} else {
				cteName[i + offset] = Character.toUpperCase(c);
			}
		}
		return new String(cteName, 0, len + offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * salto.tool.jdo.util.IDoNameCreator#dbName2javaCteName(java.lang.String)
	 */
	public String dbName2javaCteName(String dbName) {
		return createJavaCteName(createJavaAttName(dbName));
	}

	public int getDefaultNameOffset() {
		return defaultNameOffset;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setDefaultNameOffset(int defaultNameOffset) {
		this.defaultNameOffset = defaultNameOffset;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}