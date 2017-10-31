package it.macke.pbtjunitquickcheck;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GreatestCommonDivisorCalculator
{
	public long euklid(long a, long b)
	{
		if (a == 0)
		{
			return b;
		}
		else
		{
			while (b != 0)
			{
				if (a > b)
				{
					a -= b;
				}
				else
				{
					b -= a;
				}
			}
			return a;
		}
	}

	public long primeFactors(final long a, final long b)
	{
		final PrimeFactorCalculator pfc = new PrimeFactorCalculator();
		final Map<Long, Long> factorsA = pfc.factor(a).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		final Map<Long, Long> factorsB = pfc.factor(b).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		final Stream<Long> factorsBoth = factorsA.entrySet().stream().map(e -> e.getKey())
				.filter(k -> factorsB.containsKey(k));
		return factorsBoth.map(f -> (long) Math.pow(f, Math.min(factorsA.get(f), factorsB.get(f))))
				.reduce(1L, (f1, f2) -> f1 * f2);
	}
}
