package org.robobinding.gallery.activity;

import org.robobinding.MenuBinder;
import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.gallery.model.typedcursor.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractActivity extends ActionBarActivity {
    public void initializeContentView(int layoutId, Object presentationModel) {
	ViewBinder viewBinder = createViewBinder();
	View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
	setContentView(rootView);
    }
    
    private ViewBinder createViewBinder() {
	BinderFactory binderFactory = getReusableBinderFactory();
	return binderFactory.createViewBinder(this);
    }

    protected BinderFactory getReusableBinderFactory() {
	BinderFactory binderFactory = getGalleryApp().getReusableBinderFactory();
	return binderFactory;
    }
   
    private GalleryApp getGalleryApp() {
	return (GalleryApp)getApplicationContext();
    }
    
    protected DatabaseHelper getDatabaseHelper() {
	return getGalleryApp().getDatabaseHelper();
    }
    
    protected MenuBinder createMenuBinder(Menu menu, MenuInflater menuInflater) {
	BinderFactory binderFactory = getReusableBinderFactory();
	return binderFactory.createMenuBinder(menu, menuInflater, this);
    }
}
