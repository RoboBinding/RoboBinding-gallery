/**
 * Copyright 2012 Cheng Wei, Robert Taylor
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
package org.robobinding.gallery.presentationmodel;

import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.presentationmodelaspects.PresentationModel;

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
