package org.robobinding.gallery.model.customcomponent;

import org.robobinding.viewattribute.BindingAttributeMappings;
import org.robobinding.viewattribute.ViewBinding;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TitleDescriptionBarBinding implements ViewBinding<TitleDescriptionBar> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<TitleDescriptionBar> mappings) {
        mappings.mapProperty(TitleAttribute.class, "title");
        mappings.mapProperty(DescriptionAttribute.class, "description");
    }
}
