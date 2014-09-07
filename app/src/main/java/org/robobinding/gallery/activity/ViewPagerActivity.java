package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.model.MemoryProductStore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ViewPagerActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	ViewPager viewPager = new ViewPager(this);
	viewPager.setId(R.id.viewPager);
	setContentView(viewPager);

	final MemoryProductStore productStore = MemoryProductStore.getInstance();
	FragmentManager fm = getSupportFragmentManager();
	viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
	    @Override
	    public int getCount() {
		return productStore.size();
	    }

	    @Override
	    public Fragment getItem(int index) {
		return FragmentDemo.newInstance(index);
	    }
	});
	
	int selectedProductIndex = getIntent().getIntExtra(FragmentDemo.EXTRA_PRODUCT_INDEX, 0);
	viewPager.setCurrentItem(selectedProductIndex);
    }
}
