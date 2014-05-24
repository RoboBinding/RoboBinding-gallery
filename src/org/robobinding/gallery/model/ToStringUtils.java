/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.gallery.model;

import android.util.SparseBooleanArray;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ToStringUtils {
    public static String toString(SparseBooleanArray array) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < array.size(); i++) {
	    sb.append(array.keyAt(i));
	    sb.append(":");
	    sb.append(array.valueAt(i));
	    sb.append(", ");
	}

	if (sb.toString().endsWith(", ")) {
	    sb.delete(sb.length() - 2, sb.length());
	}

	return sb.toString();
    }

    private ToStringUtils() {
    }
}
