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

package com.jnerator.persistence.tool.sql;

import java.io.Serializable;
import java.sql.Connection;

import com.jnerator.persistence.tool.sql.data.CatalogInfo;
import com.jnerator.persistence.tool.sql.data.ShemaInfo;

public class ConnectionInfo implements Serializable {
	private String driverJarFile;
	private String url;
	private String user;
	private String pwd;
	private String driver;
	private String name;
	private transient Connection conn;

	private transient CatalogInfo[] catalogInfos;
	private transient ShemaInfo[] shemaInfos;

	public ConnectionInfo(String driver, String url, String user, String pwd,
			String name) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.name = name;
	}

	public ConnectionInfo(String driver, String url, String user, String pwd,
			String name, String driverJarFile) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.name = name;
		this.driverJarFile = driverJarFile;
	}

	/**
	 * @see Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	/**
	 * @return Returns the catalogInfos.
	 */
	public CatalogInfo[] getCatalogInfos() {
		if (!isConnected())
			return new CatalogInfo[0];
		if (catalogInfos == null) {
			catalogInfos = DatabaseInfo.getCatalogs(this);
			if (catalogInfos.length == 0) {
				catalogInfos = new CatalogInfo[] { new CatalogInfo(this,
						"default") };
			}
		}
		return catalogInfos;
	}

	/**
	 * Gets the conn.
	 * 
	 * @return Returns a Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Gets the driver.
	 * 
	 * @return Returns a String
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * Gets the driverJarFile.
	 * 
	 * @return Returns a String
	 */
	public String getDriverJarFile() {
		return driverJarFile;
	}

	/**
	 * Gets the name.
	 * 
	 * @return Returns a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the pwd.
	 * 
	 * @return Returns a String
	 */
	public String getPwd() {
		return pwd;
	}

	public ShemaInfo[] getShemaInfos() {
		return getShemaInfos(true);
	}

	/**
	 * @return
	 */
	public ShemaInfo[] getShemaInfos(boolean find) {
		if (!isConnected())
			return new ShemaInfo[0];
		if (find && (shemaInfos == null)) {
			shemaInfos = DatabaseInfo.getShemas(this);
			if (shemaInfos.length == 0) {
				ShemaInfo info = new ShemaInfo(this);
				info.setCatalog("default");
				info.setName("default");
				shemaInfos = new ShemaInfo[] { info };
			}
		}
		return shemaInfos;
	}

	/**
	 * Gets the url.
	 * 
	 * @return Returns a String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the user.
	 * 
	 * @return Returns a String
	 */
	public String getUser() {
		return user;
	}

	public boolean isConnected() {
		return (conn != null);
	}

	/**
	 * @param catalogInfos
	 *            The catalogInfos to set.
	 */
	public void setCatalogInfos(CatalogInfo[] catalogInfos) {
		if (catalogInfos == null)
			catalogInfos = DatabaseInfo.getCatalogs(this);
		this.catalogInfos = catalogInfos;
	}

	/**
	 * Sets the conn.
	 * 
	 * @param conn
	 *            The conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
		if (conn == null)
			shemaInfos = null;
	}

	/**
	 * Sets the driver.
	 * 
	 * @param driver
	 *            The driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * Sets the driverJarFile.
	 * 
	 * @param driverJarFile
	 *            The driverJarFile to set
	 */
	public void setDriverJarFile(String driverJarFile) {
		this.driverJarFile = driverJarFile;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the pwd.
	 * 
	 * @param pwd
	 *            The pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            The url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            The user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
