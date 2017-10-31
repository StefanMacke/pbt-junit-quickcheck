package it.macke.pbtjunitquickcheck;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher
{
	public String hashWithSha256(final String toHash)
	{
		try
		{
			final MessageDigest digest = MessageDigest.getInstance("SHA-256");
			final byte[] hash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(hash);
		}
		catch (final NoSuchAlgorithmException e)
		{
			return null;
		}
	}

	public String bytesToHex(final byte[] bytes)
	{
		final char[] hexArray = "0123456789ABCDEF".toCharArray();
		final char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++)
		{
			final int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
