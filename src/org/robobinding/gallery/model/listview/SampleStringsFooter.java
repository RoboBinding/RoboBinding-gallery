package org.robobinding.gallery.model.listview;

import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.presentationmodel.PresentationModel;

import android.text.Html;
import android.text.Spanned;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class SampleStringsFooter
{
	private SampleStringsFooter()
	{
	}

	public Spanned getDescription()
	{
		int size = SampleStrings.getSample().size();
		return Html.fromHtml("There are <BIG><EM>"+size+"</EM></BIG> samples.");
	}

	private static final SampleStringsFooter uniqueInstance = new SampleStringsFooter();

	public static SampleStringsFooter getInstance()
	{
		return uniqueInstance;
	}
}
