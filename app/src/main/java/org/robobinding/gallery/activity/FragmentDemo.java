package org.robobinding.gallery.activity;

import org.robobinding.ViewBinder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.presentationmodel.FragmentDemoPresentationModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class FragmentDemo extends AbstractFragment {
    public static final String EXTRA_PRODUCT_INDEX = "org.robobinding.gallery.FragmentDemo.productIndex";
    
    private FragmentDemoPresentationModel presentationModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        int productIndex = getArguments().getInt(EXTRA_PRODUCT_INDEX);
        Product product = MemoryProductStore.getInstance().getByIndex(productIndex);
        
        presentationModel = new FragmentDemoPresentationModel(product);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewBinder viewBinder = createViewBinder();
        return viewBinder.inflateAndBind(R.layout.fragment_demo, presentationModel);
    }
    
    public static FragmentDemo newInstance(int productIndex) {
	Bundle args = new Bundle();
	args.putInt(EXTRA_PRODUCT_INDEX, productIndex);
	FragmentDemo fragment = new FragmentDemo();
	fragment.setArguments(args);
	return fragment;
    }
    
    private FragmentDemo() {
    }
}
