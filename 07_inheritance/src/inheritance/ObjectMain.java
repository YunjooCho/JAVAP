package inheritance;
/*
//클래스의 내부 메소드 다 외우지 않아도 됨
class Object{
	public boolean equals(Object ob) //참조값 비교
	public String toString(){} //패키지명.클래스명@16진수
	public int hashCode(){}//10진수
}

final class String extends Object{
	public boolean equals(Object ob){} //문자열 비교, Object클래스의 equals()메소드 오버라이드
	public String toString(){} 
	//문자열(String클래스는 java자체에서 toString오버라이딩이 되어있어 toString()오버라이딩을 사용자가 하지 않아도
	             자동으로 주소값이 아닌 문자열이 출력됨)
	//final로 상속이 막혀있기 때문에 자식클래스에서 오버라이드도 불가능    
	public int hasCode(){}
	//문자열을 10진수로 변환
	//문자열 계산식에 의해서 만들어진 값
	//문자열은 무한이므로 10진수로 다 표기할 수 없다
	//다른 문자열이어도 같은 해시값이 발생 할 수 있다
	//int는 21억개인데 반해, 문자열은 무한대라서 표시가 불가능하다         

*/

class Test2 extends Object{ //다른 것들도 extends Object가 생략되어 있음
	@Override
	public String toString() { //Object클래스(부모클래스)의 toString()매소드를
							   //Test2(자식클래스)에서 오버라이딩(오버라이드 한 자식 메소드만 호출됨)
		//return super.toString();
		return "개바부";
	}
}


public class ObjectMain {

	public static void main(String[] args) {
		Test2 t = new Test2();
		System.out.println("객체 t = " + t);
		System.out.println("객체 t = " + t.toString()); //toString()이 주소값(16진수)을 가지고 있음
		System.out.println("객체 t = " + t.hashCode());
	
		String str = "apple";
		System.out.println("객체 str = " + str);
		System.out.println("객체 str = " + str.toString());
		System.out.println("객체 str = " + str.hashCode()); //신빙성이 없는 숫자
		System.out.println(str);
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa==bb)); //주소값 비교, false
		System.out.println("aa.equals(bb): " + aa.equals(bb)); //문자열 비교, true
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc==dd)); //주소값 비교, false
		System.out.println("cc.equals(dd): " + cc.equals(dd)); //주소값 비교(Object클래스가 불렸으므로), false
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee==ff)); //주소값 비교, false
		System.out.println("ee.equals(ff): " + ee.equals(ff)); //Override된 자식클래스의 equals()를 호출(다형성) 
		                                                       // 문자열 비교, true
		System.out.println();
		
	}
	

}

