package abstractMethod;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {

	public static void main(String[] args) {
		//<�߻�Ŭ����>NumberFormat�� Ȱ��
		//1. �ڽ�Ŭ������ �̿��� ����
		NumberFormat nf = new DecimalFormat();
		//3�ڸ����� ��ǥ�� ��� �Ҽ����� 3°�ڸ����� ���(�ڵ� �ݿø�)
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##��");
		//�Ҽ��� ������ ���ڰ� ��ȿ���ڰ� �ƴ� ���� ǥ������ �ʴ´�
		//#,###.## & #,###.00 - .�ڿ� 0�� ������ ���� ������ 0�� ��� ���
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		//�Ҽ��� ������ ���ڿ� ���� ������ 0�� ������ ǥ��(��°�ڸ�����)
		NumberFormat nf3 = new DecimalFormat("#,###.00��");
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		
		//2.NumberFormat�� �޼ҵ带 �̿��� ����
		//2-1. NumberFormat nf4 = NumberFormat.getInstance();
			//getInstance()�޼ҵ尡 �ν��Ͻ� �ڵ����� �� �ּҰ��� �ǳ���
			//3�ڸ����� ��ǥ�� ��� �Ҽ����� 3°�ڸ����� ���(�ڵ� �ݿø�)
		
		//2-2.���� �ý����� ���� �Ǵ� ������ ������ ��ȭ�� �Բ� ǥ��
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//��
		nf4.setMaximumFractionDigits(2); // #,###.##
			//�Ҽ� ���� ��°�ڸ����� ǥ��
		nf4.setMinimumFractionDigits(2); // #,###.00
			//�Ҽ����� ��°�ڸ����� ������ 0�� ǥ��
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);//��
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.JAPAN);//��
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.CHINA);//��
		//Locale�� import�� util
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance();
		nf5.setMaximumFractionDigits(2); // #,###.##
			//�Ҽ� ���� ��°�ڸ����� ǥ��
		nf5.setMinimumFractionDigits(2); // #,###.00
			//�Ҽ����� ��°�ڸ����� ������ 0�� ǥ��
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}

}
