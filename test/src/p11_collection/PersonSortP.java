package p11_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class PersonSortP {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("���� �� = ");
		for(String fruit : ar) {
			System.out.println(fruit + " ");
		}
		System.out.println();
		
		Arrays.sort(ar); //�迭�� �Ѱ��ָ� �ڵ����� ������� ����
		
		System.out.println("���� �� = ");
		for(String fruit : ar) {
			System.out.println(fruit + " ");
		}
		System.out.println();
		
		PersonDTOP aa = new PersonDTOP("����", 15);
		PersonDTOP bb = new PersonDTOP("��ġ", 14);
		PersonDTOP cc = new PersonDTOP("��", 1000);
		
		ArrayList<PersonDTOP> list = new ArrayList<PersonDTOP>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("���� �� = "); //toString�������̵�
		for(PersonDTOP dto : list) {
			System.out.println(dto);
		}
		
		System.out.println("\n���̷� ���� - ��������");
		Collections.sort(list);
		
		System.out.println("���� �� = ");
		for(PersonDTOP dto : list) {
			System.out.println(dto);
		}
		System.out.println();
		
		//���ο� ������ �����
		Comparator<PersonDTOP> com = new Comparator<PersonDTOP>() {
			public int compare(PersonDTOP p1, PersonDTOP p2) {
				return p1.getName().compareTo(p2.getName()); 
			}
		};
		
		System.out.println("\n�̸����� ��� - ��������");
		Collections.sort(list,com);
		System.out.println("���� �� = " + list);
		
	}
}
