package org.robobinding.gallery.model.typedcursor;

import org.robobinding.itempresentationmodel.RowMapper;

import android.database.Cursor;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(Cursor cursor) {
	String name = cursor.getString(cursor.getColumnIndex(ProductTable.NAME));
	String description = cursor.getString(cursor.getColumnIndex(ProductTable.DESCRIPTION));
	return new Product(name, description);
    }

}
