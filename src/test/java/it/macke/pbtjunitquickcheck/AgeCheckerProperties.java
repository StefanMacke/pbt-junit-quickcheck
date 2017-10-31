package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class AgeCheckerProperties
{
	@Property(maxShrinkDepth = 100)
	@Ignore(value = "always fails")
	public void allAgesShouldBeValid(final int age)
	{
		assertThat(new AgeChecker().isValidAge(age)).isTrue();
	}

	@Property
	public void agesBetween0and129ShouldBeValid(
			@InRange(min = "0", max = "129") final int age)
	{
		assertThat(new AgeChecker().isValidAge(age)).isTrue();
	}
}
