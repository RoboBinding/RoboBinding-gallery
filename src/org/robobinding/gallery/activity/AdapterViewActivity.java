package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.AdapterViewPresentationModel;

import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class AdapterViewActivity extends AbstractActivity {
    private AdapterViewPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new AdapterViewPresentationModel();
	initializeContentView(R.layout.activity_adapter_view, presentationModel);
    }
}
