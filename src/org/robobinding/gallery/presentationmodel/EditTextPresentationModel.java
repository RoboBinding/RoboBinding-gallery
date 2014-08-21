package org.robobinding.gallery.presentationmodel;

import org.robobinding.aspects.PresentationModel;



/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
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
