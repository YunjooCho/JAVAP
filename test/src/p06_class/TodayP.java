package p06_class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodayP {
	
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 HH시 mm분 ss초");
		System.out.println("오늘 날짜 : " + sdf.format(date));
		System.out.println();
		
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19890317190803");
		System.out.println("내 생일 = " + birth);
		System.out.println("내 생일 = " + sdf.format(birth));
		System.out.println();
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		String dayOfWeek = null;
		switch(week) {
		case 1 : dayOfWeek = "일"; break;
		case 2 : dayOfWeek = "월"; break;
		case 3 : dayOfWeek = "화"; break;
		case 4 : dayOfWeek = "수"; break;
		case 5 : dayOfWeek = "목"; break;
		case 6 : dayOfWeek = "금"; break;
		case 7 : dayOfWeek = "토"; break;
		}
		
		System.out.println("오늘 날짜 : " + year + "년 " + month + "월 " + day + "일 " + dayOfWeek);
	}

}
