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

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * 
 * @author : E. Loiez
 */
public class ConnectionMgr {
	private static HashMap map = new HashMap();

	public static void connect(ConnectionInfo connInfo) throws SQLException,
			DatabaseException {
		Connection conn = connInfo.getConn();
		ClassLoader loader = null;
		if ((conn == null) || conn.isClosed()) {
			Class cl = null;
			try {
				if ((connInfo.getDriverJarFile() != null)
						&& !"".equals(connInfo.getDriverJarFile())) {
					loader = new URLClassLoader(new URL[] { new File(connInfo
							.getDriverJarFile()).toURL() });
				}
				if (loader != null) {
					cl = Class.forName(connInfo.getDriver(), true, loader);
				} else {
					cl = Class.forName(connInfo.getDriver());
				}
			} catch (Exception e) {
				throw new DatabaseException("The driver '"
						+ connInfo.getDriver()
						+ "' cannot be found in the classpath !");
				// the driver has not yet been set
			}
			// some driver needs to be explicitly registered
			// but some drivers do not have an implicit constructor
			try {
				Driver driver = (Driver) cl.newInstance();
				Properties props = new Properties();
				if ((connInfo.getUser() != null)
						&& !"".equals(connInfo.getUser())) {
					props.put("user", connInfo.getUser());
					props.put("password", connInfo.getPwd());
				}
				conn = driver.connect(connInfo.getUrl(), props);
				connInfo.setConn(conn);
			} catch (Exception e) {
				throw new DatabaseException(
						"Error while connecting the database : " + e);
			}
			map.put(connInfo.getName(), connInfo);
		}
	}

	public static void disconnect(ConnectionInfo connInfo) throws SQLException {
		Connection conn = connInfo.getConn();
		if ((conn != null) && !conn.isClosed()) {
			conn.close();
		}
	}

	public static void disconnectAll() {
		String[] connKeys = (String[]) map.keySet().toArray(
				new String[map.size()]);
		for (int i = 0; i < connKeys.length; i++) {
			ConnectionInfo ci = (ConnectionInfo) map.remove(connKeys[i]);
			try {
				disconnect(ci);
			} catch (SQLException e) { // ignor�
			}
		}
	}

	public static void remove(ConnectionInfo connInfo) {
		try {
			disconnect(connInfo);
		} catch (Exception e) {
		}
		map.remove(connInfo.getName());
	}

	public static final Object[][] retrieve(Connection conn, String query)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			if (rs == null) {
				return null;
			}
			ResultSetMetaData rsmd = rs.getMetaData();
			int nbCol = rsmd.getColumnCount();

			String[] colNames = new String[nbCol];
			for (int i = nbCol; i >= 1; i--)
				colNames[i - 1] = rsmd.getColumnName(i);

			ArrayList vResult = new ArrayList();
			while (rs.next()) {
				Object[] obj = new Object[nbCol];
				for (int j = nbCol; j > 0; j--)
					obj[j - 1] = rs.getObject(j);
				vResult.add(obj);
			}
			// conversion en tableaux
			Object[][] res = new Object[vResult.size() + 1][nbCol];
			res[0] = colNames;
			for (int i = 0; i < vResult.size(); i++)
				res[i + 1] = (Object[]) vResult.get(i);
			return res;

		} finally // code de nettoyage ex�cut� quel que soit le r�sultat de la
		// clause try
		{
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				// if (conn != null) conn.close();
			} catch (Exception e) {
			}
		}
	}

	public static final int update(Connection conn, String query)
			throws SQLException {

		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
			}
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("smt close");
			}
		}
	}

	public static final int update(Connection conn, String query,
			Object[][] datas) throws SQLException {

		PreparedStatement stmt = null;

		int nbUpdate = 0;
		try {
			stmt = conn.prepareStatement(query);
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					stmt.setObject(j + 1, datas[i][j]);
				}
				nbUpdate += stmt.executeUpdate();
			}
			return nbUpdate;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
			}
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("smt close");
			}
		}
	}

	/**
	 * Constructor for ConnectionMgr.
	 */
	public ConnectionMgr() {
	}

}