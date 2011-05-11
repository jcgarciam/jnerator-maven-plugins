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
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.jnerator.persistence.tool.sql.data.CatalogInfo;
import com.jnerator.persistence.tool.sql.data.ShemaInfo;
import com.jnerator.persistence.tool.sql.data.TableColInfo;
import com.jnerator.persistence.tool.sql.data.TableFK;
import com.jnerator.persistence.tool.sql.data.TableInfo;
import com.jnerator.persistence.tool.sql.data.TablePK;
import com.jnerator.persistence.tool.sql.data.TypeInfo;

/**
 * Cette classe permet de r�cup�rer toutes les informations conernant une base
 * de donn�e. Un finalizer permet de supprimer la connection. Toutefois, il est
 * pr�f�rable de la fermer explicitement avec la m�thode closeConnection Les
 * informations sont renvoy�es par l'interm�diaires des objets TableColInfo
 * TaleFK TablePK TableInfo Ces objets respectent les normes JDBC 2.0. Si les
 * informations sont incompl�tes, il faut v�rifier la compatibilit� de votre
 * driver JDBC. Date de cr�ation : (28/01/01 7:56:42)
 * 
 * @author : E. Loiez
 */
public class DatabaseInfo {
	private static String shema = null;

	private static Connection defaultConn = null;

	/* information de connection */
	private static String driver = null;

	private static String pwd = null;

	private static String url = null;

	private static String user = null;

	/*
	 * static {
	 * 
	 * driver = "com.mysql.jdbc.Driver"; url = "jdbc:mysql://localhost/teste";
	 * shema = "teste"; try { getConnection(); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	private static HashMap typMap = new HashMap();

	/**
	 * Retrieves a description of the foreign key columns that reference the
	 * given table's primary key columns (the foreign keys exported by a table).
	 * They are ordered by FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, and
	 * KEY_SEQ.
	 * 
	 * <P>
	 * Each foreign key column description has the following columns:
	 * <OL>
	 * <LI><B>PKTABLE_CAT</B> String => primary key table catalog (may be
	 * <code>null</code>)
	 * <LI><B>PKTABLE_SCHEM</B> String => primary key table schema (may be
	 * <code>null</code>)
	 * <LI><B>PKTABLE_NAME</B> String => primary key table name
	 * <LI><B>PKCOLUMN_NAME</B> String => primary key column name
	 * <LI><B>FKTABLE_CAT</B> String => foreign key table catalog (may be
	 * <code>null</code>) being exported (may be <code>null</code>)
	 * <LI><B>FKTABLE_SCHEM</B> String => foreign key table schema (may be
	 * <code>null</code>) being exported (may be <code>null</code>)
	 * <LI><B>FKTABLE_NAME</B> String => foreign key table name being exported
	 * <LI><B>FKCOLUMN_NAME</B> String => foreign key column name being exported
	 * <LI><B>KEY_SEQ</B> short => sequence number within foreign key
	 * <LI><B>UPDATE_RULE</B> short => What happens to foreign key when primary
	 * is updated:
	 * <UL>
	 * <LI>importedNoAction - do not allow update of primary key if it has been
	 * imported
	 * <LI>importedKeyCascade - change imported key to agree with primary key
	 * update
	 * <LI>importedKeySetNull - change imported key to <code>NULL</code> if its
	 * primary key has been updated
	 * <LI>importedKeySetDefault - change imported key to default values if its
	 * primary key has been updated
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * </UL>
	 * <LI><B>DELETE_RULE</B> short => What happens to the foreign key when
	 * primary is deleted.
	 * <UL>
	 * <LI>importedKeyNoAction - do not allow delete of primary key if it has
	 * been imported
	 * <LI>importedKeyCascade - delete rows that import a deleted key
	 * <LI>importedKeySetNull - change imported key to <code>NULL</code> if its
	 * primary key has been deleted
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * <LI>importedKeySetDefault - change imported key to default if its primary
	 * key has been deleted
	 * </UL>
	 * <LI><B>FK_NAME</B> String => foreign key name (may be <code>null</code>)
	 * <LI><B>PK_NAME</B> String => primary key name (may be <code>null</code>)
	 * <LI><B>DEFERRABILITY</B> short => can the evaluation of foreign key
	 * constraints be deferred until commit
	 * <UL>
	 * <LI>importedKeyInitiallyDeferred - see SQL92 for definition
	 * <LI>importedKeyInitiallyImmediate - see SQL92 for definition
	 * <LI>importedKeyNotDeferrable - see SQL92 for definition
	 * </UL>
	 * </OL>
	 * 
	 * @param catalog
	 *            a catalog name; must match the catalog name as it is stored in
	 *            this database; "" retrieves those without a catalog;
	 *            <code>null</code> means that the catalog name should not be
	 *            used to narrow the search
	 * @param schema
	 *            a schema name; must match the schema name as it is stored in
	 *            the database; "" retrieves those without a schema;
	 *            <code>null</code> means that the schema name should not be
	 *            used to narrow the search
	 * @param table
	 *            a table name; must match the table name as it is stored in
	 *            this database
	 * @return a <code>ResultSet</code> object in which each row is a foreign
	 *         key column description
	 * @exception SQLException
	 *                if a database access error occurs
	 * @see java.sql.DatabaseMetaData.getExportedKeys
	 */
	public static final int IMPORTED_KEY = 0;

	public static final int EXPORTED_KEY = 1;

	/**
	 * Return a set of auto increment columns
	 * 
	 * @param tableName
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private static Set getAutoIncrementColumns(String tableName, Connection conn)
			throws SQLException {

		Statement s = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = s.executeQuery("SELECT * FROM " + tableName
				+ " WHERE 1 = 0");
		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();
		Set results = new HashSet();
		for (int i = 1; i <= columnCount; i++) {
			if (meta.isAutoIncrement(i)) {
				String colName = meta.getColumnName(i);
				results.add(colName);
			}
		}
		return results;

	}

	/**
	 * @param conn
	 */
	public static CatalogInfo[] getCatalogs(ConnectionInfo info) {
		try {
			ResultSet rs = info.getConn().getMetaData().getCatalogs();
			ArrayList list = new ArrayList();
			while (rs.next()) {
				list.add(new CatalogInfo(info, rs.getString(1)));
			}
			return (CatalogInfo[]) list.toArray(new CatalogInfo[list.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 9:03:32) Retour de getColumns TABLE_CAT String => table catalog
	 * (may be null) TABLE_SCHEM String => table schema (may be null) TABLE_NAME
	 * String => table name COLUMN_NAME String => column name DATA_TYPE short =>
	 * SQL type from java.sql.Types TYPE_NAME String => Data source dependent
	 * type name, for a UDT the type name is fully qualified COLUMN_SIZE int =>
	 * column size. For char or date types this is the maximum number of
	 * characters, for numeric or decimal types this is precision. BUFFER_LENGTH
	 * is not used. DECIMAL_DIGITS int => the number of fractional digits
	 * NUM_PREC_RADIX int => Radix (typically either 10 or 2) NULLABLE int => is
	 * NULL allowed? columnNoNulls - might not allow NULL values columnNullable
	 * - definitely allows NULL values columnNullableUnknown - nullability
	 * unknown REMARKS String => comment describing column (may be null)
	 * COLUMN_DEF String => default value (may be null) SQL_DATA_TYPE int =>
	 * unused SQL_DATETIME_SUB int => unused CHAR_OCTET_LENGTH int => for char
	 * types the maximum number of bytes in the column ORDINAL_POSITION int =>
	 * index of column in table (starting at 1) IS_NULLABLE String => "NO" means
	 * column definitely does not allow NULL values; "YES" means the column
	 * might allow NULL values. An empty string means nobody knows.
	 * 
	 */

	public static synchronized TableColInfo[] getColumns(TableInfo tbInfo) {
		TableColInfo[] res = null;
		ResultSet rs = null;
		try {
			DatabaseMetaData dbInfo = tbInfo.getConn().getMetaData();
			rs = dbInfo.getColumns(tbInfo.getTableCat(), tbInfo.getTableShem(),
					tbInfo.getTableName(), "%");
			String tableName = tbInfo.getTableName();
			if ((tbInfo.getTableShem() != null)
					&& !"".equals(tbInfo.getTableShem())) {
				tableName = tbInfo.getTableShem() + "." + tableName;
			}
			Set autoIncrementolumns = getAutoIncrementColumns(tableName, tbInfo
					.getConn());

			// ResultSet rs2 =
			// tbInfo.getConn().createStatement().executeQuery("SELECT * from "
			// + tableName);
			// ResultSetMetaData rsmd = rs2.getMetaData();
			int count = 1;
			Vector element = new Vector();
			while (rs.next()) {
				TableColInfo ti = new TableColInfo(tbInfo);

				ti.setTableInfo(tbInfo);
				ti.setTableCat(rs.getString(1));
				ti.setTableShem(rs.getString(2));
				ti.setTableName(rs.getString(3));
				ti.setColName(rs.getString(4));
				ti.setColTyp(rs.getShort(5));
				ti.setTypName(rs.getString(6));
				ti.setColSize(rs.getInt(7));
				ti.setDecDigit(rs.getInt(9));
				ti.setNumPrecRadix(rs.getInt(10));
				ti.setColNullable(rs.getInt(11));
				try {
					ti.setColRemarks(rs.getString(12));
				} catch (Exception e) {
				}
				try {
					ti.setColDefaultVal(rs.getString(16));
				} catch (Exception e) {
				}
				try {
					ti.setColCharOctetLength(rs.getInt(19));
				} catch (Exception e) {
				}
				try {
					ti.setColPosition(rs.getInt(20));
				} catch (Exception e) {
				}
				try {
					ti.setColIsNullable(rs.getString(21));
				} catch (Exception e) {
				}
				try {
					boolean isAutoIncrementable = isAutoIncrement(ti
							.getTypName(), tbInfo.getConn());
					isAutoIncrementable &= autoIncrementolumns.contains(ti
							.getColName());
					ti.setAutoIncrement(isAutoIncrementable);
				} catch (Exception e) {
					e.printStackTrace();
				}
				element.add(ti);
				count++;
			}
			Object[] o = element.toArray();
			res = new TableColInfo[o.length];
			for (int i = 0; i < o.length; i++)
				res[i] = (TableColInfo) o[i];

		} catch (Exception e) {
			e.printStackTrace();
			// throw new DatabaseException("Erreur dans la r�cup�ration des
			// tables");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}
		return res;
	}

	/**
	 * Recup�re une connexion sur la base de donn�es.
	 * 
	 * @return La connexion � la base
	 * @exception DatabaseException
	 */
	private static java.sql.Connection getConnection() throws SQLException,
			DatabaseException {
		try {
			if ((defaultConn != null) && !defaultConn.isClosed()) {
				defaultConn.close();
			}

			Class.forName(driver);
			defaultConn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			defaultConn = null;
			throw new DatabaseException(
					"getConnection-Le driver n'a pas �t� trouv� dans le classpath");
		}
		return defaultConn;
	}

	public static synchronized TableFK[][] getExportedFK(TableInfo table) {
		return getFK(table, EXPORTED_KEY);
	}

	public static synchronized TableFK[] getFK(Connection conn, String tableName) {
		String pkCat = null;
		String fkCat = null;

		TableFK[] res = null;
		Vector tempRes = new Vector();
		ResultSet rs = null;
		try {
			DatabaseMetaData dbInfo = conn.getMetaData();
			rs = dbInfo.getCrossReference(pkCat, shema, tableName, fkCat,
					shema, null);
			while (rs.next()) {
				TableFK tbfk = new TableFK();
				tbfk.setPkTableCat(rs.getString(1));
				tbfk.setPkTableShem(rs.getString(2));
				tbfk.setPkTableName(rs.getString(3));
				tbfk.setPkColumnName(rs.getString(4));
				tbfk.setFkTableCat(rs.getString(5));
				tbfk.setFkTableShem(rs.getString(6));
				tbfk.setFkTableName(rs.getString(7));
				tbfk.setFkColumnName(rs.getString(8));
				tbfk.setKeySeq(rs.getShort(9));
				tempRes.add(tbfk);
			}
			res = new TableFK[tempRes.size()];
			for (int i = 0; i < tempRes.size(); i++)
				res[i] = (TableFK) tempRes.get(i);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}

		return res;
	}

	/**
	 * Gets a description of the foreign key columns in the foreign key table
	 * that reference the primary key columns of the primary key table (describe
	 * how one table imports another's key.) This should normally return a
	 * single foreign key/primary key pair (most tables only import a foreign
	 * key from a table once.) They are ordered by FKTABLE_CAT, FKTABLE_SCHEM,
	 * FKTABLE_NAME, and KEY_SEQ.
	 * 
	 * <P>
	 * Each foreign key column description has the following columns:
	 * <OL>
	 * <LI><B>PKTABLE_CAT</B> String => primary key table catalog (may be null)
	 * <LI><B>PKTABLE_SCHEM</B> String => primary key table schema (may be null)
	 * <LI><B>PKTABLE_NAME</B> String => primary key table name
	 * <LI><B>PKCOLUMN_NAME</B> String => primary key column name
	 * <LI><B>FKTABLE_CAT</B> String => foreign key table catalog (may be null)
	 * being exported (may be null)
	 * <LI><B>FKTABLE_SCHEM</B> String => foreign key table schema (may be null)
	 * being exported (may be null)
	 * <LI><B>FKTABLE_NAME</B> String => foreign key table name being exported
	 * <LI><B>FKCOLUMN_NAME</B> String => foreign key column name being exported
	 * <LI><B>KEY_SEQ</B> short => sequence number within foreign key
	 * <LI><B>UPDATE_RULE</B> short => What happens to foreign key when primary
	 * is updated:
	 * <UL>
	 * <LI>importedNoAction - do not allow update of primary key if it has been
	 * imported
	 * <LI>importedKeyCascade - change imported key to agree with primary key
	 * update
	 * <LI>importedKeySetNull - change imported key to NULL if its primary key
	 * has been updated
	 * <LI>importedKeySetDefault - change imported key to default values if its
	 * primary key has been updated
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * </UL>
	 * <LI><B>DELETE_RULE</B> short => What happens to the foreign key when
	 * primary is deleted.
	 * <UL>
	 * <LI>importedKeyNoAction - do not allow delete of primary key if it has
	 * been imported
	 * <LI>importedKeyCascade - delete rows that import a deleted key
	 * <LI>importedKeySetNull - change imported key to NULL if its primary key
	 * has been deleted
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * <LI>importedKeySetDefault - change imported key to default if its primary
	 * key has been deleted
	 * </UL>
	 * <LI><B>FK_NAME</B> String => foreign key name (may be null)
	 * <LI><B>PK_NAME</B> String => primary key name (may be null)
	 * <LI><B>DEFERRABILITY</B> short => can the evaluation of foreign key
	 * constraints be deferred until commit
	 * <UL>
	 * <LI>importedKeyInitiallyDeferred - see SQL92 for definition
	 * <LI>importedKeyInitiallyImmediate - see SQL92 for definition
	 * <LI>importedKeyNotDeferrable - see SQL92 for definition
	 * </UL>
	 * </OL>
	 * 
	 * @param primaryCatalog
	 *            a catalog name; "" retrieves those without a catalog; null
	 *            means drop catalog name from the selection criteria
	 * @param primarySchema
	 *            a schema name; "" retrieves those without a schema
	 * @param primaryTable
	 *            the table name that exports the key
	 * @param foreignCatalog
	 *            a catalog name; "" retrieves those without a catalog; null
	 *            means drop catalog name from the selection criteria
	 * @param foreignSchema
	 *            a schema name; "" retrieves those without a schema
	 * @param foreignTable
	 *            the table name that imports the key
	 * @return ResultSet - each row is a foreign key column description
	 * @exception SQLException
	 *                if a database access error occurs
	 * @see #getImportedKeys
	 */
	public static synchronized TableFK[] getFK(String tableName) {
		return getFK(defaultConn, tableName);
	}

	public static synchronized TableFK[][] getFK(TableInfo table, int type) {
		ArrayList firstDim = new ArrayList();
		ArrayList secondDim = new ArrayList();
		ResultSet rs = null;
		try {
			Connection conn = table.getConnInfo().getConn();
			DatabaseMetaData dbInfo = conn.getMetaData();
			if (type == IMPORTED_KEY)
				rs = dbInfo.getImportedKeys(table.getTableCat(), table
						.getTableShem(), table.getTableName());
			else
				rs = dbInfo.getExportedKeys(table.getTableCat(), table
						.getTableShem(), table.getTableName());
			String previousTableName = null;
			while (rs.next()) {
				TableFK tbfk = new TableFK();
				tbfk.setPkTableCat(rs.getString(1));
				tbfk.setPkTableShem(rs.getString(2));
				tbfk.setPkTableName(rs.getString(3));
				tbfk.setPkColumnName(rs.getString(4));
				tbfk.setFkTableCat(rs.getString(5));
				tbfk.setFkTableShem(rs.getString(6));
				tbfk.setFkTableName(rs.getString(7));
				tbfk.setFkColumnName(rs.getString(8));
				tbfk.setKeySeq(rs.getShort(9));
				tbfk.setFkName(rs.getString(12));
				if (previousTableName == null) {
					previousTableName = tbfk.getFkName();
				}
				if ((previousTableName != null)
						&& !previousTableName.equals(tbfk.getFkName())) {
					firstDim.add(secondDim
							.toArray(new TableFK[secondDim.size()]));
					secondDim.clear();
				}
				secondDim.add(tbfk);
			}
			if (secondDim.size() > 0)
				firstDim.add(secondDim.toArray(new TableFK[secondDim.size()]));
			TableFK[][] res = new TableFK[firstDim.size()][];
			for (int i = 0; i < res.length; i++) {
				res[i] = (TableFK[]) firstDim.get(i);
			}
			return res;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		return new TableFK[0][0];

	}

	public static synchronized TableFK[][] getImportedFK(TableInfo table) {
		return getFK(table, IMPORTED_KEY);
	}

	public static synchronized TablePK[] getPK(Connection conn,
			String catalogue, String shema, String tableName) {

		TablePK tbpk = null;
		TablePK[] res = null;
		ArrayList temp = new ArrayList();
		ResultSet rs = null;
		try {
			DatabaseMetaData dbInfo = conn.getMetaData();
			if ("default".equals(shema)) {
				shema = null;
				catalogue = null;
			}
			rs = dbInfo.getPrimaryKeys(catalogue, shema, tableName);
			while (rs.next()) {
				tbpk = new TablePK();
				tbpk.setCat(rs.getString(1));
				tbpk.setShem(rs.getString(2));
				tbpk.setTable(rs.getString(3));
				tbpk.setCol(rs.getString(4));
				try {
					tbpk.setKeySeq((short) rs.getInt(5));
				} catch (SQLException e) {
				}
				try {
					tbpk.setPkName(rs.getString(6));
				} catch (SQLException e) {
				}
				temp.add(tbpk);
			}
			res = (TablePK[]) temp.toArray(new TablePK[temp.size()]);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}
		return res;

	}

	/**
	 * Gets a description of a table's primary key columns. They are ordered by
	 * COLUMN_NAME. Each primary key column description has the following
	 * columns:
	 * 
	 * TABLE_CAT String => table catalog (may be null) TABLE_SCHEM String =>
	 * table schema (may be null) TABLE_NAME String => table name COLUMN_NAME
	 * String => column name KEY_SEQ short => sequence number within primary key
	 * PK_NAME String => primary key name (may be null)
	 * 
	 */
	public static synchronized TablePK[] getPK(TableInfo tbInfo) {
		return getPK(tbInfo.getConnInfo().getConn(), tbInfo.getTableCat(),
				tbInfo.getTableShem(), tbInfo.getTableName());
	}

	/**
	 * @param conn
	 * @param catalog
	 * @return
	 */
	public static ShemaInfo[] getShemas(ConnectionInfo info) {
		try {
			ResultSet rs = info.getConn().getMetaData().getSchemas();
			ArrayList list = new ArrayList();
			ShemaInfo shemaInfo;
			while (rs.next()) {
				shemaInfo = new ShemaInfo(info);
				try {
					shemaInfo.setCatalog(rs.getString(2));
				} catch (Exception e) {
				}
				shemaInfo.setName(rs.getString(1));
				list.add(shemaInfo);
			}
			return (ShemaInfo[]) list.toArray(new ShemaInfo[list.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (28/01/01 8:13:15) Retour de getTables TABLE_CAT String => table catalog
	 * (may be null) TABLE_SCHEM String => table schema (may be null) TABLE_NAME
	 * String => table name TABLE_TYPE String => table type. Typical types are
	 * "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY",
	 * "ALIAS", "SYNONYM". REMARKS String => explanatory comment on the table
	 * 
	 */
	public static synchronized TableInfo[] getTables() throws DatabaseException {
		return getTables(defaultConn);
	}

	/**
	 * @param info
	 * @return
	 */
	public static TableInfo[] getTables(CatalogInfo info) {
		String catalog = info.getCatalog();
		return getTables(info.getConnInfo().getConn(), catalog, null);
	}

	public static synchronized TableInfo[] getTables(Connection conn)
			throws DatabaseException {
		TableInfo[] res;
		ResultSet rs = null;
		try {
			DatabaseMetaData dbInfo = conn.getMetaData();
			rs = dbInfo.getTables(null, null, "%", null);
			Vector element = new Vector();
			while (rs.next()) {
				TableInfo ti = new TableInfo();
				ti.setConn(conn);
				ti.setTableCat(rs.getString(1));
				ti.setTableShem(rs.getString(2));
				ti.setTableName(rs.getString(3));
				ti.setTableType(rs.getString(4));
				ti.setTableRemarks(rs.getString(5));
				element.add(ti);
			}
			Object[] o = element.toArray();
			res = new TableInfo[o.length];
			for (int i = 0; i < o.length; i++)
				res[i] = (TableInfo) o[i];

		} catch (Exception e) {
			throw new DatabaseException(
					"Erreur dans la r�cup�ration des tables" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}
		return res;
	}

	public static synchronized TableInfo[] getTables(Connection conn,
			String catalog, String schema) {
		return getTables(conn, catalog, schema, "%");
	}

	public static TableInfo[] getTables(Connection conn, String catalog,
			String shema, String pattern) {
		try {
			ResultSet rs = conn.getMetaData().getTables(catalog, shema,
					pattern, null);
			ArrayList list = new ArrayList();
			TableInfo tableInfo;
			while (rs.next()) {
				tableInfo = new TableInfo();
				tableInfo.setConn(conn);
				tableInfo.setTableCat(rs.getString(1));
				tableInfo.setTableShem(rs.getString(2));
				tableInfo.setTableName(rs.getString(3));
				tableInfo.setTableType(rs.getString(4));
				tableInfo.setTableRemarks(rs.getString(5));
				list.add(tableInfo);
			}
			return (TableInfo[]) list.toArray(new TableInfo[list.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param conn
	 * @param catalog
	 * @param name
	 * @return
	 */
	public static TableInfo[] getTables(ShemaInfo shemaInfo) {
		String catalog = shemaInfo.getCatalog();
		String shema = shemaInfo.getName();
		if ("default".equals(shema)) {
			shema = null;
			catalog = null;
		}
		return getTables(shemaInfo.getConn(), catalog, shema);
	}

	/**
	 * Retrieves a description of all the standard SQL types supported by this
	 * database. They are ordered by DATA_TYPE and then by how closely the data
	 * type maps to the corresponding JDBC SQL type.
	 * 
	 * <P>
	 * Each type description has the following columns:
	 * <OL>
	 * <LI><B>TYPE_NAME</B> String => Type name
	 * <LI><B>DATA_TYPE</B> short => SQL data type from java.sql.Types
	 * <LI><B>PRECISION</B> int => maximum precision
	 * <LI><B>LITERAL_PREFIX</B> String => prefix used to quote a literal (may
	 * be <code>null</code>)
	 * <LI><B>LITERAL_SUFFIX</B> String => suffix used to quote a literal (may
	 * be <code>null</code>)
	 * <LI><B>CREATE_PARAMS</B> String => parameters used in creating the type
	 * (may be <code>null</code>)
	 * <LI><B>NULLABLE</B> short => can you use NULL for this type.
	 * <UL>
	 * <LI>typeNoNulls - does not allow NULL values
	 * <LI>typeNullable - allows NULL values
	 * <LI>typeNullableUnknown - nullability unknown
	 * </UL>
	 * <LI><B>CASE_SENSITIVE</B> boolean=> is it case sensitive.
	 * <LI><B>SEARCHABLE</B> short => can you use "WHERE" based on this type:
	 * <UL>
	 * <LI>typePredNone - No support
	 * <LI>typePredChar - Only supported with WHERE .. LIKE
	 * <LI>typePredBasic - Supported except for WHERE .. LIKE
	 * <LI>typeSearchable - Supported for all WHERE ..
	 * </UL>
	 * <LI><B>UNSIGNED_ATTRIBUTE</B> boolean => is it unsigned.
	 * <LI><B>FIXED_PREC_SCALE</B> boolean => can it be a money value.
	 * <LI><B>AUTO_INCREMENT</B> boolean => can it be used for an auto-increment
	 * value.
	 * <LI><B>LOCAL_TYPE_NAME</B> String => localized version of type name (may
	 * be <code>null</code>)
	 * <LI><B>MINIMUM_SCALE</B> short => minimum scale supported
	 * <LI><B>MAXIMUM_SCALE</B> short => maximum scale supported
	 * <LI><B>SQL_DATA_TYPE</B> int => unused
	 * <LI><B>SQL_DATETIME_SUB</B> int => unused
	 * <LI><B>NUM_PREC_RADIX</B> int => usually 2 or 10
	 * </OL>
	 * 
	 * @return a <code>ResultSet</code> object in which each row is an SQL type
	 *         description
	 * @exception SQLException
	 *                if a database access error occurs
	 */
	public static TypeInfo[] getTypeInfo(Connection conn) throws SQLException {
		ResultSet rs = conn.getMetaData().getTypeInfo();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			list.add(new TypeInfo(rs));
		}
		TypeInfo[] res = (TypeInfo[]) list.toArray(new TypeInfo[list.size()]);
		return res;
	}

	public static synchronized boolean isAutoIncrement(int sqlTyp,
			Connection conn) throws SQLException {
		String dbName = conn.getMetaData().getDatabaseProductName();
		Boolean result = (Boolean) typMap.get(dbName + "#"
				+ new Integer(sqlTyp));
		if (result == null) {
			TypeInfo[] info = getTypeInfo(conn);
			for (int i = 0; i < info.length; i++) {
				typMap.put(dbName + "#" + new Integer(info[i].getDataTyp()),
						new Boolean(info[i].getAutoIncrement()));
			}
		}
		return ((Boolean) typMap.get(dbName + "#" + new Integer(sqlTyp)))
				.booleanValue();
	}

	public static synchronized boolean isAutoIncrement(String typeName,
			Connection conn) throws SQLException {
		String dbName = conn.getMetaData().getDatabaseProductName();
		Boolean result = (Boolean) typMap.get(dbName + "#"
				+ typeName.toUpperCase());
		if (result == null) {
			TypeInfo[] info = getTypeInfo(conn);
			for (int i = 0; i < info.length; i++) {
				typMap.put(dbName + "#" + info[i].getTypeName().toUpperCase(),
						new Boolean(info[i].getAutoIncrement()));
			}
		}
		Boolean tmp = (Boolean) typMap.get(dbName + "#"
				+ typeName.toUpperCase());
		if (tmp == null)
			return false;
		else
			return tmp.booleanValue();
	}

	public static void main(String[] args) {
		try {
			getConnection();
			TableInfo[] infos = getTables();
			getColumns(infos[0]);
			// infos[0].setConnInfo(connInfo);
			getFK(infos[0], IMPORTED_KEY);
		} catch (SQLException e) {
		} catch (DatabaseException e) {
		}
	}

	/**
	 * Commentaire relatif au constructeur DatabaseInfo.
	 */
	public DatabaseInfo(Connection conn) {
		DatabaseInfo.defaultConn = conn;
	}

	/**
	 * Commentaire relatif au constructeur DatabaseInfo.
	 */
	public DatabaseInfo(String driver, String url, String user, String pwd)
			throws SQLException, DatabaseException {
		super();
		shema = user;
		DatabaseInfo.driver = driver;
		DatabaseInfo.url = url;
		DatabaseInfo.user = user;
		DatabaseInfo.pwd = pwd;
		// conn = getConnection();
	}

	/**
	 * Gets a description of the foreign key columns in the foreign key table
	 * that reference the primary key columns of the primary key table (describe
	 * how one table imports another's key.) This should normally return a
	 * single foreign key/primary key pair (most tables only import a foreign
	 * key from a table once.) They are ordered by FKTABLE_CAT, FKTABLE_SCHEM,
	 * FKTABLE_NAME, and KEY_SEQ.
	 * 
	 * <P>
	 * Each foreign key column description has the following columns:
	 * <OL>
	 * <LI><B>PKTABLE_CAT</B> String => primary key table catalog (may be null)
	 * <LI><B>PKTABLE_SCHEM</B> String => primary key table schema (may be null)
	 * <LI><B>PKTABLE_NAME</B> String => primary key table name
	 * <LI><B>PKCOLUMN_NAME</B> String => primary key column name
	 * <LI><B>FKTABLE_CAT</B> String => foreign key table catalog (may be null)
	 * being exported (may be null)
	 * <LI><B>FKTABLE_SCHEM</B> String => foreign key table schema (may be null)
	 * being exported (may be null)
	 * <LI><B>FKTABLE_NAME</B> String => foreign key table name being exported
	 * <LI><B>FKCOLUMN_NAME</B> String => foreign key column name being exported
	 * <LI><B>KEY_SEQ</B> short => sequence number within foreign key
	 * <LI><B>UPDATE_RULE</B> short => What happens to foreign key when primary
	 * is updated:
	 * <UL>
	 * <LI>importedNoAction - do not allow update of primary key if it has been
	 * imported
	 * <LI>importedKeyCascade - change imported key to agree with primary key
	 * update
	 * <LI>importedKeySetNull - change imported key to NULL if its primary key
	 * has been updated
	 * <LI>importedKeySetDefault - change imported key to default values if its
	 * primary key has been updated
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * </UL>
	 * <LI><B>DELETE_RULE</B> short => What happens to the foreign key when
	 * primary is deleted.
	 * <UL>
	 * <LI>importedKeyNoAction - do not allow delete of primary key if it has
	 * been imported
	 * <LI>importedKeyCascade - delete rows that import a deleted key
	 * <LI>importedKeySetNull - change imported key to NULL if its primary key
	 * has been deleted
	 * <LI>importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x
	 * compatibility)
	 * <LI>importedKeySetDefault - change imported key to default if its primary
	 * key has been deleted
	 * </UL>
	 * <LI><B>FK_NAME</B> String => foreign key name (may be null)
	 * <LI><B>PK_NAME</B> String => primary key name (may be null)
	 * <LI><B>DEFERRABILITY</B> short => can the evaluation of foreign key
	 * constraints be deferred until commit
	 * <UL>
	 * <LI>importedKeyInitiallyDeferred - see SQL92 for definition
	 * <LI>importedKeyInitiallyImmediate - see SQL92 for definition
	 * <LI>importedKeyNotDeferrable - see SQL92 for definition
	 * </UL>
	 * </OL>
	 * 
	 * @param primaryCatalog
	 *            a catalog name; "" retrieves those without a catalog; null
	 *            means drop catalog name from the selection criteria
	 * @param primarySchema
	 *            a schema name; "" retrieves those without a schema
	 * @param primaryTable
	 *            the table name that exports the key
	 * @param foreignCatalog
	 *            a catalog name; "" retrieves those without a catalog; null
	 *            means drop catalog name from the selection criteria
	 * @param foreignSchema
	 *            a schema name; "" retrieves those without a schema
	 * @param foreignTable
	 *            the table name that imports the key
	 * @return ResultSet - each row is a foreign key column description
	 * @exception SQLException
	 *                if a database access error occurs
	 * @see #getImportedKeys
	 */
	public synchronized TableFK[] getFK(Connection conn, String[] tableName) {
		String pkCat = null;
		String fkCat = null;

		TableFK[] res = null;
		Vector tempRes = new Vector();
		ResultSet rs = null;
		try {
			DatabaseMetaData dbInfo = conn.getMetaData();
			for (int i = 0; i < tableName.length; i++) {
				for (int j = 0; j < tableName.length; j++) {
					if (i != j) {
						rs = dbInfo.getCrossReference(pkCat, shema,
								tableName[i], fkCat, shema, tableName[j]);
						while (rs.next()) {
							TableFK tbfk = new TableFK();
							tbfk.setPkTableCat(rs.getString(1));
							tbfk.setPkTableShem(rs.getString(2));
							tbfk.setPkTableName(rs.getString(3));
							tbfk.setPkColumnName(rs.getString(4));
							tbfk.setFkTableCat(rs.getString(5));
							tbfk.setFkTableShem(rs.getString(6));
							tbfk.setFkTableName(rs.getString(7));
							tbfk.setFkColumnName(rs.getString(8));
							tbfk.setKeySeq(rs.getShort(9));
							tempRes.add(tbfk);
						}

					}
				}
			}
			res = new TableFK[tempRes.size()];
			for (int i = 0; i < tempRes.size(); i++)
				res[i] = (TableFK) tempRes.get(i);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}

		return res;
	}

	public String getWhereClause(Connection conn, String[] tableNames) {
		TableFK[] tbfk = getFK(conn, tableNames);
		String whereValue = "";
		if (tbfk != null) {
			for (int i = 0; i < tbfk.length; i++) {
				if (i == 0)
					whereValue += "\n\t where " + tbfk[i].getPkTableName()
							+ "." + tbfk[i].getPkColumnName() + " = "
							+ tbfk[i].getFkTableName() + "."
							+ tbfk[i].getFkColumnName();
				else
					whereValue += "\n\t and " + tbfk[i].getPkTableName() + "."
							+ tbfk[i].getPkColumnName() + " = "
							+ tbfk[i].getFkTableName() + "."
							+ tbfk[i].getFkColumnName();
			}
		}
		return whereValue;
	}

	/**
	 * Ins�rez la description de la m�thode � cet endroit. Date de cr�ation :
	 * (3/02/01 11:52:21)
	 * 
	 * @return java.lang.String
	 */
	public String getWhereClause(String[] tableNames) {
		return getWhereClause(defaultConn, tableNames);
	}
}