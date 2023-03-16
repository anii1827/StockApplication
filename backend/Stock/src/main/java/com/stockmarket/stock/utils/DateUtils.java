package com.stockmarket.stock.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Value;

import com.stockmarket.stock.exception.StockException;

public class DateUtils {
	
	@Value("${DateFormat}")
	private static String dateFormat;
	
	public static LocalDate getDate(String startDate) {
		try {
		 LocalDate parse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(dateFormat==null?"dd-MM-yyyy":dateFormat));
		 return parse;
		}
		catch(DateTimeParseException e) {
			throw new StockException("Wrong Date Pattern "+e.getParsedString()+"\n Use the date format in dd-mm-yyyy format");
		}
	}
}
