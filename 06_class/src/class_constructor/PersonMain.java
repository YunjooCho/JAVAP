package class_constructor;

class PersonTest{//이것만 있으면 가짜(껍데기만 있음)
	//속성(필드) - 이름, 나이, 키, 몸무게
	//기능,행위,동작(메소드) - 걷는다, 뛴다, 먹는다
	
	//필드
	private String name;
	private int age;
	
	public PersonTest() { 
		//void쓰면 안됨!!!, void쓰면 생성자 기능을 박탈하고 일반 메소드가 됨
		//()안에 인수
		System.out.println("default 생성자");
		
	}//이게 없어도 자동으로 기본생성자가 만들어짐
	
	public PersonTest(String n, int a) {
		name = n;
		age = a;
	}
	
	
	public void setName(String n) {//생성자와 형태가 유사, 역할도 유사. 
								   //생성자는 한번밖에 사용못하지만 setter는 여러번 사용가능
		name = n;
		
	}
	
	public void setDate(String n, int a) {//셋터
		name = n;
		age = a;
		
	}
	
	public void setDate() {//셋터
		
	}
	
	
	public PersonTest(String n) {
		name = n;
	}
	
	public String getName(){ //Name대문자로 쓰는건 약속
		return name;
	}
	
	public int getAge() {
		return age;
	}
}


public class PersonMain {//이것만 있으면 가짜(껍데기만 있음)
	public static void main(String[] args) {
		//static이 있어서 new가 필요없음
		//프로그램의 시작점
		
		System.out.println("A\tB\tC\tD\tF\tG");
		PersonTest aa;//클래스로 만든건 객체(변수라고 안 부름)
//		aa = new PersonTest("홍길동"); //위에 있는 디폴트 생성자가 호출됨
		aa = new PersonTest("홍길동", 25);
		//쓰레기값 -> 클래스를 메모리에 설정
		//new PersonTest + (); - 생성 + 생성자, 이름없으므로 주소값을 줌
		System.out.println("객체 aa = " + aa);
//		aa.age = 25;
		System.out.println("이름 =" + aa.getName() + "\t나이 =" + aa.getAge());
		System.out.println();
		
		PersonTest bb = new PersonTest(); //위에 있는 디폴트 생성자가 호출됨
		//aa와 다른 곳에 새로운 객체 생성
		System.out.println("객체 bb = " + bb);
		bb.setDate("코난", 13);
		System.out.println("이름 =" + bb.getName() + "\t나이 =" + bb.getAge());
		System.out.println();
		
		PersonTest cc = new PersonTest();
		cc.setDate();
		System.out.println("이름 =" + cc.getName() + "\t나이 =" + cc.getAge());
		System.out.println();
		
	}

}


//PersonMain.java 파일에 대해
//아래 두 클래스파일이 생성
//PersonMain.class
//PersonTest.class
//두가지 클래스중 public이 붙어있는 것이 메인(대표,팀장)
//public(class)는 하나의 .java안에서 하나만 존재 가능(클래스 자체는 두개 이상 존재 가능)
