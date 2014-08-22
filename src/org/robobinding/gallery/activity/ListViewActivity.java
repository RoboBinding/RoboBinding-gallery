package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.ListViewPresentationModel;

import android.os.Bundle;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ListViewActivity extends AbstractActivity {
    private ListViewPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	presentationModel = new ListViewPresentationModel();
	initializeContentView(R.layout.activity_list_view, presentationModel);
    }
}
