package org.robobinding.gallery.activity;

import android.support.v4.app.Fragment;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class FragmentDemoActivity extends AbstractFragmentActivity {

    @Override
    protected Fragment createFragment() {
	int productIndex = getIntent().getIntExtra(FragmentDemo.EXTRA_PRODUCT_INDEX, 0);
	return FragmentDemo.newInstance(productIndex);
    }

}
