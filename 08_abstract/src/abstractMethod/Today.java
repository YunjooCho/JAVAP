package abstractMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {

	public static void main(String[] args) throws ParseException {
//		while(true) {
//			Date date = new Date();
//			System.out.println("���� ��¥ : " + date);
//			Thread.sleep(1000); //CPU�� 1�ʾ� ������ �� - ������
//		}
		
		Date date = new Date();
		System.out.println("���� ��¥ : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� hh:mm:ss");
		//�˱� ���� ��¥/�ð� ������ ��Ÿ���� �޼ҵ�(DecimalForma("#,###")�� ����)
		System.out.println("���� ��¥ : " + sdf.format(date));
		//�ڹ�
		//�� - M, �� - m
		//����Ŭ
		//�� - m, �� - mi
		
		//HH -24�ð���, hh - 12�ð���
		System.out.println();
		
		
		//�Է� - �� ���� yyyyMMddHHmmss : �Է����� ����(�ڵ���?)
		//��) 19910716131503
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		//String birth = "19910716131503"; //String  -> Date������ ��ȯ
		//Date birth = (Date)"19910716131503"; 
		//StringŬ������ ���� DateŬ������ �������� �Ҷ� ������
		//(Date)�� ���� ����ȯ�� �ȵ�
		Date birth = input.parse("19890317190803");
		System.out.println("�� ���� = " + birth);
		System.out.println("�� ���� = " + sdf.format(birth));
		System.out.println();
		
		//<<Calendar Ŭ���� ������ ���Ͽ� 1~3>>
		//Calendar�� �����ϸ� �ý����� ����ð��� ��¥�� ����
		//1.Calendar cal = new Calendar(); - error
		//CalendarŬ������ �߻�Ŭ������ new�� ���� �Ұ�(javaå �߻�Ŭ����, API Calendar Ŭ���� ����) 
		//���󺰷� �ð�,��¥�� ǥ�Ⱑ �ٸ��Ƿ� �߻�Ŭ������
		
		//2.�߻�޼ҵ��� ���� - �ڽ�Ŭ������ �̿��Ͽ� ����
		//Calendar�� �����ϸ� ���� �ð��� ���´�
		//Calendar cal = new GregorianCalendar();
		
		//3.�޼ҵ带 �̿��Ͽ� ����(new��� ����)
		Calendar cal = Calendar.getInstance();//�� �޼ҵ� �ȿ��� new Calendar();�� �̷����
		
		//����, ������ ��¥/�ð��� ������
		int year = cal.get(Calendar.YEAR); //get�޼ҵ�� Calendar�� ��������
		int month = cal.get(Calendar.MONTH) + 1; // 0 -> 1��  1 -> 2��
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);//�Ͽ��� -> 1 , ������ -> 2
		
		String dayOfWeek = null;
		switch(week) {
		case 1 : dayOfWeek = "��"; break;
		case 2 : dayOfWeek = "��"; break;
		case 3 : dayOfWeek = "ȭ"; break;
		case 4 : dayOfWeek = "��"; break;
		case 5 : dayOfWeek = "��"; break;
		case 6 : dayOfWeek = "��"; break;
		case 7 : dayOfWeek = "��"; break;
		}
		System.out.println("���� ��¥ : " + year + "�� " + month + "�� " + day + "��" + dayOfWeek);
		
		
		//�ڡڡڡڡ�Ȯ�ο� - �� �Ǵ��� ��� �����ϱ�
		GregorianCalendar calendar = new GregorianCalendar();
		int year2 = cal.get(GregorianCalendar.YEAR); 
		int month2 = cal.get(GregorianCalendar.MONTH) + 1;
		int day2 = cal.get(GregorianCalendar.DAY_OF_MONTH);
		int week2 = cal.get(Calendar.DAY_OF_WEEK);//�Ͽ��� -> 1
		System.out.println("���� ��¥(GregorianCalendar) : " + year + "�� " + month + "�� " + day + "�� " + dayOfWeek);
		//'��'�� 0���� �����ϹǷ�  '+ 1'����� ��
		
	}

}
