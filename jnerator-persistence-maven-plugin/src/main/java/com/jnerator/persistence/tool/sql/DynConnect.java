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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DynConnect {

	/**
	 * Constructor for DynConnect.
	 */
	public DynConnect() {
		super();
	}

	public void connect(ConnectionInfo connInfo) throws SQLException,
			DatabaseException {
		Connection conn = connInfo.getConn();

		ClassLoader loader = this.getClass().getClassLoader();
		if ((conn == null) || conn.isClosed()) {

			try {
				Class.forName(connInfo.getDriver(), true, loader);
			} catch (Throwable e) {
				throw new DatabaseException(
						"Le driver n'existe pas. V�rifier le nom du driver ou votre classpath");
			}
			conn = DriverManager.getConnection(connInfo.getUrl(), connInfo
					.getUser(), connInfo.getPwd());
			connInfo.setConn(conn);
		}
	}
}
