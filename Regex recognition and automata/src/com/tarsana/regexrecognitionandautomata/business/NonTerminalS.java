package com.tarsana.regexrecognitionandautomata.business;

import java.util.ArrayList;
import java.util.List;

import com.tarsana.regexrecognitionandautomata.utils.Accepteur;
import com.tarsana.regexrecognitionandautomata.utils.Triplet;

public class NonTerminalS {

	/**
	 * The list of the relations generated by this non terminal.
	 */
	private List<Triplet> listeRelations;

	/**
	 * The maximum number given to any state.
	 */
	private Integer max;

	/**
	 * The list of the accepting states generated by this non terminal.
	 */
	private List<Accepteur> listeAccepteurs;

	/**
	 * the starting state generated by this non terminal.
	 */
	private Integer debut;

	/**
	 * @return the debut
	 */
	public Integer getDebut() {
		return debut;
	}

	/**
	 * @param debut
	 *            the debut to set
	 */
	public void setDebut(Integer debut) {
		this.debut = debut;
	}

	/**
	 * @return the listeRelations
	 */
	public List<Triplet> getListeRelations() {
		return listeRelations;
	}

	/**
	 * @param listeRelations
	 *            the listeRelations to set
	 */
	public void setListeRelations(List<Triplet> listeRelations) {
		this.listeRelations = listeRelations;
	}

	/**
	 * @return the max
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(Integer max) {
		this.max = max;
	}

	/**
	 * @return the listeAccepteurs
	 */
	public List<Accepteur> getListeAccepteurs() {
		return listeAccepteurs;
	}

	/**
	 * @param listeAccepteurs
	 *            the listeAccepteurs to set
	 */
	public void setListeAccepteurs(List<Accepteur> listeAccepteurs) {
		this.listeAccepteurs = listeAccepteurs;
	}

	public NonTerminalS() {
		NonTerminalT T = new NonTerminalT();
		NonTerminalL L = new NonTerminalL();

		this.listeAccepteurs = new ArrayList<>();
		this.listeRelations = new ArrayList<>();

		// if there is a call to L that generates an OR
		// operation , it must be calculated here.
		if (L.getOr()) {
			// take all the relations from the left side.
			this.listeRelations.addAll(T.getListeRelations());

			// take all the relations from the right side after adding
			// the left's side's max value to their sate numbers.
			for (Triplet triplet : L.getListeRelations()) {
				triplet.setOrigin(triplet.getOrigin() + T.getMax());
				triplet.setTarget(triplet.getTarget() + T.getMax());
				this.listeRelations.add(triplet);
			}

			// add the left side's acceptors.
			// A link between a new state and the acceptors must also be
			// added.
			for (Accepteur accepteur : T.getListeAccepteurs()) {
				this.listeAccepteurs.add(accepteur);
				this.listeRelations.add(new Triplet(
						T.getMax() + L.getMax() + 1, accepteur.getSymbol(),
						accepteur.getState()));
			}

			// do the same thing for the right hand side.
			for (Accepteur accepteur : L.getListeAccepteurs()) {
				accepteur.setState(accepteur.getState() + T.getMax());
				this.listeAccepteurs.add(accepteur);
				this.listeRelations.add(new Triplet(
						T.getMax() + L.getMax() + 1, accepteur.getSymbol(),
						accepteur.getState()));
			}

			this.debut = T.getMax() + L.getMax() + 1;
			this.max = this.debut;
		}
		// there was no second OR operation , just add everything from
		// T to the current non terminal.
		else {
			this.listeRelations.addAll(T.getListeRelations());
			this.debut = T.getDebut();
			this.max = T.getMax();
			this.listeAccepteurs.addAll(T.getListeAccepteurs());
		}
	}

}
