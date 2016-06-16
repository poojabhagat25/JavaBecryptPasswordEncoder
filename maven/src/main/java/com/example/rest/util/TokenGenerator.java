package com.example.rest.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.log4j.Logger;

public class TokenGenerator
{

	private static Logger logger = Logger.getLogger(TokenGenerator.class);

	/**
	 * This will generate token
	 * 
	 * @param email
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateToken(String email)
	{
		StringBuffer authKey = new StringBuffer();
		try
		{
			byte[] bytesOfMessage = (String.valueOf(System.currentTimeMillis()) + email).getBytes();

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] thedigest = md.digest(bytesOfMessage);

			for (byte b : thedigest)
			{
				authKey.append(Integer.toHexString((int) (b & 0xff)));
			}
		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}

		return authKey.toString();
	}
	
	public static String systemGeneratedPassword()
	{
		Random ran = new Random();
		Integer code= (100000 + ran.nextInt(900000));
		return Integer.toString(code);
	}
	
	public static String encodeString(String password) {
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
}
