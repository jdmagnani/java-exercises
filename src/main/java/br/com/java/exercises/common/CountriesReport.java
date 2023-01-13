package br.com.java.exercises.common;

import java.util.List;


public class CountriesReport {
	
	private int totalCountries;
	private String mostOfficialLanguagesCountryWithDE;
	private int totalOfficialLanguages;
	private String higestOfficialLanguagesCountry;
	private List<String> mostCommonOfficialLanguages;
	
	
	
	public String getHigestOfficialLanguagesCountry() {
		return higestOfficialLanguagesCountry;
	}
	public void setHigestOfficialLanguagesCountry(String higestOfficialLanguagesCountry) {
		this.higestOfficialLanguagesCountry = higestOfficialLanguagesCountry;
	}
	public int getTotalCountries() {
		return totalCountries;
	}
	public void setTotalCountries(int totalCountries) {
		this.totalCountries = totalCountries;
	}
	public String getMostOfficialLanguagesCountryWithDE() {
		return mostOfficialLanguagesCountryWithDE;
	}
	public void setMostOfficialLanguagesCountryWithDE(String mostOfficialLanguagesCountryWithDE) {
		this.mostOfficialLanguagesCountryWithDE = mostOfficialLanguagesCountryWithDE;
	}
	public int getTotalOfficialLanguages() {
		return totalOfficialLanguages;
	}
	public void setTotalOfficialLanguages(int totalOfficialLanguages) {
		this.totalOfficialLanguages = totalOfficialLanguages;
	}
	public List<String> getMostCommonOfficialLanguages() {
		return mostCommonOfficialLanguages;
	}
	public void setMostCommonOfficialLanguages(List<String> mostCommonOfficialLanguages) {
		this.mostCommonOfficialLanguages = mostCommonOfficialLanguages;
	}
	@Override
	public String toString() {
		return "CountriesReport " + 
				"\n totalCountries: " + totalCountries + 
				"\n mostOfficialLanguagesCountryWithDE: "+ mostOfficialLanguagesCountryWithDE + 
				"\n totalOfficialLanguages: " + totalOfficialLanguages+ 
				"\n higestOfficialLanguagesCountry: " + higestOfficialLanguagesCountry+ 
				"\n mostCommonOfficialLanguages: " + mostCommonOfficialLanguages;
	}
	
}
