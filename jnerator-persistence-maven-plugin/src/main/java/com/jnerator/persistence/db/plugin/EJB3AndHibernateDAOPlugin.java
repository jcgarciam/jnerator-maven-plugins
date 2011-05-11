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

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

import com.jnerator.persistence.db.Constants;
import com.jnerator.persistence.tool.jdo.data.JdoInfo;
import com.jnerator.persistence.tool.jdo.util.CreatorUtil;

public class EJB3AndHibernateDAOPlugin extends VelocityAbstractPlugin {

	protected EJB3Plugin ejb3Plugin = null;

	public static final String TEMPLATE_PATH = "hibernateejb3dao";

	public void execute(String className, JdoInfo info) throws Exception {

		ejb3Plugin.execute(className, info);

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

		runVelocity(TEMPLATE_PATH, "hibernatedao.vm", srcPath + "/"
				+ (pckName + ".hibernate").replace('.', '/') + "/", className
				+ "HibernateDAO.java", context);

		runVelocity(TEMPLATE_PATH, "dao.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", className + "DAO.java",
				context);

	}

	@Override
	public String getDefaultPrefix() {
		return "";
	}

	public EJB3Plugin getEjb3Plugin() {
		return ejb3Plugin;
	}

	public String getLongDescription() {
		return "This plugin will generate Hibernate EJB3 POJOS, hibernate.cfg.xml and DAOs for each class.";
	}

	public String getName() {
		return "EJB3AndHibernateDao";
	}

	public String getShortDescription() {
		return "EJB3 + Hibernate DAO";
	}

	@Override
	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception {
		super.init(doPrefix, defaultNameOffset, srcPath, pckName);
		ejb3Plugin = new EJB3Plugin();
		ejb3Plugin
				.init(doPrefix, defaultNameOffset, srcPath, pckName + ".pojo");
	}

	@Override
	public void postExecute(JdoInfo[] infos) throws Exception {

		Template t = Velocity.getTemplate(TEMPLATE_PATH
				+ "/hibernatedaofactory.vm");

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

		runVelocity(TEMPLATE_PATH, "hibernatedaofactory.vm", srcPath + "/"
				+ (pckName + ".hibernate").replace('.', '/') + "/",
				"HibernateDAOFactory.java", context);

		runVelocity(TEMPLATE_PATH, "daofactory.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", "DAOFactory.java", context);

		runVelocity(TEMPLATE_PATH, "abstracthibernatedao.vm", srcPath + "/"
				+ (pckName + ".hibernate").replace('.', '/') + "/",
				"AbstractHibernateDAO.java", context);

		runVelocity(TEMPLATE_PATH, "genericdao.vm", srcPath + "/"
				+ pckName.replace('.', '/') + "/", "GenericDAO.java", context);

		runVelocity(TEMPLATE_PATH, "hibernateutil.vm", srcPath + "/"
				+ (pckName + ".hibernate").replace('.', '/') + "/",
				"HibernateUtil.java", context);

		runVelocity(TEMPLATE_PATH, "hibernate.cfg.xml.vm", srcPath + "/",
				"hibernate.cfg.xml", context);

	}

	public void setEjb3Plugin(EJB3Plugin ejb3Plugin) {
		this.ejb3Plugin = ejb3Plugin;
	}

}
