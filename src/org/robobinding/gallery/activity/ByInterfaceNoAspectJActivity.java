package org.robobinding.gallery.activity;

import org.robobinding.gallery.R;
import org.robobinding.gallery.presentationmodel.PresentationModel_ByInterfaceNoAspectJ;

import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ByInterfaceNoAspectJActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PresentationModel_ByInterfaceNoAspectJ presentationModel = new PresentationModel_ByInterfaceNoAspectJ();

        initializeContentView(R.layout.activity_byinterface_noaspectj, presentationModel);
    }
}
