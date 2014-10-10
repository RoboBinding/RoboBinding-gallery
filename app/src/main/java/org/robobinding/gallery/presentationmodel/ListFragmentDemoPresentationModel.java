package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.activity.FragmentDemo;
import org.robobinding.gallery.activity.ViewPagerActivity;
import org.robobinding.gallery.model.Product;
import org.robobinding.widget.adapterview.ItemClickEvent;

import android.app.Activity;
import android.content.Intent;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class ListFragmentDemoPresentationModel {
    private final Activity activity;
    private final List<Product> products;

    public ListFragmentDemoPresentationModel(Activity activity, List<Product> products) {
        this.activity = activity;
        this.products = products;
    }

    @ItemPresentationModel(value = ToStringItemPresentationModel.class)
    public List<Product> getProducts() {
        return products;
    }

    public void viewProduct(ItemClickEvent event) {
        Intent i = new Intent(activity, ViewPagerActivity.class);
        i.putExtra(FragmentDemo.EXTRA_PRODUCT_INDEX, event.getPosition());
        activity.startActivity(i);
    }
}
