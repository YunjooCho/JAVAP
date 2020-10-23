package collection;

class GenericTest2<T>{ //<T> : 이 클래스는 어떤 타입을 사용할지 설정하지 않았음을 의미
	//필드
	private T a; //타입(int, boolean, String 등등)을 선언하는 대신, T를 입력
	
	//생성자
	public GenericTest2(T a) {//String a는 에러
							  //생성자와 setter가 하는 역할이 같음
							  //다른점은 생성자는 생성시 한번만 초기화, setter는 언제든지 여러번 초기화 가능
		this.a = a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}

public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("홍길동"); 
		//new GenericTest2<String>();기본 생성자 - 클래스 안에 생성자가 하나도 없으면 자동으로 생성됨 
		// <?> 안에 있는 애들을 Object로 잡히게 됨(Object로 형변환 한 상태)
		// 어떤 타입이든 받을 수 있게 됨
		//aa.setA("홍길동"); - error : 반드시 생성자를 통해서만 데이터가 전달됨(setA()메소드는 불가능)
		//생성자를 통해서만 데이터를 전달하는 이유 : <?>의 특징

		
		//String name = aa.getA(); - error : aa 객체는 지금 String이 아닌 Object타입임
		String name = (String)aa.getA(); //자식 -> 부모 사용하기 위해선 형변환 -> 자식 = (자식)부모
		System.out.println("이름 = " + name); 
		//new GenericTest2<String>("홍길동")생성자에서 초기화한 내용이 출력됨
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (int)bb.getA(); //autoUnboxing - 원래는 int가 아닌 Integer를 입력해야함
		System.out.println("나이 = " + age);
		
	}

}
