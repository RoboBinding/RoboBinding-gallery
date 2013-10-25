/**
 * Copyright 2013 Cheng Wei, Robert Taylor
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

import org.robobinding.presentationmodel.PresentationModel;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class CustomViewPresentationModel {
    private String title;
    private String description;
    private String newTitle;
    private String newDescription;

    public CustomViewPresentationModel() {
	this.title = "Default title";
	this.description = "Default description";
    }

    public String getTitle() {
	return title;
    }

    public String getDescription() {
	return description;
    }

    public String getNewTitle() {
	return newTitle;
    }

    public void setNewTitle(String newTitle) {
	this.newTitle = newTitle;
    }

    public String getNewDescription() {
	return newDescription;
    }

    public void setNewDescription(String newDescription) {
	this.newDescription = newDescription;
    }

    public void applyNewTitleDescription() {
	title = newTitle;
	description = newDescription;

	firePropertyChange("title");
	firePropertyChange("description");
    }
}
