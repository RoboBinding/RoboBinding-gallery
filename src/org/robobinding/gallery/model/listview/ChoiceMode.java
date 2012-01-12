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
import org.robobinding.internal.com_google_common.collect.Lists;

import android.widget.ListView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum ChoiceMode implements HasName
{
	CHOICE_MODE_SINGLE("Choice mode single", ListView.CHOICE_MODE_SINGLE, android.R.layout.simple_list_item_single_choice),
	CHOICE_MODE_MULTIPLE("Choice mode multiple", ListView.CHOICE_MODE_MULTIPLE, android.R.layout.simple_list_item_multiple_choice),
	CHOICE_MODE_NONE("Choice mode none", ListView.CHOICE_MODE_NONE, android.R.layout.simple_list_item_1);
	
	private String name;
	private int modeValue;
	private int layoutResourceId;
	
	private ChoiceMode(String name, int modeValue, int layoutResourceId)
	{
		this.name = name;
		this.modeValue = modeValue;
		this.layoutResourceId = layoutResourceId;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public int getModeValue()
	{
		return modeValue;
	}

	public int getLayoutResourceId()
	{
		return layoutResourceId;
	}

	private static List<ChoiceMode> choiceModes = Lists.newArrayList(ChoiceMode.values());

	public static List<ChoiceMode> choiceModes()
	{
		return Collections.unmodifiableList(choiceModes);
	}

	public static ChoiceMode indexOf(int index)
	{
		return choiceModes.get(index);
	}
}
