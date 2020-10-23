package io;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener {
	
	private JTextArea output;
	private MenuPane menu;
	private File file;
	
	
	public TryNotepad() {
		super("간단 메모장");
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		//스크롤이 항상 표시되어 있음
		//가로 스크롤 : scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		menu = new MenuPane();
		this.setJMenuBar(menu); //JMenuBar영역(레이아웃)에 메뉴를 붙임(다른건 ContentPane지만 메뉴바는 JMenuBar
		
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		
		setBounds(800, 300, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(TryNotepad.this, "변경내용을 저장하시겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) { //예
					saveDialog();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION) {//아니오
					System.exit(0);
				}//else if(result == JOptionPane.CANCEL_OPTION) {//취소 - 자동 설정이므로 필요없음
//					return;
//				}		
			}
		});
	
	}//TryNotePad()
	
	public void event() {
		//이벤트 호출하는 메소드
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getNewM()) {
			output.setText("");
		}else if(e.getSource() == menu.getOpenM()) {
			openDialog();
			try {
				fileRead(); 
				//호출한 메소드에 예외처리가 되어있어 호출부에서도 예외처리가 필요, 여기서는 throws를 걸 수 없으므로  try~catch로 예외처리함
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == menu.getSaveM()) {
			saveDialog();
			fileWrite();
		}else if(e.getSource() == menu.getExitM()) {
			int result = JOptionPane.showConfirmDialog(TryNotepad.this, "변경내용을 저장하시겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) { //예
				saveDialog();
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {//아니오
				System.exit(0);
			}//else if(result == JOptionPane.CANCEL_OPTION) {//취소 - 자동 설정이므로 필요없음
//				return;
//			}
		}else if(e.getSource() == menu.getCutM()) {
			output.cut();
		}else if(e.getSource() == menu.getCopyM()) {
			output.copy();
		}else if(e.getSource() == menu.getPasteM()) {
			output.paste();
		}	
	
	}


	private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile(); //파일을 저장할 경로를 가져옴
			fileWrite(); //☆null값 에러 - 대책2, 여기서 파일이 선택된 경우에만 fileWriter로 이동(취소의 경우 fileWrite()자체를 부르지 않음)
		}
		JOptionPane.showMessageDialog(this, file); //☆null값 에러 - 취소를 누르는 경우 file이 null값인 채이므로 에러가 뜸
	}

	private void fileWrite()  { //값을 밖으로 빼냄(파일을 저장)
		if(file == null) return; //☆null값 에러 - 대책1, 밑에 문장으로 가지말고 빠져나감
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = output.getText(); //데이터는 자동으로 한꺼번에 꺼내짐
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void fileRead() throws IOException {
		output.setText(""); //☆null값 에러 - 대책3-1,텍스트를 초기화 하고 파일을 불러냄
		BufferedReader br = new BufferedReader(new FileReader(file)); //file에 저장된 내용을 읽어들임
		String line;
		
		while((line = br.readLine()) != null) { //파일이 비어있지 않을때만 읽어들임(덮어쓰지 말고 출력줄을 추가하며 읽어들임)
			//readLine() : 엔터값 전까지 읽음(읽어들일때 enter가 반영안됨)
			//따라서 강제로 \n을 사용하여 엔터를 넣어줌
			//output.setText(line); //덮어쓰기 효과 입력된 문장에 줄바꿈이 있으면 그걸 기준으로 덮어씀
			output.append(line + "\n");
		}//while
		
		br.close();
	}
	

	private void openDialog() {//저장한 파일을 여는 메소드
		//File file = null; //초기화(지역변수는 쓰레기값을 가지고 있으므로) - fileRead()에서도 사용하기 위해 필드로 올림
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this); //내 프레임창 위에서 파일 열기창 뜨기
		if(result == JFileChooser.APPROVE_OPTION) { //여러개의 파일을 불러올땐 파일객체배열을 같는 getSelectedFiles()메소드를 사용
			file = chooser.getSelectedFile();//파일을 가져올 경로를 가져옴
			try {
				fileRead(); //★★★★★★이 부분 한번 더 정리해보기  ☆null값 에러 - 대책3-2, 파일을 선택한 경우에만 해당 메소드를 불러옴
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, file); //정말 불러왔는지 확인, 파일 객체, 메시지창에 경로가 찍힘
	}

	public static void main(String[] args) {
		new TryNotepad().event();
		
	}
	
	

}



//Ctrl은 윈도우에서 설정한 내용
//Alt로 대처