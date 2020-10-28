package nested;

public class AbstractMain {

	public static void main(String[] args) {
		//AbstractTest의 클래스와 setName메소드를 각각 추상클래스, 추상메소드로 변경함
		//AbstractTest at = new AbstractTest(); - error
		//추상클래스(AbstractTest)는 new생성 안됨 -> 1. 자식클래스로 생성(반드시 Override 해야 한다) : 상속필요  2. 메소드로 생성
//		at.setName("홍길동");
//		System.out.println("이름 = " + at.getName());
		
		//예제1 - 추상클래스&추상메소드                                     
		AbstractTest at = new AbstractTest() {//익명 Inner클래스1 - 상속없이 추상클래스의 객체 생성이 되도록 도움(추상메소드의 Overriding 구현)
											  //원래는 상속을 해주고 추상메소드를 Override해줘야 함
			public void setName(String name) {//구현, Override
				this.name = name;
			}
		};
		//예제2 - 인터페이스&추상메소드        //익명Inner클래스2
		InterA in  = new InterA() { //InterA인터페이스의 추상메소드 구현(오버라이딩)
									//이 부분은 인터페이스를 new생성 한 것이 아닌
									//익명클래스를 생성한 것임
			                        //메소드의 body를 가질 수 있는 것은 클래스뿐임
									//이 구조가 안드로이드에서 많이 사용됨
			public void aa() {} //추상메소드의 오버라이딩, 메소드내용은 없음
			public void bb() {} //추상메소드의 오버라이딩, 메소드내용은 없음
		};
		
		//예제3 - 추상클래스&일반메소드(빈body)
		AbstractExam ae = new AbstractExam() { //익명Inner클래스3
											   //일반메소드가 있는 것과 상관없이 클래스가 추상클래스이므로 new생성자 사용불가
			public void cc() {}
		};
	}
}

//익명 클래스는 추상클래스, 인터페이스에서 사용가능 - new부분에 추상클래스명 또는 인터페이스명이 와야함
//그 아래는 해당 추상클래스, 해당 인터페이스의 메소드가 와야함(오버라이딩해야하기 때문에)
//상속, 추상, 인터페이스, 중첩클래스
