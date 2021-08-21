package za.co.antenna.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class Utils {
	private static final Logger log = LoggerFactory.getLogger(Utils.class);

	@Value("${project.date.format}")
	static String dateUsaFormat;	// 06/17/2020

	@Value("${project.date.iso.format}")
	static String dateIsoFormat;	// "yyyy-MM-dd

	@Value("${project.date.rsa.format}")
	static String dateRsaFormat;	// "dd-MM-yyyy"

	@Value("${project.time.rsa.format}")
	static String timeRsaFormat;	// "HH:mm:ss"

	/**
	 * project.date.rsa.format=dd-MM-yyyy
	 */
	public static String getDateFormatRsa() {
		if (dateRsaFormat == null) {
			dateRsaFormat = "dd-MM-yyyy";
		}

		return dateRsaFormat.trim();
	}

	/**
	 * project.time.rsa.format=HH:mm:ss
	 */
	public static String getTimeFormatRsa() {
		if (timeRsaFormat == null) {
			timeRsaFormat = "HH:mm:ss";
		}

		return timeRsaFormat.trim();
	}

	/**
	 * project.date.rsa.format=dd-MM-yyyy
	 * project.time.rsa.format=HH:mm:ss
	 */
	public static String getDateTimeFormatRsa() {
		if (dateRsaFormat == null) {
			dateRsaFormat = "dd-MM-yyyy";
		}

		if (timeRsaFormat == null) {
			timeRsaFormat = "HH:mm:ss";
		}

		return (dateRsaFormat.trim() + " " + timeRsaFormat.trim());
	}

	public static String makeMysqlDateNow() {
		Date dateNow = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String mysqlDateNow = formatter.format(dateNow);

		return mysqlDateNow;
	}

	public static String dateToString(Date dateToConvert) {
		String dateToString=null;
		log.info("ANTENNA : Utils : dateToString : converting date:" + dateToConvert);
		
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		if(dateToConvert!=null) {
			DateTimeFormatter newPattern = DateTimeFormatter.ofPattern(dateUsaFormat);
			LocalDateTime datetime = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			dateToString = datetime.format(newPattern);
		}

		log.info("ANTENNA : Utils : dateToString : converted to :" + dateToString);
		
		return dateToString;
	}

	/**
	 * 
	 * project.date.usa.format=MM/dd/yyyy
	 * project.date.iso.format=yyyy-MM-dd
	 * 
	 */
	public static Date convertStringToDate(String sDate) {
		String saDateFormat = "dd/MM/yyyy";
		
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		
		String dateFormt = dateUsaFormat;
		Date date = null;
		
		if (StringUtils.isNotEmpty(sDate)) {
			if (sDate.contains("/")) {
				dateFormt = dateUsaFormat;
		
				try {
					date = new SimpleDateFormat(dateFormt).parse(sDate);
				}
				catch (ParseException e) {
					dateFormt =saDateFormat;
				}
			}
			else if (sDate.contains("-")) {
				dateFormt = dateIsoFormat;
			}
			
			if (sDate.length() > 10) {
				sDate = sDate.substring(0, 10);
			}
			try {
				date = new SimpleDateFormat(dateFormt).parse(sDate);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}

		log.info("ANTENNA : Utils : convertStringToDate : converting date:" + date);
		return date;
	}
}
