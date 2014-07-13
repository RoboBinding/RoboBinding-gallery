package org.robobinding.gallery.model.customcomponent;

import org.robobinding.viewattribute.property.PropertyViewAttribute;


/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TitleAttribute implements PropertyViewAttribute<TitleDescriptionBar, CharSequence> {

    @Override
    public void updateView(TitleDescriptionBar view, CharSequence newText) {
	view.setTitle(newText);
    }
}
