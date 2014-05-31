package org.robobinding.gallery.model.adapterview;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class SampleStrings
{
	private static final List<String> strings = createSample("Sample");
	private static final List<String> sample1 = createSample("Sample1");
	private static final List<String> sample2 = createSample("Sample2");

	private static List<String> createSample(String sampleName)
	{
		List<String> strings = Lists.newArrayList();
		strings.add(sampleName+" text1");
		strings.add(sampleName+" text2");
		return strings;
	}

	public static List<String> getSample()
	{
		return Collections.unmodifiableList(strings);
	}

	public static List<String> getSample1()
	{
		return Collections.unmodifiableList(sample1);
	}

	public static List<String> getSample2()
	{
		return Collections.unmodifiableList(sample2);
	}
}
