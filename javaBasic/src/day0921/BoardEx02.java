package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BoardEx02 {
	
	//1.필드 선언
	private static ArrayList<Board> list;
	private static BufferedReader bufferedReader;
	//int 변수를 하나 만들어서
	//글을 쓸 때마다 그 번호가 올라가고
	//사용자가 글을 쓸 때 글 번호를 직접 입력하는게 아니라
	//그 변수의 값을 받아와서 쓰는 방법을 만들어보자
	private static int seq = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.필드 초기화
		list = new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		showMenu();
	}
	
	//3. 메뉴 메소드 작성
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("게시판 관리 프로그램");
			System.out.println("1.입력  2.출력  3.종료");
			System.out.print("> ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				add();
			}else if(choice == 2) {
				selectAll();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}
			
		}
	}
	
	//6. 배열 출력 메소드
	private static void selectAll() throws NumberFormatException, IOException {
		System.out.println("===글목록===");
		for(int i = 0; i < list.size();i++) {
			System.out.printf("%d. %s\n", (i+1), list.get(i).getTitle()); //->글번호 받고 또 일련번호 셋팅?
		}
		System.out.println("개별보기할 글 번호를 입력해주세요(0은 메인으로)");
		int choice = validateNumber(0, list.size()) - 1;
		if(choice == -1) {
			System.out.println("메인 메뉴로 이동합니다.");
		}else {
			selectOne(choice);
		}
	}
	
	//7. 상세보기 메소드(6에서 선택된 인덱스)
	private static void selectOne(int index) throws NumberFormatException, IOException {
		Board b = list.get(index);//add()와는 또다른 객체가 생성되므로 영향 없음
		System.out.println("제목 : " + b.getTitle());
		System.out.println("작성자 : " + b.getWriter());
		System.out.println("제목 : " + b.getContent());
		System.out.println("=========================");
		System.out.println("1.수정  2.삭제  3.목록으로");
		int choice = validateNumber(1,3);
		if(choice == 1) {
			update(index);
		}else if(choice == 2) {
			delete(index);
		}else if(choice == 3) {
			selectAll();
		}
	}
	
	//8.7에서 수정을 선택했을 때 호출되는 메소드(입력 내용 수정하기)
	private static void update(int index) throws IOException {
		System.out.print("제목 : ");
		list.get(index).setTitle(bufferedReader.readLine());
		System.out.print("작성자 : ");
		list.get(index).setWriter(bufferedReader.readLine());
		System.out.print("내용 : ");
		list.get(index).setContent(bufferedReader.readLine());
		
		selectOne(index);
	}
	
	
	//9.7에서 삭제를 선택했을 때 호출되는 메소드(입력 내용 수정하기)
	private static void delete(int index) throws IOException{
		System.out.println("정말로 삭제하시겠습니까?");
		String yn = bufferedReader.readLine();
		if(yn.equals("y")) {
			list.remove(index);
			selectOne(index);
		}if(yn.contentEquals("n")) {
			selectOne(index);
		}
	}
 	
	//5.글 작성 메소드(입력된 내용을 배열에 추가&배열도 함께 증가)
	private static void add() throws NumberFormatException, IOException{
		Board b = new Board();
		b.setId(seq);
		seq++;
		
		System.out.println("글 제목: ");
		b.setTitle(bufferedReader.readLine());
		
		System.out.println("글 작성자: ");
		b.setWriter(bufferedReader.readLine());
		
		System.out.println("글 내용: ");
		b.setContent(bufferedReader.readLine());
		
		list.add(b);//여기서 add는 본 메소드가 아닌 ArrayList안에 포함된 add메소드 
		            //내가 ArrayListBoard에 만든 setInfo() + add() 형태
	}
	
	
	//4.유효값 확인 메소드 작성
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
