package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.DependsOnStateOf;
import org.robobinding.aspects.PresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class MenuPresentationModel {
    private boolean enabled;
    private boolean visible;
    private boolean groupEnabled;
    private boolean groupVisible;
    
    public MenuPresentationModel() {
	this.enabled = true;
	this.visible = true;
	this.groupEnabled = true;
	this.groupVisible = true;
    }
    
    public void toggleTitle() {
	setGroupEnabled(!groupEnabled);
    }
    
    @DependsOnStateOf("groupEnabled")
    public String getTitle() {
	if(groupEnabled) {
	    return "Disable group";
	} else {
	   return "Enable group"; 
	}
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isGroupEnabled() {
        return groupEnabled;
    }
    
    public void setGroupEnabled(boolean newGroupEnabled) {
	this.groupEnabled = newGroupEnabled;
    }

    public boolean isGroupVisible() {
        return groupVisible;
    }
}
