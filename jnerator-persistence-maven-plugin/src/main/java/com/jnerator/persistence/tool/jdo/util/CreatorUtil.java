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

package com.jnerator.persistence.tool.jdo.util;

import com.jnerator.persistence.tool.jdo.data.JdoColInfo;

/**
 * 
 * 
 * @author e.loiez@salto-consulting.com
 */
public class CreatorUtil {
	private static IDoNameCreator nameCreator = new DoNameCreator();

	private static IJdbcConvert jdbcConvert = new DoJdbcConvert();

	private static CreatorUtil instance = new CreatorUtil();

	public static String getClassNameForPrimitive(String primitiveName) {
		if ("int".equals(primitiveName)) {
			return "Integer";
		}
		if ("short".equals(primitiveName)) {
			return "Short";
		}
		if ("long".equals(primitiveName)) {
			return "Long";
		}

		if ("byte".equals(primitiveName)) {
			return "Byte";
		}

		if ("boolean".equals(primitiveName)) {
			return "Boolean";
		}

		if ("double".equals(primitiveName)) {
			return "Double";
		}

		if ("float".equals(primitiveName)) {
			return "Float";
		}

		return primitiveName;
	}

	public static IDoNameCreator getDoNameCreator() {
		return nameCreator;
	}

	/**
	 * @return
	 */
	public static CreatorUtil getInstance() {
		return instance;
	}

	/**
	 * Retourne le composant permettant de converir les types Jdbc en type Java
	 * 
	 * @return Returns the jdbcConvert.
	 */
	public static IJdbcConvert getJdbcConvert() {
		return jdbcConvert;
	}

	public static int getLength(Object[] obj) {
		if (obj == null)
			return 0;
		return obj.length;
	}

	/**
	 * fonction sp�cifique au dataobjet permettant de retourner la m�thode
	 * permettant de retourner la m�thode permettant de convertir la donn�e
	 * re�ue du ResultSet.
	 * 
	 * @param colInfo
	 * @return
	 */
	public static String getMethod(JdoColInfo colInfo) {
		if (colInfo.getJavaAttClass().equals("String")) {
			return "stringValue";
		} else if (colInfo.getJavaAttClass().equals("boolean")) {
			return "primBooleanValue";
		} else if (colInfo.getJavaAttClass().equals("Boolean")) {
			return "booleanValue";
		} else if (colInfo.getJavaAttClass().equals("byte")) {
			return "primByteValue";
		} else if (colInfo.getJavaAttClass().equals("Byte")) {
			return "byteValue";
		} else if (colInfo.getJavaAttClass().equals("byte[]")) {
			return "bytesValue";
		} else if (colInfo.getJavaAttClass().equals("short")) {
			return "primShortValue";
		} else if (colInfo.getJavaAttClass().equals("Short")) {
			return "shortValue";
		} else if (colInfo.getJavaAttClass().equals("int")) {
			return "intValue";
		} else if (colInfo.getJavaAttClass().equals("Integer")) {
			return "integerValue";
		} else if (colInfo.getJavaAttClass().equals("long")) {
			return "primLongValue";
		} else if (colInfo.getJavaAttClass().equals("Long")) {
			return "longValue";
		} else if (colInfo.getJavaAttClass().equals("float")) {
			return "primFloatValue";
		} else if (colInfo.getJavaAttClass().equals("Float")) {
			return "floatValue";
		} else if (colInfo.getJavaAttClass().equals("Double")) {
			return "doubleValue";
		} else if (colInfo.getJavaAttClass().equals("double")) {
			return "primDoubleValue";
		} else if (colInfo.getJavaAttClass().equals("Timestamp")) {
			return "timestampValue";
		} else if (colInfo.getJavaAttClass().equals("Date")) {
			return "dateValue";
		} else if (colInfo.getJavaAttClass().equals("Time")) {
			return "timeValue";
		} else if (colInfo.getJavaAttClass().equals("BigDecimal")) {
			return "bigDecimalValue";
		}
		return "objectValue";
	}

	public static String getStmtMethod(JdoColInfo colInfo) {
		return "setValue";
		// if (colInfo.getJavaAttClass().equals("String")) {
		// return "setValue";
		// } else if (colInfo.getJavaAttClass().equals("boolean")) {
		// return "primBooleanValue";
		// } else if (colInfo.getJavaAttClass().equals("Boolean")) {
		// return "booleanValue";
		// } else if (colInfo.getJavaAttClass().equals("byte")) {
		// return "primByteValue";
		// } else if (colInfo.getJavaAttClass().equals("Byte")) {
		// return "byteValue";
		// } else if (colInfo.getJavaAttClass().equals("byte[]")) {
		// return "bytesValue";
		// } else if (colInfo.getJavaAttClass().equals("short")) {
		// return "primShortValue";
		// } else if (colInfo.getJavaAttClass().equals("Short")) {
		// return "shortValue";
		// } else if (colInfo.getJavaAttClass().equals("int")) {
		// return "intValue";
		// } else if (colInfo.getJavaAttClass().equals("Integer")) {
		// return "integerValue";
		// } else if (colInfo.getJavaAttClass().equals("long")) {
		// return "primLongValue";
		// } else if (colInfo.getJavaAttClass().equals("Long")) {
		// return "longValue";
		// } else if (colInfo.getJavaAttClass().equals("float")) {
		// return "primFloatValue";
		// } else if (colInfo.getJavaAttClass().equals("Float")) {
		// return "floatValue";
		// } else if (colInfo.getJavaAttClass().equals("Double")) {
		// return "doubleValue";
		// } else if (colInfo.getJavaAttClass().equals("double")) {
		// return "primDoubleValue";
		// } else if (colInfo.getJavaAttClass().equals("Timestamp")) {
		// return "timestampValue";
		// } else if (colInfo.getJavaAttClass().equals("Date")) {
		// return "dateValue";
		// } else if (colInfo.getJavaAttClass().equals("Time")) {
		// return "timeValue";
		// } else if (colInfo.getJavaAttClass().equals("BigDecimal")) {
		// return "BigDecimalValue";
		// }
		// return "objectValue";
	}

	public static String setParamMethod(JdoColInfo colInfo) {
		if (colInfo.getJavaAttClass().equals("String")) {
			return "stringValue";
		} else if (colInfo.getJavaAttClass().equals("boolean")) {
			return "pBooleanValue";
		} else if (colInfo.getJavaAttClass().equals("Boolean")) {
			return "booleanValue";
		} else if (colInfo.getJavaAttClass().equals("byte")) {
			return "pByteValue";
		} else if (colInfo.getJavaAttClass().equals("Byte")) {
			return "byteValue";
		} else if (colInfo.getJavaAttClass().equals("byte[]")) {
			return "bytesValue";
		} else if (colInfo.getJavaAttClass().equals("short")) {
			return "pShortValue";
		} else if (colInfo.getJavaAttClass().equals("Short")) {
			return "shortValue";
		} else if (colInfo.getJavaAttClass().equals("int")) {
			return "intValue";
		} else if (colInfo.getJavaAttClass().equals("Integer")) {
			return "integerValue";
		} else if (colInfo.getJavaAttClass().equals("long")) {
			return "pLongValue";
		} else if (colInfo.getJavaAttClass().equals("Long")) {
			return "longValue";
		} else if (colInfo.getJavaAttClass().equals("float")) {
			return "pFloatValue";
		} else if (colInfo.getJavaAttClass().equals("Float")) {
			return "floatValue";
		} else if (colInfo.getJavaAttClass().equals("Double")) {
			return "doubleValue";
		} else if (colInfo.getJavaAttClass().equals("double")) {
			return "pDoubleValue";
		} else if (colInfo.getJavaAttClass().equals("Timestamp")) {
			return "timestampValue";
		} else if (colInfo.getJavaAttClass().equals("Date")) {
			return "dateValue";
		} else if (colInfo.getJavaAttClass().equals("Time")) {
			return "timeValue";
		} else if (colInfo.getJavaAttClass().equals("BigDecimal")) {
			return "bigDecimalValue";
		}
		return null;
	}

}
