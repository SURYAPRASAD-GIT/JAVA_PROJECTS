package com.countries.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.countries.service.ICountriesInfoService;

@Controller
public class LocaleController {
	
	@Autowired
	private ICountriesInfoService service;
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String showHome() {
		
		return "home";
	}
	
	@RequestMapping(value="/countries",method = RequestMethod.GET)
	public ModelAndView getCountries() {
		Set<String> countriesList=null;
		ModelAndView mav=null;
		//ues service
		countriesList=service.getAllCountries();
	    mav=new ModelAndView();
	    // adding multiple model attributes
	    mav.addObject("listInfo",countriesList);
	    mav.addObject("operation","Countries");
	    mav.addObject("countriesCount",countriesList.size());
	    //adding lvn
	    mav.setViewName("show_results");
	    return mav;
	}
	
	@RequestMapping(value="/languages",method = RequestMethod.GET)
	public ModelAndView getLanguages() {
		Set<String> languagesList=null;
		ModelAndView mav=null;
		//ues service
		languagesList=service.getAllLanguages();
	    mav=new ModelAndView();
	    // adding multiple model attributes
	    mav.addObject("listInfo",languagesList);
	    mav.addObject("operation","Languages");
	    mav.addObject("countriesCount",languagesList.size());
	    //adding lvn
	    mav.setViewName("show_results");
	    return mav;
	}
	
}
