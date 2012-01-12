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
import org.robobinding.gallery.model.BooleanVisibility;
import org.robobinding.gallery.model.IntegerVisibility;
import org.robobinding.gallery.model.SampleStrings;
import org.robobinding.gallery.model.ToStringUtils;
import org.robobinding.gallery.model.listview.ChoiceMode;
import org.robobinding.gallery.model.listview.ListViewFeature;
import org.robobinding.presentationmodelaspects.PresentationModel;

import android.util.SparseBooleanArray;
import android.widget.ListView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class ListViewPresentationModel
{
	private static final String FOOTER_INTEGER_VISIBILITY = "footerIntegerVisibility";

	private static final String HEADER_BOOLEAN_VISIBILITY = "headerBooleanVisibility";

	private static final String SELECTED_CHOICE_MODE_INDEX = "selectedChoiceModeIndex";

	private static final String SELECTED_FEATURE_INDEX = "selectedFeatureIndex";
	
	private int selectedFeatureIndex;
	
	private BooleanVisibility headerBooleanVisibility;
	
	private IntegerVisibility footerIntegerVisibility;
	
	private int selectedChoiceModeIndex;
	
	private SparseBooleanArray checkedItemPositions;
	private int checkedItemPosition;
	
	public ListViewPresentationModel()
	{
		selectedFeatureIndex = 0;
		
		headerBooleanVisibility = new BooleanVisibility();
		
		footerIntegerVisibility = new IntegerVisibility();
		
		selectedChoiceModeIndex = 0;
		
		checkedItemPositions = new SparseBooleanArray();
		checkedItemPosition = ListView.INVALID_POSITION;
	}
	
	@ItemPresentationModel(value=StringItemPresentationModel.class)
	public List<String> getStrings()
	{
		return SampleStrings.getStrings();
	}
	
	public SampleStringsFooter getFooter()
	{
		return SampleStringsFooter.getInstance();
	}
	
	@DependsOnStateOf(SELECTED_CHOICE_MODE_INDEX)
	public int getItemLayout()
	{
		return getSelectedChoiceMode().getLayoutResourceId();
	}

	@ItemPresentationModel(value=NameItemPresentationModel.class)
	public List<ListViewFeature> getFeatures()
	{
		return ListViewFeature.features();
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
	public String getSelectedFeatureName()
	{
		return getSelectedFeature().getName()+":";
	}
	
	@DependsOnStateOf(SELECTED_FEATURE_INDEX)
	public boolean isHeaderVisibilityFeatureSelected()
	{
		return ListViewFeature.HEADER_VISIBILITY.equals(getSelectedFeature());
	}
	
	public boolean getHeaderBooleanVisibility()
	{
		return headerBooleanVisibility.getValue();
	}
	
	public void changeHeaderVisibility()
	{
		headerBooleanVisibility.nextState();
		firePropertyChange(HEADER_BOOLEAN_VISIBILITY);
	}
	
	@DependsOnStateOf(HEADER_BOOLEAN_VISIBILITY)
	public String getHeaderBooleanVisibilityDescription()
	{
		return "Header "+headerBooleanVisibility.describe("visible", "invisible");
	}
	
	@DependsOnStateOf(SELECTED_FEATURE_INDEX)
	public boolean isFooterVisibilityFeatureSelected()
	{
		return ListViewFeature.FOOTER_VISIBILITY.equals(getSelectedFeature());
	}
	
	public int getFooterIntegerVisibility()
	{
		return footerIntegerVisibility.getValue();
	}
	
	public void changeFooterVisibility()
	{
		footerIntegerVisibility.nextState();
		firePropertyChange(FOOTER_INTEGER_VISIBILITY);
	}
	
	@DependsOnStateOf(FOOTER_INTEGER_VISIBILITY)
	public String getFooterIntegerVisibilityDescription()
	{
		return "Footer "+footerIntegerVisibility.describe("visible", "invisible", "gone");
	}
	
	@DependsOnStateOf(SELECTED_FEATURE_INDEX)
	public boolean isChoiceModeFeatureSelected()
	{
		return ListViewFeature.CHOICE_MODE.equals(getSelectedFeature());
	}
	
	@ItemPresentationModel(value=NameItemPresentationModel.class)
	public List<ChoiceMode> getChoiceModes()
	{
		return ChoiceMode.choiceModes();
	}
	
	public int getSelectedChoiceModeIndex()
	{
		return selectedChoiceModeIndex;
	}

	public void setSelectedChoiceModeIndex(int selectedChoiceModeIndex)
	{
		this.selectedChoiceModeIndex = selectedChoiceModeIndex;
	}

	@DependsOnStateOf(SELECTED_CHOICE_MODE_INDEX)
	public int getChoiceMode()
	{
		return getSelectedChoiceMode().getModeValue();
	}
	
	public SparseBooleanArray getCheckedItemPositions()
	{
		return checkedItemPositions;
	}

	public void setCheckedItemPositions(SparseBooleanArray checkedItemPositions)
	{
		this.checkedItemPositions = checkedItemPositions;
	}

	public int getCheckedItemPosition()
	{
		return checkedItemPosition;
	}

	public void setCheckedItemPosition(int checkedItemPosition)
	{
		this.checkedItemPosition = checkedItemPosition;
	}

	@DependsOnStateOf({"checkedItemPositions", "checkedItemPosition", SELECTED_CHOICE_MODE_INDEX})
	public String getDescriptionOfSelectedItems()
	{
		if(ChoiceMode.CHOICE_MODE_SINGLE.equals(getSelectedChoiceMode()))
		{
			return ""+checkedItemPosition;
		}else
		{
			return ToStringUtils.toString(checkedItemPositions);
		}
	}
	
	private ListViewFeature getSelectedFeature()
	{
		return ListViewFeature.indexOf(selectedFeatureIndex);
	}
	
	private ChoiceMode getSelectedChoiceMode()
	{
		return ChoiceMode.indexOf(selectedChoiceModeIndex);
	}
	
}
