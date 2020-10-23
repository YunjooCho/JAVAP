package collection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukService {
	//3.필드 선언
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();; //또는 생성자에서 생성
	Scanner scanner;
	DecimalFormat df;
	
	
	/* 필드 선언하지 않을경우는 생성자에서 어레이리스트 생성
	public SungJukService(){
		list = new ArrayList<SungJukDTO>();
	}
	 */
	
	
	//4.menu메소드
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("   1.입력");
			System.out.println("   2.출력");
			System.out.println("   3.검색");
			System.out.println("   4.삭제");
			System.out.println("   5.정렬");
			System.out.println("   6.끝");
			System.out.println("*****************");
			System.out.print("번호 : ");
			scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			if(number == 1) {
				insertArticle();
			}else if(number == 2) {
				printArticle();
			}else if(number == 3) {
				searchArticle();
			}else if(number == 4) {
				deleteArticle();
			}else if(number == 5) {
				sortArticle();
			}else if(number == 6) {
				break;
			}else {
				System.out.println("1~6 중에 선택하세요");
			}
			
		}
	}
	
	//5.insertArticle메소드
	public void insertArticle() {//private도 가능
		scanner = new Scanner(System.in);
		SungJukDTO dto = new SungJukDTO();
		System.out.print("번호 입력 : ");
		dto.setNo(scanner.nextInt());
		System.out.print("이름 입력 : ");
		dto.setName(scanner.next());
		System.out.print("국어 입력 : ");
		dto.setKor(scanner.nextInt());
		System.out.print("영어 입력 : ");
		dto.setEng(scanner.nextInt());
		System.out.print("수학 입력 : ");
		dto.setMath(scanner.nextInt());
		dto.calc();
		list.add(dto);
		//이 안에 main()을 넣으면 원래 메뉴메소드가 호출되는 것이 아닌 새로운 메뉴메소드가 생성됨, 원래 메뉴로 돌아가고 싶으면 }가 끝나면
		//자동으로 원래 menu()메소드로 돌아감
		
		//<선생님 풀이>
//		scanner = new Scanner(System.in);
//		System.out.print("번호 입력 : ");
//		int no = scanner.nextInt();
//		System.out.print("이름 입력 : ");
//		String name = scanner.next();
//		System.out.print("국어 입력 : ");
//		int kor = scanner.nextInt();
//		System.out.print("영어 입력 : ");
//		int eng = scanner.nextInt();
//		System.out.print("수학 입력 : ");
//		int math = scanner.nextInt();
//		
//		SungJukDTO dto = new SungJukDTO();
//		dto.setNo(no);
//      dto.setName(name);
//      dto.setKor(kor);
//      dto.setEng(eng);
//      dto.setMath(math);
//		dto.calc();
//		list.add(dto);
	}
	
	//6.printArticle메소드
	public void printArticle() {
//		df = new DecimalFormat("#,###.###");
//		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getNo() + "\t" 
//                    + list.get(i).getName() + "\t"
//                    + list.get(i).getKor()  + "\t"
//                    + list.get(i).getEng()  + "\t"
//                    + list.get(i).getMath()  + "\t"
//                    + list.get(i).getTot()  + "\t"
//                    + df.format(list.get(i).getAvg()));
//		}
		
		//<선생님 풀이>
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list){//toString()오버라이딩 하지 않으면 클래스@16진수가 출력됨 
			System.out.println(dto); 
			}
	}
	
	//7.searchArticle()메소드
	public void searchArticle() {
		int count = 0;
		scanner = new Scanner(System.in);
		System.out.print("검색할 이름 : ");
		String name = scanner.next();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				df = new DecimalFormat("#,###.###");
					System.out.println(list.get(i).getNo() + "\t" 
		                    + list.get(i).getName() + "\t"
		                    + list.get(i).getKor()  + "\t"
		                    + list.get(i).getEng()  + "\t"
		                    + list.get(i).getMath()  + "\t"
		                    + list.get(i).getTot()  + "\t"
		                    + df.format(list.get(i).getAvg()));
				count++;
			}//if문
			
			//<선생님 풀이>
			//int sw = 0; //스위치 변수
			//if(SungJukDTO dto : list{
			//  if(dto.getName().equals(name)){
			//		System.out.pritnln(dto);
			//      sw = 1;  //한번도 같은 값이 나온 적이 없으면 sw = 0임
			//}
		}//for문
		if(count == 0) {
			System.out.println("찾고자 하는 이름이 없습니다.");
		}
	}
	
	//8.deleteArticle()메소드
	public void deleteArticle() { //★처음에만 실행되고 두번째 이후는 안됨, 같은글자가 3개인 경우, 첫번째 두번째 데이터만 지워짐 //지금은 됨 - 선생님께 여쭤보기
		//<내 풀이>
//		int count = 0;
//		for(int i = 0; i < list.size(); i++) {
//			for(int j = 0; j < list.size(); j++) {
//				if(list.get(i).getNo() != list.get(j).getNo() && list.get(i).getName().equals(list.get(j).getName())) {
//					list.remove(i);
//					++count;
//					list.remove(j-count);
//					j = -1;	
//					System.out.println("데이터를 삭제하였습니다");
//				}//if
//		}//for j
//		}//for i
		
		
		//<선생님 풀이>
		System.out.print("삭제할 이름 입력 : ");
		scanner = new Scanner(System.in);
		String name = scanner.next();
		int sw = 0;
//		for(SungJukDTO dto : list) {
//			if(dto.getName().equals(name)) {
//				list.remove(dto);
//				sw = 1;
//			}
//		}
		//java.util.ConcurrentModificationException 에러 발생 이유 : 여러개의 동일한 이름을 가진 객체가 있는 경우
		//먼저 있던 객체(항목)이 삭제되어 인덱스가 재할당됨(인덱스값이 삭제된 데이터 뒤에 것들은 앞으로 당겨짐)
		//해결방법 : Iterator필요
		// 1. Iterator변수가 가리키는 객체를 삭제할 객체 다음객체로 변경
		// 2. 삭제할 객체를 삭제
		//위의 해결방법에 대해, 한글 파일에 개념 그림 있음, 참조할 것
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO dto = it.next();
			if(dto.getName().equals(name)) {
			it.remove();
			sw = 1;
			}
		}
		if(sw == 0) System.out.println("찾고자 하는 이름이 없습니다");
		else System.out.println("데이터를 삭제하였습니다"); //한번만 찍힘
	}
	
	
	
	//9.sortArticle()메소드
	//comparator 혹은 comparable 둘 중 하나 사용하면 됨
	//[comparable] - 인터페이스(java.lang), String클래스
	// 1.DTO에 Comparable을 implements하기
	// 2.DTO에 compareTo()메소드 구현(인터페이스) - 오름차순/내림차순 결정 -1,1을 어떻게 넣을 것인지에 따라 선택가능
	// 3.toString()메소드 오버라이드(출력형식 결정)
	// 4.해당 부분에 Collection.sort(list) 2에서 구현한 내용대로 정렬하도록 입력
	// 5.출력
	//[comparator] - 인터페이스(java.util)
	// 1.Comparator 생성(익명내부클래스 사용) - 오름차순, 내림차순 결정 -1을 compareTo부분에 곱할지 곱하지 않을지에 따라 선택가능
	//    익명내부클래스 사용 이유 : Comparator는 인터페이스이므로 new생성이 불가능
	// 2.Compare메소드, CompareTo메소드를 사용하여 새로운 기준 비교
	// 3.해당 부분에  Collections.sort(list,com) 새로운 기준으로 정렬하도록 입력
	// 4.출력
	public void sortArticle() {
		while(true) {
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴");
			System.out.print("번호 입력 : ");
			scanner =  new Scanner(System.in);
			int num = scanner.nextInt();
			if(num == 1) { //comparator
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2) {
						return s1.getName().compareTo(s2.getName()); //문자열 비교 - String클래스의 compareTo()
					}
				};
				Collections.sort(list,com); //compare()함수를 불러냄(새로 정의한 기준으로 정렬)
				printArticle();
			}else if(num == 2) {//comparable
				Collections.sort(list);//정렬의 기준점을 잡지 않으면 에러가 뜸(DTO에 기준설정)
				                       //comparator 혹은 comparable 둘 중 하나 사용하면 됨(implements 또는 Comparator생성)
				printArticle();
				
				//<선생님 풀이>
//				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
//				@Override
//				public int compare(SungJukDTO s1, SungJukDTO s2) {
//					return s1.getTot() < s2.getTot() ? -1 : 1; - 오름차순 //문자열 비교 - String클래스의 compareTo()
//				    return s1.getTot() < s2.getTot() ? 1 : -1; - 내림차순
//				}
//			    };
//				Collections.sort(list,com);
//				printArticle();
				
			}else if(num == 3) {
				System.out.println("메인 메뉴로 돌아갑니다");
				break;
			}
		}
	}
	
	
}

