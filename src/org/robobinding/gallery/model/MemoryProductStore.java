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
    
    public List<Product> getAll() {
	return Collections.unmodifiableList(products);
    }
    
    public Product getByIndex(int index) {
	return products.get(index);
    }
    
    public static MemoryProductStore getInstance() {
	return uniqueInstance;
    }
}
