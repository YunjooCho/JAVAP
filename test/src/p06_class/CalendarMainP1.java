package p06_class;
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
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;

public class CalendarMainP1 {
	//필드 선언
	private int year, month, week, lastDay;
	private BufferedReader br;
	
	public CalendarMainP1() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		year = Integer.parseInt(br.readLine());
		System.out.print("월 입력 : ");
		month = Integer.parseInt(br.readLine());
		while(month < 1 || month > 12) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			System.out.print("월 입력 : ");
			month  = Integer.parseInt(br.readLine());
		}
	}
	
	public void calculator() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); 
		//Calendar클래스의 특성인 현재 시스템의 날짜와 시간을 가져오는 것이 아닌 
		//입력 받은 년도, 입력받은 달, 매월 1일로 설정
		week = cal.get(cal.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH);
	}
	
	public void display() {
		System.out.println("week = " + week);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		for(int i = 1; i <= lastDay; i++){
			System.out.print(i + "\t");
			
			if(week%7 == 0) System.out.println();
			week++;
			
		}
		
	}//display
	
	public static void main(String[] args) throws IOException {
		CalendarMainP1 calp1 = new CalendarMainP1();
		calp1.calculator();
		calp1.display();

	}

}
