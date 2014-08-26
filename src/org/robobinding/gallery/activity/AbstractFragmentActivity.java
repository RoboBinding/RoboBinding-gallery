package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractFragmentActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fragment);
	
	FragmentManager fm = getSupportFragmentManager();
	Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
	if (fragment == null) {
	    fragment = createFragment();
	    fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
	}
    }
    
    protected abstract Fragment createFragment();
}
