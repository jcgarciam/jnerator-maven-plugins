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

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author remi
 * 
 */
public final class HibernateDialectHelper {

	private static final Map dialects = new HashMap();

	static {
		dialects.put("Oracle", "org.hibernate.dialect.OracleDialect");
		dialects.put("Microsoft SQL Server",
				"org.hibernate.dialect.SQLServerDialect");
		dialects.put("PostgreSQL", "org.hibernate.dialect.PostgreSQLDialect");
		dialects.put("HypersonicSQL", "org.hibernate.dialect.HSQLDialect");

	}

	public final String getHibernateDialect(DatabaseMetaData metaData)
			throws SQLException {
		if (metaData == null)
			return null;

		if (metaData.getDatabaseProductName().equals("MySQL")) {
			if (metaData.getDatabaseMajorVersion() >= 5) {
				return "org.hibernate.dialect.MySQL5Dialect";
			}
			return "org.hibernate.dialect.MySQLDialect";
		} else
			return (String) dialects.get(metaData.getDatabaseProductName());

	}

}
