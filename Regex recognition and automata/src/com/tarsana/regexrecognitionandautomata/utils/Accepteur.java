package com.tarsana.regexrecognitionandautomata.utils;

/**
 * Wrapper for an accepting state. Contains the state's number and the symbol
 * with which it is reached.
 */
public class Accepteur {

	/**
	 * The acceptor state.
	 */
	Integer state;

	/**
	 * the symbol with which the acceptor state is reached.
	 */
	String symbol;

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Accepteur(String symbol, Integer state) {
		super();
		this.state = state;
		this.symbol = symbol;
	}

}
