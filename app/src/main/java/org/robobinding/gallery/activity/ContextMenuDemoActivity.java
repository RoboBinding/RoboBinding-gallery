package org.robobinding.gallery.activity;

import org.robobinding.MenuBinder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.presentationmodel.ContextMenuDemoPresentationModel;
import org.robobinding.gallery.presentationmodel.ContextMenuPresentationModel;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ListView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ContextMenuDemoActivity extends AbstractActivity {
    private ContextMenuDemoPresentationModel presentationModel;
    private ContextMenuPresentationModel contextMenuPresentationModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        MemoryProductStore productStore = MemoryProductStore.getInstance();
        productStore.reset();
        
        presentationModel = new ContextMenuDemoPresentationModel(productStore);
        contextMenuPresentationModel = new ContextMenuPresentationModel(productStore, presentationModel);
        
        initializeContentView(R.layout.activity_context_menu_demo, presentationModel);
        
        ListView productListView = (ListView)findViewById(R.id.productList);
        registerForContextMenu(productListView);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        MenuBinder menuBinder = createMenuBinder(menu, getMenuInflater());
        menuBinder.inflateAndBind(R.menu.context_menu, contextMenuPresentationModel);
    }
}
