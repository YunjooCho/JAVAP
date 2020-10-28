package abstractMethod;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {

	public static void main(String[] args) {
		//<추상클래스>NumberFormat의 활용
		//1. 자식클래스를 이용한 생성
		NumberFormat nf = new DecimalFormat();
		//3자리마다 쉼표를 찍고 소수이하 3째자리까지 출력(자동 반올림)
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##원");
		//소수점 이하의 숫자가 유효숫자가 아닌 것은 표현하지 않는다
		//#,###.## & #,###.00 - .뒤에 0이 있으면 값이 없더라도 0이 대신 출력
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		//소숫점 이하의 숫자에 값이 없으면 0을 강제로 표시(둘째자리까지)
		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		
		//2.NumberFormat의 메소드를 이용한 생성
		//2-1. NumberFormat nf4 = NumberFormat.getInstance();
			//getInstance()메소드가 인스턴스 자동생성 및 주소값을 건내줌
			//3자리마다 쉼표를 찍고 소수이하 3째자리까지 출력(자동 반올림)
		
		//2-2.현재 시스템의 지역 또는 지정한 지역의 통화가 함께 표시
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//￦
		nf4.setMaximumFractionDigits(2); // #,###.##
			//소수 이하 둘째자리까지 표기
		nf4.setMinimumFractionDigits(2); // #,###.00
			//소수이하 둘째자리까지 강제로 0이 표시
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);//＄
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.JAPAN);//￥
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.CHINA);//￥
		//Locale의 import는 util
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance();
		nf5.setMaximumFractionDigits(2); // #,###.##
			//소수 이하 둘째자리까지 표기
		nf5.setMinimumFractionDigits(2); // #,###.00
			//소수이하 둘째자리까지 강제로 0이 표시
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}

}
