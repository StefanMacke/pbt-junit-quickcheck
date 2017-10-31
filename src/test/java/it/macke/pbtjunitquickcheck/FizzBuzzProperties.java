package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzProperties
{
	@Property
	public void numbersOnlyDivisibleByThreeShouldYieldFizz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(0));
		assumeThat(i % 5, is(not(0)));
		assertThat(new FizzBuzz().of(i)).isEqualTo("Fizz");
	}

	@Property
	public void numbersOnlyDivisibleByFiveShouldYieldBuzz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(not(0)));
		assumeThat(i % 5, is(0));
		assertThat(new FizzBuzz().of(i)).isEqualTo("Buzz");
	}

	@Property
	public void numbersDivisibleByThreeAndFiveShouldYieldFizzBuzz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(0));
		assumeThat(i % 5, is(0));
		assertThat(new FizzBuzz().of(i)).isEqualTo("FizzBuzz");
	}

	@Property
	public void numbersNotDivisibleByThreeOrFiveShouldYieldTheNumberItself(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(not(0)));
		assumeThat(i % 5, is(not(0)));
		assertThat(new FizzBuzz().of(i)).isEqualTo("" + i);
	}
}
