package org.robobinding.gallery.activity;

import android.view.MenuItem;
import android.widget.TextView;

import org.robobinding.annotation.ViewBinding;
import org.robobinding.customviewbinding.CustomViewBinding;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@ViewBinding(simpleOneWayProperties = {"enabled", "visible"})
public class MenuItemBinding extends CustomViewBinding<MenuItem> {
}
