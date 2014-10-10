package org.robobinding.gallery.presentationmodel;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
public class ToStringItemPresentationModel implements ItemPresentationModel<Object> {
    private Object item;

    @Override
    public void updateData(Object item, ItemContext itemContext) {
        this.item = item;
    }

    public String getValue() {
        return item.toString();
    }
}
