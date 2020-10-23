package p09_interface;

public class AbstractMainP {

	public static void main(String[] args) {
		
		//AbstractTestP at = new AbstractTestP(); - 클래스의 추상화로 인해 new생성자 사용 못함
		//at.setName("홍길동");
		//System.out.println("이름 = " + at.getName());
		
		//추상클래스&추상메소드
		AbstractTestP at = new AbstractTestP() {//익명 Inner클래스 1 - 상속없이 추상클래스의 객체 생성이 되도록 도움(오버라이딩 구현)
			@Override
			public void setName(String name) {
				this.name = name;
			}
		}; //객체생성이 가능해짐
		
		//인터페이스&추상메소드
		InterA in = new InterA() {
			public void aa() {};
			public void bb() {};
		};

		
		//추상클래스&일반메소드(빈body)
		AbstractExamP exam = new AbstractExamP() {
			public void cc() {}
		};
	}

}
