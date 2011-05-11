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

package com.jnerator.persistence.tool.object;

import java.lang.reflect.Method;
import java.util.Comparator;

public class GenericComparator implements Comparator {

	private final Method reader;

	// private static final String[] args =

	public GenericComparator(Method reader) {
		this.reader = reader;
	}

	/*
	 * @see Comparator#compare(Object, Object)
	 */
	public int compare(Object o1, Object o2) {
		try {
			Object firstObj = reader.invoke(o1, null);
			Object secondOjb = reader.invoke(o2, null);
			// nullValue is always lower
			if (firstObj == null) {
				if (secondOjb == null)
					return 0;
				else
					return 1;
			} else if (secondOjb == null)
				return -1;
			else {
				String s1 = firstObj.toString();
				String s2 = secondOjb.toString();
				return s1.compareTo(s2);
			}
		} catch (Exception e) {
			// what can we do
			e.printStackTrace();
		}
		return 0;
	}

}
