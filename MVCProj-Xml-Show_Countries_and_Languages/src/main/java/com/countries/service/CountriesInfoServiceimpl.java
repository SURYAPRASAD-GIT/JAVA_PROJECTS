package com.countries.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("localeservice")
public class CountriesInfoServiceimpl implements ICountriesInfoService {

	@Override
	public Set<String> getAllCountries() {
		Locale loacles[]=null;
		Set<String> countriesList;
		//get all Countries
		loacles=Locale.getAvailableLocales();
		//add all countries to list countries to list collection
		countriesList=new TreeSet<String>();  // ||++old style++||
		//countriesList=List.of(); // java 9 feature
		
		// copy all countries to List collection
		for(Locale l:loacles) {
			if(!l.getDisplayCountry().equals(""))
			countriesList.add(l.getDisplayCountry());
		}
		
		return countriesList;
	}//method

	@Override
	public Set<String> getAllLanguages() {
		Locale loacles[]=null;
		Set<String> languagesList;
		//get all Languages
		loacles=Locale.getAvailableLocales();
		//add all Languages to list Languages to list collection
		languagesList=new TreeSet<String>();  
		
		// copy all countries to List collection
		for(Locale l:loacles) {
			if(!l.getDisplayLanguage().equals(""))
			languagesList.add(l.getDisplayLanguage());
		}
		
		return languagesList;
	}//method


}//class
