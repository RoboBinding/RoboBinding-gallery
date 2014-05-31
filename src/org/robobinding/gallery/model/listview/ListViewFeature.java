package org.robobinding.gallery.model.listview;

import java.util.Collections;
import java.util.List;

import org.robobinding.gallery.model.HasName;

import com.google.common.collect.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum ListViewFeature implements HasName
{
	HEADER_VISIBILITY("Header visibility"),
	FOOTER_VISIBILITY("Footer visibility"),
	CHECKED_ITEM_POSITION("Checked item position"),
	CHECKED_ITEM_POSITIONS("Checked item positions");

	private String name;

	private ListViewFeature(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	private static List<ListViewFeature> features = Lists.newArrayList(ListViewFeature.values());

	public static List<ListViewFeature> features()
	{
		return Collections.unmodifiableList(features);
	}

	public static ListViewFeature valueOf(int index)
	{
		return features.get(index);
	}
}
