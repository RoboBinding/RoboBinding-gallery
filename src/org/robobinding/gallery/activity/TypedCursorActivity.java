package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.typedcursor.DatabaseHelper;
import org.robobinding.gallery.presentationmodel.TypedCursorPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TypedCursorActivity extends Activity
{
	private TypedCursorPresentationModel presentationModel;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		DatabaseHelper databaseHelper = new DatabaseHelper(this);
		presentationModel = new TypedCursorPresentationModel(databaseHelper.getReadableDatabase());
		Binders.bind(this, R.layout.activity_typed_cursor, presentationModel);
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		presentationModel.refreshPresentationModel();
	}
}
