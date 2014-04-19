package com.tarsana.regexrecognitionandautomata.utils;

/**
 * Represents a relation between two states. Contains the starting state , the
 * end state and the transition symbol.
 * 
 */
public class Triplet {

	/**
	 * The starting state of this relation
	 */
	Integer origin;

	/**
	 * The end state of this relation
	 */
	Integer target;

	/**
	 * The transition symbol of this state
	 */
	String symbol;

	public Triplet(Integer origin, String symbol, Integer target) {
		super();
		this.origin = origin;
		this.target = target;
		this.symbol = symbol;
	}

	/**
	 * @return the origin
	 */
	public Integer getOrigin() {
		return origin;
	}

	/**
	 * @param origin
	 *            the origin to set
	 */
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	/**
	 * @return the target
	 */
	public Integer getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public void setTarget(Integer target) {
		this.target = target;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + origin + " , " + symbol + " , " + target + ")";
	}

}
