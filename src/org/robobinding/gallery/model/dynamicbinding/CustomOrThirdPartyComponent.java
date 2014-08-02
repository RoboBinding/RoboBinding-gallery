package org.robobinding.gallery.model.dynamicbinding;

import org.robobinding.gallery.R;

import android.content.Context;
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
public class CustomOrThirdPartyComponent extends LinearLayout {
    private TextView textView;

    public CustomOrThirdPartyComponent(Context context, AttributeSet attrs) {
	this(context, attrs, R.layout.custom_or_third_party_component);
    }

    protected CustomOrThirdPartyComponent(Context context, AttributeSet attrs, int layoutId) {
	super(context, attrs);

	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	inflater.inflate(layoutId, this);
	textView = (TextView) findViewById(R.id.textView);
    }

    public void setTextAttribute(CharSequence newText) {
	textView.setText(newText);
    }
}
