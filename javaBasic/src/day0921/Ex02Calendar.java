package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//날짜를 담당하는 Calendar 클래스
public class Ex02Calendar {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//자바에서 날짜를 담당하는 클래스는 다양하게 준비되어있지만
		//그 중에서 자바가1.8버전 이후로 권장하는 날짜 담당클래스는
		//이 Calendar클래스이다.
		
		//캘린더 객체는
		//생성자를 통한 초기화를 할 수 없고
		//항상 Calendar.getInstance()로 현재시간을 초기화해주어야한다!!!
		Calendar cal = Calendar.getInstance(); //캘린더 객체의 생성&초기화
		
		//Calendar객체를 한번 찍어보자
		System.out.println("cal : " + cal);
		
		//Calendar객체를 찍어보면, 우리가 그닥 알고싶지 않은 정보를 포함해서
		//매우 알아보기 힘든 형태가 나온다.
		
		//따라서 저 모양을 좀 예쁘게 꾸밀려면
		//DateFormat이라는 클래스 객체를 이용해서
		//우리가 좀 꾸며주어야 한다.
		//가장 많이 쓰이는 DateFormat클래스는 SimpleDateFormat이 있다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초"); 
		//대소문자 구분
		//위의 yyyy년 MM월 dd일 HH시 mm분 ss초를 설명하면
		//yyyy : 연도를 4자리 숫자로 표시
		//MM : 월을 2자리 숫자로 표시. 만약 1~9월이면 앞에 0을 붙여준다
		//dd : 해당 월의 며칠째인지를 2자리 숫자로 표시
		//HH : 시간을 0~23시 형태로 표시(hh는 12시간 단위로 표시)
		//mm : 시간을 0~59분 2자리로 표시
		//ss : 초를 2자리로 표시
		System.out.println(sdf.format(cal.getTime()));
		
		//그러면
		//연-일-월 시-분-초를
		//연: 4자리
		//일, 월, 시, 분, 초의 경우 1자리면 한자리로만 표시하려면
		sdf = new SimpleDateFormat("yyyy-M-d h:m:s");
		System.out.println(sdf.format(cal.getTime())); //CarT클래스의 getPrice와 유사
		
		//그러면 우리가 사용자로부터 년월일 시분초를 입력받아보자
		//이때는 Calender 객체에 setYear....등을 사욯하면 된다.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("연 : ");
		int year = Integer.parseInt(bufferedReader.readLine());
		System.out.println("월 : ");
		int month = Integer.parseInt(bufferedReader.readLine()) - 1;
		System.out.println("일 : ");
		int day = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println("시 : ");
		int hour = Integer.parseInt(bufferedReader.readLine());
		System.out.println("분 : ");
		int minute = Integer.parseInt(bufferedReader.readLine());
		System.out.println("초 : ");
		int second = Integer.parseInt(bufferedReader.readLine());
		//캘린더에서 하나 주의해야 할 점은
		//월의 경우 1~12가 아닌
		//0~11로 인식하기 때문에(배열같이)
		//만약 5월을 입력하고 싶다면 4라고 입력해야한다
		cal.set(year,month,day,hour,minute,second);
		System.out.println(sdf.format(cal.getTime()));
	}
}
