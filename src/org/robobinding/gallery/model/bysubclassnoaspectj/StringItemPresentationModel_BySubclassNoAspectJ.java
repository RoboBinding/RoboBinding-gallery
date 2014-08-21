package org.robobinding.gallery.model.bysubclassnoaspectj;

import org.robobinding.itempresentationmodel.AbstractItemPresentationModel;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class StringItemPresentationModel_BySubclassNoAspectJ extends AbstractItemPresentationModel<String> {
    private String value;

    @Override
    protected void doUpdateData(int index, String bean) {
	value = bean;
    }

    public String getValue() {
	return value;
    }
}
