package org.robobinding.gallery.model.customcomponent;

import org.robobinding.viewattribute.BindingAttributeMapper;
import org.robobinding.viewattribute.BindingAttributeMappings;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TitleDescriptionBarAttributeMapper implements BindingAttributeMapper<TitleDescriptionBar> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<TitleDescriptionBar> mappings) {
        mappings.mapPropertyAttribute(TitleAttribute.class, "title");
        mappings.mapPropertyAttribute(DescriptionAttribute.class, "description");
    }
}
