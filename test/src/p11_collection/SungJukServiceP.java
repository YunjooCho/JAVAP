package p11_collection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukServiceP {
	//3.�ʵ� ����
	private ArrayList<SungJukDTOP> list;
	private Scanner scanner;
	DecimalFormat df;
	
	//4.������(��̸���Ʈ ����)
	public SungJukServiceP() {
		list = new ArrayList<SungJukDTOP>();
	}
	
	//5.�޴� �޼ҵ�
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("*****************");
			System.out.println("   1.�Է�");
			System.out.println("   2.���");
			System.out.println("   3.�˻�");
			System.out.println("   4.����");
			System.out.println("   5.����");
			System.out.println("   6.��");
			System.out.println("*****************");
			System.out.print("��ȣ : ");
			scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			if(number == 1) {
				insertArticle();
			}else if(number == 2) {
				printArticle();
			}else if(number == 3) {
				searchArticle();
			}else if(number == 4) {
				deleteArticle();
			}else if(number == 5) {
				sortArticle();
			}else if(number == 6) {
				break;
			}else {
				System.out.println("1~6 �߿� �����ϼ���");
			}
			
		}
	}
	
	//6.�Է¸޼ҵ�
	public void insertArticle() {
		scanner = new Scanner(System.in);
		SungJukDTOP dto = new SungJukDTOP();
		System.out.print("��ȣ �Է� : ");
		int no = scanner.nextInt();
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("���� ���� : ");
		int kor = scanner.nextInt();
		System.out.print("���� ���� : ");
		int eng = scanner.nextInt();
		System.out.print("���� ���� : ");
		int math = scanner.nextInt();
		dto.calc();
		list.add(dto);
	}
	
	//7.��¸޼ҵ�
	public void printArticle() {
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTOP dto : list) {
			System.out.println(dto);
		}
	}
	
	
	//8.�˻� �޼ҵ�
	public void searchArticle() {
		scanner = new Scanner(System.in);
		int sw = 0;
		System.out.print("�˻��� �̸��� �Է� : ");
		String name = scanner.next();
		for(SungJukDTOP dto : list) {
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			if(dto.getName().equals(name)) {
				System.out.println(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("ã�����ϴ� �̸��� �����ϴ�");
		}
	}
	
	//9.���� �޼ҵ�
	public void deleteArticle() {
		scanner = new Scanner(System.in);
		System.out.print("������ �̸��� �Է� : ");
		String name = scanner.next();
		int sw = 0;
		for(SungJukDTOP dto : list) {
			if(dto.getName().equals(name)) {
				list.remove(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
		}else {
			System.out.println("�����͸� �����Ͽ����ϴ�");
		}
	}
	
	
	//10.���ĸ޼ҵ�
	public void sortArticle() {
		while(true) {
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴�");
			System.out.print("��ȣ �Է� : ");
			scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			
			if(num == 1) {
				Comparator<SungJukDTOP> com = new Comparator<SungJukDTOP>() {
					@Override
					public int compare(SungJukDTOP s1, SungJukDTOP s2) {
						return s1.getName().compareTo(s2.getName());
					}
				};
				Collections.sort(list,com);
				printArticle();
			}else if(num == 2) {
				Comparator<SungJukDTOP> com = new Comparator<SungJukDTOP>() {
					public int compare(SungJukDTOP s1, SungJukDTOP s2) {
						return s1.getTot() < s2.getTot() ? -1 : 1;
					}
				};
				Collections.sort(list,com);
				printArticle();
			}else if(num == 3) {
				System.out.println("���θ޴��� ���ư��ϴ�");
				break;
			}
		}
	}
}
