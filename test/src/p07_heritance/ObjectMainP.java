package p07_heritance;
/*
class Object{
	public boolean equals(Object ob)//참조값 비교
	public String toString(){} //패키지명.클래스명@16진수
	public int hashCode(){}//10진수
}

final class String extends Object{
	public boolean equals(Objectob){} //문자열 비교, Object클래스의 equals()메소드 오버라이드
	public String toString(){}
	//문자열
	//final로 상속이 막혀있기 때문에 자식클래스에서 오버라이드 불가능
    public int hashCode(){}
    //문자열을 10진수로 변환
    //문자열 계산식에 의해서 만들어진 값
    //문자열은 무한이므로 10진수로 다 표기할 수 없다
}
  
 */

class Test extends Object{
	public String toString() {
		return "개바부";
	}
}

public class ObjectMainP {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("객체 t = " + t);
		System.out.println("객체 t = " + t.toString()); //toString()이 주소값(16진수)을 가지고 있음
		System.out.println("객체 t = " + t.hashCode());
		System.out.println();
		
		String str = "apple";
		System.out.println("객체 str = " + str);
		System.out.println("객체 str = " + str.toString());
		System.out.println("객체 str = " + str.hashCode()); //신빙성이 없는 숫자
		System.out.println(str);
		System.out.println();
		
	}

}
