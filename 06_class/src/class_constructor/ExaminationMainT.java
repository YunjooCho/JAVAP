package class_constructor;

import java.util.Scanner;

public class ExaminationMainT {

	public static void main(String[] args) {
		
		//1������
		ExaminationT aa = new ExaminationT();
		aa.compare();
		System.out.println("�̸�\t1 2 3 4 5\t����");
		System.out.print(aa.getName() + "\t");
		
		for(int i = 0; i < aa.getOX().length; i++) {
			System.out.print(aa.getOX()[i] + " ");
		}
		System.out.println("\t" + aa.getScore());
		
		
		//2������
		Scanner scan = new Scanner(System.in);
		System.out.print("�ο��� �Է� : ");
		int count = scan.nextInt();
		ExaminationT[] ar = new ExaminationT[count];
		
		//����
//		ar[0] = new ExaminationT();
//		ar[1] = new ExaminationT();
//		
//		ar[0].compare();
//		ar[1].compare();
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new ExaminationT();
			ar[i].compare();
		}
		
		System.out.println("�̸�\t1 2 3 4 5\t����");
//		System.out.print(ar[0].getName() + "\t");
//		
//		for(int i = 0; i < ar[0].getOX().length; i++) {
//			System.out.print(ar[0].getOX()[i] + " ");
//		}
//		System.out.println("\t" + ar[0].getScore());
		//��������
		for(int k = 0; k < ar.length; k++) {
			System.out.print(ar[k].getName() + "\t");
			
			for(int i = 0; i < ar[k].getOX().length; i++) {
				System.out.print(ar[k].getOX()[i] + " ");
			}
			System.out.println("\t" + ar[k].getScore());
		}
	}

}
