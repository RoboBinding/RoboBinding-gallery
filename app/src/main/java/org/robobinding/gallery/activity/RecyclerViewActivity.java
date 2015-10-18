package org.robobinding.gallery.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.ListViewPresentationModel;
import org.robobinding.gallery.presentationmodel.RecyclerViewPresentationModel;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class RecyclerViewActivity extends AbstractActivity {
    private RecyclerViewPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    presentationModel = new RecyclerViewPresentationModel();
	    initializeContentView(R.layout.activity_recycler_view, presentationModel);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
