package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.presentationmodel.ContextMenuPresentationModel.ProductOperationListener;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class ContextMenuDemoPresentationModel implements ProductOperationListener {
    private MemoryProductStore productStore;
    
    public ContextMenuDemoPresentationModel(MemoryProductStore productStore) {
	this.productStore = productStore;
    }
    
    @ItemPresentationModel(value=ToStringItemPresentationModel.class)
    public List<Product> getProducts() {
	return productStore.getAll();
    }
    
    @Override
    public void onProductDeleted(Product deletedProduct) {
        refreshProducts();
    }

    private void refreshProducts() {
	firePropertyChange("products");
    }

}
