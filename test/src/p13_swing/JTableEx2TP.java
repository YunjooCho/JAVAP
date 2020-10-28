package p13_swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



//1.상속 및 구현, 필드선언
public class JTableEx2TP extends JFrame implements ActionListener{
	
	private ArrayList<PersonDTOP> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton insertBtn, deleteBtn;
	private int count;
	
	//2.생성
	public JTableEx2TP() {
		list = new ArrayList<PersonDTOP>();
		list.add(new PersonDTOP("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTOP("hong2","홍길동","111","010-123-1234"));
		list.add(new PersonDTOP("hong3","홍길동","111","010-123-1234"));
		list.add(new PersonDTOP("conan","코난","333","010-777-7777"));
		
		
		//타이틀(필드명)
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("전화번호");
		
		model = new DefaultTableModel(vector,0) {
			public boolean isCellEditable(int row, int column) {
				return (column != 0) ? true : false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		for(PersonDTOP dto : list) {
			Vector<String> v = new Vector<String>(); 
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			model.addRow(v);
		}
	
		
		insertBtn = new JButton("추가");
		deleteBtn = new JButton("삭제");
		
		JPanel p = new JPanel();
		p.add(insertBtn);
		p.add(deleteBtn);
		
		Container c = this.getContentPane();
		c.add("South",p);
		c.add("Center",scroll);
		
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		 
		setBounds(200, 200, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame 생략가능
	}
	
	
	
	
	//3.오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) {
			insert();
		}else if(e.getSource() == deleteBtn) {
			delete();
		}
		
	}

	
	private void delete() {
		String name = JOptionPane.showInputDialog(this,"삭제할 이름을 입력하세요");
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				count++;
				i = -1;
			}
		}
		if(count == 0) {
			JOptionPane.showMessageDialog(this, "찾는 이름이 없습니다");
		}else {
			JOptionPane.showMessageDialog(this,"삭제 완료!");
		}
		
	}


	private void insert() {
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		
		//취소버튼 또는 창이 닫히면 null
		if(id == null) {
			return;
		}
		if(id.length() == 0) {
			JOptionPane.showMessageDialog(this, "아이디는 필수 항목입니다");
			return;
		}
		
		for(int i = 0; i < model.getRowCount(); i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다");
				return;
			}
		}
		
		String name = JOptionPane.showInputDialog(this,"이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this,"비밀번호를 입력하세요");
		String tel = JOptionPane.showInputDialog(this,"전화번호를 입력하세요");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this,"추가완료");
	}


	public static void main(String[] args) {
		new JTableEx2TP();

	}

}
