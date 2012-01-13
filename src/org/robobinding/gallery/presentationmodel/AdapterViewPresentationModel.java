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

import java.util.List;

import org.robobinding.DependsOnStateOf;
import org.robobinding.ItemPresentationModel;
import org.robobinding.gallery.invocationlog.PublicMethodInvocationLog;
import org.robobinding.gallery.model.adapterview.AdapterViewFeature;
import org.robobinding.gallery.model.adapterview.SampleStringType;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.adapterview.StringItemLayout;
import org.robobinding.presentationmodelaspects.PresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class AdapterViewPresentationModel implements PublicMethodInvocationLog
{
	private static final String SELECTED_FEATURE_INDEX = "selectedFeatureIndex";

	private static final String SELECTED_SOURCE_INDEX = "selectedSourceIndex";

	private static final String SELECTED_ITEM_LAYOUT_INDEX = "selectedItemLayoutIndex";
	
	private int selectedFeatureIndex;
	
	private int selectedSourceIndex;
	
	private int selectedItemLayoutIndex;
	
	public AdapterViewPresentationModel()
	{
		selectedFeatureIndex = 0;
		
		selectedSourceIndex = 0;
		
		selectedItemLayoutIndex = 0;
	}
	
	@ItemPresentationModel(value=NameItemPresentationModel.class)
	public List<AdapterViewFeature> getFeatures()
	{
		return AdapterViewFeature.features();
	}

	public int getSelectedFeatureIndex()
	{
		return selectedFeatureIndex;
	}

	public void setSelectedFeatureIndex(int selectedFeatureIndex)
	{
		this.selectedFeatureIndex = selectedFeatureIndex;
	}

	@DependsOnStateOf(SELECTED_FEATURE_INDEX)
	public boolean isDynamicSourceFeatureSelected()
	{
		return AdapterViewFeature.DYNAMIC_SOURCE.equals(getSelectedFeature());
	}

	@ItemPresentationModel(value=StringItemPresentationModel.class)
	@DependsOnStateOf(SELECTED_SOURCE_INDEX)
	public List<String> getDynamicStrings()
	{
		return getSelectedSource().getSample();
	}
	
	@ItemPresentationModel(value=NameItemPresentationModel.class)
	public List<SampleStringType> getSources()
	{
		return SampleStringType.types();
	}

	public int getSelectedSourceIndex()
	{
		return selectedSourceIndex;
	}

	public void setSelectedSourceIndex(int selectedSourceIndex)
	{
		this.selectedSourceIndex = selectedSourceIndex;
	}

	private SampleStringType getSelectedSource()
	{
		return SampleStringType.valueOf(selectedSourceIndex);
	}

	@DependsOnStateOf(SELECTED_FEATURE_INDEX)
	public boolean isDynamicItemLayoutFeatureSelected()
	{
		return AdapterViewFeature.DYNAMIC_ITEM_LAYOUT.equals(getSelectedFeature());
	}

	@DependsOnStateOf(SELECTED_ITEM_LAYOUT_INDEX)
	public int getDynamicItemLayout()
	{
		return getSelectedItemLayout().getLayoutResourceId();
	}
	
	@ItemPresentationModel(value=StringItemPresentationModel.class)
	public List<String> getStaticStrings()
	{
		return SampleStrings.getSample();
	}
	
	@ItemPresentationModel(value=NameItemPresentationModel.class)
	public List<StringItemLayout> getItemLayouts()
	{
		return StringItemLayout.itemLayouts();
	}
	
	public int getSelectedItemLayoutIndex()
	{
		return selectedItemLayoutIndex;
	}

	public void setSelectedItemLayoutIndex(int selectedItemLayoutIndex)
	{
		this.selectedItemLayoutIndex = selectedItemLayoutIndex;
	}

	private StringItemLayout getSelectedItemLayout()
	{
		return StringItemLayout.valueOf(selectedItemLayoutIndex);
	}

	private AdapterViewFeature getSelectedFeature()
	{
		return AdapterViewFeature.valueOf(selectedFeatureIndex);
	}
}
