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
import java.util.HashSet;
import java.util.Map;


import com.jnerator.persistence.db.Constants;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.jdo.util.CreatorUtil;

public class EJB3Plugin extends VelocityAbstractPlugin {

	private static final String TEMPLATE_PATH = "ejb3";

	private boolean generateAnnotations = true;

	public void execute(String className, JdoInfo info) throws Exception {

		Map context = new HashMap();

		CreatorUtil.getDoNameCreator().setPrefix(doPrefix);
		CreatorUtil.getDoNameCreator().setDefaultNameOffset(
				this.defaultNameOffset);
		context.put("jdoInfo", info);
		context.put("util", CreatorUtil.getInstance());

		context.put("templatePath", TEMPLATE_PATH);
		context.put("generatorVersion", Constants.GENERATOR_NAME + " / "
				+ this.getShortDescription());
		context.put("date", new Date());
		context.put("fks", new HashSet());
		context.put("annotations", String.valueOf(generateAnnotations));
		info.setJavaPckName(pckName);
		info.setJavaClassName(className);

		runVelocity(TEMPLATE_PATH, "dataobject.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", className + ".java", context);

	}

	@Override
	public String getDefaultPrefix() {
		return "";
	}

	public String getLongDescription() {
		return "This plugin will generate EJB3 from database. Generated class can be used with Hibernate Annotations.";
	}

	public String getName() {
		return "EJB3";
	}

	public String getShortDescription() {
		return "EJB3";
	}

	public boolean isGenerateAnnotations() {
		return generateAnnotations;
	}

	@Override
	public void postExecute(JdoInfo[] infos) throws Exception {
		if (!generateAnnotations) {

			CreatorUtil.getDoNameCreator().setPrefix(doPrefix);
			CreatorUtil.getDoNameCreator().setDefaultNameOffset(
					this.defaultNameOffset);
			Map context = new HashMap();
			context.put("jdoInfos", infos);
			context.put("connInfo", infos[0].getConnInfo());
			context.put("util", CreatorUtil.getInstance());
			context.put("templatePath", TEMPLATE_PATH);
			context.put("generatorVersion", Constants.GENERATOR_NAME);
			context.put("date", new Date());
			context.put("dialect", this);
			context.put("pckName", pckName);
			context.put("annotations", String.valueOf(generateAnnotations));
			context.put("hibernateDialectHelper", new HibernateDialectHelper());

			runVelocity(TEMPLATE_PATH, "hibernate.cfg.xml.vm", srcPath,
					"hibernate.cfg.xml", context);

		}
	}

	public void setGenerateAnnotations(boolean generateAnnotations) {
		this.generateAnnotations = generateAnnotations;
	}

}
