package br.com.java.exercises;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.java.exercises.common.CountriesReport;

/**
 * 
 * @author jmagnani
 * 
 *         Exercise description Create a function that reads a JSON object with
 *         a list of countries and it's respective spoken languages and
 *         generates the following report data: 
 *         - returns the number of countries in the world 
 *         - finds the country with the most official languages, where they officially speak German (de) 
 *         - that counts all the official languages spoken in the listed countries 
 *         - to find the country with the highest number of official languages 
 *         - to find the most common official language(s), of all countries
 */
public class ParseJsonData {

	private static final Logger logger = LogManager.getLogger(ParseJsonData.class);
	
	public static void main(String[] args) {
		
		CountriesReport countriesReportObject = new CountriesReport();
		ParseJsonData parseJsonData = new ParseJsonData();

		try {
			
			// Local tests, getting JSON file from resources folder
			String defualtJsonFile = ParseJsonData.class
                    .getClassLoader().getResource("countries.json").getPath();
			
			
			// setting file path, in case of null, assuming default test path
			String filePath = (args.length > 0) ? args[0] : defualtJsonFile;
			JsonNode jsonData = parseJsonData.readJSONFile(filePath);
			
			if (jsonData.size() == 0) {
				throw new NullPointerException();
			}
			
			// parsing JSON object to generate report data
			countriesReportObject = parseJsonData.generateReport(jsonData, "de");
			parseJsonData.printReport(countriesReportObject);
			
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (NullPointerException nullEx) {
			logger.error("Cannot read JSON file. Please make sure you provided a valid file path.");
		}

	}
	
	public JsonNode readJSONFile(String filePath) throws IOException {
		
		File jsonFile = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonData = null;
		
		if (jsonFile.exists()) {
			jsonData = objectMapper.readTree(new File(filePath));
		}
		return jsonData;
	}


	public void printReport(CountriesReport countriesReport) {
		System.out.println(countriesReport.toString());
	}

	public CountriesReport generateReport(JsonNode countries, String countryFilter) {

		int langsSize = 0;
		CountriesReport countriesReportObject = new CountriesReport();
		HashMap<String, Integer> countryLanguagesMap = new HashMap<>();

		// 1 - set total number of countries
		if (countries.path("country") != null) {
			countriesReportObject.setTotalCountries(countries.size());
		}

		for (JsonNode country : countries) {

			JsonNode languages = country.path("languages");
			if (!languages.isMissingNode() && languages.isArray()) {
				for (JsonNode language : languages) {

					if ((languages.size() > langsSize)) {
						langsSize = languages.size();

						// 2 - set higest official languages country
						countriesReportObject.setHigestOfficialLanguagesCountry(country.path("country").asText());

					}

					// 3 - finds the country with the most official languages, where they officially
					// speak German (de)
					if (language.asText().equals(countryFilter)) {
						countriesReportObject.setMostOfficialLanguagesCountryWithDE(country.path("country").asText());
					}

					// store country languages
					countryLanguagesMap.merge(language.asText(), 1, Integer::sum);

				}
			}

		}

		// 4 - counts all the official languages spoken in the listed countries
		countriesReportObject.setTotalOfficialLanguages(countryLanguagesMap.size());

		// 5 - find the most common official language(s), of all countries
		countriesReportObject.setMostCommonOfficialLanguages(countryLanguagesMap.entrySet().stream()
				.filter(lang -> lang.getValue() > 1L).map(Entry::getKey).collect(Collectors.toList()));

		return countriesReportObject;
	}

}
