package org.robobinding.gallery.presentationmodel;


import org.robobinding.annotation.PresentationModel;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class EditTextPresentationModel {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
