package com.tarsana.regexrecognitionandautomata.business;

/**
 * 
 * Represents the context of the application : the current symbol , current
 * position in the input , the available symbols and the input itself.
 * 
 * 
 */
public class Context {

	/**
	 * The regex given by the user.
	 */
	private static String input;

	/**
	 * the symbol that is currently being scanned.
	 */
	private static String currentSymbol;

	/**
	 * The current position in the input.
	 */
	private static int currentPosition = 0;

	public static String getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public static void setInput(String input) {
		Context.input = input;
	}

	/**
	 * @return the currentSymbol
	 */
	public static String getCurrentSymbol() {
		return currentSymbol;
	}

	/**
	 * @param currentSymbol
	 *            the currentSymbol to set
	 */
	public static void setCurrentSymbol(String currentSymbol) {
		Context.currentSymbol = currentSymbol;
	}

	/**
	 * @return the currentPosition
	 */
	public static int getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * @param currentPosition
	 *            the currentPosition to set
	 */
	public static void setCurrentPosition(int currentPosition) {
		Context.currentPosition = currentPosition;
	}

	/**
	 * reads one more symbol into the symbols list and changes the current
	 * symbol.
	 */
	public static void nextSymbol() {
		StringBuilder builder = new StringBuilder();
		// iterate until you reach an operator.
		for (int i = currentPosition; i < input.length(); i++) {

			if (input.charAt(i) == '+' || input.charAt(i) == '.'
					|| input.charAt(i) == '*' || input.charAt(i) == '('
					|| input.charAt(i) == ')') {

				currentSymbol = String.valueOf(input.charAt(i));

				currentPosition = i + 1;
				break;

			} else if (!(input.charAt(i) == ' ') && !(input.charAt(i) == '\n')
					&& !(input.charAt(i) == '\t')) {
				builder.append(input.charAt(i));
				if (i + 1 == input.length() || input.charAt(i + 1) == '+'
						|| input.charAt(i + 1) == '.'
						|| input.charAt(i + 1) == '*'
						|| input.charAt(i + 1) == '('
						|| input.charAt(i + 1) == ')') {

					currentSymbol = builder.toString();
					currentPosition = i + 1;
					break;

				}
			}

		}
	}

	public static void raiseError(int n) {
		switch (n) {
		case 0:
			System.err
					.println("missing values between paranthesis at position "
							+ (currentPosition + 1));
			System.exit(1);
			break;

		case 1:
			System.err
					.println("missing right argument for \".\" operation at position "
							+ (currentPosition));
			System.exit(1);
			break;

		case 2:
			System.err
					.println("missing right argument for \"+\" operation at position "
							+ (currentPosition));
			System.exit(1);
			break;

		default:
			break;
		}
	}

	public static void accept(String symbol) {
		if (currentSymbol.equals(symbol)) {
			nextSymbol();
		} else
			System.err.println("Expected " + symbol + " but found "
					+ currentSymbol);
	}
}
