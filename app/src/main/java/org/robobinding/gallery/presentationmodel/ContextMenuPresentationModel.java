package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;

import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class ContextMenuPresentationModel {
    private MemoryProductStore productStore;
    private ProductOperationListener productOperationListener;

    public ContextMenuPresentationModel(MemoryProductStore productStore, ProductOperationListener productOperationListener) {
        this.productStore = productStore;
        this.productOperationListener = productOperationListener;
    }

    public void deleteProduct(MenuItem menuItem) {
        AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
        Product deletedProduct = productStore.remove(menuInfo.position);
        productOperationListener.onProductDeleted(deletedProduct);
    }

    public interface ProductOperationListener {
        void onProductDeleted(Product deletedProduct);
    }

}
