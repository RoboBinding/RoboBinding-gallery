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
import org.robobinding.gallery.model.Pet;
import org.robobinding.gallery.model.PetStore;
import org.robobinding.presentationmodelaspects.PresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class ListViewPresentationModel
{
	private PetStore petStore;
	private PetFooter petFooter;
	
	private BooleanVisibility petHeaderBooleanVisibility;
	private IntegerVisibility petFooterIntegerVisibility;
	public ListViewPresentationModel()
	{
		petStore = PetStore.getInstance();
		petFooter = new PetFooter(petStore);
		
		petHeaderBooleanVisibility = new BooleanVisibility();
		petFooterIntegerVisibility = new IntegerVisibility();
	}
	
	@ItemPresentationModel(value=PetRow.class)
	public List<Pet> getPets()
	{
		return petStore.getPets();
	}
	
	public boolean getPetHeaderBooleanVisibility()
	{
		return petHeaderBooleanVisibility.getValue();
	}
	
	public void changeHeaderVisibility()
	{
		petHeaderBooleanVisibility.nextState();
		firePropertyChange("petHeaderBooleanVisibility");
	}
	
	@DependsOnStateOf("petHeaderBooleanVisibility")
	public String getHeaderBooleanVisibilityDescription()
	{
		return "Header "+petHeaderBooleanVisibility.describe("visible", "invisible");
	}
	
	public PetFooter getPetFooter()
	{
		return petFooter;
	}
	
	public int getPetFooterIntegerVisibility()
	{
		return petFooterIntegerVisibility.getValue();
	}
	
	public void changeFooterVisibility()
	{
		petFooterIntegerVisibility.nextState();
		firePropertyChange("petFooterIntegerVisibility");
	}
	
	@DependsOnStateOf("petFooterIntegerVisibility")
	public String getFooterIntegerVisibilityDescription()
	{
		return "Footer "+petFooterIntegerVisibility.describe("visible", "invisible", "gone");
	}
}
