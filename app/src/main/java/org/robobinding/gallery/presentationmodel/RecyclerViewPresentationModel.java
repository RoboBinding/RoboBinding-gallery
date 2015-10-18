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

import android.util.SparseBooleanArray;

import com.google.common.collect.Lists;

import org.robobinding.annotation.DependsOnStateOf;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.gallery.invocationlog.PublicMethodInvocationLog;
import org.robobinding.gallery.model.Strings;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.listview.SampleStringsFooter;
import org.robobinding.gallery.model.view.BooleanVisibility;
import org.robobinding.gallery.model.view.IntegerVisibility;
import org.robobinding.itempresentationmodel.ListObservable;
import org.robobinding.itempresentationmodel.ViewTypeSelectionContext;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.List;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
@PresentationModel
public class RecyclerViewPresentationModel implements HasPresentationModelChangeSupport, PublicMethodInvocationLog {
    private final PresentationModelChangeSupport changeSupport;
    private final ListObservable<String> strings;
    private int sampleCounter = 0;

    public RecyclerViewPresentationModel() {
        changeSupport = new PresentationModelChangeSupport(this);
        strings = new ListObservable(Lists.newArrayList("sample1", "sample2", "sample3"));
        sampleCounter = 3;
    }

    @ItemPresentationModel(value = StringItemPresentationModel.class,
            viewTypeSelector = "selectViewType")
    public ListObservable<String> getStrings() {
        return strings;
    }

    public int selectViewType(ViewTypeSelectionContext<String> context) {
        return context.getPosition() % context.getViewTypeCount();
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public void removeLastItem() {
        if (!strings.isEmpty()) {
            strings.remove(strings.size()-1);
        }
    }

    public void addItem() {
        sampleCounter++;
        strings.add("sample" + sampleCounter);
    }
}
