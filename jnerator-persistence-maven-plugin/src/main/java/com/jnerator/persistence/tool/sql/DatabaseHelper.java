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

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import com.jnerator.persistence.tool.sql.data.TableColInfo;
import com.jnerator.persistence.tool.sql.data.TablePK;

/**
 * Objet contenant un certain nombre de m�thodes statiques utiles tri, ...
 * 
 * @version 1.0
 * @author E.Loiez
 */
public class DatabaseHelper {

	public static void orderBySeq(TablePK[] pk) {
		Arrays.sort(pk, new Comparator() {
			public int compare(Object o1, Object o2) {
				TablePK pk1 = (TablePK) o1;
				TablePK pk2 = (TablePK) o2;
				if (pk1.getKeySeq() == pk2.getKeySeq())
					return 0;
				else if (pk1.getKeySeq() == pk2.getKeySeq())
					return -1;
				else
					return 1;
			}
		});
	}

	public static void setPk(TableColInfo[] col, TablePK[] pk) {
		HashMap map = new HashMap();
		for (int i = 0; i < pk.length; i++) {
			map.put(pk[i].getCol(), new Integer(pk[i].getKeySeq()));
		}
		Integer seq;
		for (int i = 0; i < col.length; i++) {
			seq = (Integer) map.get(col[i].getColName());
			if (seq != null) {
				col[i].setPkColSeq(seq.intValue());
			}
		}
	}
}
