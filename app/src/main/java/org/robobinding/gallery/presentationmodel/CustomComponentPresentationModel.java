package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;


/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class CustomComponentPresentationModel implements HasPresentationModelChangeSupport {
    private final PresentationModelChangeSupport changeSupport;
    private String title;
    private String description;
    private String newTitle;
    private String newDescription;

    public CustomComponentPresentationModel() {
        changeSupport = new PresentationModelChangeSupport(this);
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

        changeSupport.firePropertyChange("title");
        changeSupport.firePropertyChange("description");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
