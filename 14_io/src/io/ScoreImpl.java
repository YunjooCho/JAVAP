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



//������ ���� �����(������ó��) �ϴ� ���� Score�������̽�
//ScoreImpl�� Score�������̽��� ����Ŭ���� 
public class ScoreImpl implements Score { //�����Ҷ��� ���� Ŭ������ ����
	private List<ScoreDTO> list;
	private File file;
	//private int count; //������ �б�ó�����(������ �ٸ� ���) 1-1
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
		
	}

	@Override
	public void input(ScoreDTO dto) {
		//if(dto.getName() == null) return;  //�ڡڡڡڡ��Է³����� ������ ������ ���� �ʵ�����
		list.add(dto);
		
	}

	@Override
	public void print(DefaultTableModel model) {
		//���̺� �ʱ�ȭ
		model.setRowCount(0); 
		for(ScoreDTO dto : list) { //list�����ŭ dto��ü�� ����Ǿ��ִ� ���� vector�� �߰�
 			Vector<String> v = new Vector<String>(); //����Ʈ�� ���̺� �߰��� �� �����Ƿ�  Vector���
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
		int result = chooser.showSaveDialog(null); //��null
		File file = null;
		if(result  == JFileChooser.APPROVE_OPTION) {//�������ư�� �����ٸ�
			file = chooser.getSelectedFile(); //������ ������ ��������� ������
			//fileWriter()�κ�
			if(file == null) return; //����ҹ�ư�� �����ٸ� ������
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
																					//file�κ��� �����ϸ� ������ ������ �� �� ����
				//oos.writeObject(list); - Serialization�� �ɷ��־����(�ݺ���(for) ó�� �ʿ����)
				for(ScoreDTO dto : list) {
					oos.writeObject(dto);
					//������ �б�ó����� 1-2. count++;
				}
				oos.close();
				//<�� Ǯ��>
				//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				//String data = list.toString();
				//bw.write(data);
				//bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//if
		JOptionPane.showMessageDialog(chooser, file); //��null�� ���� - ��Ҹ� ������ ��� file�� null���� ä�̹Ƿ� ������ ��
		
	}

	
	@Override
	public void load()  { //ä��â �ο�ǥ�⿡ Ȱ�밡��
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null); 
		if(result == JFileChooser.APPROVE_OPTION) { //���⸦ �����ٸ�
			file = chooser.getSelectedFile(); //�������� ������ �ҷ��ö� ���ϰ�ü�迭�� ���� getSelectedFiles()�޼ҵ带 ���
		}
		if(file == null) return;
		list.clear(); //������ ���̺� ����Ǿ��ִ� �����Ͱ��� ����ȭ��(���� ������ ���� ���̺� ���� ���� �������Ե�)
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		while(true) { //������ �б�ó����� 1-3-1.(try~catch���ʿ�) for(int i = 0; i < count; i++) ������ ���������� ����Ǿ� �ִ� ��ü�� �о��
					  //������ ������ error�� �߻�
			try {
				ScoreDTO dto = (ScoreDTO)ois.readObject(); //�ڽ� = (�ڽ�)�θ�
				list.add(dto);
				//������ �б�ó����� 1-3-2.(try~catch���ʿ�) 
				//int num = 0;
				//++num;
				//if(num == count) break;
			} catch (ClassNotFoundException | IOException e) { //ClassNotFoundException - ��ü�� ������ error�� ��
															   //EOFException : End of file - ������ ���� �������� � ������ �ؾ��ϴ���
															   //����� ó���� �ȵȴٴ� ��
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
		//showInputDialog�� �̿��Ͽ� �й��� �Է¹޴´�
		//���� ��� �Ǵ� �й��� �Է����� ������
		String keyword = JOptionPane.showInputDialog(null, "�й��� �Է����ּ���");
		if(keyword == null||keyword.equals("")) return;
		

		//�ڡڡڡ����̺� �߰��ϴ� �� Ȯ���غ���, �й��� ������ �ذ��� �߰��ϱ�
//		for(int i = 0; i < list.size(); i++) { 
//			if(list.get(i).getHak().equals(keyword)) {
//				int num = i;
//				JOptionPane.showMessageDialog(null, list.get(i).getName());
//			}
//		}
		
		//<������ Ǯ��>
		int sw = 0;
		for(ScoreDTO dto : list){
			if(dto.getHak().equals(keyword)){
			 if(sw == 0)model.setRowCount(0); //ȭ���� ���̺� �ʱ�ȭ
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
		if(sw == 0) JOptionPane.showMessageDialog(null,"ã���� �ϴ� �й��� �����ϴ�"); 
	}

	@Override
	public void tot_desc() {
		
		Collections.sort(list);

		//<�ٸ� Ǯ��> comparable �������̽� implements���ʿ�
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
		output.setText(""); //��null�� ���� - ��å3-1,�ؽ�Ʈ�� �ʱ�ȭ �ϰ� ������ �ҷ���
		BufferedReader br = new BufferedReader(new FileReader(file)); //file�� ����� ������ �о����
		String line;
		
		while((line = br.readLine()) != null) { //������ ������� �������� �о����(����� ���� ������� �߰��ϸ� �о����)
			//readLine() : ���Ͱ� ������ ����(�о���϶� enter�� �ݿ��ȵ�)
			//���� ������ \n�� ����Ͽ� ���͸� �־���
			//output.setText(line); //����� ȿ�� �Էµ� ���忡 �ٹٲ��� ������ �װ� �������� ���
			output.append(line + "\n");
		}//while
		
		br.close();
	}
	

	private void openDialog() {//������ ������ ���� �޼ҵ�
		//File file = null; //�ʱ�ȭ(���������� �����Ⱚ�� ������ �����Ƿ�) - fileRead()������ ����ϱ� ���� �ʵ�� �ø�
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this); //�� ������â ������ ���� ����â �߱�
		if(result == JFileChooser.APPROVE_OPTION) { //�������� ������ �ҷ��ö� ���ϰ�ü�迭�� ���� getSelectedFiles()�޼ҵ带 ���
			file = chooser.getSelectedFile();
			try {
				fileRead(); //�ڡڡڡڡڡ��� �κ� �ѹ� �� �����غ���  ��null�� ���� - ��å3-2, ������ ������ ��쿡�� �ش� �޼ҵ带 �ҷ���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, file); //���� �ҷ��Դ��� Ȯ��, ���� ��ü, �޽���â�� ��ΰ� ����
	}
 * private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			fileWrite(); //��null�� ���� - ��å2, ���⼭ ������ ���õ� ��쿡�� fileWriter�� �̵�(����� ��� fileWrite()��ü�� �θ��� ����)
		}
		JOptionPane.showMessageDialog(this, file); //��null�� ���� - ��Ҹ� ������ ��� file�� null���� ä�̹Ƿ� ������ ��
	}

	private void fileWrite()  { //���� ������ ����(������ ����)
		if(file == null) return; //��null�� ���� - ��å1, �ؿ� �������� �������� ��������
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = output.getText(); //�����ʹ� �ڵ����� �Ѳ����� ������
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
 */
