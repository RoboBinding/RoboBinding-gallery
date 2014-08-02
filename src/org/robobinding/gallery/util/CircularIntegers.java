package org.robobinding.gallery.util;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class CircularIntegers {
    private int[] values;
    private int currentIndex;
    
    public CircularIntegers(int... values) {
	this.values = values;
    }
    
    public int start() {
	currentIndex = 0;
	return next();
    }
    
    public int next() {
	int current = value();
	
	currentIndex++;
	if(currentIndex >= values.length) {
	    currentIndex = 0;
	}
	
	return current;
    }
    
    public int value() {
	return values[currentIndex];
    }
}
