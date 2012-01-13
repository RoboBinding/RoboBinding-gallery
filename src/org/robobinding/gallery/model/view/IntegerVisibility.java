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
package org.robobinding.gallery.model.view;

import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class IntegerVisibility
{
	private int[] values;
	private int currentIndex;
	
	public IntegerVisibility()
	{
		values = new int[]{View.VISIBLE, View.INVISIBLE, View.GONE};
		currentIndex = 0;
	}
	
	public int getValue()
	{
		return values[currentIndex];
	}
	
	public void nextState()
	{
		currentIndex = nextIndex();
	}

	private int nextIndex()
	{
		int nextIndex = currentIndex + 1;
		if(nextIndex >= values.length)
		{
			nextIndex = 0;
		}
		return nextIndex;
	}

	public String describe(String visibleDescription, String invisibleDescription, String goneDescription)
	{
		if(currentIndex == 0)
		{
			return visibleDescription;
		}else if(currentIndex == 1)
		{
			return invisibleDescription;
		}else
		{
			return goneDescription;
		}
	}
}
