package org.robobinding.gallery.presentationmodel;

import org.robobinding.gallery.model.HasName;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class NameItemPresentationModel implements ItemPresentationModel<HasName>
{
	private HasName hasName;

	@Override
	public void updateData(int index, HasName bean)
	{
		this.hasName = bean;
	}

	public String getName()
	{
		return hasName.getName();
	}
}
