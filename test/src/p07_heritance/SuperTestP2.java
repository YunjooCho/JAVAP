package p07_heritance;

public class SuperTestP2 {
	protected double weight;
	protected double height;
	
	public SuperTestP2() {
		System.out.println("SuperTestP2 �⺻ ������");
	}
	
	public SuperTestP2(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("SuperTestŬ������ disp()");
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
		
	}
}
