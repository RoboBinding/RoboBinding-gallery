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
