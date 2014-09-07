package org.robobinding.gallery.presentationmodel;

import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class StringItemPresentationModel implements ItemPresentationModel<String>
{
	private String value;

	@Override
	public void updateData(int index, String bean)
	{
		value = bean;
	}

	public String getValue()
	{
		return value;
	}
}
