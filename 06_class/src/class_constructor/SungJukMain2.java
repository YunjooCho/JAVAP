package class_constructor;
/*
SungJuk Ŭ���� �̿��Ͻÿ�
��ü �迭

[������]
�ο��� �Է� : 2

�̸� �Է� : ȫ�浿
���� �Է� : 85
���� �Է� : 93
���� �Է� : 100

�̸� �Է� : �ڳ�
���� �Է� : 75
���� �Է� : 86
���� �Է� : 92

----------------------------------------------------
�̸�      ����      ����      ����      ����      ���      ����
----------------------------------------------------
ȫ�浿   85      93      100
�ڳ�      75      86      92
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJukMain2 {

	//�ʵ弱��
//	static SungJuk[] ar;
//	static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws IOException  {
		//������Ǯ��
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�ο��� �Է� : ");
		int count = Integer.parseInt(bufferedReader.readLine());
		SungJuk[] ar = new SungJuk[count];
		
//		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("�ο��� �Է� : ");
//		int count = Integer.parseInt(bufferedReader.readLine());
//		ar = new SungJuk[count-1];
		
		for(int i = 0; i < count; i++) {
			//add();
			//������ Ǯ��
			System.out.print("�̸� �Է� : ");
			String name = bufferedReader.readLine();
			System.out.print("���� �Է� : ");
			int kor = Integer.parseInt(bufferedReader.readLine());
			System.out.print("���� �Է� : ");
			int eng = Integer.parseInt(bufferedReader.readLine());
			System.out.print("���� �Է� : ");
			int math = Integer.parseInt(bufferedReader.readLine());
			ar[i] = new SungJuk(name, kor, eng, math);
			ar[i].calc();
		}
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");	
//		for(int i = 0; i < ar.length; i++) {
//			ar[i].calc();
//			System.out.println(ar[i].getName()+ "\t" 
//							   + ar[i].getKor() + "\t" 
//							   + ar[i].getEng() + "\t" 
//							   + ar[i].getMath() + "\t" 
//							   + ar[i].getTot() + "\t" 
//							   + String.format("%.2f", ar[i].getAvg()) + "\t"
//			                   + ar[i].getGrade());
//		}
		//������ Ǯ��
		for(SungJuk data : ar) {
			System.out.println(data.getName()+ "\t" 
					   + data.getKor() + "\t" 
					   + data.getEng() + "\t" 
					   + data.getMath() + "\t" 
					   + data.getTot() + "\t" 
					   + String.format("%.2f", data.getAvg()) + "\t"
	                   + data.getGrade());
		}
		
		

	}
	
//	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
//		int value = Integer.parseInt(bufferedReader.readLine());
//		
//		while(value < minimum || value > maximum) {
//			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
//			value = Integer.parseInt(bufferedReader.readLine());
//		}
//		
//		return value;
//	}
//	
//	private static SungJuk setInfo() throws IOException {
//		
//		SungJuk s = new SungJuk();
//		System.out.println("�̸� �Է� : ");
//		s.setName(bufferedReader.readLine());
//		System.out.println("���� �Է� : ");
//		s.setKor(validateNumber(0,100));
//		System.out.println("���� �Է� : ");
//		s.setEng(validateNumber(0,100));
//		System.out.println("���� �Է� : ");
//		s.setMath(validateNumber(0,100));
//	
//		return s;
//	}
//	
//	private static SungJuk[] add(SungJuk[] ar, SungJuk s) {
//		//���� �迭�� �ӽ� �迭�� �����Ѵ�
//		int size = ar.length;
//		SungJuk[] temp = new SungJuk[size];
//		for(int i = 0; i < size; i++) {
//			temp[i] = ar[i];
//		}
//		
//		//�迭�� ũ�⸦ 1����(������ ���ÿ� �ʱ�ȭ��)
//		ar = new SungJuk[size + 1];
//		
//		//studentArray�� temp�� �� ����
//		for(int i = 0; i < size; i++) { //�ӽ� �迭�� ũ�⿡ ���� �ۼ�
//			ar[i] = temp[i];
//		}
//		
//		ar[size] = s; //postArray�� ũ�Ⱑ size+1�� �����߱� ������ size�� 
//							 //���� ������ �ε����� ��, ������ �ε����� �߰� ��ü�� ����
//		
//		return ar;
//	}
//	
//	private static void add() throws IOException {
//		ar = add(ar, setInfo());
//	}
	
}
