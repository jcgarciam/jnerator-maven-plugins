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

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public abstract class VelocityAbstractPlugin extends
		DefaultAbstractGeneratorPlugin {

	protected static void runVelocity(String templatesPath,
			String templateName, String outputDirectory, String outputFilename,
			Map context) throws Exception {
		// Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM, this);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		FileOutputStream fileOutputStream = null;

		try {

			PropertyResourceBundle bundle = (PropertyResourceBundle) ResourceBundle
					.getBundle("org.apache.velocity.runtime.defaults.velocity");
			Properties props = new Properties();
			Enumeration enumeration = bundle.getKeys();
			String cle;
			while (enumeration.hasMoreElements()) {
				cle = (String) enumeration.nextElement();
				props.put(cle, bundle.getString(cle));
			}
			props.put("resource.loader", "class");
			props
					.put("class.resource.loader.class",
							"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			props.put("class.resource.loader.path", templatesPath);
			props.put("directive.foreach.counter.initial.value", "0");
			Velocity.init(props);
			Template t = Velocity.getTemplate(templatesPath + "/"
					+ templateName);

			VelocityContext velocityContext = new VelocityContext();
			for (Iterator iterator = context.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				velocityContext.put((String) entry.getKey(), entry.getValue());
			}

			t.initDocument();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					out));
			t.merge(velocityContext, writer);
			writer.flush();
			File dir = new File(outputDirectory);
			dir.mkdirs();
			fileOutputStream = new FileOutputStream(dir.getPath() + "/"
					+ outputFilename);
			fileOutputStream.write(out.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
			}
			try {
				fileOutputStream.close();
			} catch (IOException e1) {
			}
		}

	}

}
