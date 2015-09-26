package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.DependsOnStateOf;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.invocationlog.PublicMethodInvocationLog;
import org.robobinding.gallery.model.adapterview.SampleStringType;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.adapterview.StringItemLayout;
import org.robobinding.itempresentationmodel.ViewTypeSelectionContext;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
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

    @ItemPresentationModel(value = ToStringItemPresentationModel.class)
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

    @ItemPresentationModel(value = ToStringItemPresentationModel.class)
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

    @ItemPresentationModel(value = StringItemPresentationModel.class,
            factoryMethod = "createDifferentStringItemPresentationModel",
            viewTypeSelector = "selectViewType")
    public List<String> getDifferentLookStrings() {
        return SampleStrings.getSample();
    }

    public StringItemPresentationModel createDifferentStringItemPresentationModel(int viewType) {
        if(viewType == 0) {
            return new StringItemPresentationModel1();
        } else {
            return new StringItemPresentationModel2();
        }
    }

    public int selectViewType(ViewTypeSelectionContext<String> context) {
        return context.getPosition() % context.getViewTypeCount();
    }

    private static class StringItemPresentationModel1 extends StringItemPresentationModel {
        @Override
        public String getValue() {
            return super.getValue() + " - from StringItemPresentationModel1";
        }
    }

    private static class StringItemPresentationModel2 extends StringItemPresentationModel {
        @Override
        public String getValue() {
            return super.getValue() + " - from StringItemPresentationModel2";
        }
    }
}
