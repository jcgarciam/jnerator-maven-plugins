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

/**
 * @author rflament@laposte.net
 * 
 */

public interface IGeneratorPlugin {

	public void abort() throws Exception;

	public void execute(String className, JdoInfo info) throws Exception;

	public int getDefaultNameOffset();

	public String getDefaultPrefix();

	public String getLongDescription();

	public String getName();

	public String getShortDescription();

	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception;

	public void postExecute(JdoInfo[] infos) throws Exception;

}
