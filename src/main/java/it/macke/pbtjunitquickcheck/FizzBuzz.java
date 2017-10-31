package it.macke.pbtjunitquickcheck;

public class FizzBuzz
{
	public static void main(final String[] args)
	{
		final FizzBuzz fb = new FizzBuzz();
		for (int i = 1; i <= 100; i++)
		{
			System.out.println(fb.of(i));
		}
	}

	public String of(final int i)
	{
		String result = "";
		if (i % 3 == 0)
		{
			result += "Fizz";
		}
		if (i % 5 == 0)
		{
			result += "Buzz";
		}
		if (result.isEmpty())
		{
			result += i;
		}
		return result;
	}
}
