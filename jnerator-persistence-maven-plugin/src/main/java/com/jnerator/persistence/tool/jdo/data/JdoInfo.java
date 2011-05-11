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

import java.util.ArrayList;


import com.jnerator.persistence.tool.jdo.util.DoNameCreator;
import com.jnerator.persistence.tool.jdo.util.IDoNameCreator;
import com.jnerator.persistence.tool.sql.data.TableFK;
import com.jnerator.persistence.tool.sql.data.TableInfo;

/**
 * Objet de donn�e correspondant � un attribut java d'une classe de type
 * Dataobject Date de cr�ation : (18/10/01 06:37:36)
 * 
 * @author : E. Loiez
 */
public class JdoInfo extends TableInfo implements Cloneable {
	protected String javaPckName = null;

	protected String javaClassName = null;

	protected JdoColInfo[] jdoColInfos = null;

	// composant cr�ant les noms / ce composant doit �tre param�trable
	protected static IDoNameCreator nameCreator = new DoNameCreator();

	/**
	 * Commentaire relatif au constructeur JdoInfo.
	 */
	public JdoInfo() {
		super();
	}

	/**
	 * Commentaire relatif au constructeur JdoInfo.
	 */
	public JdoInfo(TableInfo tableInfo) {
		super(tableInfo);
		if (colInfos != null) {
			jdoColInfos = new JdoColInfo[colInfos.length];
			for (int i = 0; i < jdoColInfos.length; i++) {
				jdoColInfos[i] = new JdoColInfo(colInfos[i]);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/**
	 * colinfos that are not pk and not fk
	 * 
	 * @return
	 */
	public JdoColInfo[] getBasicColInfos() {
		ArrayList list = new ArrayList();

		for (int i = 0; i < jdoColInfos.length; i++) {
			boolean basic = true;

			for (int j = 0; (j < this.pk.length) && basic; j++) {
				if (pk[j].getCol().equals(jdoColInfos[i].getColName())) {
					basic = false;
				}

			}

			for (int j = 0; (j < this.getImportedFk().length) && basic; j++) {
				TableFK[] fks = this.getImportedFk()[j];

				for (int k = 0; k < fks.length; k++) {
					if (fks[k].getFkColumnName().equals(
							jdoColInfos[i].getColName())) {
						basic = false;
					}
				}

			}

			if (basic) {
				list.add(jdoColInfos[i]);
			}
		}

		return (JdoColInfo[]) list.toArray(new JdoColInfo[list.size()]);
	}

	/**
	 * @return Returns the javaClassName.
	 */
	public String getJavaClassName() {
		if (javaClassName == null)
			javaClassName = nameCreator.createDoName(tableName);
		return javaClassName;
	}

	/**
	 * @return Returns the javaPckName.
	 */
	public String getJavaPckName() {
		return javaPckName;
	}

	/**
	 * @return Returns the jdoColInfos.
	 */
	public JdoColInfo[] getJdoColInfos() {
		return jdoColInfos;
	}

	/**
	 * colinfos that are not fk
	 * 
	 * @return
	 */
	public JdoColInfo[] getNonFKColInfos() {
		ArrayList list = new ArrayList();

		for (int i = 0; i < jdoColInfos.length; i++) {
			boolean basic = true;

			for (int j = 0; (j < this.getImportedFk().length) && basic; j++) {
				TableFK[] fks = this.getImportedFk()[j];

				for (int k = 0; k < fks.length; k++) {
					if (fks[k].getFkColumnName().equals(
							jdoColInfos[i].getColName())) {
						basic = false;
					}
				}

			}

			if (basic) {
				list.add(jdoColInfos[i]);
			}
		}

		return (JdoColInfo[]) list.toArray(new JdoColInfo[list.size()]);
	}

	/**
	 * @param javaClassName
	 *            The javaClassName to set.
	 */
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}

	/**
	 * @param javaPckName
	 *            The javaPckName to set.
	 */
	public void setJavaPckName(String javaPckName) {
		this.javaPckName = javaPckName;
	}

	/**
	 * @param jdoColInfos
	 *            The jdoColInfos to set.
	 */
	public void setJdoColInfos(JdoColInfo[] jdoColInfos) {
		this.jdoColInfos = jdoColInfos;
	}

}
