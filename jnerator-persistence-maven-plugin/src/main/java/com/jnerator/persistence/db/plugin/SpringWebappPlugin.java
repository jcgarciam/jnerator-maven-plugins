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

/**
 * @author rflament@salto-consulting.com
 * 
 */
public class SpringWebappPlugin extends VelocityAbstractPlugin {

	private SpringEJB3AndHibernateDAOPlugin plugin;

	public static final String TEMPLATE_PATH = "springwebapp";

	public void execute(String className, JdoInfo info) throws Exception {
		plugin.execute(className, info);

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

		runVelocity(TEMPLATE_PATH, "listcontroller.vm", srcPath + "/src/"
				+ (pckName + ".webapp.controller").replace('.', '/') + "/",
				className + "ListController.java", context);

		runVelocity(TEMPLATE_PATH, "addupdatecontroller.vm", srcPath + "/src/"
				+ (pckName + ".webapp.controller").replace('.', '/') + "/",
				className + "AddUpdateController.java", context);

		runVelocity(TEMPLATE_PATH, "ajaxdeletecontroller.vm", srcPath + "/src/"
				+ (pckName + ".webapp.controller").replace('.', '/') + "/",
				className + "AjaxDeleteController.java", context);

		runVelocity(TEMPLATE_PATH, "searchcontroller.vm", srcPath + "/src/"
				+ (pckName + ".webapp.controller").replace('.', '/') + "/",
				className + "SearchController.java", context);

		runVelocity(TEMPLATE_PATH, "editor.vm", srcPath + "/src/"
				+ (pckName + ".webapp.editor").replace('.', '/') + "/",
				className + "EditorSupport.java", context);

		runVelocity(TEMPLATE_PATH, "emlist.jsp.vm", srcPath
				+ "/WebContent/WEB-INF/pages", CreatorUtil.getDoNameCreator()
				.class2attribute(className)
				+ "EmList.jsp", context);

		runVelocity(TEMPLATE_PATH, "list.jsp.vm", srcPath
				+ "/WebContent/WEB-INF/pages", CreatorUtil.getDoNameCreator()
				.class2attribute(className)
				+ "List.jsp", context);

		runVelocity(TEMPLATE_PATH, "form.jsp.vm", srcPath
				+ "/WebContent/WEB-INF/pages", CreatorUtil.getDoNameCreator()
				.class2attribute(className)
				+ "Form.jsp", context);
		runVelocity(TEMPLATE_PATH, "searchform.jsp.vm", srcPath
				+ "/WebContent/WEB-INF/pages", CreatorUtil.getDoNameCreator()
				.class2attribute(className)
				+ "SearchForm.jsp", context);

	}

	public String getLongDescription() {
		return "Generate a complete Spring/Hibernate and Spring MVC webapp";
	}

	public String getName() {
		return "springWebapp";
	}

	public String getShortDescription() {
		return "Generate a complete Spring/Hibernate and Spring MVC webapp";
	}

	@Override
	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception {
		super.init(doPrefix, defaultNameOffset, srcPath, pckName);
		plugin = new SpringEJB3AndHibernateDAOPlugin();
		plugin.init(doPrefix, defaultNameOffset, srcPath + "/src", pckName);
	}

	@Override
	public void postExecute(JdoInfo[] infos) throws Exception {

		plugin.postExecute(infos);

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
		context.put("dialect", this.plugin);
		context.put("pckName", pckName);
		context.put("hibernateDialectHelper", new HibernateDialectHelper());

		runVelocity(TEMPLATE_PATH, "action-servlet.xml.vm", srcPath
				+ "/WebContent/WEB-INF/", "action-servlet.xml", context);
		runVelocity(TEMPLATE_PATH, "web.xml.vm", srcPath
				+ "/WebContent/WEB-INF/", "web.xml", context);
		runVelocity(TEMPLATE_PATH, "ApplicationResources.properties.vm",
				srcPath + "/src/", "ApplicationResources.properties", context);
		runVelocity(TEMPLATE_PATH, "menu.jsp.vm", srcPath
				+ "/WebContent/common", "menu.jsp", context);
		runVelocity(TEMPLATE_PATH, "menu2.jsp.vm", srcPath
				+ "/WebContent/WEB-INF/pages", "menu.jsp", context);
		runVelocity(TEMPLATE_PATH, "menu-config.xml.vm", srcPath
				+ "/WebContent/WEB-INF/", "menu-config.xml", context);
		runVelocity(TEMPLATE_PATH, "log4j.properties.vm", srcPath + "/src/",
				"log4j.properties", context);
		runVelocity(TEMPLATE_PATH, "pom.xml.vm", srcPath + "/", "pom.xml",
				context);

		// unzip appfuse.zip
		// ZipUtil.unzip(this.getClass().getClassLoader().getResourceAsStream(
		// "appfuse.zip"), srcPath + "/");

	}

}
