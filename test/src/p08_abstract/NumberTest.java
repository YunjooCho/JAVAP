package p08_abstract;

import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class NumberTest {

	public static void main(String[] args) {
		//NumberFormat은 추상클래스
		//1.자식클래스로 생성
		NumberFormat nf = new DecimalFormat();
		//3자리마다 ',' & 소수이하 3쩨자리까지 출력(자동 반올림)
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.#원");
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.0원");
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		
		//2.NumberFormat의 메소드를 이용한 생성
		//NumberFormat nf4 = NumberFormat.getInstamce();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		nf4.setMaximumFractionDigits(2); //소숫점 이하 둘째자리까지 표시
		nf4.setMinimumFractionDigits(2); //소숫점 이하 둘째자리까지 강제로 표시
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		

	}

}
