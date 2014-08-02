package org.robobinding.gallery.presentationmodel;

import java.util.List;
import java.util.Map;

import org.robobinding.presentationmodel.DependsOnStateOf;
import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.common.collect.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class GalleryPresentationModel
{
	private Context context;
	private Map<String, Class<? extends Activity>> demoActivityMappings;

	private int selectedDemoIndex;

	public GalleryPresentationModel(Context context, Map<String, Class<? extends Activity>> demoActivityMappings)
	{
		this.context = context;
		this.demoActivityMappings = demoActivityMappings;
		selectedDemoIndex = 0;
	}

	@ItemPresentationModel(value = StringItemPresentationModel.class)
	public List<String> getDemoList()
	{
		return Lists.newArrayList(demoActivityMappings.keySet());
	}

	public int getSelectedDemoIndex()
	{
		return selectedDemoIndex;
	}

	public void setSelectedDemoIndex(int selectedDemoIndex)
	{
		this.selectedDemoIndex = selectedDemoIndex;
	}

	@DependsOnStateOf("selectedDemoIndex")
	public String getSelectedDemoDescription()
	{
		return "Try "+getSelectedDemo();
	}

	public void showDemo()
	{
		String demo = getSelectedDemo();

		Class<?> activityClass = demoActivityMappings.get(demo);
		context.startActivity(new Intent(context, activityClass));
	}

	private String getSelectedDemo()
	{
		return getDemoList().get(selectedDemoIndex);
	}
}
