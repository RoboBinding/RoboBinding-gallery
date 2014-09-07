package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.ViewPresentationModel;

import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ViewActivity extends AbstractActivity {
    private ViewPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new ViewPresentationModel();
	initializeContentView(R.layout.activity_view, presentationModel);
    }
}
