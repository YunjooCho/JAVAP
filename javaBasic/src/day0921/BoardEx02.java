package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BoardEx02 {
	
	//1.�ʵ� ����
	private static ArrayList<Board> list;
	private static BufferedReader bufferedReader;
	//int ������ �ϳ� ����
	//���� �� ������ �� ��ȣ�� �ö󰡰�
	//����ڰ� ���� �� �� �� ��ȣ�� ���� �Է��ϴ°� �ƴ϶�
	//�� ������ ���� �޾ƿͼ� ���� ����� ������
	private static int seq = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.�ʵ� �ʱ�ȭ
		list = new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		showMenu();
	}
	
	//3. �޴� �޼ҵ� �ۼ�
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("�Խ��� ���� ���α׷�");
			System.out.println("1.�Է�  2.���  3.����");
			System.out.print("> ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				add();
			}else if(choice == 2) {
				selectAll();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}
			
		}
	}
	
	//6. �迭 ��� �޼ҵ�
	private static void selectAll() throws NumberFormatException, IOException {
		System.out.println("===�۸��===");
		for(int i = 0; i < list.size();i++) {
			System.out.printf("%d. %s\n", (i+1), list.get(i).getTitle()); //->�۹�ȣ �ް� �� �Ϸù�ȣ ����?
		}
		System.out.println("���������� �� ��ȣ�� �Է����ּ���(0�� ��������)");
		int choice = validateNumber(0, list.size()) - 1;
		if(choice == -1) {
			System.out.println("���� �޴��� �̵��մϴ�.");
		}else {
			selectOne(choice);
		}
	}
	
	//7. �󼼺��� �޼ҵ�(6���� ���õ� �ε���)
	private static void selectOne(int index) throws NumberFormatException, IOException {
		Board b = list.get(index);//add()�ʹ� �Ǵٸ� ��ü�� �����ǹǷ� ���� ����
		System.out.println("���� : " + b.getTitle());
		System.out.println("�ۼ��� : " + b.getWriter());
		System.out.println("���� : " + b.getContent());
		System.out.println("=========================");
		System.out.println("1.����  2.����  3.�������");
		int choice = validateNumber(1,3);
		if(choice == 1) {
			update(index);
		}else if(choice == 2) {
			delete(index);
		}else if(choice == 3) {
			selectAll();
		}
	}
	
	//8.7���� ������ �������� �� ȣ��Ǵ� �޼ҵ�(�Է� ���� �����ϱ�)
	private static void update(int index) throws IOException {
		System.out.print("���� : ");
		list.get(index).setTitle(bufferedReader.readLine());
		System.out.print("�ۼ��� : ");
		list.get(index).setWriter(bufferedReader.readLine());
		System.out.print("���� : ");
		list.get(index).setContent(bufferedReader.readLine());
		
		selectOne(index);
	}
	
	
	//9.7���� ������ �������� �� ȣ��Ǵ� �޼ҵ�(�Է� ���� �����ϱ�)
	private static void delete(int index) throws IOException{
		System.out.println("������ �����Ͻðڽ��ϱ�?");
		String yn = bufferedReader.readLine();
		if(yn.equals("y")) {
			list.remove(index);
			selectOne(index);
		}if(yn.contentEquals("n")) {
			selectOne(index);
		}
	}
 	
	//5.�� �ۼ� �޼ҵ�(�Էµ� ������ �迭�� �߰�&�迭�� �Բ� ����)
	private static void add() throws NumberFormatException, IOException{
		Board b = new Board();
		b.setId(seq);
		seq++;
		
		System.out.println("�� ����: ");
		b.setTitle(bufferedReader.readLine());
		
		System.out.println("�� �ۼ���: ");
		b.setWriter(bufferedReader.readLine());
		
		System.out.println("�� ����: ");
		b.setContent(bufferedReader.readLine());
		
		list.add(b);//���⼭ add�� �� �޼ҵ尡 �ƴ� ArrayList�ȿ� ���Ե� add�޼ҵ� 
		            //���� ArrayListBoard�� ���� setInfo() + add() ����
	}
	
	
	//4.��ȿ�� Ȯ�� �޼ҵ� �ۼ�
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException{
		System.out.print("> ");
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			System.out.println("> ");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		return value;
	}//validateNumber
}
