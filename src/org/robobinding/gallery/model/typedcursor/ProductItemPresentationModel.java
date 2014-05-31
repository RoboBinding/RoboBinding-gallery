package org.robobinding.gallery.model.typedcursor;

import java.text.MessageFormat;

import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ProductItemPresentationModel implements ItemPresentationModel<Product> {
    private Product product;
    private int index;

    public String getProductDetails() {
	return MessageFormat.format("{0}.{1}: {2}",
		index+1,
		product.getName(),
		product.getDescription());
    }

    public void updateData(int index, Product product) {
	this.index = index;
	this.product = product;
    }
}
