package controller;

import java.util.ArrayList;

import model.BoardDTO;


//����� ���� Viewer������ ����
public class BoardController {
	
	//��13.�Խõ� �۵��� ��̸���Ʈ ���� / ������
	private ArrayList<BoardDTO> list; //�� ����
	public BoardController() {
		list = new ArrayList<>();
	}
	
	//��15.�Խñ� �߰� �޼ҵ�(��ü�߰�)
	//BoardViewer���� �ۼ��� ������ �߰���
	public void add(BoardDTO b) {
		list.add(b);
	}
	
	//��14. ����ڵ��� ����Ʈ ������ �������� ���ϱ� ���� �ӽø���Ʈ(ī�Ǻ�)�� ����, ��ȯ�ϴ� �޼ҵ� - ĸ��ȭ�� ����� ����
	//      ����, ������ȣ(�ջ� ����)�� ����
	public ArrayList<BoardDTO> selectAll(){ 
		//����ڵ��� ����Ʈ ������ �������� ���ϱ� ���� �ӽø���Ʈ(ī�Ǻ�)�� ����
		ArrayList<BoardDTO> temp = new ArrayList<>();
		temp.addAll(list);//�Ķ���ͷ� �Ѿ�� ��̸���Ʈ�� ��� ������  temp�� �Է�
		return temp;
	}
	
	//��16.�Խñ� ������ ����ϴ� �޼ҵ�(��ü�� �ҷ��� ���� �󼼳��� ��������)
	public BoardDTO selectOne(int index) {
		return list.get(index);
	}
	
	//��17.�Խñ� �����ϴ� �޼ҵ�
	public void update(int index, BoardDTO b) {
		list.set(index, b);//�ش� �ε����� �Ķ���� b�� ����
	}
	
	//��18.�Խñ� �����ϴ� �޼ҵ�
	public void delete(int index) {
		list.remove(index);
	}
}
