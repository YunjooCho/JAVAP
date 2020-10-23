package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//1.상속 및 구현
public class JTableEx2 extends JFrame implements ActionListener {
	//4.어레이리스트 생성
	//6.벡터생성
	private ArrayList<PersonDTO> list;	//데이터 저장
	private Vector<String> vector;      //필드명 저장
	private DefaultTableModel model; //AbstractTableModel 대행, AbstractTableModel는 추상메소드의 오버라이딩이 필요
	private JTable table; 			 //AbstractTableModel 대행
	private JButton insertBtn, deleteBtn;
	private int count = 0;
	
	public JTableEx2() {
		
		//5.데이터입력
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("conan","코난","333","010-777-7777"));
		
		//7.타이틀
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");
		
		
		//8.
		model = new DefaultTableModel(vector, 0) {//0대신 1을 넣으면 칸이 하나 생김, 수정가능함, celleditable을 사용하기 위해 익명내부클래스 생성
			@Override
			public boolean isCellEditable(int r, int c) { //row, column
				return (c!=0)? true : false; //수정할 수 있다 없다, 0번째 id가 들어가는 방은 수정할 수 없게 설정
			}
		}; 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//9.데이터 붙이기
		//객체가 들어있는 어레이리스트는 프레임에 붙일 수 없으므로 어레이리스트의 객체를 벡터에 옮긴 뒤 프레임에 붙임
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //★벡터의 자료 저장 형태... 객체?, 일렬로 자료 들어감?
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			
			model.addRow(v); //행단위로 데이터를 붙임
		}
		
		//10.버튼 생성
		insertBtn = new JButton("추가");
		deleteBtn = new JButton("삭제");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //안정성(표면상 차이 없음)
		p.add(insertBtn);
		p.add(deleteBtn);
		
		
		Container c = this.getContentPane();
		c.add("South", p);
		c.add("Center",scroll);
		
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		 
		setBounds(200, 200, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame 생략가능
	}
	
	
	//2. 오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) { //길어지므로 함수로 대응
			insert();
		}else if(e.getSource() == deleteBtn) {
			delete();
		}
		
	}
	
	//11. 입력함수
	private void insert() {
		
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		if(id == null || id.length() == 0) {
			JOptionPane.showMessageDialog(this, "아이디는 필수 항목입니다");
			return; //현재 메소드를 빠져나라는 지시
		}
		
		//★중복체크 - 사용중인 아이디입니다
		for(int i = 0; i < list.size(); i++) {
			if(id.equals(list.get(i).getId())) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다");
				return;
				//id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
				//여기에 이걸 넣으면 처음에만 메시지가 뜨고 입력이 안될뿐, 그 다음에는 입력이 가능해짐
			}
		}
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this, "패스워드를 입력하세요");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요(XXX-XXX-XXXX)");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "추가 완료");
		
		
		
	}

	//★12. 삭제함수
	private void delete() {
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
//		Iterator<PersonDTO> it = list.iterator();
//		while(it.hasNext()) {
//			PersonDTO dto = it.next();
//			if(dto.getName().equals(name)) {
//				count++;
//				int index = count;
//				model.removeRow(index);
//				
//				
//			}
//		   	//★2개이상일때 삭제가 안됨
			for(int i = 0; i < list.size(); i++) {
				if(name.equals(list.get(i).getName())) {
					//System.out.println("있따");
					model.removeRow(i);
					count++;
				}
			}
			if(count == 0) {
				JOptionPane.showMessageDialog(this, "없는 이름입니다");
			}else {
				JOptionPane.showMessageDialog(this, "삭제 완료");
			}
			
			
		
		
		
		
		
		//삭제완료
		//없는 이름입니다
		//둘 중 하나가 뜸
		//같은이름이 있으면 둘다 지우기
		//테이블도 삭제하면 인덱스가 바뀜(앞으로 당겨짐)
	}


	
	
	
	//3. PersonDTO생성
	
	
	public static void main(String[] args) {
		new JTableEx2();
		

	}

}
