package org.robobinding.gallery.activity;

import org.robobinding.MenuBinder;
import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractFragment extends Fragment {
    protected ViewBinder createViewBinder() {
	BinderFactory binderFactory = getReusableBinderFactory();
	return binderFactory.createViewBinder(getActivity());
    }

    private BinderFactory getReusableBinderFactory() {
	BinderFactory binderFactory = getGalleryApp().getReusableBinderFactory();
	return binderFactory;
    }
    
    private GalleryApp getGalleryApp() {
	return (GalleryApp)getActivity().getApplicationContext();
    }
    
    protected MenuBinder createMenuBinder(Menu menu, MenuInflater menuInflater) {
	BinderFactory binderFactory = getReusableBinderFactory();
	return binderFactory.createMenuBinder(menu, menuInflater, getActivity());
    }
}
