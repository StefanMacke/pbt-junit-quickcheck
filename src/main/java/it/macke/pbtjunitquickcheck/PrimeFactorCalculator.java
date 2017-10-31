package it.macke.pbtjunitquickcheck;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorCalculator
{
	public List<Long> factor(Long i)
	{
		List<Long> primeFactors = new ArrayList<>();
		long divisor = 1;
		double squareRoot = Math.sqrt(i);
		while (i > 1)
		{
			divisor++;
			while (i % divisor == 0)
			{
				primeFactors.add(divisor);
				i /= divisor;
			}
			if (divisor > squareRoot)
			{
				divisor = i - 1;
			}
		}
		return primeFactors;
	}

	public boolean isPrime(Long n)
	{
		if (n <= 1)
		{
			return false;
		}

		if (n == 2)
		{
			return true;
		}

		if (n % 2 == 0)
		{
			return false;
		}

		for (Long divisor = 3L; divisor * divisor <= n; divisor++)
		{
			if (n % divisor == 0)
			{
				return false;
			}
		}
		return true;
	}
}
