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
package org.robobinding.gallery.model.adapterview;

import java.util.Collections;
import java.util.List;

import org.robobinding.gallary.R;
import org.robobinding.gallery.model.HasName;
import org.robobinding.internal.com_google_common.collect.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum StringItemLayout implements HasName
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
	public String getName()
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

	public static StringItemLayout indexOf(int index)
	{
		return itemLayouts.get(index);
	}
}
