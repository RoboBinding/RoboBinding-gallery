package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.bysubclassnoaspectj.StringItemPresentationModel_BySubclassNoAspectJ;
import org.robobinding.presentationmodel.AbstractPresentationModel;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class PresentationModel_BySubclassNoAspectJ extends AbstractPresentationModel {
    @ItemPresentationModel(value = StringItemPresentationModel_BySubclassNoAspectJ.class)
    public List<String> getStrings() {
	return SampleStrings.getSample();
    }

}
