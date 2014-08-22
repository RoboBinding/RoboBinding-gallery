package org.robobinding.gallery.activity;

import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.gallery.model.typedcursor.DatabaseHelper;

import android.app.Application;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class GalleryApp extends Application {
    private BinderFactory reusableBinderFactory;
    private DatabaseHelper databaseHelper;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        databaseHelper = new DatabaseHelper(this);
        reusableBinderFactory = new BinderFactoryBuilder().build();
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
}
