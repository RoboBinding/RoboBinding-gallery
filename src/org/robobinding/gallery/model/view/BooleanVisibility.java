package org.robobinding.gallery.model.view;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class BooleanVisibility
{
	private boolean visible;
	public BooleanVisibility()
	{
		visible = false;
	}

	public boolean getValue()
	{
		return visible;
	}

	public void nextState()
	{
		visible = !visible;
	}

	public String describe(String visibleDescription, String invisibleDescription)
	{
		return visible?visibleDescription:invisibleDescription;
	}
}
