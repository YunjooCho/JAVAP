package class_constructor;

/*
 �⵵ �Է� : 2002
�� �Է� : 10   

��  	 ��  	  ȭ  	     ��      ��      ��      ��
          1    2    3    4    5
6    7    8    9    10   11   12
13   14   15   16   17   18   19
20   21   22   23   24   25   26
27   28   29   30   31

�⺻������ - �⵵, �� �Է�
calculator() - �Ŵ� 1���� ���� ���Ϸ� ����?, �Ŵ� ������ ��? //�޼ҵ� 2�� ã�ƺ���(+1�� get�� �ݴ� �޼ҵ�)
display() - ���
 */
//���� �ð��� �޾ƿ�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


public class CalendarMain {
	//1.�ʵ�� ����
	private int year;
	private int month;
	private int week;
	private int lastDay;
	
	
	//2.�⺻ ������ ����
	public CalendarMain() throws NumberFormatException, IOException {
		
		//��NumberFormatException - Ű����� �Էµ� ���� ���ڰ� �ƴ� �� ����ó�� ("A" - �ƽ�Ű�ڵ� �ƴ�)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�⵵ �Է� : ");
		year = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("�� �Է� : ");
		month = Integer.parseInt(bufferedReader.readLine());
		while(month < 1 || month > 12) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			System.out.print("�� �Է� : ");
			month = Integer.parseInt(bufferedReader.readLine());
		}
		
	}
	
	
	
	public void calculator() {
		
		//3.Calendar Ŭ���� ���� (new Calendar ->�߻�Ŭ������ �� ������ error)
		Calendar calendar = Calendar.getInstance();
		//getInstance()�� �߻�޼ҵ带 �������̵� �� ������ �� �ּҸ� calendar�� �Ѱ��� - Ŭ���� ������ ����
		
		
		//4.����
		//4-1.calendar.set(Calendar.YEAR,year); 
			//���� ������ ���� ��¥(CalendarŬ������ Ư¡)�� �ƴ� �Է¹��� ������ ��ü
		//4-2.calendar.set(Calendar.MONTH,month-1);
			//�Է¹��� ���� -1�� ó���ϱ� 2 -> 1��  
		//4-3.calendar.set(Calendar.DAY_OF_MONTH,1);
			//calendar.set(Calendar.DAY_OF_MONTH,1)�� �ǹ� : �������� ������ �� �۾��� ������ ���� ��¥(����)�� ����
			//�� ������ ������ 2020.9.29���� 29�� ��µ�, �׷��� �޷��� 1������ ��� for���� ���� �����̹Ƿ� 1�� �ʱ�ȭ
			//API :set(int field, int value) - Sets the given calendar field to the given value.
			//���� ���ϴ� ��, �������� ������ �۾��ϰ� �ִ� ���� ��¥�� ������ ���߾���
		calendar.set(year, month-1, 1);
			//4-1~4-3�� ���� �ǹ�
			//API :	set(int year, int month, int date) - Sets the values for the calendar fields YEAR, MONTH, and DAY_OF_MONTH.
			//month�� �Է¹��� �� �̸� -1�ص� ��(1���� 0���� �����ϹǷ� ������ -1)
			//�Է¹��� ���� year, month�� calendar��ü�� �Է�
		
		week = calendar.get(calendar.DAY_OF_WEEK);
		//��ü calendar�� ����ִ� ���� �Ŵ� 1��(calendar.set(year, month-1, 1))�� ���� ���Ϸ� �����ϴ��� Ȯ��
		//������� ���ڷ� ��ȯ(�Ͽ���-1, ������-2, ȭ����-3,....)
		lastDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		//�Ŵ� ������ ���� �������� Ȯ�� - �� �߿��� ���� ū ��(������ ��) ��������(���� �ڵ����� ����)
	}
	
	
	
	public void display() {
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		//��µǴ� 1���� �ش� ���Ͽ� �°� ǥ��
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		//��¥ǥ��
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");
			
			//7�ϸ���(��~��) �߶� ��µǰ� ��
			if(week % 7 == 0) System.out.println();
			week++;
		}

		
	}

	public static void main(String[] args) throws IOException { 
		//����ó�� NumberFormatException�� ���� ����
		//NumberFormatException(�ڽ�)�� IOException(�θ�)�� ���
		//IOException�� �� ó������
		//�ʱ�ȭ
		CalendarMain cm = new CalendarMain();
		cm.calculator();
		cm.display();
		
		

	}

}
