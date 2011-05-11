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

package com.jnerator.persistence.tool.sql.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @version 1.0
 * @author
 */
public class TypeInfo {

	/**
	 * Nom du type (retourn� par la base de donn�e)
	 */
	private String typeName;
	/**
	 * @see Types
	 */
	private short dataTyp;
	/**
	 * maximum precision
	 */
	private int precision;
	/**
	 * prefix used to quote a literal
	 */
	private String literalPrefix;
	/**
	 * suffix used to quote a literal
	 */
	private String literalsuffix;
	/**
	 * parameters used in creating the type
	 */
	private String createParams;
	/**
	 * can you use NULL for this type.
	 * <UL>
	 * <LI>typeNoNulls - does not allow NULL values
	 * <LI>typeNullable - allows NULL values
	 * <LI>typeNullableUnknown - nullability unknown
	 * </UL>
	 */
	private short nullable;
	/**
	 * is it case sensitive.
	 */
	private boolean caseSensitive;
	/**
	 * can you use "WHERE" based on this type:
	 * <UL>
	 * <LI>typePredNone - No support
	 * <LI>typePredChar - Only supported with WHERE .. LIKE
	 * <LI>typePredBasic - Supported except for WHERE .. LIKE
	 * <LI>typeSearchable - Supported for all WHERE ..
	 * </UL>
	 */
	private short searchable;
	/**
	 * is it unsigned.
	 */
	private boolean unsignedAttribute;
	/**
	 * can it be a money value.
	 */
	private boolean fixedPrecScale;
	/**
	 * can it be used for an auto-increment value.
	 */
	private boolean autoIncrement;
	/**
	 * localized version of type name
	 */
	private String localTypeName;
	/**
	 * minimum scale supported
	 */
	private short minimumScale;
	/**
	 * maximum scale supported
	 */
	private short maximumScale;
	/**
	 * unused
	 */
	private int sqlDataTyp;
	/**
	 * unused
	 */
	private int sqlDateTimeSub;
	/**
	 * usually 2 or 10
	 */
	private int numPrecRadix;

	/**
	 * Constructor for TypeInfo.
	 */
	public TypeInfo(ResultSet rs) {
		try {
			typeName = rs.getString(1);
		} catch (SQLException e) {
		}
		try {
			dataTyp = rs.getShort(2);
		} catch (SQLException e) {
		}
		try {
			precision = rs.getInt(3);
		} catch (SQLException e) {
		}
		try {
			literalPrefix = rs.getString(4);
		} catch (SQLException e) {
		}
		try {
			literalsuffix = rs.getString(5);
		} catch (SQLException e) {
		}
		try {
			createParams = rs.getString(6);
		} catch (SQLException e) {
		}
		try {
			nullable = rs.getShort(7);
		} catch (SQLException e) {
		}
		try {
			caseSensitive = rs.getBoolean(8);
		} catch (SQLException e) {
		}
		try {
			searchable = rs.getShort(9);
		} catch (SQLException e) {
		}
		try {
			unsignedAttribute = rs.getBoolean(10);
		} catch (SQLException e) {
		}
		try {
			fixedPrecScale = rs.getBoolean(11);
		} catch (SQLException e) {
		}
		try {
			autoIncrement = rs.getBoolean(12);
		} catch (SQLException e) {
		}
		try {
			localTypeName = rs.getString(13);
		} catch (SQLException e) {
		}
		try {
			minimumScale = rs.getShort(14);
		} catch (SQLException e) {
		}
		try {
			maximumScale = rs.getShort(15);
		} catch (SQLException e) {
		}
		try {
			sqlDataTyp = rs.getInt(16);
		} catch (SQLException e) {
		}
		try {
			sqlDateTimeSub = rs.getInt(17);
		} catch (SQLException e) {
		}
		try {
			numPrecRadix = rs.getInt(18);
		} catch (SQLException e) {
		}
	}

	/**
	 * Gets the autoIncrement.
	 * 
	 * @return Returns a boolean
	 */
	public boolean getAutoIncrement() {
		return autoIncrement;
	}

	/**
	 * Gets the caseSensitive.
	 * 
	 * @return Returns a boolean
	 */
	public boolean getCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * Gets the createParams.
	 * 
	 * @return Returns a String
	 */
	public String getCreateParams() {
		return createParams;
	}

	/**
	 * Gets the dataTyp.
	 * 
	 * @return Returns a short
	 */
	public short getDataTyp() {
		return dataTyp;
	}

	/**
	 * Gets the ixedPrecScale.
	 * 
	 * @return Returns a boolean
	 */
	public boolean getIxedPrecScale() {
		return fixedPrecScale;
	}

	/**
	 * Gets the literalPrefix.
	 * 
	 * @return Returns a String
	 */
	public String getLiteralPrefix() {
		return literalPrefix;
	}

	/**
	 * Gets the literalsuffix.
	 * 
	 * @return Returns a String
	 */
	public String getLiteralsuffix() {
		return literalsuffix;
	}

	/**
	 * Gets the localTypeName.
	 * 
	 * @return Returns a String
	 */
	public String getLocalTypeName() {
		return localTypeName;
	}

	/**
	 * Gets the maximumScale.
	 * 
	 * @return Returns a short
	 */
	public short getMaximumScale() {
		return maximumScale;
	}

	/**
	 * Gets the minimumScale.
	 * 
	 * @return Returns a short
	 */
	public short getMinimumScale() {
		return minimumScale;
	}

	/**
	 * Gets the nullable.
	 * 
	 * @return Returns a short
	 */
	public short getNullable() {
		return nullable;
	}

	/**
	 * Gets the numPrecRadix.
	 * 
	 * @return Returns a int
	 */
	public int getNumPrecRadix() {
		return numPrecRadix;
	}

	/**
	 * Gets the precision.
	 * 
	 * @return Returns a int
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * Gets the searchable.
	 * 
	 * @return Returns a short
	 */
	public short getSearchable() {
		return searchable;
	}

	/**
	 * Gets the sqlDataTyp.
	 * 
	 * @return Returns a int
	 */
	public int getSqlDataTyp() {
		return sqlDataTyp;
	}

	/**
	 * Gets the sqlDateTimeSub.
	 * 
	 * @return Returns a int
	 */
	public int getSqlDateTimeSub() {
		return sqlDateTimeSub;
	}

	/**
	 * Gets the typeName.
	 * 
	 * @return Returns a String
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Gets the unsignedAttribute.
	 * 
	 * @return Returns a boolean
	 */
	public boolean getUnsignedAttribute() {
		return unsignedAttribute;
	}

	/**
	 * Sets the autoIncrement.
	 * 
	 * @param autoIncrement
	 *            The autoIncrement to set
	 */
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	/**
	 * Sets the caseSensitive.
	 * 
	 * @param caseSensitive
	 *            The caseSensitive to set
	 */
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Sets the createParams.
	 * 
	 * @param createParams
	 *            The createParams to set
	 */
	public void setCreateParams(String createParams) {
		this.createParams = createParams;
	}

	/**
	 * Sets the dataTyp.
	 * 
	 * @param dataTyp
	 *            The dataTyp to set
	 */
	public void setDataTyp(short dataTyp) {
		this.dataTyp = dataTyp;
	}

	/**
	 * Sets the ixedPrecScale.
	 * 
	 * @param ixedPrecScale
	 *            The ixedPrecScale to set
	 */
	public void setIxedPrecScale(boolean ixedPrecScale) {
		fixedPrecScale = ixedPrecScale;
	}

	/**
	 * Sets the literalPrefix.
	 * 
	 * @param literalPrefix
	 *            The literalPrefix to set
	 */
	public void setLiteralPrefix(String literalPrefix) {
		this.literalPrefix = literalPrefix;
	}

	/**
	 * Sets the literalsuffix.
	 * 
	 * @param literalsuffix
	 *            The literalsuffix to set
	 */
	public void setLiteralsuffix(String literalsuffix) {
		this.literalsuffix = literalsuffix;
	}

	/**
	 * Sets the localTypeName.
	 * 
	 * @param localTypeName
	 *            The localTypeName to set
	 */
	public void setLocalTypeName(String localTypeName) {
		this.localTypeName = localTypeName;
	}

	/**
	 * Sets the maximumScale.
	 * 
	 * @param maximumScale
	 *            The maximumScale to set
	 */
	public void setMaximumScale(short maximumScale) {
		this.maximumScale = maximumScale;
	}

	/**
	 * Sets the minimumScale.
	 * 
	 * @param minimumScale
	 *            The minimumScale to set
	 */
	public void setMinimumScale(short minimumScale) {
		this.minimumScale = minimumScale;
	}

	/**
	 * Sets the nullable.
	 * 
	 * @param nullable
	 *            The nullable to set
	 */
	public void setNullable(short nullable) {
		this.nullable = nullable;
	}

	/**
	 * Sets the numPrecRadix.
	 * 
	 * @param numPrecRadix
	 *            The numPrecRadix to set
	 */
	public void setNumPrecRadix(int numPrecRadix) {
		this.numPrecRadix = numPrecRadix;
	}

	/**
	 * Sets the precision.
	 * 
	 * @param precision
	 *            The precision to set
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * Sets the searchable.
	 * 
	 * @param searchable
	 *            The searchable to set
	 */
	public void setSearchable(short searchable) {
		this.searchable = searchable;
	}

	/**
	 * Sets the sqlDataTyp.
	 * 
	 * @param sqlDataTyp
	 *            The sqlDataTyp to set
	 */
	public void setSqlDataTyp(int sqlDataTyp) {
		this.sqlDataTyp = sqlDataTyp;
	}

	/**
	 * Sets the sqlDateTimeSub.
	 * 
	 * @param sqlDateTimeSub
	 *            The sqlDateTimeSub to set
	 */
	public void setSqlDateTimeSub(int sqlDateTimeSub) {
		this.sqlDateTimeSub = sqlDateTimeSub;
	}

	/**
	 * Sets the typeName.
	 * 
	 * @param typeName
	 *            The typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Sets the unsignedAttribute.
	 * 
	 * @param unsignedAttribute
	 *            The unsignedAttribute to set
	 */
	public void setUnsignedAttribute(boolean unsignedAttribute) {
		this.unsignedAttribute = unsignedAttribute;
	}

}
