package org.robobinding.gallery.activity;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;

import android.support.v4.app.Fragment;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractFragment extends Fragment {
    protected ViewBinder createViewBinder() {
	BinderFactory binderFactory = getGalleryApp().getReusableBinderFactory();
	return binderFactory.createViewBinder(getActivity());
    }
    
    private GalleryApp getGalleryApp() {
	return (GalleryApp)getActivity().getApplicationContext();
    }
}
