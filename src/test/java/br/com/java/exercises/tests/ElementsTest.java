package br.com.java.exercises.tests;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.java.exercises.common.Elements;

public class ElementsTest {
	
	private static Elements<String> elements;
	
	@BeforeAll
	public static void init() {
		elements = new Elements<String>(15);
	}
	
	@Test
	public void checkIfElementsHasNext() {
		Iterator<String> it = elements.iterator();
		assertTrue(it.hasNext());		
	}
	
	@Test
	public void checkIfThirdElementIsVisual() {
		Iterator<String> it = elements.iterator();
		it.next();
		it.next();
		assertTrue(it.next().equals("Visual"));
	}
	
	@Test
	public void checkIfFifthElementIsNuts() {
		Iterator<String> it = elements.iterator();
		it.next();
		it.next();
		it.next();
		it.next();
		assertTrue(it.next().equals("Nuts"));
	}
	
	@Test
	public void checkIfLastElementIsVisualNuts() {
		Iterator<String> it = elements.iterator();
		String lastElement = null;
		while(it.hasNext()) {
			lastElement = it.next();
		}
		assertTrue(lastElement.equals("Visual Nuts"));
	}

}
