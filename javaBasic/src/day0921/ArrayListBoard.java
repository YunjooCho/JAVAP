package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import util.ArrayUtil;

public class ArrayListBoard {
    //필드선언(어레이 리스트, 버퍼리더)
	private static ArrayList<Board> boardList;
	private static BufferedReader bufferedReader;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//생성자
		boardList= new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		showMenu();
		
	}
	
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("\t게  시  판");
			System.out.println("1.새글작성   2.목록보기   3. 종료");
			int userChoice = validateNumber(1,3);
			if(userChoice == 1) {
				//새글작성
				add();
			}else if(userChoice == 2) {
				//목록보기
				printAll();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다!");
				break;
			}
		}//while
	}//showMenu
	
	
	
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		System.out.print("> ");
		int number = Integer.parseInt(bufferedReader.readLine());
		if(number < minimum || number > maximum) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("> ");
			number = Integer.parseInt(bufferedReader.readLine());
		}
		return number;
	}//validateNumber
	
	
	
	private static Board setBoardInfo() throws NumberFormatException, IOException {
		Board b = new Board();
		System.out.print("글번호 : ");
		b.setId(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("제목 : ");
		b.setTitle(bufferedReader.readLine());
		System.out.print("내용 : ");
		b.setContent(bufferedReader.readLine());
		System.out.print("작성자 : ");
		b.setWriter(bufferedReader.readLine());
		
		return b;
		
	}//setBoardInfo
	
	
	
	private static void add() throws NumberFormatException, IOException {
		boardList.add(setBoardInfo());
	}//add
	
	
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("=========");
		System.out.println("번호  |  제목");
		for(int i = 0; i < boardList.size(); i++) {
			System.out.printf("%d. %s\n", boardList.get(i).getId(), boardList.get(i).getTitle());
		}
		System.out.println("상세보기 할 번호 (0은 메뉴로)");
		int choice = validateNumber(0,boardList.size())-1; //배열리스트 인덱스가 됨
		if(choice == -1) {
			//메뉴로 돌아가기
			System.out.println("처음메뉴로 돌아갑니다.");
		}else {
			printOne(choice);
		}
	}//printAll
	
	
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.println("글번호 : " + boardList.get(index).getId());
		System.out.println("제목 : " + boardList.get(index).getTitle());
		System.out.println("작성자 : " + boardList.get(index).getWriter());
		System.out.println("내용 : " + boardList.get(index).getContent());
		System.out.println("1. 수정 2. 삭제 3.메뉴로");
		int updere = validateNumber(1,3);
		if(updere == 1) {
			update(index);	
		}else if(updere == 2) {
			delete(index);
		}else if(updere == 3) {
			printAll();
		}
	}//printOne
	
	
	
	private static void update(int index) throws IOException {
		
		System.out.print("제목 : ");
		boardList.get(index).setTitle(bufferedReader.readLine());
		System.out.print("내용 : ");
		boardList.get(index).setContent(bufferedReader.readLine());
		System.out.print("작성자 : ");
		boardList.get(index).setWriter(bufferedReader.readLine());
		
		printOne(index);
		
	}
	
	private static void delete(int index) throws NumberFormatException, IOException {
		
		System.out.println("정말로 삭제하시겠습니까?(y/n)");
		String answer = bufferedReader.readLine().toLowerCase();
		if(answer.equals("y")) {
			boardList.remove(index);
			printAll();
		}else if(answer.equals("n")) {
			printOne(index);
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
		}
		
	}

}
