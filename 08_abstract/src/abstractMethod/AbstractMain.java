package abstractMethod;

import java.util.Calendar;
import java.util.GregorianCalendar;

public  class AbstractMain extends AbstractTest {

	public void setName(String name) {//추상메소드는 전부 자식클래스에서 오버라이딩 해줘야 함
		this.name = name;
	}
	
	public static void main(String[] args) {
		//클래스 생성
		//AbstractTest at = new AbstractTest(); - 추상클래스는 자기자신을 new(생성)할 수 없다.
		//이유 : 추상클래스에서는 인스턴스를 생성할 수 없다.
		//자식 클래스 이용
		// 1. 반드시 자식클래스는 부모클래스의 추상메소드를 Override해야 한다
		
		AbstractTest at = new AbstractMain(); 
		//추상클래스는 추상메소드 때문에 자기 자신을 생성할 수 없으므로 자식클래스의 메소드(추상메소드X)를 통해 생성을 한다 
		//다형성, 모든 부모는 자식클래스를 참조할 수 있다
		//부모클래스의 틀을 가져와 자식클래스를 만듦
		at.setName("홍길동"); //오버라이딩 - 본인(AbstractMain,자식클래스)의 메소드만이 호출될 수 있음
		System.out.println(at.getName());
	
		
		//Calendar cal = new Calendar(); -error
		Calendar cal = new GregorianCalendar();
		GregorianCalendar gc = new GregorianCalendar();
		
	}
	
	
	

}
