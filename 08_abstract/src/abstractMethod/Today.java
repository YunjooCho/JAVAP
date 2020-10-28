package abstractMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {

	public static void main(String[] args) throws ParseException {
//		while(true) {
//			Date date = new Date();
//			System.out.println("오늘 날짜 : " + date);
//			Thread.sleep(1000); //CPU를 1초씩 쉬도록 함 - 스레드
//		}
		
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 hh:mm:ss");
		//알기 쉬운 날짜/시간 형식을 나타내는 메소드(DecimalForma("#,###")와 유사)
		System.out.println("오늘 날짜 : " + sdf.format(date));
		//자바
		//월 - M, 분 - m
		//오라클
		//월 - m, 분 - mi
		
		//HH -24시간제, hh - 12시간제
		System.out.println();
		
		
		//입력 - 내 생일 yyyyMMddHHmmss : 입력형식 지정(핸드폰?)
		//예) 19910716131503
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		//String birth = "19910716131503"; //String  -> Date형으로 변환
		//Date birth = (Date)"19910716131503"; 
		//String클래스의 값을 Date클래스로 받으려고 할때 에러남
		//(Date)와 같은 형변환도 안됨
		Date birth = input.parse("19890317190803");
		System.out.println("내 생일 = " + birth);
		System.out.println("내 생일 = " + sdf.format(birth));
		System.out.println();
		
		//<<Calendar 클래스 생성에 대하여 1~3>>
		//Calendar를 생성하면 시스탬의 현재시간과 날짜를 얻어옴
		//1.Calendar cal = new Calendar(); - error
		//Calendar클래스는 추상클래스라서 new로 생성 불가(java책 추상클래스, API Calendar 클래스 참조) 
		//나라별로 시간,날짜의 표기가 다르므로 추상클래스임
		
		//2.추상메소드의 생성 - 자식클래스를 이용하여 생성
		//Calendar를 생성하면 현재 시간만 얻어온다
		//Calendar cal = new GregorianCalendar();
		
		//3.메소드를 이용하여 생성(new사용 안함)
		Calendar cal = Calendar.getInstance();//이 메소드 안에서 new Calendar();가 이루어짐
		
		//오늘, 지금의 날짜/시간을 가져옴
		int year = cal.get(Calendar.YEAR); //get메소드는 Calendar가 갖고있음
		int month = cal.get(Calendar.MONTH) + 1; // 0 -> 1월  1 -> 2월
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);//일요일 -> 1 , 월요일 -> 2
		
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
		System.out.println("오늘 날짜 : " + year + "년 " + month + "월 " + day + "일" + dayOfWeek);
		
		
		//★★★★★확인용 - 왜 되는지 상속 정리하기
		GregorianCalendar calendar = new GregorianCalendar();
		int year2 = cal.get(GregorianCalendar.YEAR); 
		int month2 = cal.get(GregorianCalendar.MONTH) + 1;
		int day2 = cal.get(GregorianCalendar.DAY_OF_MONTH);
		int week2 = cal.get(Calendar.DAY_OF_WEEK);//일요일 -> 1
		System.out.println("오늘 날짜(GregorianCalendar) : " + year + "년 " + month + "월 " + day + "일 " + dayOfWeek);
		//'월'만 0부터 시작하므로  '+ 1'해줘야 함
		
	}

}
