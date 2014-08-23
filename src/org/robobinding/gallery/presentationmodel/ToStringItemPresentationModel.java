package org.robobinding.gallery.presentationmodel;

import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ToStringItemPresentationModel implements ItemPresentationModel<Object>
{
	private Object item;

	@Override
	public void updateData(int index, Object item)
	{
		this.item = item;
	}

	public String getValue()
	{
		return item.toString();
	}
}
