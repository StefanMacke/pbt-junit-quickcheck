package it.macke.pbtjunitquickcheck;

public class JsonSerializer
{
	public String toJson(final Name name)
	{
		return "{ name: \"" + name.getName() + "\" }";
	}
}
