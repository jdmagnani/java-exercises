package br.com.java.exercices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Joiner;

import br.com.java.exercices.common.MathOperation;

public class VisualNutsExec01 {
	
	private static final Logger logger = LogManager.getLogger(VisualNutsExec01.class);
	
    public static void main(String[] args) {
        int number = 0;
        String result = null;
        VisualNutsExec01 visualNutsExec01 = new VisualNutsExec01();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter with an integer number: ");
        
        try {
        	number = scanner.nextInt();
        	result = visualNutsExec01.isThreeOrFiveDivided(number);
        	System.out.println(result);	
		} catch (InputMismatchException e) {
			logger.error("Invalid input: " +scanner.next() + " is not a valid Integer number!");
		} catch (Exception e) {
			logger.error(e);
		} finally {
			scanner.close();
		}
        
    }

    /**
     * @param number
     * @return String containing the result of the checkdividedByThreeAndFive. E.g:
     * Input: 3 
     * Output: 1,2,Visual
     */
    public String isThreeOrFiveDivided(Integer number) throws IllegalArgumentException {
    	
    	if (number == null) {
    		throw new IllegalArgumentException("Invalid integer number!");
    	}
    	
        List<String> elements = new ArrayList<>();
        
        for (int element=1; element <= number; element++){
            MathOperation checkdividedByThreeAndFive = (num) -> (num%3==0 && num%5==0) ? "Visual Nuts" : (num%3==0) ? "Visual"
                : (num%5==0) ? "Nuts" : String.valueOf(num);

            elements.add(checkdividedByThreeAndFive.checkDividedNumber(element)); 
           
        }
        return Joiner.on(",").join(elements);
    }

}