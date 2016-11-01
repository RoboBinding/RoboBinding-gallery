package org.robobinding.gallery.presentationmodel;

import android.util.Log;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
public class StringItemPresentationModel implements ItemPresentationModel<String> {
    private String value;

    @Override
    public void updateData(String bean, ItemContext itemContext) {
        Log.d(StringItemPresentationModel.class.getSimpleName(), "in updateData");
        value = bean;
    }

    public String getValue() {
        Log.d(StringItemPresentationModel.class.getSimpleName(), "in getValue");
        return value;
    }
}
