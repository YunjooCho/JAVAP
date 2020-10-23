package practice;

public class NumberTest {
	public static void main(String[] args){
		System.out.println(25+36);  //결과값 : 61
		System.out.println("25+36"); //결과값 : 25+36
		System.out.println("25+36 = " + 25+36); //결과값: 25+36 = 2536
		System.out.println("25+36 = " + (25+36)); //결과값: 25+36 = 61
		System.out.println("25/36 = " + (25/36)); //결과값: 25/36 = 0
		System.out.println("25/36 = " + (25.0/36)); //결과값 : 25/36 = 0.xxxx
		System.out.printf("25/36 = %.2f\n", (25.0/36)); //결과값 : 25/36 = 0.xx
		System.out.printf("25/36 = %.1f\n", (25.0/36)); //결과값 : 25/36 = 0.x
		System.out.printf("%d / %d = %.1f\n", 25, 36, (25.0/36)); //결과값 : 25/36 = 0.x
		System.out.println("25/36 = " + String.format("%.2f", (25.0/36))); //결과값 : 25/36 = 0.xx
		System.out.println();
	}
}
