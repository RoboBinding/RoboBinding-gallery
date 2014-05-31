package org.robobinding.gallery.model.customcomponent;

import org.robobinding.viewattribute.AbstractReadOnlyPropertyViewAttribute;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractTextAttribute extends AbstractReadOnlyPropertyViewAttribute<TitleDescriptionBar, CharSequence> {

    protected abstract void updateText(CharSequence newText);

    @Override
    protected void valueModelUpdated(CharSequence newValue) {
	updateText(newValue);
    }
}
