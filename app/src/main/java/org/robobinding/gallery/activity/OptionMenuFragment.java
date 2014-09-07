package org.robobinding.gallery.activity;

import org.robobinding.MenuBinder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.MenuPresentationModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class OptionMenuFragment extends AbstractFragment {
    private MenuPresentationModel presentationModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        presentationModel = new MenuPresentationModel();

        setRetainInstance(true);
        setHasOptionsMenu(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_options_menu, container, false);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        
	MenuBinder menuBinder = createMenuBinder(menu, inflater);
	menuBinder.inflateAndBind(R.menu.options_menu, presentationModel);
    }
}
