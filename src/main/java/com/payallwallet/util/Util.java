package com.payallwallet.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Util {
	
	private static SecureRandom secureRandom = null;
	
	/**
	 * Gets the masked number.
	 *
	 * @param number
	 *            the number to mask
	 * @param preUnMaskedLength
	 *            the preUnMaskedLength
	 * @param preUnMaskedLength
	 *            the postUnMaskedLength
	 * @param maskChar
	 *            the maskChar
	 * @return the masked email
	 */
	public static String maskNumber(String number, String preUnMaskedLength, String postUnMaskedLength, String maskChar) {

		int minLen = 0;
		int totalLen = 0;
		int maskLen = 0;
		int preLen = 0;
		int postLen = 0;
		String maskNum = number;
		if (!isEmpty(number) && !isEmpty(preUnMaskedLength) && !isEmpty(postUnMaskedLength) && !isEmpty(maskChar)) {
			preLen = Integer.parseInt(preUnMaskedLength);
			postLen = Integer.parseInt(postUnMaskedLength);
			minLen = preLen + postLen;
			totalLen = number.length();
			if (totalLen > minLen) {
				maskLen = totalLen - minLen;
				StringBuffer maskedbuf = new StringBuffer(number.substring(0, preLen));
				for (int i = 0; i < maskLen; i++) {
					maskedbuf.append(maskChar);
				}
				maskedbuf.append(number.substring(preLen + maskLen, totalLen));
				maskNum = maskedbuf.toString();
			}
		}
		return maskNum;
	}
	
	
	/**
	 * Checks if is empty.
	 *
	 * @param s
	 *            the s
	 * @return true, if is empty
	 */
	public static boolean isEmpty(String s) {
		return (s == null) || (s.trim().length() == 0);
	}
	
	/**
	 * This method will generate a random integer value by taking double value.
	 *
	 * @param power
	 *            the power
	 * @return int
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	public static int generateRandomValue(int power) throws NoSuchAlgorithmException {
		//LOG.info("generateRandomValue Entered....");

		int seedByteCount = power;
		if (secureRandom == null) {
			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
			byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		}
		int ramdongen = 0;

		ramdongen = secureRandom.nextInt((int) Math.pow(10, power));

		String strRan = "" + ramdongen;
		while (strRan.length() < power) {
			ramdongen = secureRandom.nextInt((int) Math.pow(10, power));
			strRan = "" + ramdongen;
		}
		//LOG.info("generateRandomValue Exit....");
		return ramdongen;

	}




}
