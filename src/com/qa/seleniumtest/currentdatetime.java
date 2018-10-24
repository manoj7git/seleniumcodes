package com.qa.seleniumtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class currentdatetime {

	public static void main(String[] args) {
		
		Calendar cal = Calendar. getInstance();
		Date date = cal. getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat. format(date);
		System. out. println("Current time of the day using Calendar - 24 hour format: "+ formattedDate);

	}

}
