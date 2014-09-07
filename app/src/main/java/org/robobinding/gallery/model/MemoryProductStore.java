package org.robobinding.gallery.model;

import java.util.Collections;
import java.util.List;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class MemoryProductStore {
    private static final MemoryProductStore uniqueInstance = new MemoryProductStore();
    
    private List<Product> products;
    
    private MemoryProductStore() {
	this.products = TestData.products();
    }
    
    public void reset() {
	this.products = TestData.products();
    }
    
    public List<Product> getAll() {
	return Collections.unmodifiableList(products);
    }
    
    public Product getByIndex(int index) {
	return products.get(index);
    }
    
    public Product remove(int index) {
	return products.remove(index);
    }
    
    public int size() {
        return products.size();
    }

    public static MemoryProductStore getInstance() {
	return uniqueInstance;
    }
}
