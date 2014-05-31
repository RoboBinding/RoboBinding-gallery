package org.robobinding.gallery.model.adapterview;

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
public enum AdapterViewFeature implements HasName
{
	DYNAMIC_SOURCE("Dynamic source"),
	DYNAMIC_ITEM_LAYOUT("Dynamic item layout");

	private String name;

	private AdapterViewFeature(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	private static List<AdapterViewFeature> features = Lists.newArrayList(AdapterViewFeature.values());

	public static List<AdapterViewFeature> features()
	{
		return Collections.unmodifiableList(features);
	}

	public static AdapterViewFeature valueOf(int index)
	{
		return features.get(index);
	}
}
