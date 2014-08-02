package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.ViewPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ViewActivity extends Activity {
    private ViewPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new ViewPresentationModel();
	Binders.bind(this, R.layout.activity_view, presentationModel);
    }

    @Override
    protected void onResume() {
	super.onResume();

	presentationModel.refreshPresentationModel();
    }
}
