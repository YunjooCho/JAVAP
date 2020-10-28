package p06_class;


import static java.lang.String.format;
import static java.lang.System.out;


public class ImportStaticP {
	public static void main(String[] args) {
		out.println("난수 = " + Math.random()); //Math클래스의 random()메소드
		out.println("제곱승 = " + Math.pow(2,5));
		out.println("소수 이하 2째자리 = " + format("%.2f",123.456));
	}
}
