package org.robobinding.gallery.activity;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.gallery.model.typedcursor.DatabaseHelper;

import android.app.Activity;
import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractActivity extends Activity {
    public void initializeContentView(int layoutId, Object presentationModel) {
	ViewBinder viewBinder = createViewBinder();
	View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
	setContentView(rootView);
    }
    
    private ViewBinder createViewBinder() {
	BinderFactory binderFactory = getGalleryApp().getReusableBinderFactory();
	return binderFactory.createViewBinder(this);
    }
    
    private GalleryApp getGalleryApp() {
	return (GalleryApp)getApplicationContext();
    }
    
    protected DatabaseHelper getDatabaseHelper() {
	return getGalleryApp().getDatabaseHelper();
    }
}
