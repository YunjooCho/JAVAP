package swing;

import java.awt.Container;
import java.awt.FlowLayout;
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
public class JTableEx2T extends JFrame implements ActionListener {
	//4.어레이리스트 생성
	//6.벡터생성
	private ArrayList<PersonDTO> list;	
	private Vector<String> vector;
	private DefaultTableModel model; //AbstractTableModel 대행, AbstractTableModel는 추상메소드의 오버라이딩이 필요
	private JTable table; 			 //AbstractTableModel 대행
	private JButton insertBtn, deleteBtn;
	private int count;
	
	//list - dto를 모아놓음
	//vector - list는 프레임에 올릴수 없으므로 vector로 옮김
	//그러므로 본래 list도 추가 혹은 삭제 이벤트가 발생시, 수정내용을 반영해야함(그래야 다른 함수에서 출력을 할때 제대로 내용이 반영되서 나옴)
	
	public JTableEx2T() {
		
		//5.데이터입력
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("hong2","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("hong3","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("conan","코난","333","010-777-7777"));
		
		//7.타이틀
		vector = new Vector<String>();
		vector.addElement("아이디"); 
		//add()와 addelement()의 차이 : 
		//하는 일은 두가지 다 완전히 동일합니다. 두 메쏘드 다 벡터 객체에 직접 sync 를 잡습니다.
		//다만 addElement 는 벡터에만 있는 API 셋이고 add 는 JDK 1.2 에 추가된 Collection 인터페이스를 구현한 것으로 
		//add 를 쓰는 편이 일반적으로 더 나은 선택이라고 할 수 있겠습니다. 
		//하지만 JDK 1.1 에서 돌아가는 애플릿을 만들 생각이시라면 addElement 를 쓰는 수 밖에 없겠죠.
		//Collection 의 add 는 엘리먼트의 추가 작업의 성공 여부를 boolean 으로 리턴합니다(vector 의 경우 항상 true). 
		//addElement 는 따로 리턴값이 없습니다.
		vector.addElement("이름");
		vector.add("비밀번호"); //true반환 - 윗 설명참조
		vector.add("핸드폰");  //true반환 - 윗 설명참조
		
		
		//8.테이블 생성
		model = new DefaultTableModel(vector, 0) { //AbstractTableModel과 다른 메소드(같은 유형)
			//0대신 1을 넣으면 칸이 하나 생김, 수정가능함, celleditable을 사용하기 위해 익명내부클래스 생성
			@Override
			public boolean isCellEditable(int r, int c) { //row, column
				return (c!=0)? true : false; //수정할 수 있다 없다, 0번째 id가 들어가는 방은 수정할 수 없게 설정
											 //0이 아니라면 수정 가능(true), 0이면 수정 불가(false)
			}
		}; 
		table = new JTable(model); //모델을 생성하고 테이블에 넣음(?)
		JScrollPane scroll = new JScrollPane(table);//스크롱에 테이블 붙임
		
		//9.데이터 붙이기
		//객체가 들어있는 어레이리스트는 프레임에 붙일 수 없으므로 어레이리스트의 객체를 벡터에 옮긴 뒤 프레임에 붙임
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //★벡터의 자료 저장 형태... 객체, 배열과 유사
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
		
		
		Container c = this.getContentPane(); //판넬과 스크롤(테이블이 붙어있음)을 콘테이너에 묶음
		c.add("South", p);
		c.add("Center",scroll); //테이블이 붙어있는 스크롤을 프레임에 붙임
		
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
		//리턴값 : 사용자가 입력한 문자열, 취소 버튼이 선택되거나 창이 닫히면 null 리턴
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		//parameter - parentComponent : the parent Component for the dialog & message : the Object to display
		//표시할 곳, 표시할 메시지
		if(id == null) {
			return; //현재 메소드를 빠져나라는 지시
		}
		
		if(id.length() == 0) {
			JOptionPane.showMessageDialog(this, "아이디는 필수 항목입니다");
			return; //현재 메소드를 빠져나라는 지시
		}
		
		//★중복체크 - 사용중인 아이디입니다 : 
		 for(int i = 0; i <model.getRowCount() ; i++) {
			 if(id.equals(model.getValueAt(i,0))) { //비교할 아이디가 있는 부분이 [~~][0]이므로 ~~는 i(데이터 수만큼 아래로 이동), 0은 고정
				 JOptionPane.showMessageDialog(this, "사용중인 아이디입니다");
				 return;
			 }
		 }
		 
		 //아이디 이름
		 //hong 홍길동
		 //conan 코난
		 //angel 천사
		 //hong -> model.getValueAt(0,0)
		 //conan -> model.getValueAt(1,0);
		 //angel -> model.getValueAt(2,0);
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this, "패스워드를 입력하세요");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요(XXX-XXX-XXXX)");
		
		Vector<String> v = new Vector<String>(); //리스트에 집어넣기
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v); //모델의 행에 vector(객체?)추가
		JOptionPane.showMessageDialog(this, "추가 완료");
		
		
		
	}

	//12. 삭제함수
	private void delete() {
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		if(name == null) return;
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))){//1은 이름이 들어있는 열
				model.removeRow(i);
				count++;
				i = -1; //i--;
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
		new JTableEx2T();
		

	}

}
