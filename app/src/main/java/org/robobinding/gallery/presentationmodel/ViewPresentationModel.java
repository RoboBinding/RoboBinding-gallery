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
    private boolean checked;
    private int numCheckedChanges;

    public ViewPresentationModel() {
        changeSupport = new PresentationModelChangeSupport(this);
        integerVisibilityRotation = new CircularIntegers(View.VISIBLE, View.INVISIBLE, View.GONE);

        integerVisibilityDescriptions = Maps.newHashMap();
        integerVisibilityDescriptions.put(View.VISIBLE, "Visible");
        integerVisibilityDescriptions.put(View.INVISIBLE, "Invisible");
        integerVisibilityDescriptions.put(View.GONE, "Gone");

        checked = false;
        numCheckedChanges  = 0;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void onCheckedChange() {
        numCheckedChanges++;
        changeSupport.firePropertyChange("checkedChangeDisplay");
    }

    public void changeChecked() {
        setChecked(!checked);
    }

    public String getCheckedChangeDisplay() {
        return "Change Checked: "+ numCheckedChanges;
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
