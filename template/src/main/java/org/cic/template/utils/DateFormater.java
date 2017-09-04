package org.cic.template.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateFormater {
	
	/**
	 * 	
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);	//把日期加減天數.整數往後推,負數往前移動
		 
		return calendar.getTime();
	}
	
	public static int intValue(Date date) {
		String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String d = sdf.format(date.getTime());
		return Integer.parseInt(d);
	}

	public static double getintValue(Date date) {
		String DATE_FORMAT = "yyyyMMddHHmm";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String d = sdf.format(date.getTime());
		return Double.parseDouble(d);
	}

	/**
	 * 將現在的日期轉換為yyyymmddHHmm
	 * 
	 * @return
	 */
	public static double intConvertToDate() {
		Date date = new Date();
		String DATE_FORMAT = "yyyyMMddHHmm";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String d = sdf.format(date);
		return Double.parseDouble(d);
	}

	/**
	 * 將現在的日期轉換為yyyy/mm/dd字串
	 * 
	 * @return
	 */
	public static String stringConvertToDate() {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(date);
	}

	/**
	 * 將昨天的日期轉換為yyyy/mm/dd字串
	 * 
	 * @return
	 */
	public static String stringConvertYesterdayToDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DAY_OF_MONTH, -1);
		// String result = dateFormat.format(ca.getTime());
		// System.out.println(dateFormat.format(date));
		System.out.println(dateFormat.format(ca.getTime()));
		// return dateFormat.format(date);
		return dateFormat.format(ca.getTime());
	}

	/**
	 * 指定日期轉換為yyyy/mm/dd字串
	 * 
	 * @return
	 */
	public static String convertDateToString(Date aDate) {
		if (aDate == null) {
			return "";
		} else {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			return dateFormat.format(aDate);
		}
	}

	/**
	 * 指定日期轉換為yyyy/MM/dd HH:mm:ss
	 * 
	 * @param aDate
	 * @return
	 */
	public static String convertDateTimeToString(Date aDate) {
		if (aDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(aDate);
		} else {
			return "";
		}

	}

	/**
	 * 指定日期轉換為（不含秒）yyyy/MM/dd HH:mm
	 * 
	 * @param aDate
	 * @return
	 */
	public static String convertDateTimeToStringNoSec(Date aDate) {
		if (aDate == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(aDate);
	}

	public static Date convertDate(String year, String month, String day) {

		return convertDate(Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day), 0, 0, 0);
	}

	// 2010.1.26 Add by Max Lai for SPV, end
	/**
	 * 轉換年月日為日期物件
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return Date
	 */
	public static Date convertDate(int year, int month, int day) {
		return convertDate(year, month, day, 0, 0, 0);
	}

	public static Date convertDate(int year, int month, int day, int hour,
			int minute, int second) {
		Date date = null;
		Calendar cal = new GregorianCalendar();
		cal = DateUtils.truncate(cal, Calendar.DATE);
		if (year != 0 && month != 0 && day != 0) {
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
			cal.set(Calendar.DATE, day);
			if (hour != 0 || minute != 0 || second != 0) {
				cal.set(Calendar.HOUR_OF_DAY, hour);
				cal.set(Calendar.MINUTE, minute);
				cal.set(Calendar.SECOND, second);
			}
			date = cal.getTime();
		}
		return date;
	}

	/**
	 * 檢核指定的日期元素的正確性
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return2009/02/13 13:29
	 */
	public static boolean checkDateYearMonthDayValid(String year, String month,
			String day, String hour, String minute, String second) {
		Date dt = convertDate(parseInt(year, 0), parseInt(month, 0),
				parseInt(day, 0), parseInt(hour, 0), parseInt(minute, 0),
				parseInt(second, 0));
		String dtStr = convertDateTimeToString(dt);
		return dtStr.equals(alignDateFieldStr(year, 4) + "/"
				+ alignDateFieldStr(month, 2) + "/" + alignDateFieldStr(day, 2)
				+ " " + alignDateFieldStr(hour, 2) + ":"
				+ alignDateFieldStr(minute, 2) + ":"
				+ alignDateFieldStr(second, 2));
	}

	/**
	 * 檢核指定的日期元素是否小於系統日期
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return2009/02/13 13:29
	 */
	public static boolean checkDateSmallSys(String year, String month,
			String day, String hour, String minute, String second) {
		Date dt = convertDate(parseInt(year, 0), parseInt(month, 0),
				parseInt(day, 0), parseInt(hour, 0), parseInt(minute, 0),
				parseInt(second, 0));

		return getintValue(dt) < intConvertToDate();
	}

	private static int parseInt(String str, int idefValue) {
		try {
			return str == null || str.equals("") ? idefValue : Integer
					.parseInt(str);
		} catch (Exception ex) {
			return idefValue;
		}
	}

	private static String alignDateFieldStr(String str, int iLen) {
		if (str == null) {
			str = StringUtils.repeat("0", iLen);
		} else if (!str.equals("")) {
			str = StringUtils.repeat("0", iLen - str.length()) + str;
		}
		return str;
	}

	
	public static Date parseDateTime(String strValue, String format)
			throws ParseException {
		if (strValue == null || strValue.equals("")) {
			return null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strValue);
		}
	}

	public static String formatDateTime(Date dateTime, String format) {
		if (dateTime == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(dateTime);
		}
	}

	
	/**
	 * 傳回目前的 系統年(西洋)
	 * 
	 */
	public static String nowYear() {
		Date date = new Date();
		String DATE_FORMAT = "yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String d = sdf.format(date.getTime());
		return d;
	}

	
	/**
	 * 將傳入的 year month day 轉成 yyyy/mm/dd
	 * 
	 */
	public static String strToDateStr(int year, int month, int day) {
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("/");
		if (month < 10) {
			sb.append("0").append(month).append("/");
		} else {
			sb.append(month).append("/");
		}
		if (day < 10) {
			sb.append("0").append(day);
		} else {
			sb.append(day);
		}
		return sb.toString();
	}

	
	public static String strToTimeStr(int hour, int minute) {
		StringBuffer sb = new StringBuffer();
		if (hour < 10) {
			sb.append("0").append(hour).append(":");
		} else {
			sb.append(hour).append(":");
		}
		if (minute < 10) {
			sb.append("0").append(minute);
		} else {
			sb.append(minute);
		}
		return sb.toString();
	}

	
	public static String[] promoQueryDefaultDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String[] sysDate = dateFormat.format(new Date()).split("/");

		int beginYear = Integer.parseInt(sysDate[0]);
		int beginMonth = Integer.parseInt(sysDate[1]);
		int endYear = Integer.parseInt(sysDate[0]);
		int endMonth = Integer.parseInt(sysDate[1]);

		if (beginMonth - 2 > 0) {
			beginMonth = beginMonth - 2;
		} else {
			beginYear = beginYear - 1;
			if (beginMonth - 2 == 0) {
				beginMonth = 12;
			} else if (beginMonth - 2 == -1) {
				beginMonth = 11;
			}
		}

		if (endMonth + 2 < 12) {
			endMonth = endMonth + 2;
		} else {
			endYear = endYear + 1;
			if (endMonth + 2 == 13) {
				endMonth = 1;
			} else if (endMonth + 2 == 14) {
				endMonth = 2;
			}
		}

		String[] str = { String.valueOf(beginYear), String.valueOf(beginMonth),
				"1", String.valueOf(endYear), String.valueOf(endMonth), "1" };
		return str;
	}

	/**
	 * 此方法有點問題，要查證
	 * @param ExpirationDate
	 * @return
	 */
	/*public static int compareSysTime(Date ExpirationDate) {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d;
		int returnDiffDay = 0;
		//d = sdf.parse(ExpirationDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		long timethis = calendar.getTimeInMillis();
		calendar.setTime(ExpirationDate);
		long timeend = calendar.getTimeInMillis();
		//returnDiffDay =  new Long(((timeend - timethis) / (1000 * 60 * 60 * 24))).intValue();
		timeend = (timeend - timethis) / (1000 * 60 * 60 * 24);
		if(timeend<0)
		return 0;
		else
		return (int)timeend;
	}*/
	
	/**
	 * 與系統日期比較
	 */
	public static int compareSysTime(Date expirationDate) {
		int result = 0;
		
		Date nowDate = new Date();
		
		if(expirationDate.equals(nowDate)){
			result = 0;
		} else if(expirationDate.after(nowDate)){
			result = 1;
		} else if(expirationDate.before(nowDate)){
			result = -1;
		}
		
		return result;
	}
	
	public static int getdiffMonths(Date ExpirationDate) {
			if(null==ExpirationDate){
				return 0;
			}
			return compareSysTime(ExpirationDate)/30;
	}
	
	public static String getFeeChargePK(String syscode,String sequnence){
		Date nowDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddmmss");
		// feechargemain seq
		// to_char(sysdate, 'YYMMDD') || #{sysCode,jdbcType=VARCHAR} || to_char(sysdate, 'MMSS') || FEES_CHARGES_MAIN_SEQ.NEXTVAL
		String part1 = sdf1.format(nowDate);
		String pkpart1 = part1.substring(2,4)+part1.substring(4,8)+syscode+part1.substring(8,part1.length());
		return pkpart1+sequnence;
	}
	
	 public static String getDateTimeFormate(String m_pattern, Locale m_local){
         /*
                 String[] patterns = {
                    "dd.MM.yy",
                    "yyyy.MM.dd G 'at' hh:mm:ss z",
                    "EEE, MMM d, ''yy",
                    "h:mm a",
                    "H:mm",
                    "H:mm:ss:SSS",
                    "K:mm a,z",
                    "yyyy.MMMMM.dd GGG hh:mm aaa"
                 };
         */
         SimpleDateFormat formatter = new SimpleDateFormat(m_pattern, m_local);
         Date today = new Date();
         return formatter.format(today);
 }
	 
	 public static String getDate(Date aDate) {
			if (aDate != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(aDate);
			} else {
				return "";
			}
	 }

	
	/*
	 * 取回繳款期限
	 * for BarCode
	 */
	public static String getPaymentDueDate(int dueperoid,String DATE_FORMAT){
		if(null==DATE_FORMAT)
			DATE_FORMAT ="yyyy-MM-dd";
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, dueperoid);
		return sdf.format(c.getTime());
	}
	
	/*
	 * 依據使用日期取回繳款期限
	 * for BarCode
	 */
	public static Date getPaymentDueDate(Date useDate ,int dueperoid){
		
		Calendar c = Calendar.getInstance();
		c.setTime(useDate);
		c.add(Calendar.DAY_OF_YEAR, dueperoid);
		return c.getTime();
	}
	
	public static String getPaymentDueDateStr(Date useDate ,int dueperoid){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(useDate);
		c.add(Calendar.DAY_OF_YEAR, dueperoid);
		return sdf.format(c.getTime());
	}
	
	
	/*
	 * 取回民國格式
	 * for BarCode 
	 */
	public static String getRocDate(Date invoice){
		String rocYearStr ="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		Calendar c = Calendar.getInstance();
		c.setTime(invoice);
		int RocYear = c.get(Calendar.YEAR)-1911;
		rocYearStr = Integer.toString(RocYear);
		
		return rocYearStr + sdf.format(c.getTime()).substring(4);
	}
	
	/*
	 * 取回繳款期限MMdd
	 * for BarCode 
	 */
	public static String getPaymentDueMMdd(Date invoice){
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Calendar c = Calendar.getInstance();
		c.setTime(invoice);
		
		return sdf.format(c.getTime());
	}
	/*
	 * 取回預約總時數(需扣除中午一小時)
	 */
	public static float getdiffHours(String beginDate , String endDate) {
		Calendar cal = Calendar.getInstance();
		
		Calendar noon = Calendar.getInstance();
		noon.set(Calendar.HOUR_OF_DAY,12);
		noon.set(Calendar.MINUTE, 00);
		
		Date begin = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), Integer.parseInt(beginDate.substring(0,2)), Integer.parseInt(beginDate.substring(3,5))).getTime();
		Date end = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), Integer.parseInt(endDate.substring(0,2)), Integer.parseInt(endDate.substring(3,5))).getTime();
		
		long diff = end.getTime() - begin.getTime();
		
	    BigDecimal b1 = new BigDecimal(Float.toString(diff));
	    BigDecimal b2 = new BigDecimal(Float.toString(1000*60*60));
	    float hours =  b1.divide(b2,3,BigDecimal.ROUND_HALF_UP).floatValue();
		if(noon.getTime().compareTo(begin)>0 && noon.getTime().compareTo(end)<0 ){
			hours = hours-1;
		}
		return hours;
		
		
	}
	/*
	 * 判斷預約儀器使用是否可以取消
	 */
	public static boolean isCancelable(String bookingdatestr , int stopcanceldays) {
		try {
		Date bookingdate =	parseDateTime(bookingdatestr,"yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date nowdate = cal.getTime();
		cal.setTime(bookingdate);
		cal.add(Calendar.DAY_OF_YEAR, -stopcanceldays);
		if(nowdate.before(cal.getTime()))
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/*
	 * 判斷預約儀器使用是否可以預約
	 */
	public static boolean isBookingable(String bookingdatestr , int stopbookingdays) {
		try {
		Date bookingdate =	parseDateTime(bookingdatestr,"yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date nowdate = cal.getTime();
		cal.setTime(bookingdate);
		cal.add(Calendar.DAY_OF_YEAR, -stopbookingdays);
		if(nowdate.before(cal.getTime()))
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/*
	 * 判斷預約儀器使用是否可以開始預約
	 */
	public static boolean isBookingable(int startweeks) {
		
		Calendar cal = Calendar.getInstance();
		Date nowdate = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, -(startweeks*7));
		if(nowdate.before(cal.getTime()))
			return true;
		
		return false;
	}
	
	/**
	 * 判斷傳入的日期是否有超過目前的日期
	 * @param duedate
	 * @return
	 */
	public static boolean isOverCurrentDate(Date duedate)  {
		Calendar cal = Calendar.getInstance();
		Date nowdate = cal.getTime();
		if(duedate.before(nowdate))
			return true;
		else
			return false;
		
	}
	
	/*
	 * 取回民國格式繳款期限
	 * for BarCode 
	 */
	public static String getRocPaymentDueDate(Date invoice){
		String RocYearStr ="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.setTime(invoice);
		int RocYear = c.get(Calendar.YEAR)-1911;
		if(RocYear>99)
			RocYearStr = Integer.toString(RocYear).substring(1,3);
		else
			RocYearStr = Integer.toString(RocYear);
		
		//System.out.println(sdf.format(c.getTime()));
		return RocYearStr+sdf.format(c.getTime()).substring(4);
	}
}
