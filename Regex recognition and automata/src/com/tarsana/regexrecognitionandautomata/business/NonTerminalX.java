package com.tarsana.regexrecognitionandautomata.business;

public class NonTerminalX {

	/**
	 * indicates if this non terminal has generated the kleen operator.
	 */
	private boolean kleen;

	/**
	 * @return the kleen indicator
	 */
	public boolean getKleen() {
		return kleen;
	}

	/**
	 * @param kleen
	 *            the kleen to set
	 */
	public void setKleen(boolean kleen) {
		this.kleen = kleen;
	}

	public NonTerminalX() {
		if (Context.getCurrentSymbol().equals("*")) {
			this.kleen = true;
			Context.accept("*");
		} else
			this.kleen = false;
	}

}
