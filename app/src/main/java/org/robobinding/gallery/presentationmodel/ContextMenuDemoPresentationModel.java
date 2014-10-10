package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;
import org.robobinding.gallery.presentationmodel.ContextMenuPresentationModel.ProductOperationListener;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class ContextMenuDemoPresentationModel implements ProductOperationListener, HasPresentationModelChangeSupport {
    private final MemoryProductStore productStore;
    private final PresentationModelChangeSupport changeSupport;

    public ContextMenuDemoPresentationModel(MemoryProductStore productStore) {
        this.productStore = productStore;
        changeSupport = new PresentationModelChangeSupport(this);
    }

    @ItemPresentationModel(value = ToStringItemPresentationModel.class)
    public List<Product> getProducts() {
        return productStore.getAll();
    }

    @Override
    public void onProductDeleted(Product deletedProduct) {
        refreshProducts();
    }

    private void refreshProducts() {
        changeSupport.firePropertyChange("products");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
