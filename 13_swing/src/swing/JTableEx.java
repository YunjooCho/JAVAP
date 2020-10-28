package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


//2. 테이블 작성을 위한 새로운 클래스 생성, 상속
class JTableModel extends AbstractTableModel{ //AbastracTableModel는 추상클래스(용도 : 테이블 작성)
	Object[][] data = {{"Nari", "마루치", new Integer(1234), "옆집친구"},
					   {"One", "오윤아", new Integer(1111), "예쁜이"},
					   {"two", "오윤서", new Integer(2222), "귀염둥이"},
					   {"three","아라치", new Integer(3333), "동아리 친구"}}; //튜플
					   
	String[] name = {"아이디", "이름","비밀번호","구분"}; //필드명 들
			
	
	//3.오버라이딩(반드시 오버라이딩해야 테이블을 생성할 수 있음)
	@Override
	public int getRowCount() { //열, 필수로 {}안을 입력해야 함
		return data.length; // 일인분의 튜플의 갯수
	}

	@Override
	public int getColumnCount() { //행, 필수로 {}안을 입력해야 함
		return name.length; //아이디, 이름, 비밀번호 다 됨
	}

	@Override
	public Object getValueAt(int r, int c) {//필수로 {}안을 입력해야 함  //row, column
		
		return data[r][c];
	}
	
	@Override
	public String getColumnName(int c) {//column의 갯수만큼(배열), 속성명 가져오기
		return name[c];
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { //row, column
		return (c!=0)? true : false; //수정할 수 있다 없다, 0번째(id)가 들어가는 방은 수정할 수 없게 설정
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) { //원하는 위치의 데이터를 가져올수 있음(2차원 배열중 한칸의 값을 가져옴)
													  //숫자, 문자 등 여러가지로 수정할 수 있음
		data[r][c] = ob;
	}
	
}


//1.클래스 상속, 프레임 생성
public class JTableEx extends JFrame {

	JTable table;
	JTableModel model;
	
	
	public JTableEx() {
		model = new JTableModel(); //상단에 만든 테이블 작성 클래스를 생성
		table = new JTable(model); //위에서 모델을 생성한 뒤 값을 받아올지 or 테이블생성과 동시에 모델을 생성할지 결정할 수 있음 (여기는 전자)
		add(new JScrollPane(table)); //아까는 스크롤을 생성, 그 뒤 스크롤을 붙임
									 //지금은 스크롤을 생성하면서 테이블에 붙임-
		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();

	}

}
