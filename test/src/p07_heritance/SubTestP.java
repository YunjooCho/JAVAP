package p07_heritance;

public class SubTestP extends SuperTestP{
	protected String name;
	protected int age;
	
	public SubTestP() {
		System.out.println("SubTestP 기본 생성자");
	}
	
	public SubTestP(double weight, double height, String name, int age) {
		System.out.println("SubTestP 생성자");
		super.weight = weight;
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void output() {
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
	}
	
	public static void main(String[] args) {
		SubTestP a = new SubTestP();
		System.out.println();
		
		SubTestP aa = new SubTestP(75.3, 185.6, "홍길동", 25);
		aa.output();
		System.out.println();
		
		aa.disp();//부모클래스의 메소드를 빌려옴
		
		SuperTestP bb = new SubTestP(35.8, 156.3, "코난", 13);
		bb.disp();//bb.outpu()은 사용할수 없음
	}
}
