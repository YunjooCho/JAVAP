package controller;

import java.util.ArrayList;

import model.BoardDTO;


//출력은 오직 Viewer에서만 실행
public class BoardController {
	
	//▶13.게시된 글들의 어레이리스트 생성 / 생성자
	private ArrayList<BoardDTO> list; //글 원본
	public BoardController() {
		list = new ArrayList<>();
	}
	
	//▶15.게시글 추가 메소드(객체추가)
	//BoardViewer에서 작성한 내용을 추가함
	public void add(BoardDTO b) {
		list.add(b);
	}
	
	//▶14. 사용자들이 리스트 원본에 접근하지 못하기 위해 임시리스트(카피본)를 생성, 반환하는 메소드 - 캡슐화의 개념과 같음
	//      보안, 정보보호(손상 방지)를 위해
	public ArrayList<BoardDTO> selectAll(){ 
		//사용자들이 리스트 원본에 접근하지 못하기 위해 임시리스트(카피본)를 보냄
		ArrayList<BoardDTO> temp = new ArrayList<>();
		temp.addAll(list);//파라미터로 넘어온 어레이리스트의 모든 내용을  temp에 입력
		return temp;
	}
	
	//▶16.게시글 내용을 출력하는 메소드(객체를 불러와 안의 상세내용 열람가능)
	public BoardDTO selectOne(int index) {
		return list.get(index);
	}
	
	//▶17.게시글 수정하는 메소드
	public void update(int index, BoardDTO b) {
		list.set(index, b);//해당 인덱스에 파라미터 b를 넣음
	}
	
	//▶18.게시글 삭제하는 메소드
	public void delete(int index) {
		list.remove(index);
	}
}
