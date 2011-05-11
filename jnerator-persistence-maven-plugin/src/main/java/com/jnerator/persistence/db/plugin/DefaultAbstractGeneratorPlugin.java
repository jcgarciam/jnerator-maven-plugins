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

public abstract class DefaultAbstractGeneratorPlugin implements
		IGeneratorPlugin {

	protected String doPrefix;

	protected String srcPath;

	protected String pckName;

	protected int defaultNameOffset = 0;

	public void abort() throws Exception {

	}

	public int getDefaultNameOffset() {
		return defaultNameOffset;
	}

	public String getDefaultPrefix() {
		return "";
	}

	public void init(String doPrefix, int defaultNameOffset, String srcPath,
			String pckName) throws Exception {
		this.doPrefix = doPrefix;
		this.srcPath = srcPath;
		this.pckName = pckName;
		/*
		 * this.compName = compName; this.info = info;
		 */

		if (this.doPrefix == null) {
			this.doPrefix = this.getDefaultPrefix();
		}

		this.defaultNameOffset = defaultNameOffset;
	}

	public void postExecute(JdoInfo[] infos) throws Exception {

	}

	public void setDefaultNameOffset(int defaultNameOffset) {
		this.defaultNameOffset = defaultNameOffset;
	}

}
