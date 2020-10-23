package io;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm extends JFrame implements ActionListener {
	
	//1.필드선언
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputB, printB, searchB, rankB, saveB, loadB;
	private DefaultTableModel model;
	private JTable table;
	private Score score;
	
	
	//2.생성자
	public ScoreForm() {
		
		hakL = new JLabel("학번");
		nameL = new JLabel("이름");
		korL = new JLabel("국어");
		engL = new JLabel("영어");
		mathL = new JLabel("수학");
	
		hakT = new JTextField(21);
		nameT = new JTextField(21);
		korT = new JTextField(21);
		engT = new JTextField(21);
		mathT = new JTextField(21);
		
		inputB = new JButton("입력");
		printB = new JButton("출력");
		searchB = new JButton("학번경력");
		rankB = new JButton("순위");
		saveB = new JButton("파일저장");
		loadB = new JButton("파일읽기");
		
		
		Vector<String> attribute = new Vector<String>();
		attribute.add("학번");
		attribute.add("이름");
		attribute.add("국어");
		attribute.add("영어");
		attribute.add("수학");
		attribute.add("총점");
		attribute.add("평균");
		
		model = new DefaultTableModel(attribute, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column != 0) return true; //학번은 수정할 수 없게 함
				else return false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl(); //자식클래스로 생성
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,38));
		p1.add(hakL);
		p1.add(hakT);
	
		p1.add(nameL);
		p1.add(nameT);
		
		p1.add(korL);
		p1.add(korT);
		
		p1.add(engL);
		p1.add(engT);
	
		p1.add(mathL);
		p1.add(mathT);
		
		
		JPanel p3 = new JPanel(new GridLayout());
		p3.add(p1);
		p3.add(scroll);
		
		
		JPanel p2 = new JPanel(new GridLayout(1,6,5,1));
		p2.add(inputB);
		p2.add(printB);
		p2.add(searchB);
		p2.add(rankB);
		p2.add(saveB);
		p2.add(loadB);
				
		
		Container container = this.getContentPane();
		container.add("Center", p3);
		container.add("South", p2);
		
		
		
		
		//<선생님 풀이>
		//JPanel p1 = new JPanel();
		//p1.add(hakL); p1.add(hakT);
		//JPanel p2 = new JPanel();
		//p2.add(
		
		
		
		
		setBounds(800,300, 600, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//여기서 이벤트 호출해도 됨
	}
	
	//이벤트 처리 메소드
	public void event() { 
		inputB.addActionListener(this);
		printB.addActionListener(this);
		searchB.addActionListener(this);
		rankB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputB) {
			//데이터
			String hak = hakT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText().trim());
			int eng = Integer.parseInt(engT.getText().trim());
			int math = Integer.parseInt(mathT.getText().trim());
			
			//ScoreDTO에 저장하기
			ScoreDTO dto = new ScoreDTO();
			dto.setHak(hak);
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);
			
			//총점, 평균 계산
			dto.calc();
			
			//데이터 보관(모으기) - 객체 저장
			score.input(dto);
			
			
			JOptionPane.showMessageDialog(this, "등록 완료");
			
			//초기화
			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}else if(e.getSource() == printB) {
			score.print(model); //list의 항목을 모두 꺼내서 JTable에 뿌리기
		}else if(e.getSource() == searchB) {
			score.search(model);
		}else if(e.getSource() == rankB) {
			score.tot_desc();//총점으로 내림차순
			score.print(model);
		}else if(e.getSource() == saveB) { 
			score.save();
		}else if(e.getSource() == loadB) {
			score.load();
			score.print(model);
			
		}
		
	}
	
	
}
