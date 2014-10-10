package org.robobinding.gallery.presentationmodel;

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
        value = bean;
    }

    public String getValue() {
        return value;
    }
}
