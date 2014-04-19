package com.tarsana.regexrecognitionandautomata.business;

import java.util.HashSet;
import java.util.Set;

import com.tarsana.regexrecognitionandautomata.utils.Triplet;

public class NonTerminalA {

	private Set<String> getSymbols(NonTerminalS S) {
		Set<String> set = new HashSet<String>();
		for (Triplet triplet : S.getListeRelations()) {
			set.add(triplet.getSymbol());
		}

		return set;

	}

	public NonTerminalA() {
		Context.nextSymbol();
		NonTerminalS S = new NonTerminalS();
		System.out.print("({1,...," + S.getMax() + "},{");
		Set<String> set = getSymbols(S);
		Object[] array = set.toArray();
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.print(array[array.length - 1] + "},{");
		for (int i = 0; i < S.getListeRelations().size() - 1; i++) {
			System.out.print(S.getListeRelations().get(i) + ",");
		}
		System.out.print(S.getListeRelations().get(
				S.getListeRelations().size() - 1)
				+ "}," + S.getDebut() + ",{");
		for (int i = 0; i < S.getListeAccepteurs().size() - 1; i++) {
			System.out.print(S.getListeAccepteurs().get(i).getState() + ",");
		}
		System.out.println(S.getListeAccepteurs()
				.get(S.getListeAccepteurs().size() - 1).getState()
				+ "})");

	}
}
