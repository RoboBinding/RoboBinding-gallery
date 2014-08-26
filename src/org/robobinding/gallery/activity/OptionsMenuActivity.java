package org.robobinding.gallery.activity;

import android.support.v4.app.Fragment;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class OptionsMenuActivity extends AbstractFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new OptionMenuFragment();
    }
}
