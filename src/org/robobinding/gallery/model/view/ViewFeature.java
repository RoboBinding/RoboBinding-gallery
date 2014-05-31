package org.robobinding.gallery.model.view;

import org.robobinding.gallery.model.HasName;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum ViewFeature implements HasName
{
	BACKGROUND("Background"),
	BACKGROUND_COLOR("Background color"),
	ENABLED("Enabled"),
	VISIBILITY("Visibility");

	private String name;
	private ViewFeature(String name)
	{
		this.name = name;
	}
	@Override
	public String getName()
	{
		return name;
	}

}
