package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.BoardController;
import model.BoardDTO;
import model.UserDTO;
import util.InputUtil;

public class BoardViewer {
	//19.필드선언
	private UserDTO logInUser; //본인이 쓴 글만 수정, 삭제가 가능하도록 함
	private BufferedReader bufferedReader;
	private BoardController boardController;
	private int boardId;
	
	//20.생성자
	public BoardViewer() {
			this.logInUser = logInUser;//객체자기자신(this)??????????겟터/셋터와 비교하며 천천히 확인하기 
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			boardController = new BoardController();
			boardId = 1;
	}
	
	//21.로그인 하고 있는 사람의 정보 가져오기?? (본인이 쓴 글만 수정, 삭제가 가능하도록 함)
	public void setLogInUser(UserDTO logInUser) {
		this.logInUser = logInUser;
	}
	
	//22. 글 작성 메소드
	public void writeBoard() throws IOException {
		BoardDTO b = new BoardDTO();
		b.setId(boardId);
		boardId++; //글을 작성할 때마다 하나씩 자동으로 증가(해당 메소드가 호출될때마다 자동으로 증가)
		b.setWriterId(logInUser.getId());
		b.setWriterName(logInUser.getNickname());
		Calendar cal = Calendar.getInstance();
		b.setWrittenDate(cal);
		b.setUpdatedDate(cal); //입력&수정은 똑같은 날짜임(수정과 동시에 입력됨)
		
		System.out.print("제목 : ");
		b.setTitle(bufferedReader.readLine());
		System.out.print("내용 : ");
		b.setContent(bufferedReader.readLine()); //위에서 다 설정되고 아직 설정이 되지 않은 필드가 이 두개.
		
		boardController.add(b);//작성된 내용이 들어간 객체를 반환
		
	}
	
	//23.은 util패키지 InputUtil로 넘어감
	
	//24.
	public void selectAll() throws IOException {
		ArrayList<BoardDTO> list = boardController.selectAll();
		for(int i = 0; i < list.size();i++) {
			System.out.printf("%d. %s\n", i+1, list.get(i).getTitle(), list.get(i).getWriterName());
		}
		System.out.println("상세보기할 번호를 입력해주세요(0은 뒤로)");
		int userChoice = InputUtil.validateInt(0, list.size()) - 1;
		if(userChoice == -1) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {
			selectOne(userChoice);
		}
	}
	
	
	//25.상세정보 보기 메소드
	public void selectOne(int index) throws IOException {
		BoardDTO b = boardController.selectOne(index);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일 H시 m분 s초");
		System.out.println("제목 : " + b.getTitle());
		System.out.println("작성자 : " + b.getWriterName());
		System.out.println("작성일 : " + sdf.format(b.getWrittenDate().getTime()));
		System.out.println("수정일 : " + sdf.format(b.getUpdatedDate().getTime()));
		System.out.println("--------------------------------------------------------");
		System.out.println("내용 : ");
		System.out.println(b.getContent());
		System.out.println("--------------------------------------------------------");
		if(logInUser.getId() == b.getWriterId()) {
			System.out.println("1.수정   2.삭제   3.목록으로"); 
			//로그인 한 사람과 글을 작성한 사람의 회원번호가 같아야만 글수정, 삭제가 가능하게 함
			int userChoice = InputUtil.validateInt(1, 3);
			if(userChoice == 1) {
				update(index);
			}else if(userChoice == 2) {
				delete(index);
			}else if(userChoice == 3) {
				selectAll();
			}
		}else {
			System.out.println("1.목록으로");
			int userChoice = InputUtil.validateInt(1, 1);
			if(userChoice == 1) {
				selectAll();
			}
		}

	}
	
	//26.수정메소드
	public void update(int index) throws IOException {
		BoardDTO b = boardController.selectOne(index);
		Calendar cal = Calendar.getInstance();
		System.out.println("제목 : ");
		b.setTitle(bufferedReader.readLine());
		System.out.println("내용 : ");
		b.setContent(bufferedReader.readLine());
		b.setUpdatedDate(cal);
		boardController.update(index, b);//어디 업데이트 할지, 뭘로 업데이트 할지를 보내줘야하기 때문
		selectOne(index);
		
	}
	
	//27.
	public void delete(int index) throws IOException {
		System.out.println("해당 글을 정말로 삭제하시겠습니까?(Y/N)");
		System.out.print("> ");
		String yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			boardController.delete(index);
			selectAll();
		}else if(yn.equals("N")) {
			selectOne(index);
		}
	}
	

}
