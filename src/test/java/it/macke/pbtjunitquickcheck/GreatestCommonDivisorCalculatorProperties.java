package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class GreatestCommonDivisorCalculatorProperties
{
	@Property
	public void euklidAndPrimeFactorsShouldYieldSameResult(
			@InRange(min = "2", max = "999999999999") final long a,
			@InRange(min = "2", max = "999999999999") final long b)
	{
		final GreatestCommonDivisorCalculator sut = new GreatestCommonDivisorCalculator();
		assertThat(sut.euklid(a, b)).isEqualTo(sut.primeFactors(a, b));
	}
}
