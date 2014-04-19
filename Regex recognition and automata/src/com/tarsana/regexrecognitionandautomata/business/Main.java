package com.tarsana.regexrecognitionandautomata.business;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Context.setInput(scanner.nextLine());
		@SuppressWarnings("unused")
		NonTerminalA A = new NonTerminalA();
		scanner.close();
	}
}
