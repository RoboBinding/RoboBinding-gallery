package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.model.typedcursor.GetAllQuery;
import org.robobinding.gallery.model.typedcursor.ProductItemPresentationModel;
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
    private final SQLiteDatabase db;
    private final GetAllQuery<Product> allProductsQuery;
    private TypedCursor<Product> productCursor;

    public TypedCursorPresentationModel(SQLiteDatabase db, GetAllQuery<Product> allProductsQuery) {
	this.db = db;
	this.allProductsQuery = allProductsQuery;
    }

    @ItemPresentationModel(value=ProductItemPresentationModel.class)
    public TypedCursor<Product> getProducts() {
	productCursor = allProductsQuery.execute(db);
	return productCursor;
    }
    
    public void cleanUp() {
	if (productCursor != null) {
	    productCursor.close();
	}
    }
}
