package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.EditTextPresentationModel;

import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class EditTextActivity extends AbstractActivity {
    private EditTextPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new EditTextPresentationModel();
	initializeContentView(R.layout.activity_edittext, presentationModel);
    }
}
