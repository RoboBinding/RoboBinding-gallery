package org.robobinding.gallery.model.typedcursor;

import android.provider.BaseColumns;


/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public interface ProductTable extends BaseColumns {
    String TABLE_NAME = "product";

    String NAME = "name";
    String DESCRIPTION = "description";
}
