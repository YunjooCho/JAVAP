package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("���� �� = ");
		for(String data : ar) {
			System.out.println(data + " ");
		}
		System.out.println();
		
		Arrays.sort(ar); //'�迭'�� �Ѱ��ָ� �ڵ����� ������� ����
		
		System.out.println("���� �� = ");
		for(String data : ar) {
			System.out.println(data + " ");
		}
		System.out.println("\n");
		
		
		PersonDTO aa =  new PersonDTO("ȫ�浿", 25); //aa,bb,cc - ��������, �ּҰ��� ��� ����
		PersonDTO bb =  new PersonDTO("��ġ", 40);
		PersonDTO cc =  new PersonDTO("�����", 30);
		//���� �������� �����Ƿ� PersonDTO���� ���� :compareTo(PersonDTO o) 
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("���� �� = " + list);
		//��°� : [collection.PersonDTO@15db9742, collection.PersonDTO@6d06d69c, collection.PersonDTO@7852e922]
		//toString���� �������̵�
//		Test t = new Test();
//		System.out.println(t);
		
		System.out.println("\n���̷� ���� - ��������");
		Collections.sort(list); //DTO���Ͽ��� Comparable�������̽��� implements�ؾ� ��
								//�迭 - Arrays�� ����, ��̸���Ʈ��(�迭�ƴ�) Collection
			                    //�Ǵ� Comporator�� ����Ͽ� ���ο� ������ �����ְ� �ش� �������� ����, �̶� sort�� �Ű������� 2��
		                        //Collection.sort(list,com) - com�� ���ο� ������ ������ ��ü
		System.out.println("���� �� = " + list);
		System.out.println();
		
		
		
		//���ı����� �̸����� ���� - ���ο� ������ �����
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {//(Comparator)
			//Comparator�� �������̽��̹Ƿ� new���� �� �� ���� ->compare()�޼ҵ� �������̵��Ͽ� �ذ�
			public int compare(PersonDTO p1, PersonDTO p2) {//�������̵�
				return p1.getName().compareTo(p2.getName()) * -1; //��ü���� ���� �Ѿ, ��������(���⿡ -1�� ���ϸ� ���������� ��)
			}
		}; 
		//���⼭ ���� DTO�� �������̵��� compareTo�� ������������ ����Ǿ��� ���, -1�� �ϸ� �ٽ� ���������� ��?
		//���� �������� �ٰ��� ���
		System.out.println("\n�̸����� ��� - ��������");
		Collections.sort(list,com); //�⺻ �������� �ƴ� ����ڰ� ������ ���������� �����ϵ��� ��(com) - Comparator
		System.out.println("���� �� = " + list);
	}
}
