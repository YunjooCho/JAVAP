package class_constructor;

/*
 년도 입력 : 2002
월 입력 : 10   

일  	 월  	  화  	     수      목      금      토
          1    2    3    4    5
6    7    8    9    10   11   12
13   14   15   16   17   18   19
20   21   22   23   24   25   26
27   28   29   30   31

기본생성자 - 년도, 월 입력
calculator() - 매달 1일이 무슨 요일로 시작?, 매달 끝나는 일? //메소드 2개 찾아보기(+1개 get의 반대 메소드)
display() - 출력
 */
//현재 시간을 받아옴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


public class CalendarMain {
	//1.필드명 선언
	private int year;
	private int month;
	private int week;
	private int lastDay;
	
	
	//2.기본 생성자 구현
	public CalendarMain() throws NumberFormatException, IOException {
		
		//※NumberFormatException - 키보드로 입력된 값이 숫자가 아닐 때 예외처리 ("A" - 아스키코드 아님)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		year = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("월 입력 : ");
		month = Integer.parseInt(bufferedReader.readLine());
		while(month < 1 || month > 12) {
			System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
			System.out.print("월 입력 : ");
			month = Integer.parseInt(bufferedReader.readLine());
		}
		
	}
	
	
	
	public void calculator() {
		
		//3.Calendar 클래스 생성 (new Calendar ->추상클래스라 이 문장은 error)
		Calendar calendar = Calendar.getInstance();
		//getInstance()는 추상메소드를 오버라이드 한 다음에 그 주소를 calendar로 넘겨줌 - 클래스 생성의 역할
		
		
		//4.기준
		//4-1.calendar.set(Calendar.YEAR,year); 
			//받은 연도를 현재 날짜(Calendar클래스의 특징)가 아닌 입력받은 값으로 대체
		//4-2.calendar.set(Calendar.MONTH,month-1);
			//입력받은 값은 -1로 처리하기 2 -> 1월  
		//4-3.calendar.set(Calendar.DAY_OF_MONTH,1);
			//calendar.set(Calendar.DAY_OF_MONTH,1)의 의미 : 설정하지 않으면 이 작업을 실행한 현재 날짜(오늘)가 나옴
			//이 수업이 진행한 2020.9.29에서 29이 출력됨, 그러나 달력은 1월부터 찍어 for문을 돌릴 예정이므로 1로 초기화
			//API :set(int field, int value) - Sets the given calendar field to the given value.
			//내가 원하는 일, 설정하지 않으면 작업하고 있는 현재 날짜로 기준이 맞추어짐
		calendar.set(year, month-1, 1);
			//4-1~4-3과 같은 의미
			//API :	set(int year, int month, int date) - Sets the values for the calendar fields YEAR, MONTH, and DAY_OF_MONTH.
			//month는 입력받을 때 미리 -1해도 됨(1월이 0부터 시작하므로 월에서 -1)
			//입력받은 값을 year, month에 calendar객체에 입력
		
		week = calendar.get(calendar.DAY_OF_WEEK);
		//객체 calendar에 들어있는 값인 매달 1일(calendar.set(year, month-1, 1))이 무슨 요일로 시작하는지 확인
		//결과값은 숫자로 반환(일요일-1, 월요일-2, 화요일-3,....)
		lastDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		//매달 마지막 날이 언제인지 확인 - 월 중에서 가장 큰 값(마지막 날) 꺼내오기(윤달 자동으로 계산됨)
	}
	
	
	
	public void display() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		//출력되는 1일을 해당 요일에 맞게 표시
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		//날짜표시
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");
			
			//7일마다(일~토) 잘라서 출력되게 함
			if(week % 7 == 0) System.out.println();
			week++;
		}

		
	}

	public static void main(String[] args) throws IOException { 
		//예외처리 NumberFormatException가 없는 이유
		//NumberFormatException(자식)와 IOException(부모)은 상속
		//IOException이 다 처리가능
		//초기화
		CalendarMain cm = new CalendarMain();
		cm.calculator();
		cm.display();
		
		

	}

}
