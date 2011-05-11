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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.jnerator.persistence.db.Constants;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.jdo.util.CreatorUtil;

public class SpringEJB3AndHibernateDAOAndTestCasesPlugin extends
		SpringEJB3AndHibernateDAOPlugin {

	@Override
	public void execute(String className, JdoInfo info) throws Exception {

		super.execute(className, info);

		CreatorUtil.getDoNameCreator().setPrefix(doPrefix);
		CreatorUtil.getDoNameCreator().setDefaultNameOffset(
				this.defaultNameOffset);
		Map context = new HashMap();
		context.put("jdoInfo", info);
		context.put("util", CreatorUtil.getInstance());
		context.put("templatePath", TEMPLATE_PATH);
		context.put("generatorVersion", Constants.GENERATOR_NAME + " / "
				+ this.getShortDescription());
		context.put("date", new Date());
		info.setJavaPckName(pckName);
		info.setJavaClassName(className);

		runVelocity(TEMPLATE_PATH, "test.vm", srcPath + "/"
				+ (pckName + ".test").replace('.', '/') + "/", className
				+ "DAOTest.java", context);

	}

	@Override
	public String getLongDescription() {
		return "This plugin will generate Hibernate EJB3 POJOS, hibernate.cfg.xml, Spring DAOs for each class and unit tests for each dao.";
	}

	@Override
	public String getName() {
		return "SpringEJB3AndHibernateDaoAndTestCases";
	}

	@Override
	public String getShortDescription() {
		return "EJB3 + Spring/Hibernate DAO + TestCases";
	}

	@Override
	public void postExecute(JdoInfo[] infos) throws Exception {

		super.postExecute(infos);
		CreatorUtil.getDoNameCreator().setPrefix(doPrefix);
		CreatorUtil.getDoNameCreator().setDefaultNameOffset(
				this.defaultNameOffset);
		Map context = new HashMap();
		context.put("jdoInfos", infos);
		context.put("connInfo", infos[0].getConnInfo());
		context.put("util", CreatorUtil.getInstance());
		context.put("templatePath", TEMPLATE_PATH);
		context.put("generatorVersion", Constants.GENERATOR_NAME + " / "
				+ this.getShortDescription());
		context.put("date", new Date());
		context.put("dialect", this.ejb3Plugin);
		context.put("pckName", pckName);
		context.put("hibernateDialectHelper", new HibernateDialectHelper());
		context.put("annotations", String.valueOf(ejb3Plugin
				.isGenerateAnnotations()));
		runVelocity(TEMPLATE_PATH, "applicationContext-test.xml.vm", srcPath,
				"applicationContext-test.xml", context);
	}

}
