package it.macke.pbtjunitquickcheck;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class PersonGenerator extends Generator<Person>
{
	public PersonGenerator(final Class<Person> type)
	{
		super(type);
	}

	@Override
	public Person generate(final SourceOfRandomness random, final GenerationStatus status)
	{
		return new Person(
				random.nextBoolean() ? Gender.Male : Gender.Female,
				random.nextInt(1, 130));
	}
}
