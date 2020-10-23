package p07_heritance;

public class SuperTestP2 {
	protected double weight;
	protected double height;
	
	public SuperTestP2() {
		System.out.println("SuperTestP2 기본 생성자");
	}
	
	public SuperTestP2(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("SuperTest클래스의 disp()");
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
		
	}
}
