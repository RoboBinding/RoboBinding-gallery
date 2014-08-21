package org.robobinding.gallery.presentationmodel;

import org.robobinding.aspects.PresentationModel;


/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class CustomComponentPresentationModel {
    private String title;
    private String description;
    private String newTitle;
    private String newDescription;

    public CustomComponentPresentationModel() {
	this.title = "Default title";
	this.description = "Default description";
    }

    public String getTitle() {
	return title;
    }

    public String getDescription() {
	return description;
    }

    public String getNewTitle() {
	return newTitle;
    }

    public void setNewTitle(String newTitle) {
	this.newTitle = newTitle;
    }

    public String getNewDescription() {
	return newDescription;
    }

    public void setNewDescription(String newDescription) {
	this.newDescription = newDescription;
    }

    public void applyNewTitleDescription() {
	title = newTitle;
	description = newDescription;

	firePropertyChange("title");
	firePropertyChange("description");
    }
}
