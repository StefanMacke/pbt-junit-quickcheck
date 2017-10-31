package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzGenericProperties
{
	@Property
	public void resultMayOnlyBeFizzBuzzOrTheNumber(@InRange(min = "1") final int i)
	{
		assertThat(Arrays.asList("Fizz", "Buzz", "FizzBuzz", "" + i)).contains(new FizzBuzz().of(i));
	}

	@Property
	public void threeSubsequentResultsMayNotBeTheSame(@InRange(min = "1") final int i)
	{
		final FizzBuzz fb = new FizzBuzz();
		assertThat(fb.of(i)).isNotEqualTo(fb.of(i + 1)).isNotEqualTo(fb.of(i + 2));
	}

	@Property
	public void numbersDivisibleByThreeShouldYieldResultContainingFizz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(0));
		assertThat(new FizzBuzz().of(i)).startsWith("Fizz");
	}

	@Property
	public void numbersDivisibleByFiveShouldYieldResultContainingBuzz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 5, is(0));
		assertThat(new FizzBuzz().of(i)).endsWith("Buzz");
	}

	@Property
	public void numbersDivisibleByThreeAndFiveShouldYieldFizzBuzz(@InRange(min = "1") final int i)
	{
		assumeThat(i % 3, is(0));
		assumeThat(i % 5, is(0));
		assertThat(new FizzBuzz().of(i)).isEqualTo("FizzBuzz");
	}
}
