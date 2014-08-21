package org.robobinding.gallery.activity;

import org.robobinding.binder.Binders;
import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.PresentationModel_BySubclassNoAspectJ;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class BySubclassNoAspectJActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PresentationModel_BySubclassNoAspectJ presentationModel = new PresentationModel_BySubclassNoAspectJ();

        Binders.bind(this, R.layout.activity_bysubclass_noaspectj, presentationModel);
    }
}
