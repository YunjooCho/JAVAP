package p11_collection;

class GenericTestP<T>{
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


public class GenericMainP {

	public static void main(String[] args) {
		GenericTestP<String> aa = new GenericTestP<String>();
		aa.setA("ȫ�浿");
		System.out.println("�̸� = " + aa.getA());
		
		//aa.setA(25); - error!
		GenericTestP<Integer> bb = new GenericTestP<Integer>();
		bb.setA(25);
		System.out.println("���� = " + bb.getA());
	}

}
