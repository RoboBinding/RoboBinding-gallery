package org.robobinding.gallery.presentationmodel;

import java.util.Map;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.util.CircularIntegers;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import android.app.Presentation;
import android.view.View;

import com.google.common.collect.Maps;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class ViewPresentationModel implements HasPresentationModelChangeSupport {
    private PresentationModelChangeSupport changeSupport;
    private CircularIntegers integerVisibilityRotation;
    private Map<Integer, String> integerVisibilityDescriptions;

    public ViewPresentationModel() {
        changeSupport = new PresentationModelChangeSupport(this);
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
        changeSupport.firePropertyChange("integerVisibilityState");
        changeSupport.firePropertyChange("integerVisibility");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
