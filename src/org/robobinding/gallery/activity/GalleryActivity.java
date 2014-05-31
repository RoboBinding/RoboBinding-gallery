package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.GalleryPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class GalleryActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);


		GalleryPresentationModel presentationModel = new GalleryPresentationModel(this);
		Binders.bind(this, R.layout.gallery_activity, presentationModel);
	}
}