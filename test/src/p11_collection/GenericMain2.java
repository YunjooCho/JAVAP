package p11_collection;

class GenericTest2P<T>{
	private T a;
	
	public GenericTest2P(T a) {
		this.a = a;
	}
	
	public void setA() {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2P<?> aa = new GenericTest2P<String>("홍길동");
		//String name = aa.getA();
		String name = (String)aa.getA();
		System.out.println("이름 = " + name);
		
		GenericTest2P<?> bb = new GenericTest2P<Integer>(25);
		int age = (int)bb.getA(); //autoUnboxing
		System.out.println("나이 = " + age);
	}

}
