package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class FizzBuzzShould
{
	private FizzBuzz sut;

	@BeforeEach
	public void setup()
	{
		sut = new FizzBuzz();
	}

	@Test
	public void returnFizzForNumbersDivisibleByThree()
	{
		assertThat(sut.of(3)).isEqualTo("Fizz");
		assertThat(sut.of(6)).isEqualTo("Fizz");
		assertThat(sut.of(9)).isEqualTo("Fizz");
		assertThat(sut.of(33)).isEqualTo("Fizz");
		assertThat(sut.of(303)).isEqualTo("Fizz");
		assertThat(sut.of(3366)).isEqualTo("Fizz");
	}

	@Test
	public void returnBuzzForNumbersDivisibleByFive()
	{
		assertThat(sut.of(5)).isEqualTo("Buzz");
		assertThat(sut.of(10)).isEqualTo("Buzz");
		assertThat(sut.of(50)).isEqualTo("Buzz");
		assertThat(sut.of(500)).isEqualTo("Buzz");
		assertThat(sut.of(5555)).isEqualTo("Buzz");
	}

	@Test
	public void returnFizzBuzzForNumbersDivisibleByFifteen()
	{
		assertThat(sut.of(15)).isEqualTo("FizzBuzz");
		assertThat(sut.of(30)).isEqualTo("FizzBuzz");
		assertThat(sut.of(45)).isEqualTo("FizzBuzz");
		assertThat(sut.of(150)).isEqualTo("FizzBuzz");
		assertThat(sut.of(1500)).isEqualTo("FizzBuzz");
		assertThat(sut.of(1515)).isEqualTo("FizzBuzz");
	}

	@Test
	public void returnNumberForNumbersNotDivisibleByThreeOrFive()
	{
		assertThat(sut.of(1)).isEqualTo("1");
		assertThat(sut.of(2)).isEqualTo("2");
		assertThat(sut.of(4)).isEqualTo("4");
		assertThat(sut.of(98)).isEqualTo("98");
		assertThat(sut.of(1001)).isEqualTo("1001");
	}
}
