package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class PrimeFactorCalculatorShould
{
	private PrimeFactorCalculator sut;

	private List<Long> split(final String s)
	{
		return Pattern.compile(";")
				.splitAsStream(s)
				.map(Long::parseLong)
				.collect(Collectors.toList());
	}

	@BeforeEach
	public void setup()
	{
		sut = new PrimeFactorCalculator();
	}

	@Test
	public void factor2()
	{
		assertThat(sut.factor(2L)).isEqualTo(Arrays.asList(2L));
	}

	@Test
	public void factor3()
	{
		assertThat(sut.factor(3L)).isEqualTo(Arrays.asList(3L));
	}

	@Test
	public void factor4()
	{
		assertThat(sut.factor(4L)).isEqualTo(Arrays.asList(2L, 2L));
	}

	@Test
	public void factor5()
	{
		assertThat(sut.factor(5L)).isEqualTo(Arrays.asList(5L));
	}

	@Test
	public void factor6()
	{
		assertThat(sut.factor(6L)).isEqualTo(Arrays.asList(2L, 3L));
	}

	@Test
	public void factor7()
	{
		assertThat(sut.factor(7L)).isEqualTo(Arrays.asList(7L));
	}

	@Test
	public void factor8()
	{
		assertThat(sut.factor(8L)).isEqualTo(Arrays.asList(2L, 2L, 2L));
	}

	@Test
	public void factor9()
	{
		assertThat(sut.factor(9L)).isEqualTo(Arrays.asList(3L, 3L));
	}

	@Test
	@Disabled(value = "cannot work")
	public void factorRandomNumber()
	{
		Long randomNumber = new Random().nextLong();
		List<Long> expectedPrimeFactors = Arrays.asList(1L);
		assertThat(sut.factor(randomNumber)).isEqualTo(expectedPrimeFactors);
	}

	@Test
	public void factorSmallNumbers2()
	{
		assertThat(sut.factor(2L)).isEqualTo(Arrays.asList(2L));
		assertThat(sut.factor(3L)).isEqualTo(Arrays.asList(3L));
		assertThat(sut.factor(4L)).isEqualTo(Arrays.asList(2L, 2L));
		assertThat(sut.factor(5L)).isEqualTo(Arrays.asList(5L));
	}

	@ParameterizedTest(name = "{0} should be factored as [{1}]")
	@CsvSource({
			"2, 2",
			"3, 3",
			"4, 2;2",
			"5, 5" })
	public void factorSmallNumbers(final long n, final String factors)
	{
		assertThat(sut.factor(n)).isEqualTo(split(factors));
	}

	@ParameterizedTest(name = "{0} should be prime? {1}")
	@CsvSource({
			"1, false",
			"2, true",
			"3, true",
			"4, false",
			"5, true",
			"6, false",
			"7, true",
			"8, false",
			"9, false",
			"10, false",
			"2147483647, true" })
	public void findPrimeNumbers(long n, boolean isPrime)
	{
		assertThat(sut.isPrime(n)).isEqualTo(isPrime);
	}
}
