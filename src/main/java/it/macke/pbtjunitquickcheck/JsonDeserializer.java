package it.macke.pbtjunitquickcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonDeserializer
{
	public Name fromJson(final String json)
	{
		final Matcher m = Pattern.compile("\\{ name: \"(.*)\" \\}", Pattern.DOTALL).matcher(json);
		if (m.matches())
		{
			return new Name(m.group(1));
		}
		return null;
	}
}
