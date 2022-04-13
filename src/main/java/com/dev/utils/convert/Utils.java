package com.dev.utils.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * <pre>
 * com.dev.utils
 * Utils.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date   : 2019. 10. 31.
 * @Version :
 */
public class Utils {
	
	/**
	 * 
	 * <pre>
	 * 1. 처리내용: 현재 날짜를 UTC 날짜로 변경 하고 String 형식으로 만들기 위한 함수
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 31.
	 * @Version : 
	 * @Method Name: convertLocalTimeToUTC
	 * @return
	 * @throws ParseException
	 */
	public String convertLocalTimeToUTC() throws ParseException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		return dateFormat.format(date);
	}
	
	/**
	 * 
	 * <pre> 
	 * 1. 처리내용: 현재 날짜를 특정 Day만큼 추가 시키고 UTC 날짜로 변경하고 String 형식으로 만들기 위한 함수 
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 31.
	 * @Version : 
	 * @Method Name: convertLocalTimeToUTC
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public String convertLocalTimeToUTC(int day) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, +day);
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		return dateFormat.format(date);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 처리내용: 현재 날짜를 UTC로 변환하고 다시 Date 형식으로 넘겨주는 함수 
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 31.
	 * @Version : 
	 * @Method Name: currentUTCDateTime
	 * @return
	 * @throws ParseException
	 */
	public Date currentUTCDateTime() throws ParseException {
		SimpleDateFormat transDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDateTime = convertLocalTimeToUTC();
		return transDateFormat.parse(curDateTime);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 처리내용: 현재 날짜 보다 특정 날짜 만큼 + 시켜서 UTC로 변환하고 다시 Date 형식으로 넘겨 주는 함수 
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 1.
	 * @Version : 
	 * @Method Name: getSelectDayUTCDateTime
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public Date getSelectDayUTCDateTime(int day) throws ParseException {
		SimpleDateFormat transDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDateTime = convertLocalTimeToUTC(day);
		return transDateFormat.parse(curDateTime);
	}
	
	/**
	 * 
	 * <pre> 
	 * 1. 처리내용: 특정 날짜를 특정 형식으로 변환 시켜 준다. 
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 31.
	 * @Version : 
	 * @Method Name: convertStringToDate
	 * @param datetime
	 * @return
	 * @throws ParseException
	 */
	public Date convertStringToDate(String datetime) throws ParseException {
		SimpleDateFormat transDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return transDateFormat.parse(datetime);
	}
}
