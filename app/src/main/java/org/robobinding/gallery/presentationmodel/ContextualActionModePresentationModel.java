package org.robobinding.gallery.presentationmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.model.MemoryProductStore;
import org.robobinding.gallery.model.Product;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class ContextualActionModePresentationModel {
    private MemoryProductStore productStore;
    private Set<Integer> selectedProductIndexes;
    
    public ContextualActionModePresentationModel(MemoryProductStore productStore) {
	this.productStore = productStore;
	selectedProductIndexes = new HashSet<Integer>();
    }
    
    @ItemPresentationModel(value=ToStringItemPresentationModel.class)
    public List<Product> getProducts() {
	return productStore.getAll();
    }
    
    public void deleteSelectedProducts() {
	List<Integer> indexes = new ArrayList<Integer>(selectedProductIndexes);
	selectedProductIndexes.clear();
	Collections.sort(indexes);
	Collections.reverse(indexes);
	for(Integer index : indexes) {
	    productStore.remove(index);
	}
	
        refreshProducts();
    }

    private void refreshProducts() {
	firePropertyChange("selectedProductIndexes");
	firePropertyChange("products");
    }

    public Set<Integer> getSelectedProductIndexes() {
        return selectedProductIndexes;
    }

    public void setSelectedProductIndexes(Set<Integer> selectedProductIndexes) {
        this.selectedProductIndexes = selectedProductIndexes;
    }
}
