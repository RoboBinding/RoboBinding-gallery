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
package org.robobinding.gallery.model.customcomponent;

import org.robobinding.gallery.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class TitleDescriptionBar extends LinearLayout {
    private TextView title;
    private TextView description;

    public TitleDescriptionBar(Context context, AttributeSet attrs) {
	this(context, attrs, R.layout.title_description_bar);
    }

    protected TitleDescriptionBar(Context context, AttributeSet attrs, int layoutId) {
	super(context, attrs);

	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	inflater.inflate(layoutId, this);
	title = (TextView) findViewById(R.id.title);
	description = (TextView) findViewById(R.id.description);

	TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleDescriptionBar);
	String titleText = a.getString(R.styleable.TitleDescriptionBar_title);
	String descriptionText = a.getString(R.styleable.TitleDescriptionBar_description);
	a.recycle();

	setTitle(titleText);
	setDescription(descriptionText);
    }

    public void setTitle(CharSequence titleText) {
	title.setText(titleText);
    }

    public void setDescription(CharSequence descriptionText) {
	description.setText(descriptionText);
    }
}
