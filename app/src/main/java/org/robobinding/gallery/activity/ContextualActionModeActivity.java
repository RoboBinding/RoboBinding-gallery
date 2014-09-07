package org.robobinding.gallery.activity;

import org.robobinding.MenuBinder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.presentationmodel.ContextualActionModePresentationModel;

import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ContextualActionModeActivity extends AbstractActivity {
    private ContextualActionModePresentationModel presentationModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        MemoryProductStore productStore = MemoryProductStore.getInstance();
        productStore.reset();
        
        presentationModel = new ContextualActionModePresentationModel(productStore);
        
        initializeContentView(R.layout.activity_contextual_action_mode, presentationModel);
        
        ListView productListView = (ListView)findViewById(R.id.productList);
        productListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        	startSupportActionMode(new ActionMode.Callback() {
		    
		    @Override
		    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
			return false;
		    }
		    
		    @Override
		    public void onDestroyActionMode(ActionMode actionMode) {
		    }
		    
		    @Override
		    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
			MenuBinder menuBinder = createMenuBinder(menu, getMenuInflater());
			menuBinder.inflateAndBind(R.menu.contextual_action_mode, presentationModel);
			return true;
		    }
		    
		    @Override
		    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
			return false;
		    }
		});
        	return true;
            }
	});
    }
}
