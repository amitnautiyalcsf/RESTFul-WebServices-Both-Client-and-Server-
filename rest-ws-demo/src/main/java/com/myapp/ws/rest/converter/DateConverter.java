package com.myapp.ws.rest.converter;

import org.springframework.util.StringUtils;

import java.time.LocalDate;



public class DateConverter 
{

	public static LocalDate parse(String rawValue){
		if(StringUtils.isEmpty(rawValue)){
		return null;
		}
		try{
		return java.time.LocalDate.parse(rawValue);
		}catch(IllegalArgumentException ex){
		throw new ConverterException("Unable to parse date: " + rawValue, ex);
		}
		}

		public static String print(LocalDate date){
		if(date == null){
		return null;
		}
		return date.toString();
		}
	
}
