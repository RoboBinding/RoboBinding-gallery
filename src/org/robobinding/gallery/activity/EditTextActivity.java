package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.EditTextPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class EditTextActivity extends Activity {
    private EditTextPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new EditTextPresentationModel();
	Binders.bind(this, R.layout.activity_edittext, presentationModel);
    }

    @Override
    protected void onResume() {
	super.onResume();

	presentationModel.refreshPresentationModel();
    }
}
