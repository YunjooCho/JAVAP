//package day0916P;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import day0916.CarT;
//
//
//
//public class CarEx04Array02 {
//	private static int SIZE = 3;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		//����ڰ� �Է��� ������ Car ��ü�� ����
//		//Car�迭�� ����ִ� ĭ�� �ְ�
//		//����ִ� ĭ�� ������ "�� ĭ�� �����ϴ�"��� ������ ���α׷��� ������
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		CarT[] carArray = new CarT[SIZE];
//		
//		while(true) {
//			System.out.print("1. �Է�  2. ���  3. ���� : ");
//			int userChoice = Integer.parseInt(bufferedReader.readLine());
//			//���� �Է��� ������ ��
//			//��ĭ���� �ƴ����� ��� �� �� ������?
//			if(userChoice == 1) {
//				int index;// = -1; //->?????????????????
//				for(int i = 0; i < carArray.length; i++) { //[0][1][2]������ ���� null�̸� 
//					if(carArray[i] == null) {
//						index = i;
//						 System.out.println("i: " + i + "index: " + index);
//					}else {
//						index = -1;
//					}
//				}
//				if(index == -1) {
//					System.out.println("��ĭ�� �����ϴ�.");
//				}else {
//					CarT c = new CarT();
//					System.out.print("��ȣ : ");
//					c.setNumber(bufferedReader.readLine());
//					System.out.print("���� : ");
//					c.setType(bufferedReader.readLine());
//					System.out.print("���� : ");
//					c.setYear(Integer.parseInt(bufferedReader.readLine()));
//					System.out.print("���� : ");
//					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
//					System.out.print("���� : ");
//					c.setColor(bufferedReader.readLine());
//					carArray[index] = c;
//					
//				}
////				if(index == -1) {
////					System.out.println("��ĭ�� �����ϴ�.");
////				}else {
////					CarT c = new CarT();
////					System.out.print("��ȣ : ");
////					c.setNumber(bufferedReader.readLine());
////					System.out.print("���� : ");
////					c.setType(bufferedReader.readLine());
////					System.out.print("���� : ");
////					c.setYear(Integer.parseInt(bufferedReader.readLine()));
////					System.out.print("���� : ");
////					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
////					System.out.print("���� : ");
////					c.setColor(bufferedReader.readLine());
////					carArray[index] = c;
////					
////				}
//			}else if(userChoice == 2) {
//				//���
//				//�Է°��� �ִ��� ������ Ȯ��
////				if(c.setNumber == 0) {
////					
////				}
//			}else if(userChoice == 3){
//				System.out.println("������ּż� �����մϴ�");
//				break;
//			}else {
//				System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� ������ �ּ���");
//			}
//			
//		}//�޴��� while
//	}
//}
