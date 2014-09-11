package org.robobinding.gallery.model.adapterview;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

import org.robobinding.gallery.R;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum StringItemLayout
{
	item_layout1("Item layout 1", R.layout.string_item_layout1),
	item_layout2("Item layout 2", R.layout.string_item_layout2);

	private String name;
	private int layoutResourceId;

	private StringItemLayout(String name, int layoutResourceId)
	{
		this.name = name;
		this.layoutResourceId = layoutResourceId;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public int getLayoutResourceId()
	{
		return layoutResourceId;
	}

	private static List<StringItemLayout> itemLayouts = Lists.newArrayList(StringItemLayout.values());

	public static List<StringItemLayout> itemLayouts()
	{
		return Collections.unmodifiableList(itemLayouts);
	}

	public static StringItemLayout valueOf(int index)
	{
		return itemLayouts.get(index);
	}
}
