package org.robobinding.gallery.presentationmodel;

import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.model.Product;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
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
