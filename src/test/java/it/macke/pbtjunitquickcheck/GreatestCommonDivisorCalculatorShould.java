package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreatestCommonDivisorCalculatorShould
{
	private GreatestCommonDivisorCalculator sut;

	@BeforeEach
	public void setup()
	{
		sut = new GreatestCommonDivisorCalculator();
	}

	@Test
	public void findTheGreatestDivisor()
	{
		assertThat(sut.euklid(3780, 3528)).isEqualTo(252);
		assertThat(sut.primeFactors(3780, 3528)).isEqualTo(252);
		assertThat(sut.euklid(99, 81)).isEqualTo(9);
	}
}
