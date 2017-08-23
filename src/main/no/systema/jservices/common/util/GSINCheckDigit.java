package no.systema.jservices.common.util;

/**
 * This class creates a check digit using GS1 algo. See https://www.gs1.org/how-calculate-check-digit-manually
 * 
 * @author Fredrik Möller
 * @date Aug 23, 2017
 *
 */
public class GSINCheckDigit {

	/** weighting given to digits depending on their right position */
	private static final int[] POSITION_WEIGHT = new int[] { 1, 3 };

	/**
	 * Calculate a check digit for a code which does not yet have one.
	 *
	 * @param code
	 *            The code for which to calculate the Check Digit; the check
	 *            digit should not be included
	 * @return The calculated Check Digit
	 * @throws IllegalArgumentException
	 *             if an error occurs calculating the check digit
	 */
	public static String calculate(String code)  {
		if (code == null || code.length() == 0 || code.length() != 16) {
			throw new IllegalArgumentException("Code lenght is incorrect, code="+code);
		}
		int total = 0;
		for (int i = 0; i < code.length(); i++) {
			int lth = code.length();
			int rightPos = lth - i;
			int charValue = Character.getNumericValue(code.charAt(i));
			total += weightedValue(charValue, rightPos);
		}
		if (total == 0) {
			throw new IllegalArgumentException("Invalid code, sum is zero");
		}

		int value = 10 - total % 10;
		return String.valueOf(value);

	}

	/**
	 * Calculates the <i>weighted</i> value of a character in the code at a
	 * specified position.
	 * <p>
	 * GSIN are weighted in the following manner:
	 * 
	 * <pre>
	 * <code>
	 *     right position: 6  2  9  1  0  4  1  5  0  0  2  1  x
	 *            weight:  1  3  1  3  1  3  1  3  1  3  1  3->3  (60-57=3)
	 * </code>
	 * </pre>
	 * 
	 * <br>
	 * https://www.gs1.org/how-calculate-check-digit-manually
	 *
	 * @param charValue
	 *            The numeric value of the character.
	 * @param rightPos
	 *            The positionof the character in the code, counting from right
	 *            to left
	 * @return The weighted value of the character.
	 */
	protected static int weightedValue(int charValue, int rightPos) {
		int weight = POSITION_WEIGHT[rightPos % 2];
		return charValue * weight;
	}

}
