package day0918;

import java.util.ArrayList;

import day0916.CarT;

//ArrayUtil�� ����:
//�츮�� �ʿ��� ������ �Ź� ����� �޼ҵ带 �� ������־�� �Ѵ�.
//������ Student �迭�� Car �迭�� �����Ҵ��� �����ϴ�.
//���� �츮�� �Խ����� �����? �� �ش��ϴ� �޼ҵ带 ������־�� �ϰ�
//ȸ���� ������־�� �Ѵ�.
//���� ��� ������?
public class Ex01ArrayList {
	public static void main(String[] args) {
	//���� �迭�� �����Ҵ�(CarT, Student, Post)�� �Ź� �żҵ带 ����� �����(ArrayUtil����)
		
	//�ڹٿ��� ArrayList��� Ŭ������ �����Ѵ�
	//�� ArrayList�� �츮�� �����Ҵ����� �����س��� ��� ��ɵ��� ������ �ִ�.
	//���� ���ø��̶�� ���� ����ؼ�
	//��� Ŭ������ �����Ҵ� �޼ҵ�� ���� �������� �ʾƵ� ����� �����ϴ�.
	
	//ArrayList�� �� �� ������ �� 2����
	//1. ���ø����� Ŭ������ ���� �� �ִ�.
	//   Q)�⺻�� ������ Ÿ���� ��̸���Ʈ�� ����Ҽ� ���°�?
	//   A)�⺻�� ������ Ÿ���� ������� ���Ѵ�.
	//	   �׷��� �ڹٰ� �⺻�� ������Ÿ���� Ŭ����ó�� ����� ���� ���� Ŭ����(warpper Ŭ����)�� ����.
	//    int -> Integer, double -> Double ���
	//2. ArrayList�� ���������� �ش� Ŭ������ equals()�޼ҵ带 ���������� ����ϱ� ������
	//	  �츮�� ���� Ŭ������ equals()�޼ҵ带 ��Ȯ�ϰ� �����ϴ� ���� �߿��ϴ�.
	
	//��̸���Ʈ�� java.util ��Ű���� �����Ƿ� �츮�� import�ؾ��Ѵ�.
	
	//��̸���Ʈ�� �����ϱ�
	//ArrayLise<Ŭ�����̸�> list = new ArrayList<>();
	ArrayList<CarT> carList = new ArrayList<>();
	
	CarT c1 = new CarT("a", "typeA", 2000, 1000000, "a"); //������(�Ķ���Ͱ� �ִ� ������)
	CarT c2 = new CarT("b", "typeB", 2001, 2000000, "b"); //������
	CarT c3 = new CarT("c", "typeC", 2002, 3000000, "c"); //������
	CarT c4 = new CarT("d", "typeD", 2003, 4000000, "d"); //������
	CarT c5 = new CarT("e", "typeE", 2004, 5000000, "e"); //������
	
	//1.�迭�� ����ũ�⸦ �˾ƺ� ���� size()�� �̿��ϸ� �ȴ�.
	System.out.println("carList.size(): " + carList.size());
	
	//2.��̸���Ʈ�� ���ο� ��ü�� �߰��Ҷ����� add(��ü)�� �̿��ϸ� �ȴ�.(�����Ҵ�)
	carList.add(c1);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c2);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c3);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c4);
	System.out.println("carList.size(): " + carList.size());
	
	//3.��̸���Ʈ���� �ش� ��ġ�� �ִ� ��ü�� ȣ���� �� get(index) �޼ҵ带 ����ϸ� �ȴ�
	System.out.println("carList.get(1): " + carList.get(1)); //CarTŬ�������� ���� toString()�� �������� ������
	//get���� ȣ���� ��ü�� �迭�� ���° ĭ�� �ִ� ��ü�̴� ó�� �츮�� �� ��ü�� �޼ҵ带 ������ �� �� �ִ�
	System.out.println("carList.get(0).getType(): " + carList.get(0).getType()); //�ش� �迭�� ��ü�ּ��� type�������� ������
	
	//4.��̸���Ʈ���� ��ü�� ������ ������ 2���� ����� �����ϴ�
	//	A)�ε����� �����ϱ�(�����ε�1)
	//	    �ε����� ������ ������ remove(index)�� �ϸ� �ȴ�.
	System.out.println("carList.get(0) : " + carList.get(0));
	carList.remove(0);//remove�����ε�1 - removeByIndex
	System.out.println("carList.get(0) : " + carList.get(0));
	//	B)��ü�� �����ϱ�(�����ε�2)
	//    ��ü�� ������ ������ �ش� ��ü�� equals()�� true�� ������ ��ü�� �־��ָ� �ȴ� 
	//�������� removeByIndex()�޼ҵ��� �Ķ���Ϳ� ���Ͽ� ����
	CarT c44 = new CarT("d", "typeD", 2003, 4000000, "d"); //������, �迭�� �߰� ��(�����Ҵ�)
	CarT c55 = new CarT("e", "typeE", 2004, 5000000, "e"); //������, �迭�� �߰� ��(�����Ҵ�)
	
	System.out.println("c4.equals(c44) : " + c4.equals(c44)); //����� : true
	System.out.println("carList.get(2) : " + carList.get(2)); //2�� ���� ������ �տ��� [0]�� �����߱� ������ ������ ��ĭ ������
	System.out.println("carList.size(): " + carList.size());
	carList.remove(c44);//c4�� ����, //remove�����ε�2 - removeByElement
	System.out.println("carList.size(): " + carList.size());
	carList.remove(c55);//c5�� ������ c5�� add������ �ʾ����Ƿ� �迭�� �߰����� �ʾ���
	System.out.println("carList.size(): " + carList.size());
	//remove�� ��ü�� ���������
	//ArrayList�� �ش� ��̸���Ʈ�� ó������ ������
	//�Ķ���ͷ� �Ѿ�� ��ü�� �� ĭ(�ε���)�� equals()�� �����ؼ�
	//true�� ������ ĭ(�ε���)�� �����Ѵ�.
	//���� remove�� �Ѱ��ִ� ��ü�� equals()�� true�� ������ ��ü�� ��̸���Ʈ�� ������
	//�ƹ��͵� �������� �ʴ´�.
	
	//carList�� �ִ� �ֵ� : c1, c2, c3, c4
	//remove(0) : c2, c3, c4
	//remove(c44) : c2, c3
	
	//5. carList���� �ش� ��ü�� index�� �ñ��ϸ� indexOf() �޼ҵ带 �����ϸ� �ȴ�.
	System.out.println("carList.indexOf(c2) : " + carList.indexOf(c2));
	//���� �ش� ����Ʈ�� �� ��ü�� �������� ������ -1�� ���ϵȴ�
	System.out.println("carList.indexOf(c4) : " + carList.indexOf(c4));//�Ʊ� ������ �����߱� ������ c4��ü�� �����Ƿ� ������� -1
	
	//6. carList���� �ش� ��ü�� �����ϴ��� �������� �ʴ����� üũ�� ������ contains() �޼ҵ带 �����ϸ� �ȴ�(�޼ҵ� ���� equals()���)
	System.out.println("carList.contains(c2) : " + carList.contains(c2));//����� : true
	System.out.println("carList.contains(c4) : " + carList.contains(c4));//����� : false
	
	//����, ArrayList�� ����� ����ϰ� �ʹٸ�,
	//�츮��< >�ȿ� �־��� Ŭ������
	//equals()�� ��Ȯ�ϰ� ����� �ִ� ���� �߿��ϴ�!!!! �ڡ��ٽ�

	//<CarT���鶧 ����>
	//public boolean equals(Object obj) { //���� ��Ű���� Ex01Class.java���� 
		//java.lang.Object�� ��� �޾ұ� ������ ����� ���� �ذ�
        //�ٹ�ȣ ���� ���ﰢ�� : �������̵���
		//�Ķ���ͷ� �Ѿ�� ��ü�� �� equals�޼ҵ带 �����ϴ� ��ü�� ������ ���Ϸ���
		//1. obj�� �� CarT Ŭ������ ��ü���� Ȯ���Ѵ�
		//2. obj�� CarT Ŭ������ ��ü�� �´ٸ�
		//   �ʵ� �� ��� ������ ���ؼ� ���� ������ (���ϱ� ���� ����ȯ ��)
		//   return true ���ش�.

		//1. obj�� �ش� Ŭ������ü���� Ȯ���Ҷ�����
		//	 instanceof Ŭ�����̸� �̶� �ڵ�� Ȯ�� �����ϴ�
		//   instanceof : �ش� Ŭ������ ��ü���� �ƴ����� Ȯ���ϴ� ���๮
	//if(obj instanceof CarT) { //obj�� ����ȯ�� �����ϴٸ�(�ش� Ŭ���� ��ü���!!!!!!!)obj�� ����ȯ ������
	    //���� : ��ü  + instanceof + Ŭ���� ->����ȯ & �ش� Ŭ������ ��ü���� �ƴ��� Ȯ��
	    //obj�� CarT Ŭ������ ��ü�̹Ƿ�(obj������ ���� ��� ��ü)
	    //obj�� ī�� ����ȯ ������ �� �ִ�.
	    //Object obj = new Object();���� �ʵ尡 ����
	//CarT c = (CarT)obj;   //Object���� �ʵ尡 �����Ƿ� Ŭ������ CarT�� �ٲ���(����ȯ)
		//���� �θ�Ŭ�����̹Ƿ� �ڽ�Ŭ������ �°� �������̵�(number, type�� ������ �� �ְ� �������)
	//if(number.equals(c.number)){
		//�Ѵ� CarT�� ��ü
		//�տ� number�� equals�� �����ϴ� ��ü(c2.equals(c3)�� �����غ��� -c2��ü�� number), 
		//c.number�� �Ķ���ͷ� �Ѿ�� obj�� c�� �ٲ� number 
	//return true;
	//}
	//}
	//return false;	
	//}
	
	}	

}
