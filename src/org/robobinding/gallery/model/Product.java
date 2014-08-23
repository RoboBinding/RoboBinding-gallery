package org.robobinding.gallery.model;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class Product {
    private String name;
    private String description;

    public Product(String name, String description) {
	this.name = name;
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public String getDescription() {
	return description;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
