package org.robobinding.gallery.activity;

import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.customviewbinding.CustomViewBinding;
import org.robobinding.gallery.model.customcomponent.TitleDescriptionBar;
import org.robobinding.gallery.model.customcomponent.TitleDescriptionBarBinding;
import org.robobinding.gallery.model.typedcursor.DatabaseHelper;
import org.robobinding.supportwidget.recyclerView.RecyclerViewBinding;
import org.robobinding.widget.menuitemgroup.MenuItemGroup;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
        reusableBinderFactory = new BinderFactoryBuilder()
                .add(new ViewBindingForView().extend(View.class))
                .add(new MenuItemBinding().extend(MenuItem.class))
                .add(new MenuItemGroupBinding().forView(MenuItemGroup.class))
                .add(CustomViewBinding.forView(RecyclerView.class, new RecyclerViewBinding()))
                .build();
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
}
