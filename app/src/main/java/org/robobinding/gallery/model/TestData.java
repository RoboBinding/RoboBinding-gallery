package org.robobinding.gallery.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TestData {
    public static List<Product> products() {
	List<Product> products = Lists.newArrayList();
	
	int numProducts = new Random().nextInt(30)+10;
	for(int i=1; i<=numProducts; i++) {
	    products.add(new Product("product#"+i, "description for product#"+i));
	}
	
	return products;
    }
}
