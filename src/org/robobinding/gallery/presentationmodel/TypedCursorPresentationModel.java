package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.model.typedcursor.GetAllQuery;
import org.robobinding.gallery.model.typedcursor.Product;
import org.robobinding.gallery.model.typedcursor.ProductItemPresentationModel;
import org.robobinding.gallery.model.typedcursor.ProductRowMapper;
import org.robobinding.gallery.model.typedcursor.ProductTable;
import org.robobinding.itempresentationmodel.TypedCursor;

import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class TypedCursorPresentationModel {
    private SQLiteDatabase db;
    private GetAllQuery<Product> allProductsQuery;

    public TypedCursorPresentationModel(SQLiteDatabase db) {
	this.db = db;
	allProductsQuery = new GetAllQuery<Product>(ProductTable.TABLE_NAME, new ProductRowMapper());
    }

    @ItemPresentationModel(value=ProductItemPresentationModel.class)
    public TypedCursor<Product> getProducts() {
	return allProductsQuery.execute(db);
    }
}
