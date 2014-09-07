package org.robobinding.gallery.activity;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.customcomponent.TitleDescriptionBar;
import org.robobinding.gallery.model.customcomponent.TitleDescriptionBarBinding;
import org.robobinding.gallery.presentationmodel.CustomComponentPresentationModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class CustomComponentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomComponentPresentationModel presentationModel = new CustomComponentPresentationModel();

        initializeContentView(R.layout.activity_custom_component, presentationModel);
    }
    
    private void initializeContentView(int layoutId, Object presentationModel) {
	ViewBinder viewBinder = createViewBinder();
	View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
	setContentView(rootView);
    }
    
    private ViewBinder createViewBinder() {
	BinderFactory binderFactory = new BinderFactoryBuilder()
		.mapView(TitleDescriptionBar.class, new TitleDescriptionBarBinding())
		.build();
	return binderFactory.createViewBinder(this);
    }
}
