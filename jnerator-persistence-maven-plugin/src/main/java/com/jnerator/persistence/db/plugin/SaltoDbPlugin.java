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

public class SaltoDbPlugin extends VelocityAbstractPlugin {

	private static final String TEMPLATE_PATH = "saltodb";

	public void execute(String className, JdoInfo info) throws Exception {

		Map context = new HashMap();
		context.put("jdoInfo", info);
		context.put("util", CreatorUtil.getInstance());
		context.put("templatePath", TEMPLATE_PATH);
		context.put("generatorVersion", Constants.GENERATOR_NAME + " / "
				+ this.getShortDescription());
		context.put("date", new Date());
		info.setJavaPckName(pckName);
		info.setJavaClassName(className);

		runVelocity(TEMPLATE_PATH, "dataobject.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", className + ".java", context);

		runVelocity(TEMPLATE_PATH, "desc/description.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", className + "Desc.java",
				context);
	}

	@Override
	public String getDefaultPrefix() {
		return "Do";
	}

	public String getLongDescription() {
		return "This plugin will generate Salto-db DataObjects.";
	}

	public String getName() {
		return "Salto-db";
	}

	public String getShortDescription() {
		return "Salto-db Dataobjects";
	}

}
