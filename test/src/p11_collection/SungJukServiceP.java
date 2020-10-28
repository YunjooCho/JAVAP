package p11_collection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukServiceP {
	//3.필드 선언
	private ArrayList<SungJukDTOP> list;
	private Scanner scanner;
	DecimalFormat df;
	
	//4.생성자(어레이리스트 생성)
	public SungJukServiceP() {
		list = new ArrayList<SungJukDTOP>();
	}
	
	//5.메뉴 메소드
	public void menu() {
		while(true) {
			System.out.println();
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
	
	//6.입력메소드
	public void insertArticle() {
		scanner = new Scanner(System.in);
		SungJukDTOP dto = new SungJukDTOP();
		System.out.print("번호 입력 : ");
		int no = scanner.nextInt();
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어 점수 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 점수 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 점수 : ");
		int math = scanner.nextInt();
		dto.calc();
		list.add(dto);
	}
	
	//7.출력메소드
	public void printArticle() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTOP dto : list) {
			System.out.println(dto);
		}
	}
	
	
	//8.검색 메소드
	public void searchArticle() {
		scanner = new Scanner(System.in);
		int sw = 0;
		System.out.print("검색할 이름을 입력 : ");
		String name = scanner.next();
		for(SungJukDTOP dto : list) {
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			if(dto.getName().equals(name)) {
				System.out.println(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("찾고자하는 이름이 없습니다");
		}
	}
	
	//9.삭제 메소드
	public void deleteArticle() {
		scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력 : ");
		String name = scanner.next();
		int sw = 0;
		for(SungJukDTOP dto : list) {
			if(dto.getName().equals(name)) {
				list.remove(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("찾고자 하는 이름이 없습니다");
		}else {
			System.out.println("데이터를 삭제하였습니다");
		}
	}
	
	
	//10.정렬메소드
	public void sortArticle() {
		while(true) {
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴");
			System.out.print("번호 입력 : ");
			scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			
			if(num == 1) {
				Comparator<SungJukDTOP> com = new Comparator<SungJukDTOP>() {
					@Override
					public int compare(SungJukDTOP s1, SungJukDTOP s2) {
						return s1.getName().compareTo(s2.getName());
					}
				};
				Collections.sort(list,com);
				printArticle();
			}else if(num == 2) {
				Comparator<SungJukDTOP> com = new Comparator<SungJukDTOP>() {
					public int compare(SungJukDTOP s1, SungJukDTOP s2) {
						return s1.getTot() < s2.getTot() ? -1 : 1;
					}
				};
				Collections.sort(list,com);
				printArticle();
			}else if(num == 3) {
				System.out.println("메인메뉴로 돌아갑니다");
				break;
			}
		}
	}
}
