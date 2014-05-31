package org.robobinding.gallery.model;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum Widget implements HasName
{
	ADAPTER_VIEW("AdapterView"),
	LIST_VIEW("ListView"),
	CUSTOM_VIEW("Custom Component"),
	TYPED_CURSOR("TypedCursor");

	private String name;

	private Widget(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	private static List<Widget> widgets = Lists.newArrayList(Widget.values());

	public static List<Widget> widgets()
	{
		return Collections.unmodifiableList(widgets);
	}

	public static Widget valueOf(int index)
	{
		return widgets.get(index);
	}
}
