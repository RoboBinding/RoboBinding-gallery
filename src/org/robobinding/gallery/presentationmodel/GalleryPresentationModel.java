package org.robobinding.gallery.presentationmodel;

import java.util.List;
import java.util.Map;

import org.robobinding.gallery.activity.AdapterViewActivity;
import org.robobinding.gallery.activity.CustomComponentActivity;
import org.robobinding.gallery.activity.ListViewActivity;
import org.robobinding.gallery.activity.TypedCursorActivity;
import org.robobinding.gallery.model.Widget;
import org.robobinding.presentationmodel.DependsOnStateOf;
import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.common.collect.Maps;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@PresentationModel
public class GalleryPresentationModel
{
	private static Map<Widget, Class<? extends Activity>> widgetToActivity = createWidgetToActivity();

	private Context context;
	private int selectedWidgetIndex;

	public GalleryPresentationModel(Context context)
	{
		this.context = context;
		selectedWidgetIndex = 0;
	}

	@ItemPresentationModel(value = NameItemPresentationModel.class)
	public List<Widget> getWidgets()
	{
		return Widget.widgets();
	}

	public int getSelectedWidgetIndex()
	{
		return selectedWidgetIndex;
	}

	public void setSelectedWidgetIndex(int selectedWidgetIndex)
	{
		this.selectedWidgetIndex = selectedWidgetIndex;
	}

	@DependsOnStateOf("selectedWidgetIndex")
	public String getSelectedWidgetDescription()
	{
		Widget widget = getSelectedWidget();
		return "Try "+widget.getName();
	}

	public void tryWidget()
	{
		Widget widget = getSelectedWidget();

		Class<?> activityClass = widgetToActivity.get(widget);
		context.startActivity(new Intent(context, activityClass));
	}

	private Widget getSelectedWidget()
	{
		return Widget.valueOf(selectedWidgetIndex);
	}

	private static Map<Widget, Class<? extends Activity>> createWidgetToActivity()
	{
		Map<Widget, Class<? extends Activity>> widgetToActivity = Maps.newHashMap();
		widgetToActivity.put(Widget.ADAPTER_VIEW, AdapterViewActivity.class);
		widgetToActivity.put(Widget.LIST_VIEW, ListViewActivity.class);
		widgetToActivity.put(Widget.CUSTOM_VIEW, CustomComponentActivity.class);
		widgetToActivity.put(Widget.TYPED_CURSOR, TypedCursorActivity.class);
		return widgetToActivity;
	}
}
