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
package org.robobinding.gallery.activity;

import org.robobinding.gallary.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class AbsListViewActivity extends ListActivity {

	final String[] listContent = { "0", "1", "2", "3" };
	ListView list;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abs_list_view_activity);
		list = (ListView) findViewById(android.R.id.list);

		TextView label = new TextView(this);
		label.setText("HeaderView");
		list.addHeaderView(label, null, false);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, listContent));
		list.setItemsCanFocus(false);
		//list.setChoiceMode(ListView.CHOICE_MODE_NONE);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if(list.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE)
		{
			SparseBooleanArray checked = list.getCheckedItemPositions();
			for (int i = 0; i < listContent.length; i++) {
				Log.i("AbsListViewActivity", listContent[i] + ": " + checked.get(i));
			}
		}else if(list.getChoiceMode() == ListView.CHOICE_MODE_SINGLE)
		{
			int chckedItemPosition = list.getCheckedItemPosition();
			Log.i("AbsListViewActivity", "checkedItemPosition: "+chckedItemPosition);
		}
	}

}
