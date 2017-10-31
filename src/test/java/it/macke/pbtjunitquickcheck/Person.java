package it.macke.pbtjunitquickcheck;

public class Person implements Comparable<Person>
{
	private final Gender gender;
	private final int age;

	public Person(final Gender gender, final int age)
	{
		this.gender = gender;
		this.age = age;
	}

	public Gender getGender()
	{
		return gender;
	}

	public int getAge()
	{
		return age;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (gender == null ? 0 : gender.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Person other = (Person) obj;
		if (age != other.age)
		{
			return false;
		}
		if (gender != other.gender)
		{
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(final Person o)
	{
		return new Integer(getAge())
				.compareTo(new Integer(o.getAge()));
	}
}
