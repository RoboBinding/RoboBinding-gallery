package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.model.Product;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class FragmentDemoPresentationModel {
    private Product product;

    public FragmentDemoPresentationModel(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return product.getName();
    }

    public String getProductDescription() {
        return product.getDescription();
    }

}
