/**
 * Copyright 2013 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.gallery.activity;

import org.robobinding.ActivityBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.gallery.R;
import org.robobinding.gallery.model.customview.TitleDescriptionBar;
import org.robobinding.gallery.model.customview.TitleDescriptionBarAttributeMapper;
import org.robobinding.gallery.presentationmodel.CustomViewPresentationModel;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class CustomViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewPresentationModel presentationModel = new CustomViewPresentationModel();

        BinderFactory binderFactory = new BinderFactoryBuilder()
        	.mapView(TitleDescriptionBar.class, new TitleDescriptionBarAttributeMapper())
        	.build();

        ActivityBinder activityBinder = binderFactory.createActivityBinder(this, true);
        activityBinder.inflateAndBind(R.layout.custom_view_activity, presentationModel);
    }
}
