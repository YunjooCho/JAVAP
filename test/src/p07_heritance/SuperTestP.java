package p07_heritance;

public class SuperTestP {
	protected double weight;
	protected double height;
	
	public SuperTestP() {
		System.out.println("SuperTestP 기본 생성자");
	}
	
	public SuperTestP(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("SuperTestP 클래스의 disp()");
		System.out.println("몸무게  = " + weight);
		System.out.println("키 = " + height);
	}
}
