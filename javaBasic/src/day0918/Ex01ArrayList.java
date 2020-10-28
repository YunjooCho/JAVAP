package day0918;

import java.util.ArrayList;

import day0916.CarT;

//ArrayUtil의 단점:
//우리가 필요할 때마다 매번 비슷한 메소드를 또 만들어주어야 한다.
//지금은 Student 배열과 Car 배열만 동적할당이 가능하다.
//만약 우리가 게시판을 만들면? 또 해당하는 메소드를 만들어주어야 하고
//회원도 만들어주어야 한다.
//편한 방법 없을까?
public class Ex01ArrayList {
	public static void main(String[] args) {
	//이전 배열의 동적할당(CarT, Student, Post)은 매번 매소드를 만들어 줘야함(ArrayUtil참조)
		
	//자바에는 ArrayList라는 클래스가 존재한다
	//이 ArrayList는 우리가 동적할당으로 구현해놨던 모든 기능들을 가지고 있다.
	//또한 템플릿이라는 것을 사용해서
	//모든 클래스를 동적할당 메소드로 따로 구현하지 않아도 사용이 가능하다.
	
	//ArrayList를 쓸 때 주의할 점 2가지
	//1. 템플릿에는 클래스만 들어올 수 있다.
	//   Q)기본형 데이터 타입은 어레이리스트로 사용할수 없는가?
	//   A)기본형 데이터 타입은 사용하지 못한다.
	//	   그래서 자바가 기본형 데이터타입을 클래스처럼 만들어 놓은 포장 클래스(warpper 클래스)가 존재.
	//    int -> Integer, double -> Double 등등
	//2. ArrayList는 내부적으로 해당 클래스의 equals()메소드를 적극적으로 사용하기 때문에
	//	  우리가 만든 클래스에 equals()메소드를 정확하게 구현하는 것이 중요하다.
	
	//어레이리스트는 java.util 패키지에 있으므로 우리가 import해야한다.
	
	//어레이리스트를 선언하기
	//ArrayLise<클래스이름> list = new ArrayList<>();
	ArrayList<CarT> carList = new ArrayList<>();
	
	CarT c1 = new CarT("a", "typeA", 2000, 1000000, "a"); //생성자(파라미터가 있는 생성자)
	CarT c2 = new CarT("b", "typeB", 2001, 2000000, "b"); //생성자
	CarT c3 = new CarT("c", "typeC", 2002, 3000000, "c"); //생성자
	CarT c4 = new CarT("d", "typeD", 2003, 4000000, "d"); //생성자
	CarT c5 = new CarT("e", "typeE", 2004, 5000000, "e"); //생성자
	
	//1.배열의 현재크기를 알아볼 때는 size()를 이용하면 된다.
	System.out.println("carList.size(): " + carList.size());
	
	//2.어레이리스트에 새로운 객체를 추가할때에는 add(객체)를 이용하면 된다.(동적할당)
	carList.add(c1);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c2);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c3);
	System.out.println("carList.size(): " + carList.size());
	carList.add(c4);
	System.out.println("carList.size(): " + carList.size());
	
	//3.어레이리스트에서 해당 위치에 있는 객체를 호출할 땐 get(index) 메소드를 사용하면 된다
	System.out.println("carList.get(1): " + carList.get(1)); //CarT클래스에서 만든 toString()의 형식으로 가져옴
	//get으로 호출한 객체는 배열의 몇번째 칸에 있는 객체이다 처럼 우리가 그 객체의 메소드를 실행해 줄 수 있다
	System.out.println("carList.get(0).getType(): " + carList.get(0).getType()); //해당 배열안 객체주소의 type변수값만 가져옴
	
	//4.어레이리스트에서 객체를 제거할 때에는 2가지 방법이 가능하다
	//	A)인덱스로 삭제하기(오버로딩1)
	//	    인덱스로 삭제할 때에는 remove(index)를 하면 된다.
	System.out.println("carList.get(0) : " + carList.get(0));
	carList.remove(0);//remove오버로딩1 - removeByIndex
	System.out.println("carList.get(0) : " + carList.get(0));
	//	B)객체로 삭제하기(오버로딩2)
	//    객체로 삭제할 때에는 해당 객체와 equals()가 true가 나오는 객체를 넣어주면 된다 
	//이전에는 removeByIndex()메소드의 파라미터와 비교하여 삭제
	CarT c44 = new CarT("d", "typeD", 2003, 4000000, "d"); //생성자, 배열에 추가 됨(동적할당)
	CarT c55 = new CarT("e", "typeE", 2004, 5000000, "e"); //생성자, 배열에 추가 됨(동적할당)
	
	System.out.println("c4.equals(c44) : " + c4.equals(c44)); //결과값 : true
	System.out.println("carList.get(2) : " + carList.get(2)); //2를 넣은 이유는 앞에서 [0]을 삭제했기 때문에 앞으로 한칸 땡겨짐
	System.out.println("carList.size(): " + carList.size());
	carList.remove(c44);//c4와 같음, //remove오버로딩2 - removeByElement
	System.out.println("carList.size(): " + carList.size());
	carList.remove(c55);//c5와 같으나 c5는 add해주지 않았으므로 배열에 추가되지 않았음
	System.out.println("carList.size(): " + carList.size());
	//remove에 객체를 집어넣으면
	//ArrayList는 해당 어레이리스트의 처음부터 끝까지
	//파라미터로 넘어온 객체와 각 칸(인덱스)에 equals()를 실행해서
	//true가 나오는 칸(인덱스)을 삭제한다.
	//만약 remove에 넘겨주는 객체랑 equals()가 true가 나오는 객체가 어레이리스트에 없으면
	//아무것도 삭제되지 않는다.
	
	//carList에 있던 애들 : c1, c2, c3, c4
	//remove(0) : c2, c3, c4
	//remove(c44) : c2, c3
	
	//5. carList에서 해당 객체의 index가 궁금하면 indexOf() 메소드를 실행하면 된다.
	System.out.println("carList.indexOf(c2) : " + carList.indexOf(c2));
	//만약 해당 리스트에 그 객체가 존재하지 않으면 -1이 리턴된다
	System.out.println("carList.indexOf(c4) : " + carList.indexOf(c4));//아까 위에서 삭제했기 때문에 c4객체는 없으므로 결과값이 -1
	
	//6. carList에서 해당 객체가 존재하는지 존재하지 않는지를 체크할 때에는 contains() 메소드를 실행하면 된다(메소드 내에 equals()사용)
	System.out.println("carList.contains(c2) : " + carList.contains(c2));//결과값 : true
	System.out.println("carList.contains(c4) : " + carList.contains(c4));//결과값 : false
	
	//따라서, ArrayList를 제대로 사용하고 싶다면,
	//우리가< >안에 넣어줄 클래스에
	//equals()를 정확하게 만들어 주는 것이 중요하다!!!! ★★핵심

	//<CarT만들때 문장>
	//public boolean equals(Object obj) { //같은 패키지의 Ex01Class.java참조 
		//java.lang.Object를 상속 받았기 때문에 생기는 문제 해결
        //줄번호 옆에 역삼각형 : 오버라이드함
		//파라미터로 넘어온 객체가 이 equals메소드를 실행하는 객체와 같은지 비교하려면
		//1. obj가 이 CarT 클래스의 객체인지 확인한다
		//2. obj가 CarT 클래스의 객체가 맞다면
		//   필드 중 몇몇 정보를 비교해서 같을 때에만 (비교하기 위해 형변환 함)
		//   return true 해준다.

		//1. obj가 해당 클래스객체인지 확인할때에는
		//	 instanceof 클래스이름 이란 코드로 확인 가능하다
		//   instanceof : 해당 클래스의 객체인지 아닌지를 확인하는 예약문
	//if(obj instanceof CarT) { //obj가 형변환이 가능하다면(해당 클래스 객체라면!!!!!!!)obj를 형변환 시켜줌
	    //형태 : 객체  + instanceof + 클래스 ->형변환 & 해당 클래스의 객체인지 아닌지 확인
	    //obj가 CarT 클래스의 객체이므로(obj변수의 뜻은 모든 객체)
	    //obj를 카로 형변환 시켜줄 수 있다.
	    //Object obj = new Object();에는 필드가 없음
	//CarT c = (CarT)obj;   //Object에는 필드가 없으므로 클래스를 CarT로 바꿔줌(형변환)
		//아직 부모클래스이므로 자식클래스에 맞게 오버라이딩(number, type에 접근할 수 있게 만들어줌)
	//if(number.equals(c.number)){
		//둘다 CarT의 객체
		//앞에 number는 equals를 실행하는 객체(c2.equals(c3)로 생각해보기 -c2객체의 number), 
		//c.number는 파라미터로 넘어온 obj를 c로 바꾼 number 
	//return true;
	//}
	//}
	//return false;	
	//}
	
	}	

}
