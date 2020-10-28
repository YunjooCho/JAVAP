package inheritance;

public class ChildTest extends SuperTest {
	protected String name; //자기꺼
	protected int age;     //자기꺼
	
	public ChildTest() {
		System.out.println("Child 기본 생성자");
	}
	
	public ChildTest(double weight, double height, String name, int age) {
		super(weight, height); //부모생성자 호출(아래 중복 코드를 없애기 위해 super()메소드 사용
		//반드시 첫째줄에서 호출 아니면 error : Constructor call must be the first statement in a constructor
//		this.weight = weight; 부모꺼, 만약 자식클래스에 동일 필드가 설정되면, this는 자식클래스의 필드를 가리킴
//		this.height = height; 부모꺼
//		super.weight = weight; //부모꺼랑 중복, 상기 내용과 표기만 다름. super는 예약어(클래스명 상관없음)
//		super.height = height; //부모꺼랑 중복
		System.out.println("Child 생성자");
		this.name = name;
		this.age = age;
	}
	
	public void disp() { //오버라이드
		System.out.println("ChildTest클래스의 disp()");
		System.out.println("몸무게 = " + weight);//super등을 선언하지 않아도 부모클래스에 존재하기 때문에 정상작동
		System.out.println("키 = " + height);
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
	}
	
	public static void main(String[] args) {
		ChildTest aa = new ChildTest(75.3, 185.5, "홍길동", 25);
		aa.disp(); //자식클래스인 ChildTest에서 먼저 찾음
		System.out.println();
		
		//자식클래스에 부모클래스와 동일한 이름의 메소드(disp())가 있는 경우, 
		//부모클래스의 메소드는 자식클래스에서 호출할 수 없다.
		//static 안에서는 this, super 사용할 수 없다
		
		System.out.println("-----------------------");
		SuperTest bb = new ChildTest(35.8, 156.3, "코난", 13);
		bb.disp();
	}
}
