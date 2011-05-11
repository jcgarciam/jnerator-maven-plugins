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

public class HibernatePlugin extends EJB3Plugin {

	private static final String TEMPLATE_HIBERNATE = "hibernate";

	@Override
	public void execute(String className, JdoInfo info) throws Exception {
		super.execute(className, info);

		CreatorUtil.getDoNameCreator().setPrefix(doPrefix);
		CreatorUtil.getDoNameCreator().setDefaultNameOffset(
				this.defaultNameOffset);
		Map context = new HashMap();
		context.put("jdoInfo", info);
		context.put("util", CreatorUtil.getInstance());
		context.put("templatePath", TEMPLATE_HIBERNATE);
		context.put("generatorVersion", Constants.GENERATOR_NAME + " / "
				+ this.getShortDescription());
		context.put("date", new Date());
		context.put("fks", new HashSet());
		context.put("annotations", String.valueOf(false));
		info.setJavaPckName(pckName);
		info.setJavaClassName(className);

		runVelocity(TEMPLATE_HIBERNATE, "mapping.hbm.vm", srcPath + "/",
				className + ".hbm.xml", context);

	}

	@Override
	public String getDefaultPrefix() {
		return "";
	}

	@Override
	public String getLongDescription() {
		return "This plugin will generate pojos from database. Generated class can be used with Hibernate with mapping in xml files.";
	}

	@Override
	public String getName() {
		return "Hibernate";
	}

	@Override
	public String getShortDescription() {
		return "Hibernate pojos and xml mapping files.";
	}

	@Override
	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception {
		super.init(doPrefix, defaultNameOffset, srcPath, pckName);
		this.setGenerateAnnotations(false);
	}

}
