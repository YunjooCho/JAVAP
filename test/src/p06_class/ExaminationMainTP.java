package p06_class;

import java.util.Scanner;

public class ExaminationMainTP {

	public static void main(String[] args) {
		//1번문제
		ExaminationTP em = new ExaminationTP();
		em.compare();
		//출력
		System.out.println("이름\t1 2 3 4 5\t점수");
		System.out.print(em.getName() + "\t");
		
		for(int i = 0; i < em.getOx().length; i++) {
			System.out.print(em.getOx()[i] + " ");
		}
		
		System.out.println("\t" + em.getScore());
		
		
		//2번문제
		Scanner scanner = new Scanner(System.in);
		System.out.print("인원수 입력 : ");
		int people = scanner.nextInt();
		
		ExaminationTP[] ar = new ExaminationTP[people];
		
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new ExaminationTP();
			ar[i].compare();
		}
		System.out.println("이름\t1 2 3 4 5\t점수");
		for(int j = 0; j < ar.length; j++) {
			System.out.print(ar[j].getName() + "\t");
			for(int i = 0; i < ar[j].getOx().length; i++) {
				System.out.print(ar[j].getOx()[i] + " ");
			}
			System.out.println("\t" + ar[j].getScore());
			
		}
		
		
	}

}
