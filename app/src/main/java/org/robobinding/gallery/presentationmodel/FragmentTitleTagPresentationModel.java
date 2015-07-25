package org.robobinding.gallery.presentationmodel;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.model.Product;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class FragmentTitleTagPresentationModel {
    public FragmentTitleTagPresentationModel() {
    }

    public String getTitle() {
        return "fragment tag title";
    }

    public String getDescription() {
        return ": some description";
    }
}

