package class_constructor;

public class Compute {

	private int x;
	private int y;
	private int sum;
	private int sub;
	private int mul;
	private double div;
	
	
	public Compute(int x, int y) { //�����͸� �޾� �ʵ忡 ���� �Ѱ���
		this.x = x;
		this.y = y;
	}
	
	public void calc() {//�����ڷ� �̹� �ʵ忡 ���� �����ϹǷ� �Ķ���� �ʿ� ����
		
		sum = x + y;
		
		sub = x - y;
		
		mul = x * y; 
		 
		div = (double)x / y;

	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSum() {
		//calc(); ������� ������ ���ο� �ѹ��� ���ָ� �� ����
		return sum;
	}
	
	public int getSub() {
		//calc();
		return sub;
	}

	public int getMul() {
		//calc();
		return mul;
	}
	
	public double getDiv() {
		//calc();
		return div;
	}
	
	
}






