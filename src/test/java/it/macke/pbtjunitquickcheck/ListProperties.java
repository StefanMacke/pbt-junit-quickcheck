package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class ListProperties
{
	@Property
	public void applyingFiltersShouldBeCommutative(
			final List<@From(PersonGenerator.class) Person> people)
	{
		assertThat(
				people.stream().filter(p -> p.getAge() < 20).filter(p -> p.getGender() == Gender.Male)
						.collect(Collectors.toList()))
								.isEqualTo(
										people.stream().filter(p -> p.getGender() == Gender.Male)
												.filter(p -> p.getAge() < 20).collect(Collectors.toList()));
	}

	@Property
	public void sortedListsShouldStaySorted(
			final List<@From(PersonGenerator.class) Person> people)
	{
		assertThat(sort(people))
				.isEqualTo(sort(sort(people)));
	}

	private List<Person> sort(final List<Person> people)
	{
		return people.stream().sorted().collect(Collectors.toList());
	}
}
