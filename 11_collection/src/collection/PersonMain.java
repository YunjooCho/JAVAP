package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonMain {

	public void init() {
		PersonDTO aa =  new PersonDTO("ȫ�浿", 25); //aa,bb,cc - ��������, �ּҰ��� ��� ����
		PersonDTO bb =  new PersonDTO("��ġ", 40);
		PersonDTO cc =  new PersonDTO("�����", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //list�� �ּҰ��� �������
		list.add(aa); //get(0)
		list.add(bb); //get(1)
		list.add(cc); //get(2)
		for(int i = 0; i < list.size(); i++) { 
			//�迭 - length, ���ڿ� - length(), ��̸���Ʈ - size()
			//�ڡڿ����� Ȯ���ϱ�, <>�� ���������ϱ� - ���� ��̸���Ʈ �����Ҷ� <>�� �Է����� �ʾҴ��� �Ʒ����� getName(),getAge()�� �ȶ�
			System.out.print("�̸� = " + list.get(i).getName()); 
			System.out.println(" ���� = " + list.get(i).getAge());
		}
		
		//return list;
		
	}
	
	public static void main(String[] args) {
		PersonMain personMain = new PersonMain();
		personMain.init();
	}

}
