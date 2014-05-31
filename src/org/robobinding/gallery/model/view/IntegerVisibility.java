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
		currentIndex = 2;
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
