package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class PrimeFactorCalculatorProperties
{
	private PrimeFactorCalculator sut;

	@Before
	public void setup()
	{
		sut = new PrimeFactorCalculator();
	}

	@Property
	public void primeFactorsShouldContainAtLeastOneElement(
			@InRange(min = "2", max = "9999999999999") final Long i)
	{
		assertThat(sut.factor(i).size())
				.isGreaterThan(0);
	}

	@Property
	public void productOfPrimeFactorsShouldBeTheOriginalNumber(
			@InRange(min = "2", max = "9999999999999") final Long i)
	{
		assertThat(sut.factor(i).stream().reduce(1L, (a, b) -> a * b))
				.isEqualTo(i);
	}

	@Property(maxShrinkDepth = 100, maxShrinks = 1000)
	public void primeFactorsShouldBePrimeNumbers(
			@InRange(min = "2", max = "9999999999999") final Long i)
	{
		sut.factor(i)
				.stream()
				.forEach(primeFactor -> assertThat(sut.isPrime(primeFactor))
						.as("factor " + primeFactor + " should be a prime number")
						.isTrue());
	}

	@Property
	public void primeFactorsShouldNotBeFactorizable(
			@InRange(min = "2", max = "9999999999999") final Long i)
	{
		sut.factor(i)
				.stream()
				.forEach(primeFactor -> assertThat(sut.factor(primeFactor))
						.isEqualTo(Arrays.asList(primeFactor)));
	}

	@Property(maxShrinkDepth = 100, maxShrinks = 1000)
	public void primeFactorsForEvenNumbersShouldContain2(
			@InRange(min = "2", max = "9999999999999") @When(seed = -6527596145222155897L) final Long i)
	{
		assumeThat(i % 2, is(0L));
		assertThat(sut.factor(i)).contains(2L);
	}
}
