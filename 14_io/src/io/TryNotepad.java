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
		super("���� �޸���");
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		//��ũ���� �׻� ǥ�õǾ� ����
		//���� ��ũ�� : scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		menu = new MenuPane();
		this.setJMenuBar(menu); //JMenuBar����(���̾ƿ�)�� �޴��� ����(�ٸ��� ContentPane���� �޴��ٴ� JMenuBar
		
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		
		setBounds(800, 300, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(TryNotepad.this, "���泻���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) { //��
					saveDialog();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION) {//�ƴϿ�
					System.exit(0);
				}//else if(result == JOptionPane.CANCEL_OPTION) {//��� - �ڵ� �����̹Ƿ� �ʿ����
//					return;
//				}		
			}
		});
	
	}//TryNotePad()
	
	public void event() {
		//�̺�Ʈ ȣ���ϴ� �޼ҵ�
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
				//ȣ���� �޼ҵ忡 ����ó���� �Ǿ��־� ȣ��ο����� ����ó���� �ʿ�, ���⼭�� throws�� �� �� �����Ƿ�  try~catch�� ����ó����
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == menu.getSaveM()) {
			saveDialog();
			fileWrite();
		}else if(e.getSource() == menu.getExitM()) {
			int result = JOptionPane.showConfirmDialog(TryNotepad.this, "���泻���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) { //��
				saveDialog();
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {//�ƴϿ�
				System.exit(0);
			}//else if(result == JOptionPane.CANCEL_OPTION) {//��� - �ڵ� �����̹Ƿ� �ʿ����
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
			file = chooser.getSelectedFile(); //������ ������ ��θ� ������
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
			file = chooser.getSelectedFile();//������ ������ ��θ� ������
			try {
				fileRead(); //�ڡڡڡڡڡ��� �κ� �ѹ� �� �����غ���  ��null�� ���� - ��å3-2, ������ ������ ��쿡�� �ش� �޼ҵ带 �ҷ���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, file); //���� �ҷ��Դ��� Ȯ��, ���� ��ü, �޽���â�� ��ΰ� ����
	}

	public static void main(String[] args) {
		new TryNotepad().event();
		
	}
	
	

}



//Ctrl�� �����쿡�� ������ ����
//Alt�� ��ó