package p13_swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


//2.테이블 작성을 위한 새로운 클래스 생성, 상속
class JTableModelP extends AbstractTableModel{

	Object[][] data = {{"Nari", "마루치", new Integer(1234), "옆집친구"},
			   {"One", "오윤아", new Integer(1111), "예쁜이"},
			   {"two", "오윤서", new Integer(2222), "귀염둥이"},
			   {"three","아라치", new Integer(3333), "동아리 친구"}}; //튜플
	
	String[] name = {"아이디", "이름","비밀번호","구분"}; //필드명 들
	
	
	//3.오버라이딩(반드시 오버라이딩해야 테이블을 만들 수 있음)
	@Override
	public int getRowCount() {//열, 필수로 입력
		return data.length;
	}

	@Override
	public int getColumnCount() {//행, 필수로 입력
		return name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {//필수로 입력
		return data[rowIndex][columnIndex];
	}
	
	
	public String getColumnName(int column) {
		return name[column];
	}
	
	public boolean isCellEditable(int row, int column) {
		return (column != 0)? true : false;
	}
	
	public void setValueAt(Object ob, int row, int column) {
		data[row][column] = ob;
	}
}


public class JTableExP extends JFrame {
	
	//1.클래스 상속, 프레임 생성
	JTable table;
	JTableModelP model;
	
	public JTableExP() {
		model = new JTableModelP(); //테이블 작성 클래스 생성
		table = new JTable(model); //위에서 모델을 생성한 뒤 값을 받아올지, 테이블 생성과 동시에 모델을 생성할지 결정할 수 있음
		add(new JScrollPane(table)); //스크롤을 생성하면서 테이블에 붙임
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableExP();

	}

}
