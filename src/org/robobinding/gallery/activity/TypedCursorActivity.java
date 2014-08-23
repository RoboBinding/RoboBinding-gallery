package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.model.typedcursor.GetAllQuery;
import org.robobinding.gallery.model.typedcursor.ProductRowMapper;
import org.robobinding.gallery.model.typedcursor.ProductTable;
import org.robobinding.gallery.presentationmodel.TypedCursorPresentationModel;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TypedCursorActivity extends AbstractActivity {

    private TypedCursorPresentationModel presentationModel;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	
	GetAllQuery<Product> allProductsQuery = new GetAllQuery<Product>(ProductTable.TABLE_NAME, new ProductRowMapper());
	db = getDatabaseHelper().getReadableDatabase();
	presentationModel = new TypedCursorPresentationModel(db, allProductsQuery);

	initializeContentView(R.layout.activity_typed_cursor, presentationModel);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        presentationModel.cleanUp();
        db.close();
    }

}
