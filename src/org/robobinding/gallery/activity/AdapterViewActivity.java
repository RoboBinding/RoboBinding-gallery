package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.AdapterViewPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class AdapterViewActivity extends Activity
{
	private AdapterViewPresentationModel presentationModel;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		presentationModel = new AdapterViewPresentationModel();
		Binders.bind(this, R.layout.activity_adapter_view, presentationModel);
	}
	@Override
	protected void onResume()
	{
		super.onResume();

		presentationModel.refreshPresentationModel();
	}
}
