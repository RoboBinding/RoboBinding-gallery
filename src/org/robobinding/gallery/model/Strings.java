package org.robobinding.gallery.model;

import android.util.SparseBooleanArray;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class Strings {
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

    private Strings() {
    }
}
