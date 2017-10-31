package it.macke.pbtjunitquickcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class HasherProperties
{
	@Property
	public void sha256HashesMustAlwaysBe64CharactersLong(
			final String text)
	{
		assertThat(new Hasher().hashWithSha256(text).length())
				.isEqualTo(64);
	}

	@Property
	public void sha256HashesMustOnlyContainHexCharacters(
			final String text)
	{
		assertThat(new Hasher().hashWithSha256(text))
				.matches("[0-9A-F]+");
	}
}
