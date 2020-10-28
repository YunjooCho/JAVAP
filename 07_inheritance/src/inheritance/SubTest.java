package inheritance;

public class SubTest extends SuperTest{
	protected String name; //자기꺼
	protected int age;     //자기꺼
	//최종 자기꺼 2개  + 부모꺼 2개(weight, height)로 총 4개의 필드 사용
	//자식클래스는 접근제한자가 무엇이든 상관없지만 기본 캡슐화를 위해, private 아니면  
	//상속이 있을 경우 protected 사용
	
	
	public SubTest() {
		System.out.println("SubTest 기본 생성자");
	}
	
	public SubTest(double weight, double height, String name, int age) {
		System.out.println("SubTest 생성자");
//		this.weight = weight; 부모꺼, 만약 자식클래스에 동일 필드가 설정되면, this는 자식클래스의 필드를 가리킴
//		this.height = height; 부모꺼
		super.weight = weight; //부모꺼, 상기 내용과 표기만 다름. super는 예약어(클래스명 상관없음)
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void outPut() {
		System.out.println("몸무게 = " + weight);//super등을 선언하지 않아도 부모클래스에 존재하기 때문에 정상작동
		System.out.println("키 = " + height);//super등을 선언하지 않아도 부모클래스에 존재하기 때문에 정상작동
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
	}
	
	
	public static void main(String[] args) {
		SubTest a = new SubTest(); 
		//부모 기본 생성자와 자기자신의 기본 생성자 둘다 호출
		System.out.println();
		
		SubTest aa = new SubTest(75.3, 185.5, "홍길동", 25); 
		//부모 기본 생성자와 자기자신의 파라미터 있는 생성자 둘다 호출
		aa.outPut();//outPut()를 SubTest에서 찾는다. 없으면 부모클래스에 가서 찾는다.
		System.out.println();
		
		
		aa.disp();//부모클래스 메소드. disp()를 SubTest에서 찾는다. 없으면 부모클래스에 가서 찾는다.
		System.out.println("-----------------------");
		
		SuperTest bb = new SubTest(35.8, 156.3, "코난", 13);
		//bb.outPut(); -error : 자식클래스 메소드는 부모클래스에서 호출할 수 없음
		bb.disp();
	}
}

//자식클래스는 부모 생성자를 선택해서 호출할 수 있다.
//아무 말이 없으면 부모의 기본 생성자를 호출한다.
