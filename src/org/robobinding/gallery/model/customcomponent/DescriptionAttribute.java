package org.robobinding.gallery.model.customcomponent;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class DescriptionAttribute extends AbstractTextAttribute {
    @Override
    protected void updateText(CharSequence newText) {
	view.setDescription(newText);
    }

}
