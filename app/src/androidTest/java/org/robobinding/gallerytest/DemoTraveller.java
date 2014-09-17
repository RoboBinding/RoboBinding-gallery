package org.robobinding.gallerytest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Spinner;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.robobinding.gallery.R;
import org.robobinding.gallery.activity.GalleryActivity;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@LargeTest
public class DemoTraveller extends ActivityInstrumentationTestCase2<GalleryActivity> {
    public DemoTraveller() {
        super(GalleryActivity.class);
    }

    public void testTravelThroughAllDemos() {
        Spinner demoSpinner = (Spinner)getActivity().findViewById(R.id.demoSpinner);
        int numDemos = demoSpinner.getCount();

        for(int i=0; i<numDemos; i++) {
            Espresso.onData(Matchers.anything())
                    .inAdapterView(ViewMatchers.withId(R.id.demoSpinner))
                    .atPosition(i)
                    .perform(ViewActions.click());
            Espresso.pressBack();

            Espresso.onView(ViewMatchers.withId(R.id.showDemoButton))
                    .perform(ViewActions.click());
            Espresso.pressBack();
        }
    }
}
