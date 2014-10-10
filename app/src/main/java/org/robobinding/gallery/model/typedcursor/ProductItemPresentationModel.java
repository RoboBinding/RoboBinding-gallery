package org.robobinding.gallery.model.typedcursor;

import java.text.MessageFormat;

import org.robobinding.gallery.model.Product;
import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
public class ProductItemPresentationModel implements ItemPresentationModel<Product> {
    private Product product;
    private int index;

    public String getProductDetails() {
        return MessageFormat.format("{0}.{1}: {2}",
                index + 1,
                product.getName(),
                product.getDescription());
    }

    public void updateData(Product product, ItemContext itemContext) {
        this.index = itemContext.getPosition();
        this.product = product;
    }
}
