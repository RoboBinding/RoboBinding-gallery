package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.DependsOnStateOf;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.gallery.invocationlog.PublicMethodInvocationLog;
import org.robobinding.gallery.model.adapterview.SampleStringType;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.adapterview.StringItemLayout;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class AdapterViewPresentationModel implements PublicMethodInvocationLog {
    private static final String SELECTED_SOURCE_INDEX = "selectedSourceIndex";

    private static final String SELECTED_ITEM_LAYOUT_INDEX = "selectedItemLayoutIndex";

    private int selectedSourceIndex;

    private int selectedItemLayoutIndex;

    public AdapterViewPresentationModel() {
	selectedSourceIndex = 0;

	selectedItemLayoutIndex = 0;
    }

    @ItemPresentationModel(value = StringItemPresentationModel.class)
    @DependsOnStateOf(SELECTED_SOURCE_INDEX)
    public List<String> getDynamicStrings() {
	return getSelectedSource().getSample();
    }

    @ItemPresentationModel(value = NameItemPresentationModel.class)
    public List<SampleStringType> getSources() {
	return SampleStringType.types();
    }

    public int getSelectedSourceIndex() {
	return selectedSourceIndex;
    }

    public void setSelectedSourceIndex(int selectedSourceIndex) {
	this.selectedSourceIndex = selectedSourceIndex;
    }

    private SampleStringType getSelectedSource() {
	return SampleStringType.valueOf(selectedSourceIndex);
    }

    @DependsOnStateOf(SELECTED_ITEM_LAYOUT_INDEX)
    public int getDynamicItemLayout() {
	return getSelectedItemLayout().getLayoutResourceId();
    }

    @ItemPresentationModel(value = StringItemPresentationModel.class)
    public List<String> getStaticStrings() {
	return SampleStrings.getSample();
    }

    @ItemPresentationModel(value = NameItemPresentationModel.class)
    public List<StringItemLayout> getItemLayouts() {
	return StringItemLayout.itemLayouts();
    }

    public int getSelectedItemLayoutIndex() {
	return selectedItemLayoutIndex;
    }

    public void setSelectedItemLayoutIndex(int selectedItemLayoutIndex) {
	this.selectedItemLayoutIndex = selectedItemLayoutIndex;
    }

    private StringItemLayout getSelectedItemLayout() {
	return StringItemLayout.valueOf(selectedItemLayoutIndex);
    }
}
