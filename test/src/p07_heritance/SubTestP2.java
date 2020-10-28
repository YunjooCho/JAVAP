package p07_heritance;


public class SubTestP2 extends SuperTestP2 {
	protected String name; //자식클래스
	protected int age; //자식클래스
	
	public SubTestP2() {
		System.out.println("SubTestP2 기본 생성자");
	}
	
	public SubTestP2(double weight, double height, String name, int age) {
		System.out.println("SubTestP2 생성자");
		super.weight = weight;
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
		SubTestP2 sub = new SubTestP2();
		System.out.println();
		
		SubTestP2 sub2 = new SubTestP2(75.3, 185.5, "홍길동", 25);
		sub2.outPut();
		System.out.println();
		
		sub2.disp(); //부모클래스 메소드
		System.out.println("----------------------------------");
		
		SuperTestP2 bb = new SubTestP2(35.8, 156.3, "코난", 13);
		//bb.outPut(); //-error : 자식클래스 메소드는 부모클래스에서 호출할 수 없음
		bb.disp();
	}
}


