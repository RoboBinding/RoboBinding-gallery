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
