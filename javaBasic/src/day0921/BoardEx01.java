package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.ArrayUtil;

//동적할당을 이용한 게시판 프로그램
public class BoardEx01 {
	private static Board[] boardArray;
	private static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		boardArray = new Board[0];
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		showMenu();
	}
	
	
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("게시판 프로그램");
			System.out.println("1. 입력  2. 목록보기  3. 종료");
			System.out.print("> ");
			int choice = Integer.parseInt(bufferedReader.readLine());
			if(choice == 1) {
				insertBoard();
			}else if(choice == 2) {
				selectAll();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}//showMenu
	
	
	private static void insertBoard() throws NumberFormatException, IOException{
		boardArray = ArrayUtil.add(boardArray, setBoardInfo());
	}
	
	
	private static Board setBoardInfo() throws NumberFormatException, IOException {
		Board b = new Board();
		
		System.out.println("게시글 번호: ");
		b.setId(Integer.parseInt(bufferedReader.readLine()));
		System.out.println("게시글 제목: ");
		b.setContent(bufferedReader.readLine());
		System.out.print("게시글 내용: ");
	    b.setContent(bufferedReader.readLine());
		System.out.println("작성자: ");
		b.setWriter(bufferedReader.readLine());
		
		return b;
	}//setBoardInfo
	
	
	private static void selectAll() throws NumberFormatException, IOException{
		System.out.println("=========");
		System.out.println("번호  |  제목");
		for(int i = 0; i < boardArray.length; i++) {
			System.out.printf("%d. %s\n", (i+1), boardArray[i].getTitle());
			
		}//for
		System.out.println("상세보기 할 번호 (0은 메뉴로)");
		int choice = validateNumber(0, boardArray.length) - 1;
		if(choice == -1) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {
			selectOne(choice);
		}
	}//selectAll
	
	
	
	private static void selectOne(int index) throws NumberFormatException, IOException {
		Board b= boardArray[index]; //boardArray[index]는 객체
		System.out.println("글번호 : " + b.getId());
		System.out.println("제목 : " + b.getTitle());
		System.out.println("작성자 : " + b.getWriter());
		System.out.println("내용 : " + b.getContent());
		System.out.println("1. 수정 2. 삭제 3.메뉴로");
		int choice = validateNumber(1,3);
		if(choice == 1) {
			update(index);
		}else if(choice == 2){
			deleteIndex(index);
		}else if(choice == 3) {
			selectAll();
		}
	}//selsectOne
	
	
	private static void update(int index) throws IOException {
		System.out.println("제목: ");
		boardArray[index].setTitle(bufferedReader.readLine());
		System.out.println("내용: ");
		boardArray[index].setContent(bufferedReader.readLine());
		System.out.println("작성자: ");
		boardArray[index].setWriter(bufferedReader.readLine());
		selectOne(index);
	}//update
	
	
	private static void deleteIndex(int index) throws IOException {
		System.out.println("정말로 해당 글을 지우시겠습니까? (y/n)");
		String yn = bufferedReader.readLine();
		if(yn.equals("y")) {
			boardArray = ArrayUtil.removeByIndex(boardArray, index);
		}else if(yn.equals("n")){
			selectOne(index);
		}
		
	}
	
	
	
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException{
		System.out.print("> ");
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("> ");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		return value;
	}//validateNumber
}
