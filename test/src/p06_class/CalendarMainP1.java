package p06_class;
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
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;

public class CalendarMainP1 {
	//�ʵ� ����
	private int year, month, week, lastDay;
	private BufferedReader br;
	
	public CalendarMainP1() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�⵵ �Է� : ");
		year = Integer.parseInt(br.readLine());
		System.out.print("�� �Է� : ");
		month = Integer.parseInt(br.readLine());
		while(month < 1 || month > 12) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			System.out.print("�� �Է� : ");
			month  = Integer.parseInt(br.readLine());
		}
	}
	
	public void calculator() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); 
		//CalendarŬ������ Ư���� ���� �ý����� ��¥�� �ð��� �������� ���� �ƴ� 
		//�Է� ���� �⵵, �Է¹��� ��, �ſ� 1�Ϸ� ����
		week = cal.get(cal.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH);
	}
	
	public void display() {
		System.out.println("week = " + week);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		for(int i = 1; i <= lastDay; i++){
			System.out.print(i + "\t");
			
			if(week%7 == 0) System.out.println();
			week++;
			
		}
		
	}//display
	
	public static void main(String[] args) throws IOException {
		CalendarMainP1 calp1 = new CalendarMainP1();
		calp1.calculator();
		calp1.display();

	}

}
