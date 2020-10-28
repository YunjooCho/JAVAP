package controllerP;

import java.util.ArrayList;

import modelP.BoardDTOP;

public class BoardControllerP {

	//13.게시된 글을의 어레이리스트 생성
	private ArrayList<BoardDTOP> list;
	
	public BoardControllerP() {
		list = new ArrayList<>();
	}
	
	//14.임시리스트 생성
	public ArrayList<BoardDTOP> sellectAll(){
		ArrayList<BoardDTOP> temp = new ArrayList<>();
		temp.addAll(list);
		return temp;
	}
	
	//15.게시글 추가 메소드(viewer에서 작성한 내용을 추가함)
	public void add(BoardDTOP b) {
		list.add(b);
	}
	
	//16.게시글 내용을 출력하는 메소드
	public BoardDTOP selectOne(int index) {
		return list.get(index);
	}
	
	//17.게시글을 수정하는 메소드
	public BoardDTOP update(int index, BoardDTOP b) {
		return list.set(index, b);
	}
	
	//18.게시글을 삭제하는 메소드
	public BoardDTOP delete(int index) {
		return list.remove(index);
	}
}
