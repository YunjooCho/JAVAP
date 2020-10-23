package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	@SuppressWarnings("all") //◆협박 - 어노테이션
	public static void main(String[] args) {
		//Collection - 인터페이스 & 추상메소드
		Collection coll = new ArrayList(); //implements Collection이 필요없음
										   //일반클래스이기 때문에 WindowAdapter와 달리 익명내부클래스 없이도 new로 생성가능
		//부모                               자식           -> 이렇게 이해할 수도 있음
		//ArrayList implements Collection
		
		coll.add("호랑이"); //입력한 순서대로 저장됨, 제네릭이 없어서 Warning이 뜸
		coll.add("사자");
		coll.add("호랑이"); //중복허용, 순서
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		//Iterator - 항목(요소)하나하나를 가리킬 수 있음
		//hasNext() - 현재 위치에 항목이 있으면 True, 없으면 False
		//next() - 항목을 가져오고 다음 항목으로 이동
		//어디에 만드냐에 따라 사용범위가 달라짐(지금은 Collection안, setter나 다른 클래스에서도 사용가능)
		//Iterator - 지정자, Collection에 지정자를 만듦
		Iterator it = coll.iterator(); //coll(Collection)안에 iterator를 생성하여 배열리스트 항목을 가리키도록 함
		while(it.hasNext()) {//항목이 없을 때까지 반복, 값이 없으면 while문 빠져나감
			System.out.println(it.next()); //각 항목의 값 출력(위에 값을 입력한 순서대로 츌력됨)
		}//while
	}

}


//Collection - Interface
//1.implements : 모든 추상메소드를 반드시 오버라이드 해줘야 함
//  (Collection의 추상메소드는 15개)  
//    ※WindowListener는 7개 -> WindowAdapter는 WindowListener를 대신해서 모두 Override 해줌
//2.익명 inner클래스를 사용 : 모든 추상메소드를 반드시 오버라이드 해줘야 함 (Adapter같은 클래스가 없으므로)
//3.누군가가 대신해서 모든 추상메소드를 Override해줌 : Implementing Classes
//  ArrayList(일반클래스, new로 생성), Stack, Vector. TreeSet(알고리즘) - WindowAdapter(추상클래스,익명내부클래스로 생성)와 같은 역할