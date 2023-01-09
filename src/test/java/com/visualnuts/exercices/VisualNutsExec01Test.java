package com.visualnuts.exercices;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VisualNutsExec01Test {

	private static VisualNutsExec01 visualNutsExec01;
	
	String mockDivThree = "1,2,Visual";
	String mockDivFive = "1,2,Visual,4,Nuts";
	String mockDivThreeAndFive= "1,2,Visual,4,Nuts,Visual,7,8,Visual,Nuts,11,Visual,13,14,Visual Nuts";
	
	@BeforeAll
	public static void init() {
		visualNutsExec01 = new VisualNutsExec01();
	}
	
	@Test
	public void givenANonNullInteger_WhenisThreeOrFiveDivided_ThenCheckIsDivided() {
		assertEquals(mockDivThree, visualNutsExec01.isThreeOrFiveDivided(3));
		assertEquals(mockDivFive, visualNutsExec01.isThreeOrFiveDivided(5));
		assertTrue(visualNutsExec01.isThreeOrFiveDivided(15).contains("Visual Nuts"));
	}
	
	@Test
	void givenNull_WhenisThreeOrFiveDivided_ThenThrows() {
	    assertThrows(IllegalArgumentException.class, () -> visualNutsExec01.isThreeOrFiveDivided(null));
	}
	
}
