package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



//실제로 값을 입출력(데이터처리) 하는 것은 Score인터페이스
//ScoreImpl는 Score인터페이스의 구현클래스 
public class ScoreImpl implements Score { //생성할때는 구현 클래스로 실행
	private List<ScoreDTO> list;
	private File file;
	//private int count; //◆파일 읽기처리방법(본문과 다른 방법) 1-1
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
		
	}

	@Override
	public void input(ScoreDTO dto) {
		//if(dto.getName() == null) return;  //★★★★★입력내용이 없을때 에러가 뜨지 않도록함
		list.add(dto);
		
	}

	@Override
	public void print(DefaultTableModel model) {
		//테이블 초기화
		model.setRowCount(0); 
		for(ScoreDTO dto : list) { //list사이즈만큼 dto객체에 저장되어있는 값을 vector에 추가
 			Vector<String> v = new Vector<String>(); //리스트는 테이블에 추가할 수 없으므로  Vector사용
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor() + "");
			v.add(dto.getEng() + "");
			v.add(dto.getMath() + "");
			v.add(dto.getTot() + "");
			v.add(dto.getAvg() + "");
			
			model.addRow(v);
		}//for
	}

	
	@Override
	public void save() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null); //★null
		File file = null;
		if(result  == JFileChooser.APPROVE_OPTION) {//◇저장버튼을 눌렀다면
			file = chooser.getSelectedFile(); //파일을 저장할 경로정보를 가져옴
			//fileWriter()부분
			if(file == null) return; //◇취소버튼을 눌렀다면 나가기
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
																					//file부분을 수정하면 서버로 나가게 할 수 있음
				//oos.writeObject(list); - Serialization이 걸려있어야함(반복문(for) 처리 필요없음)
				for(ScoreDTO dto : list) {
					oos.writeObject(dto);
					//◆파일 읽기처리방법 1-2. count++;
				}
				oos.close();
				//<내 풀이>
				//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				//String data = list.toString();
				//bw.write(data);
				//bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//if
		JOptionPane.showMessageDialog(chooser, file); //☆null값 에러 - 취소를 누르는 경우 file이 null값인 채이므로 에러가 뜸
		
	}

	
	@Override
	public void load()  { //채팅창 인원표기에 활용가능
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null); 
		if(result == JFileChooser.APPROVE_OPTION) { //열기를 눌렀다면
			file = chooser.getSelectedFile(); //여러개의 파일을 불러올땐 파일객체배열을 같는 getSelectedFiles()메소드를 사용
		}
		if(file == null) return;
		list.clear(); //기존에 테이블에 저장되어있는 데이터값을 백지화함(하지 않으면 기존 테이블에 블러온 값이 더해지게됨)
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		while(true) { //◆파일 읽기처리방법 1-3-1.(try~catch불필요) for(int i = 0; i < count; i++) 파일이 끝날때까지 저장되어 있는 객체를 읽어옴
					  //파일이 없으면 error가 발생
			try {
				ScoreDTO dto = (ScoreDTO)ois.readObject(); //자식 = (자식)부모
				list.add(dto);
				//◆파일 읽기처리방법 1-3-2.(try~catch불필요) 
				//int num = 0;
				//++num;
				//if(num == count) break;
			} catch (ClassNotFoundException | IOException e) { //ClassNotFoundException - 객체가 없으면 error가 뜸
															   //EOFException : End of file - 파일의 끝을 만났을때 어떤 동작을 해야하는지
															   //제대로 처리가 안된다는 뜻
				break;
			}
		}
		//ois.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}//load

	@Override
	public void search(DefaultTableModel model) {
		//showInputDialog을 이용하여 학번을 입력받는다
		//만약 취소 또는 학번을 입력하지 않으면
		String keyword = JOptionPane.showInputDialog(null, "학번을 입력해주세요");
		if(keyword == null||keyword.equals("")) return;
		

		//★★★★테이블에 추가하는 법 확인해보기, 학번이 없을때 해결방법 추가하기
//		for(int i = 0; i < list.size(); i++) { 
//			if(list.get(i).getHak().equals(keyword)) {
//				int num = i;
//				JOptionPane.showMessageDialog(null, list.get(i).getName());
//			}
//		}
		
		//<선생님 풀이>
		int sw = 0;
		for(ScoreDTO dto : list){
			if(dto.getHak().equals(keyword)){
			 if(sw == 0)model.setRowCount(0); //화면의 테이블 초기화
		     Vector<String> v = new Vector<String>();
			   v.add(dto.getHak());
		     v.add(dto.getName());
			   v.add(dto.getKor() + "");
			   v.add(dto.getEng() + "");
			   v.add(dto.getMath() + "");
			   v.add(dto.getTot() + "");
			   v.add(dto.getAvg() + "");
		     model.addRow(v);
		     sw = 1;
		     
			}
		}
		if(sw == 0) JOptionPane.showMessageDialog(null,"찾고자 하는 학번이 없습니다"); 
	}

	@Override
	public void tot_desc() {
		
		Collections.sort(list);

		//<다른 풀이> comparable 인터페이스 implements불필요
//		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
//			@Override
//			public int compare(ScoreDTO s1, ScoreDTO s2) {
//				return s1.getTot()<s2.getTot() ? 1 : -1;
//			}
//		};
//		Collections.sort(list, com);
		
	
	}
		
		
}






/*
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
			file = chooser.getSelectedFile();
			try {
				fileRead(); //★★★★★★이 부분 한번 더 정리해보기  ☆null값 에러 - 대책3-2, 파일을 선택한 경우에만 해당 메소드를 불러옴
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, file); //정말 불러왔는지 확인, 파일 객체, 메시지창에 경로가 찍힘
	}
 * private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
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
	
	
	
	
 */
