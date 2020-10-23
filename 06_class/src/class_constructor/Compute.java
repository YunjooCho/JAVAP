package class_constructor;

public class Compute {

	private int x;
	private int y;
	private int sum;
	private int sub;
	private int mul;
	private double div;
	
	
	public Compute(int x, int y) { //데이터를 받아 필드에 값을 넘겨줌
		this.x = x;
		this.y = y;
	}
	
	public void calc() {//생성자로 이미 필드에 값이 존재하므로 파라미터 필요 없음
		
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
		//calc(); 결과값은 같으나 메인에 한번만 써주면 더 간단
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






