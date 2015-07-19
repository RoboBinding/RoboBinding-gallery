package org.robobinding.gallery.activity;

import android.widget.TextView;

import org.robobinding.annotation.ViewBinding;
import org.robobinding.customviewbinding.CustomViewBinding;
import org.robobinding.widget.menuitemgroup.MenuItemGroup;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@ViewBinding(simpleOneWayProperties = {"enabled", "visible"})
public class MenuItemGroupBinding extends CustomViewBinding<MenuItemGroup> {
}
