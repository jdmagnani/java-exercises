package br.com.java.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.java.exercises.common.Elements;

/**
 * 
 * @author jmagnani
 * 
 * Exercise description: 
 * 
 * 	Write or describe an algorithm that prints the whole integer numbers to the console, start
 *	from the number 1, and print all numbers going up to the number 100.
 *  However, when the number is divisible by 3, do not print the number, but print the word
 *  'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all
 *  numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.
 *
 */

public class VisualNutsExec01 {

	private static final Logger logger = LogManager.getLogger(VisualNutsExec01.class);

	public static void main(String[] args) {

		int number = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter with an integer number: ");

		try {
			number = scanner.nextInt();
			
			// printing elements
			for (String num : new Elements<String>(number) ) {
				System.out.println(num);
			}
			
		} catch (InputMismatchException e) {
			logger.error("Invalid input: " + scanner.next() + " is not a valid Integer number!");
		} catch (Exception e) {
			logger.error(e);
		} finally {
			scanner.close();
		}
	}

}
