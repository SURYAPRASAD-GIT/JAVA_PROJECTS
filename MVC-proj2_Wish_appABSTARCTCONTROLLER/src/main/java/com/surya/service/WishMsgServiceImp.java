package com.surya.service;

import java.util.Calendar;
import java.util.Locale;

public class WishMsgServiceImp implements WishMsgService {

	@Override
	public String generateMsg() {
		int hour = 0;
	
		Calendar calender = Calendar.getInstance();
		hour = calender.get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			return "Good Morning";
		else if(hour <16)
			return "Good AfterNoon";
		else if(hour <20)
			return "Good Evening";
		else
			return "Good Night";
	
	}

}
