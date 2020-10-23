package method;

/*
 �̸�(name), ����(kor), ����(eng), ����(math)������ �Է¹޾Ƽ� ����(tot),���(avg)�� ���Ͻÿ�

���� = ���� + ���� + ����
��� = ���� / �����

[������]
�̸� �Է� : ȫ�浿
���� �Է� : 95
���� �Է� : 90
���� �Է� : 91

   *** ȫ�浿 ���� ***
����      ����      ����      ����      ���
95      90      91      xxx      xx.xxx
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SungJuk {
	
	public static void main(String[] args) throws IOException {
		
		//�޸� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�Է�
		System.out.println("[������]");
		System.out.println("�̸��Է� : ");
		String name = br.readLine();
		System.out.println("���� : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("���� : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("���� : ");
		int math = Integer.parseInt(br.readLine());
		
		//���� �޼ҵ�, ��� �޼ҵ�
		SungJuk sungJuk = new SungJuk(); 
		int tot = sungJuk.calcTot(kor, eng, math);
		double avg = sungJuk.calcAvg(tot);
		
		
		//����&��� �ٸ� Ǯ��
		//int tot = kor + eng + math;
		//double avg = (double)tot / 3;
		
		//���
		System.out.println("\t *** " + name + " ���� ***");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));
		

	}

	public int calcTot(int kor, int eng, int math) { 
		//����, ko = kor & en = eng & ma = math�� ��Ƶ� ��(�޸𸮰� �ٸ�)
		return kor + eng + math;
			
	}
	
	public double calcAvg(int tot) {
		return tot / 3.0;
	}
	
}
