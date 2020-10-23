package p06_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



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
public class SungJukMain2P {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�ο� �� �Է� : ");
		int number = Integer.parseInt(br.readLine());
		
		SungJukP[] arr = new SungJukP[number];
		
		for(int i = 0; i < number; i++) {
			System.out.print("�̸� �Է� : ");
			String name = br.readLine();
			System.out.print("���� �Է� : ");
			int kor = Integer.parseInt(br.readLine());
			System.out.print("���� �Է� : ");
			int eng = Integer.parseInt(br.readLine());
			System.out.print("���� �Է� : ");
			int math = Integer.parseInt(br.readLine());
			arr[i] = new SungJukP(name, kor, eng, math);
			arr[i].calc();
			System.out.println();
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");		
		for(SungJukP data : arr) {
			System.out.println(data.getName()+ "\t" 
					   + data.getKor() + "\t" 
					   + data.getEng() + "\t" 
					   + data.getMath() + "\t" 
					   + data.getTot() + "\t" 
					   + String.format("%.2f", data.getAvg()) + "\t"
	                   + data.getGrade());
		}
	}

}
