/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
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
	CUSTOM_VIEW("Custom Component");

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
