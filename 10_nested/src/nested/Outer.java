package nested;

public class Outer {//Outer.class 생성됨(고시원 주인)
	private String name;
	
	public void output() {//Outer클래스(외부클래스)의 메소드
		//Inner inner = new Inner();
		//System.out.println("이름 = " + name + "\t 나이 = " + in.age);
		//위의 두 줄을 아래와 같이 요약 가능함
		//실무에선 setter/getter를 주로 사용 - 언제 누가 사용할 지 모르기 때문에
		System.out.println("이름 = " + this.name + "\t 나이 = " + new Inner().age);
		
		//☆상속과 다른점1
		//중첩클래스를 사용하지 않으면 getter메소드를 작성해서 불러와야 함(in.getAge())
		//중첩클래스를 사용하는 경우 getter메소드를 사용하지 않아도 직접 접근이 가능
		//(외부클래스에서 내부클래스를 사용하려면 객체생성이 필요하긴 함) 
		//System.out.println("이름 = " + name + "\t 나이 = " + age);  : error - 내부클래스의 멤버 사용 불가
	}
	
	
	class Inner{//Outer$Inner.class 생성됨(입주자)
		private int age;
		
		public void disp() {//Inner클래스(중첩클래스)의 메소드
			System.out.println("이름 = " + Outer.this.name + "\t 나이 = " + this.age); 
			//외부클래스의 멤버를 가져다 씀(소유자가 누구인지 정확히 표기 - Outer.this.name)
		}
	}
	
	
	public static void main(String[] args) {
		Outer ou = new Outer(); //☆상속과 다른점2 : 객체 생성시 자기것만 만듦
		ou.name = "홍길동";
		ou.output();
		System.out.println();
		
		Outer.Inner in = ou.new Inner(); //Outer.Inner로 중첩클래스임을 표시
										 //메모리 생성시 ou안에 생성하라는 선언
										 //이 구현이 Outer클래스 안에서 일어나는 것이므로
		                                 //Outer.Inner in에서 Outer부분은 생략가능하다
										 //내부클래스를 생성하려면 반드시 외부클래스의 생성이 필요하다
		in.age = 25;
		in.disp();
		//ou.output(); - 여기서 이 메소드를 입력할 경우, 
		//11번째 줄의 new Inner().age 로 인해 36번째 줄 new Inner()(값 25가 초기화되어있음) 와 다른
		//새로운 내부클래스 객체가 생성되므로 값이 저장안됨(한글파일 중첩클래스 참조)
		
		//in.output(); - error
		//(같은 클래스 영역 안에서는 내부클래스가 외부클래스의 멤버를 사용할 수 있으나
		//main메소드 안에서는 in.output()은 사용할 수 없음) - Inner클래스만 참조하기 때문에 외부클래스의 멤버는 보이지 않음
		
		System.out.println();
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		System.out.println();
		
		Outer.Inner in3 = new Outer().new Inner(); 
		//new Inner() 만 있으면 error
		//상기 생성과 또 다른 Outer객체 생성, 그 안에 또 다른 Inner객체 생성
		in3.age = 35;
		in3.disp();
	}
}//class Outer
