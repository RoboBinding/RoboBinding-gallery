package org.robobinding.gallery.activity;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.dynamicbinding.DynamicViewBinding;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.dynamicbinding.CustomOrThirdPartyComponent;
import org.robobinding.gallery.presentationmodel.DynamicBindingPresentationModel;
import org.robobinding.widget.textview.TextViewBinding;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class DynamicBindingActivity extends Activity {
    private DynamicBindingPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new DynamicBindingPresentationModel();

	initializeContentView(R.layout.activity_dynamic_binding, presentationModel);
    }

    private void initializeContentView(int layoutId, Object presentationModel) {
	ViewBinder viewBinder = createViewBinder();
	View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
	setContentView(rootView);
    }

    private ViewBinder createViewBinder() {
	BinderFactoryBuilder binderFactoryBuilder = new BinderFactoryBuilder()
		.add(new DynamicViewBinding().extend(TextView.class, new TextViewBinding())
			.oneWayProperties("typeface"))
		.add(new DynamicViewBinding().forView(CustomOrThirdPartyComponent.class)
			.oneWayProperties("textAttribute"));	
	BinderFactory binderFactory = binderFactoryBuilder.build();
	return binderFactory.createViewBinder(this);
    }
}
