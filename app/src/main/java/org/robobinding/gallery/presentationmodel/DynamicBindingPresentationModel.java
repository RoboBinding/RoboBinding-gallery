package org.robobinding.gallery.presentationmodel;

import java.util.Map;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.util.CircularIntegers;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import android.graphics.Typeface;

import com.google.common.collect.Maps;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class DynamicBindingPresentationModel implements HasPresentationModelChangeSupport {
    private final PresentationModelChangeSupport changeSupport;
    private CircularIntegers typefaceRotation;
    private Map<Integer, String> typefaceDescriptions;

    public DynamicBindingPresentationModel() {
        changeSupport = new PresentationModelChangeSupport(this);
        typefaceRotation = new CircularIntegers(Typeface.BOLD, Typeface.NORMAL);

        typefaceDescriptions = Maps.newHashMap();
        typefaceDescriptions.put(Typeface.BOLD, "Bold");
        typefaceDescriptions.put(Typeface.NORMAL, "Normal");
    }

    public Typeface getTypeface() {
        return Typeface.defaultFromStyle(typefaceRotation.value());
    }

    public void changeTypeface() {
        typefaceRotation.next();
        changeSupport.firePropertyChange("typeface");
        changeSupport.firePropertyChange("typefaceDescription");
    }

    public String getTypefaceDescription() {
        return typefaceDescriptions.get(typefaceRotation.value());
    }

    public String getTextAttributeValue() {
        return "sample text";
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
