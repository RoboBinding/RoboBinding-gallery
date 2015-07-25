package org.robobinding.gallery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.robobinding.ViewBinder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.presentationmodel.FragmentDemoPresentationModel;
import org.robobinding.gallery.presentationmodel.FragmentTitleTagPresentationModel;

/**
 * Created by cheng on 2015/7/26.
 */
public class FragmentTitleTag extends AbstractFragment {
    private FragmentTitleTagPresentationModel presentationModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presentationModel = new FragmentTitleTagPresentationModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewBinder viewBinder = createViewBinder();
        return viewBinder.inflateAndBind(R.layout.fragment_title_tag, presentationModel);
    }
}
