package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class JsonSerializerProperties
{
	@Property
	public void allNamesShouldBeSerializable(final String str)
	{
		final JsonSerializer sut = new JsonSerializer();
		final JsonDeserializer de = new JsonDeserializer();
		final Name name = new Name(str);
		assertThat(de.fromJson(sut.toJson(name))).isEqualTo(name);
	}
}
