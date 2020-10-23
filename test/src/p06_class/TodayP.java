package p06_class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodayP {
	
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println("���� ��¥ : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� HH�� mm�� ss��");
		System.out.println("���� ��¥ : " + sdf.format(date));
		System.out.println();
		
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19890317190803");
		System.out.println("�� ���� = " + birth);
		System.out.println("�� ���� = " + sdf.format(birth));
		System.out.println();
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		String dayOfWeek = null;
		switch(week) {
		case 1 : dayOfWeek = "��"; break;
		case 2 : dayOfWeek = "��"; break;
		case 3 : dayOfWeek = "ȭ"; break;
		case 4 : dayOfWeek = "��"; break;
		case 5 : dayOfWeek = "��"; break;
		case 6 : dayOfWeek = "��"; break;
		case 7 : dayOfWeek = "��"; break;
		}
		
		System.out.println("���� ��¥ : " + year + "�� " + month + "�� " + day + "�� " + dayOfWeek);
	}

}
