package org.robobinding.gallery.presentationmodel;

import java.util.Map;

import org.robobinding.gallery.util.CircularIntegers;
import org.robobinding.internal.guava.Maps;
import org.robobinding.presentationmodel.PresentationModel;

import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class ViewPresentationModel
{
    private CircularIntegers integerVisibilityRotation;
    private Map<Integer, String> integerVisibilityDescriptions;
    public ViewPresentationModel() {
	integerVisibilityRotation = new CircularIntegers(View.VISIBLE, View.INVISIBLE, View.GONE);
	
	integerVisibilityDescriptions = Maps.newHashMap();
	integerVisibilityDescriptions.put(View.VISIBLE, "Visible");
	integerVisibilityDescriptions.put(View.INVISIBLE, "Invisible");
	integerVisibilityDescriptions.put(View.GONE, "Gone");
    }
    
    public int getIntegerVisibility() {
	return integerVisibilityRotation.value();
    }
    
    public String getIntegerVisibilityState() {
	return integerVisibilityDescriptions.get(integerVisibilityRotation.value());
    }
    
    public void integerVisibilityStateNext() {
	integerVisibilityRotation.next();
	firePropertyChange("integerVisibilityState");
	firePropertyChange("integerVisibility");
    }
}
