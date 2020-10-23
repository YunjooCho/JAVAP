package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonMain {

	public void init() {
		PersonDTO aa =  new PersonDTO("홍길동", 25); //aa,bb,cc - 지역변수, 주소값을 담고 있음
		PersonDTO bb =  new PersonDTO("또치", 40);
		PersonDTO cc =  new PersonDTO("도우너", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //list도 주소값을 담고있음
		list.add(aa); //get(0)
		list.add(bb); //get(1)
		list.add(cc); //get(2)
		for(int i = 0; i < list.size(); i++) { 
			//배열 - length, 문자열 - length(), 어레이리스트 - size()
			//★★왜인지 확인하기, <>의 역할이해하기 - 위에 어레이리스트 선언할때 <>를 입력하지 않았더니 아래에서 getName(),getAge()가 안뜸
			System.out.print("이름 = " + list.get(i).getName()); 
			System.out.println(" 나이 = " + list.get(i).getAge());
		}
		
		//return list;
		
	}
	
	public static void main(String[] args) {
		PersonMain personMain = new PersonMain();
		personMain.init();
	}

}
