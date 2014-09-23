package org.robobinding.gallery.model.bysubclassnoaspectj;

import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.AbstractPresentationModel;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class StringItemPresentationModel_BySubclassNoAspectJ extends AbstractPresentationModel implements ItemPresentationModel<String> {
    private String value;

    @Override
    public void updateData(int index, String bean) {
	value = bean;
    }

    public String getValue() {
	return value;
    }
}
