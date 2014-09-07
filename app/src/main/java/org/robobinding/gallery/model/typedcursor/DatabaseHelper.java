package org.robobinding.gallery.model.typedcursor;

import java.text.MessageFormat;
import java.util.List;

import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.model.TestData;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @since 1.0
 * @version $Revision: $
 * @author Cheng Wei
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 2;

    public DatabaseHelper(Context context) {
	super(context, "typedcursorsample.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
	String itemTable = MessageFormat.format("create table {0} ({1} integer primary key autoincrement, {2} text not null, {3} text not null)",
		ProductTable.TABLE_NAME, ProductTable._ID, ProductTable.NAME, ProductTable.DESCRIPTION);
	db.execSQL(itemTable);

	List<Product> products = TestData.products();
	for(Product product : products) {
	    insertProduct(db, product);
	}
    }

    private long insertProduct(SQLiteDatabase db, Product product) {
	ContentValues values = new ContentValues();
	values.put(ProductTable.NAME, product.getName());
	values.put(ProductTable.DESCRIPTION, product.getDescription());
	return db.insert(ProductTable.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	db.execSQL("drop table if exists " + ProductTable.TABLE_NAME);
	onCreate(db);
    }

}
