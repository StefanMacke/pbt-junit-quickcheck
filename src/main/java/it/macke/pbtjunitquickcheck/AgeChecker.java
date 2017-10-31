package it.macke.pbtjunitquickcheck;

public class AgeChecker
{
	public boolean isValidAge(final int age)
	{
		return age >= 0 && age < 130;
	}
}
