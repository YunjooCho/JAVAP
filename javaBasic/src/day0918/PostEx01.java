package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.ArrayUtil;

public class PostEx01 {
	//1. 필드선언
	private static BufferedReader bufferedReader;
	private static Post[] postArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.배열선언
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		postArray = new Post[0];
		
		showMenu();
		
	}

	//2.메뉴 메소드
	private static void showMenu() throws NumberFormatException, IOException {
	
		while(true) {	
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("\t게   시   판\t");
			System.out.println("1.새글작성   2.글목록   3.종료");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("메뉴 선택> ");
			
			//메뉴선택
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//작성하기
				add();
			}else if(userChoice == 2) {
				//목록보기
				printArray();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요!");
			}
			
		}//메뉴 while문	
	}//메뉴 메소드

	
	//3.글을 작성하는 메소드(입력하는 메소드) - 객체정보를 입력하는 메소드
	private static Post setPostInfo() throws IOException {
		Post p = new Post();
		System.out.print("제목: ");
		p.setTitle(bufferedReader.readLine());
		System.out.print("내용: ");
		p.setContents(bufferedReader.readLine());
		System.out.print("작성자: ");
		p.setWriter(bufferedReader.readLine());
		
		return p;
		
	}//setPostInfor메소드
	
	
	//4.확장된 배열에 객체정보를 추가로 입력하는 메소드
	private static void add() throws IOException {
		postArray = ArrayUtil.add(postArray, setPostInfo());
	}
	
	
	//5.작성된 글 목록을 간략하게 보여주는 메소드
	private static void printArray() throws NumberFormatException, IOException {
		
		System.out.printf(" ┌────────────────────┐\n");
		System.out.printf(" │   번호          글제목       │\n");
		System.out.printf(" └────────────────────┘\n");
		for(int i = 0; i < postArray.length; i++) {
		System.out.printf("   %d      %s     \n", (i+1), postArray[i].getTitle());
		}
		System.out.println("개별 열람을 원하는 번호를 선택(0은 전체메뉴로 돌아가기)");
		System.out.print("> ");
		int selectNumber = validateNumber(0, postArray.length) - 1;
		if (selectNumber == -1) {
			System.out.println("전체메뉴로 돌아갑니다");
		}else {
			//상세보기 메소드 호출
			printOne(selectNumber);
		}
		
		
	}//printArray메소드
	
	
	//6.입력 값이 유효한 값인지 확인하는 메소드
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		int number = Integer.parseInt(bufferedReader.readLine()); 
		if( number < minimum || number > maximum) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			number = Integer.parseInt(bufferedReader.readLine()); 
		}
		
		
		return number;
	}
	
	
	//7.상세보기 메소드
	private static void printOne(int index) throws NumberFormatException, IOException {
		
		System.out.printf("<%d번 게 시 글 >\n", (index+1));
		System.out.printf("제목 : %s\n", postArray[index].getTitle());
		System.out.printf("내용 : %s\n", postArray[index].getContents());
		System.out.printf("작성자 : %s\n", postArray[index].getWriter());
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1.수정    2.  삭제    3. 글목록");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("> ");
		int modideleretu = validateNumber(1,3);
		if(modideleretu == 1) {
			update(index);
		}else if(modideleretu == 2) {
			delete(index);
		}else{
			printArray();
		}
	}
	
	
	//8.수정하는 메소드
	private static void update(int index) throws IOException {
		
		System.out.print("제목: ");
		postArray[index].setTitle(bufferedReader.readLine());
		System.out.print("내용: ");
		postArray[index].setContents(bufferedReader.readLine());
		System.out.print("작성자: ");
		postArray[index].setWriter(bufferedReader.readLine());	

		printOne(index);
	}
	
	
	//9.삭제하는 메소드
	private static void delete(int index) throws IOException {
		System.out.println("해당 게시글을 삭제하시겠습니까?(Y/N)");
		System.out.print("> ");
		String yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			postArray = ArrayUtil.removeByIndex(postArray, index);
			printArray();
		}else if(yn.equals("N")) {
			printOne(index);
		}else {
			System.out.println("잘못 선택하셨습니다. 다시 선택하세요.");
		}
	}

}//PostEx01클래스






