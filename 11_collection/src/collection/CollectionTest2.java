package collection;

import java.util.ArrayList;

public class CollectionTest2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); //<E>
		//�߿����ذ� : <String>�� �ָ� ������̼� ��� ����, ������ �� ��ȣ��
		list.add("ȣ����"); //�Է��� ������� �����
		list.add("����");
		list.add("ȣ����"); //�ߺ����, ����
		//list.add(25);   //���ʸ��� String�̶� �� �� ����, ���� ����ϰ� ������ <String>�� ����
		//list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");
		
		list.get(0); //ArrayList�ȿ� get�޼ҵ尡 ����
		for(int i = 0; i < list.size(); i++) { 
			//�迭 - length, ���ڿ� - length(), ��̸���Ʈ - size()
			System.out.println(list.get(i));
		}
		System.out.println("==================================");
		
		for(String data : list) {
			System.out.println(data);
		}
		
		
	}

}

//