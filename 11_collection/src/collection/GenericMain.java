package collection;

class GenericTest<T>{ //<T> : 이 클래스는 어떤 타입을 사용할지 설정하지 않았음을 의미 / Object대신
	private T a; //타입(int, boolean, String 등등)을 선언하는 대신, T를 입력
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}

//------------------------------------------------------------------
public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>(); //위에 T가 String으로 설정됨
		aa.setA("홍길동");
		System.out.println("이름 = " + aa.getA());
		
		//aa.setA(25); - error : T가 String타입으로 설정되어 있어 String타입 이외의 데이터는 에러
		//다시 객체를 선언, Integer타입으로 선언
		GenericTest<Integer> bb = new GenericTest<Integer>(); //<>안에는 클래스명만 올수 있으므로 int대신 Integer사용
		bb.setA(25);
		System.out.println("나이 = " + bb.getA());
	}

}
