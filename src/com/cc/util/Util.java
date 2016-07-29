package com.cc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String getDateToString(Date date) {
        DateFormat dateTime = new SimpleDateFormat("dd/MM/aaaa");
        String dateStr = dateTime.format(date);

        return dateStr;
    }

}
