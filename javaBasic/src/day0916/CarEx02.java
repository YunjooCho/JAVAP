package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//����ڷκ��� ���� ������ �Է¹ް� ����ϴ� ���α׷��� �ۼ��ϼ���
//���� 1. ���� �ƹ��� ������ ���ٸ� ����� ���� �ʰ� �Ͻÿ�
//���� 2. ���ѷ����� ���ؼ� �Է°� ����� ����ڰ� �����ϴ� ��ŭ �ݺ��ϰ� ���弼��

//����:
//1. �Է� 2. ��� 3. ���� : 1
//���� ��ȣ��? (00�� 0000)
//���� ������ .....
//���� ������? (������)
//�Է¿Ϸ�
//1. �Է� 2. ��� 3. ���� : 2 
//(������ ������ ��µ�)

//20�б���
public class CarEx02 {
	
	//1.�޴� �޼ҵ�
	public static void showMenu() {
		
		System.out.println("============================");
		System.out.print("1.�Է�   2.���    3. ����  : ");

	}
	
	
	public static void main(String[] args) throws IOException {
	 //2. Ű���� �Է� �޸� ����
	 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	 CarT c = new CarT();
	 //3.�޴����
	 while(true) {
		 
		 showMenu();
		 int choice = Integer.parseInt(bufferedReader.readLine());
		 if(choice == 1) {
			 
			 //���� ���� �Է�
			 System.out.print("��ȣ: ");
			 c.setNumber(bufferedReader.readLine());
			 System.out.print("����: ");
			 c.setType(bufferedReader.readLine());
			 System.out.print("����: ");
			 c.setYear(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("����: ");
			 c.setPrice(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("����: ");
			 c.setColor(bufferedReader.readLine());
			 //�ڳ��߿� �޼ҵ�� �Է��ϵ��� �غ��� insertCarinfo(bufferedReader);
			 
		 }else if(choice == 2) {
			 //4. ���� ���� ���
			 //���� c�� �ʵ尪�� 0�̰ų� ""�̸� �ƹ��� ������ �Էµ��� �ʾҴٴ� ���̹Ƿ�
			 //���޽����� ����Ѵ�
			 //null�� �ƴ� ������ CarT.java���� �ʱ�ȭ�Ͽ� null���� ����
			 if(c.getYear() == 0) {
				 System.out.println("���� �Էµ� ������ �����ϴ�");
			 }else {
				 c.printInfo();//CarT.java�� �ۼ��� �޼ҵ�
			 }
			 
		 }else if(choice == 3) {
			 System.out.println("������ּż� �����մϴ�");
			 break;
		 }else{
			 System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �����ϼ���.");
		 }
		 
	 
	 }//�޴��ݺ� while
	 
	}
	
	

//	//�ڳ��߿� �޼ҵ�� �Է��ϵ��� �غ���
//	//2.�Է� �޼ҵ�
//	public static void insertCarinfo(BufferedReader bufferedReader) throws IOException {
//		
//		String yn = new String();
//		do{
//		
//		System.out.print("���� ��ȣ��? ");
//		c.setNumber(bufferedReader.readLine());
//		System.out.print("���� ������? ");
//		c.setType(bufferedReader.readLine());
//		System.out.print("���� ������? ");
//		c.setColor(bufferedReader.readLine());
//	
//		System.out.println("�Է��� �����Ͻðڽ��ϱ�(Y/N)?");
//		yn = bufferedReader.readLine().toUpperCase();
//		
//		}while(yn.equals("Y"));
//			System.out.println("�Է��� �����մϴ�");
//	     
//		
//		
//		
//	}
	

}
