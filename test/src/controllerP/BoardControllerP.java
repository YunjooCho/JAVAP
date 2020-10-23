package controllerP;

import java.util.ArrayList;

import modelP.BoardDTOP;

public class BoardControllerP {

	//13.�Խõ� ������ ��̸���Ʈ ����
	private ArrayList<BoardDTOP> list;
	
	public BoardControllerP() {
		list = new ArrayList<>();
	}
	
	//14.�ӽø���Ʈ ����
	public ArrayList<BoardDTOP> sellectAll(){
		ArrayList<BoardDTOP> temp = new ArrayList<>();
		temp.addAll(list);
		return temp;
	}
	
	//15.�Խñ� �߰� �޼ҵ�(viewer���� �ۼ��� ������ �߰���)
	public void add(BoardDTOP b) {
		list.add(b);
	}
	
	//16.�Խñ� ������ ����ϴ� �޼ҵ�
	public BoardDTOP selectOne(int index) {
		return list.get(index);
	}
	
	//17.�Խñ��� �����ϴ� �޼ҵ�
	public BoardDTOP update(int index, BoardDTOP b) {
		return list.set(index, b);
	}
	
	//18.�Խñ��� �����ϴ� �޼ҵ�
	public BoardDTOP delete(int index) {
		return list.remove(index);
	}
}
