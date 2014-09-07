package org.robobinding.gallery.model.adapterview;

import java.util.Collections;
import java.util.List;

import org.robobinding.internal.guava.Lists;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public enum SampleStringType
{
	SAMPLE1("Sample strings 1", SampleStrings.getSample1()),
	SAMPLE2("Sample strings 2", SampleStrings.getSample2());

	private String name;
	private List<String> sample;

	private SampleStringType(String name, List<String> sample)
	{
		this.name = name;
		this.sample = sample;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public List<String> getSample()
	{
		return sample;
	}

	private static List<SampleStringType> types = Lists.newArrayList(SampleStringType.values());

	public static List<SampleStringType> types()
	{
		return Collections.unmodifiableList(types);
	}

	public static SampleStringType valueOf(int index)
	{
		return types.get(index);
	}
}
