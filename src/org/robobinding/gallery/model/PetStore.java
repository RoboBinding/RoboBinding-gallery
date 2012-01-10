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
package org.robobinding.gallery.model;

import java.util.Collections;
import java.util.List;

import org.robobinding.internal.com_google_common.collect.Lists;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class PetStore
{
	private List<Pet> pets;

	private PetStore()
	{
		pets = Lists.newArrayList();
		pets.add(new Pet("Dog", "Please throw me bones"));
		pets.add(new Pet("Cat", "I like fish"));
	}

	public List<Pet> getPets()
	{
		return Collections.unmodifiableList(pets);
	}

	public int size()
	{
		return pets.size();
	}

	private static PetStore uniqueInstance = new PetStore();

	public static PetStore getInstance()
	{
		return uniqueInstance;
	}
}
