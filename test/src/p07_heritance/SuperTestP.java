package p07_heritance;

public class SuperTestP {
	protected double weight;
	protected double height;
	
	public SuperTestP() {
		System.out.println("SuperTestP �⺻ ������");
	}
	
	public SuperTestP(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("SuperTestP Ŭ������ disp()");
		System.out.println("������  = " + weight);
		System.out.println("Ű = " + height);
	}
}
