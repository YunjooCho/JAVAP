package p03_method;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SungJuk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸� �Է� : ");
		String name = br.readLine();
		System.out.print("���� �Է� : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int math = Integer.parseInt(br.readLine());
		
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		
		System.out.println("\t*** " + name + " ���� ***");
		System.out.println("");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));

	}

}
