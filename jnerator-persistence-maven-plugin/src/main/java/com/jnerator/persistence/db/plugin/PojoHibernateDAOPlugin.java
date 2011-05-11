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

package com.jnerator.persistence.db.plugin;

import com.jnerator.persistence.tool.jdo.data.JdoInfo;

public class PojoHibernateDAOPlugin extends EJB3AndHibernateDAOPlugin {

	@Override
	public String getLongDescription() {
		return "This plugin will generate Hibernate POJOS, hibernate mapping, and DAOs for each class.";
	}

	@Override
	public String getName() {
		return "PojoHibernateDao";
	}

	@Override
	public String getShortDescription() {
		return "Pojos + Hibernate mapping + Generic DAO";
	}

	@Override
	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception {
		super.init(doPrefix, defaultNameOffset, srcPath, pckName);
		HibernatePlugin hibernatePlugin = new HibernatePlugin();
		hibernatePlugin.init(doPrefix, defaultNameOffset, srcPath, pckName
				+ ".pojo");
		this.setEjb3Plugin(hibernatePlugin);
	}

	@Override
	public void postExecute(JdoInfo[] infos) throws Exception {
		super.postExecute(infos);
		this.getEjb3Plugin().postExecute(infos);
	}
}
