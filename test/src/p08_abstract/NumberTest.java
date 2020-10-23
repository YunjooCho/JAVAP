package p08_abstract;

import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class NumberTest {

	public static void main(String[] args) {
		//NumberFormat�� �߻�Ŭ����
		//1.�ڽ�Ŭ������ ����
		NumberFormat nf = new DecimalFormat();
		//3�ڸ����� ',' & �Ҽ����� 3���ڸ����� ���(�ڵ� �ݿø�)
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.#��");
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.0��");
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		
		//2.NumberFormat�� �޼ҵ带 �̿��� ����
		//NumberFormat nf4 = NumberFormat.getInstamce();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		nf4.setMaximumFractionDigits(2); //�Ҽ��� ���� ��°�ڸ����� ǥ��
		nf4.setMinimumFractionDigits(2); //�Ҽ��� ���� ��°�ڸ����� ������ ǥ��
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
