package br.com.java.exercises.tests;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import br.com.java.exercises.ParseJsonData;
import br.com.java.exercises.common.CountriesReport;

public class ParseJsonDataTests {
	
	private static CountriesReport countriesReportObject;
	
	
	@BeforeAll
	public static void init() throws IOException {
		ParseJsonData parseJsonData = new ParseJsonData();
		JsonNode jsonData = parseJsonData.readJSONFile("src/main/resources/countries.json");
		
		// parsing JSON object to generate report data
		countriesReportObject = parseJsonData.generateReport(jsonData, "de");
	}
	
	@Test
	public void checkIfTotalCountriesIsSet() {
		assertTrue(countriesReportObject.getTotalCountries() == 5);
	}
	
	@Test
	public void checkIfmostOfficialLanguagesCountryWithDEIsSet() {
		assertEquals(countriesReportObject.getMostOfficialLanguagesCountryWithDE(), "DE");
	}
	
	@Test
	public void checkIftotalOfficialLanguagesIsSet() {
		assertTrue(countriesReportObject.getTotalOfficialLanguages() == 6);
	}
	
	@Test
	public void checkIfhigestOfficialLanguagesCountryIsSet() {
		assertEquals(countriesReportObject.getHigestOfficialLanguagesCountry(), "BE");
	}
	
	@Test
	public void checkIfmostCommonOfficialLanguagesIsSet() {
		List<String> languages = Arrays.asList("de","nl");
		assertEquals(countriesReportObject.getMostCommonOfficialLanguages(),languages);
	}
	

}
