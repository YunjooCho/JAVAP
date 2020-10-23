package collection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukService {
	//3.�ʵ� ����
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();; //�Ǵ� �����ڿ��� ����
	Scanner scanner;
	DecimalFormat df;
	
	
	/* �ʵ� �������� �������� �����ڿ��� ��̸���Ʈ ����
	public SungJukService(){
		list = new ArrayList<SungJukDTO>();
	}
	 */
	
	
	//4.menu�޼ҵ�
	public void menu() {
		while(true) {
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
	
	//5.insertArticle�޼ҵ�
	public void insertArticle() {//private�� ����
		scanner = new Scanner(System.in);
		SungJukDTO dto = new SungJukDTO();
		System.out.print("��ȣ �Է� : ");
		dto.setNo(scanner.nextInt());
		System.out.print("�̸� �Է� : ");
		dto.setName(scanner.next());
		System.out.print("���� �Է� : ");
		dto.setKor(scanner.nextInt());
		System.out.print("���� �Է� : ");
		dto.setEng(scanner.nextInt());
		System.out.print("���� �Է� : ");
		dto.setMath(scanner.nextInt());
		dto.calc();
		list.add(dto);
		//�� �ȿ� main()�� ������ ���� �޴��޼ҵ尡 ȣ��Ǵ� ���� �ƴ� ���ο� �޴��޼ҵ尡 ������, ���� �޴��� ���ư��� ������ }�� ������
		//�ڵ����� ���� menu()�޼ҵ�� ���ư�
		
		//<������ Ǯ��>
//		scanner = new Scanner(System.in);
//		System.out.print("��ȣ �Է� : ");
//		int no = scanner.nextInt();
//		System.out.print("�̸� �Է� : ");
//		String name = scanner.next();
//		System.out.print("���� �Է� : ");
//		int kor = scanner.nextInt();
//		System.out.print("���� �Է� : ");
//		int eng = scanner.nextInt();
//		System.out.print("���� �Է� : ");
//		int math = scanner.nextInt();
//		
//		SungJukDTO dto = new SungJukDTO();
//		dto.setNo(no);
//      dto.setName(name);
//      dto.setKor(kor);
//      dto.setEng(eng);
//      dto.setMath(math);
//		dto.calc();
//		list.add(dto);
	}
	
	//6.printArticle�޼ҵ�
	public void printArticle() {
//		df = new DecimalFormat("#,###.###");
//		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getNo() + "\t" 
//                    + list.get(i).getName() + "\t"
//                    + list.get(i).getKor()  + "\t"
//                    + list.get(i).getEng()  + "\t"
//                    + list.get(i).getMath()  + "\t"
//                    + list.get(i).getTot()  + "\t"
//                    + df.format(list.get(i).getAvg()));
//		}
		
		//<������ Ǯ��>
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list){//toString()�������̵� ���� ������ Ŭ����@16������ ��µ� 
			System.out.println(dto); 
			}
	}
	
	//7.searchArticle()�޼ҵ�
	public void searchArticle() {
		int count = 0;
		scanner = new Scanner(System.in);
		System.out.print("�˻��� �̸� : ");
		String name = scanner.next();
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				df = new DecimalFormat("#,###.###");
					System.out.println(list.get(i).getNo() + "\t" 
		                    + list.get(i).getName() + "\t"
		                    + list.get(i).getKor()  + "\t"
		                    + list.get(i).getEng()  + "\t"
		                    + list.get(i).getMath()  + "\t"
		                    + list.get(i).getTot()  + "\t"
		                    + df.format(list.get(i).getAvg()));
				count++;
			}//if��
			
			//<������ Ǯ��>
			//int sw = 0; //����ġ ����
			//if(SungJukDTO dto : list{
			//  if(dto.getName().equals(name)){
			//		System.out.pritnln(dto);
			//      sw = 1;  //�ѹ��� ���� ���� ���� ���� ������ sw = 0��
			//}
		}//for��
		if(count == 0) {
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
		}
	}
	
	//8.deleteArticle()�޼ҵ�
	public void deleteArticle() { //��ó������ ����ǰ� �ι�° ���Ĵ� �ȵ�, �������ڰ� 3���� ���, ù��° �ι�° �����͸� ������ //������ �� - �����Բ� ���庸��
		//<�� Ǯ��>
//		int count = 0;
//		for(int i = 0; i < list.size(); i++) {
//			for(int j = 0; j < list.size(); j++) {
//				if(list.get(i).getNo() != list.get(j).getNo() && list.get(i).getName().equals(list.get(j).getName())) {
//					list.remove(i);
//					++count;
//					list.remove(j-count);
//					j = -1;	
//					System.out.println("�����͸� �����Ͽ����ϴ�");
//				}//if
//		}//for j
//		}//for i
		
		
		//<������ Ǯ��>
		System.out.print("������ �̸� �Է� : ");
		scanner = new Scanner(System.in);
		String name = scanner.next();
		int sw = 0;
//		for(SungJukDTO dto : list) {
//			if(dto.getName().equals(name)) {
//				list.remove(dto);
//				sw = 1;
//			}
//		}
		//java.util.ConcurrentModificationException ���� �߻� ���� : �������� ������ �̸��� ���� ��ü�� �ִ� ���
		//���� �ִ� ��ü(�׸�)�� �����Ǿ� �ε����� ���Ҵ��(�ε������� ������ ������ �ڿ� �͵��� ������ �����)
		//�ذ��� : Iterator�ʿ�
		// 1. Iterator������ ����Ű�� ��ü�� ������ ��ü ������ü�� ����
		// 2. ������ ��ü�� ����
		//���� �ذ����� ����, �ѱ� ���Ͽ� ���� �׸� ����, ������ ��
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO dto = it.next();
			if(dto.getName().equals(name)) {
			it.remove();
			sw = 1;
			}
		}
		if(sw == 0) System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
		else System.out.println("�����͸� �����Ͽ����ϴ�"); //�ѹ��� ����
	}
	
	
	
	//9.sortArticle()�޼ҵ�
	//comparator Ȥ�� comparable �� �� �ϳ� ����ϸ� ��
	//[comparable] - �������̽�(java.lang), StringŬ����
	// 1.DTO�� Comparable�� implements�ϱ�
	// 2.DTO�� compareTo()�޼ҵ� ����(�������̽�) - ��������/�������� ���� -1,1�� ��� ���� �������� ���� ���ð���
	// 3.toString()�޼ҵ� �������̵�(������� ����)
	// 4.�ش� �κп� Collection.sort(list) 2���� ������ ������ �����ϵ��� �Է�
	// 5.���
	//[comparator] - �������̽�(java.util)
	// 1.Comparator ����(�͸���Ŭ���� ���) - ��������, �������� ���� -1�� compareTo�κп� ������ ������ �������� ���� ���ð���
	//    �͸���Ŭ���� ��� ���� : Comparator�� �������̽��̹Ƿ� new������ �Ұ���
	// 2.Compare�޼ҵ�, CompareTo�޼ҵ带 ����Ͽ� ���ο� ���� ��
	// 3.�ش� �κп�  Collections.sort(list,com) ���ο� �������� �����ϵ��� �Է�
	// 4.���
	public void sortArticle() {
		while(true) {
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴�");
			System.out.print("��ȣ �Է� : ");
			scanner =  new Scanner(System.in);
			int num = scanner.nextInt();
			if(num == 1) { //comparator
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2) {
						return s1.getName().compareTo(s2.getName()); //���ڿ� �� - StringŬ������ compareTo()
					}
				};
				Collections.sort(list,com); //compare()�Լ��� �ҷ���(���� ������ �������� ����)
				printArticle();
			}else if(num == 2) {//comparable
				Collections.sort(list);//������ �������� ���� ������ ������ ��(DTO�� ���ؼ���)
				                       //comparator Ȥ�� comparable �� �� �ϳ� ����ϸ� ��(implements �Ǵ� Comparator����)
				printArticle();
				
				//<������ Ǯ��>
//				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
//				@Override
//				public int compare(SungJukDTO s1, SungJukDTO s2) {
//					return s1.getTot() < s2.getTot() ? -1 : 1; - �������� //���ڿ� �� - StringŬ������ compareTo()
//				    return s1.getTot() < s2.getTot() ? 1 : -1; - ��������
//				}
//			    };
//				Collections.sort(list,com);
//				printArticle();
				
			}else if(num == 3) {
				System.out.println("���� �޴��� ���ư��ϴ�");
				break;
			}
		}
	}
	
	
}

