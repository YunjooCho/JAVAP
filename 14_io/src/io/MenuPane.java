package io;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuPane extends JMenuBar { //�����ӿ� �پ�� ��(���� ��� �Ұ�)

	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	private TryNotepad note;
	
	public MenuPane() {
		fileM = new JMenu("����");
		editM = new JMenu("����");
		viewM = new JMenu("����");
		
		newM = new JMenuItem("���θ����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("����");
		
		cutM = new JMenuItem("�߶󳻱�");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");
		
		
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);
		
		add(fileM);
		add(editM);
		add(viewM);
		
		//����Ű
		cutM.setAccelerator(KeyStroke.getKeyStroke('X',Event.ALT_MASK)); //ALT + X
		copyM.setAccelerator(KeyStroke.getKeyStroke('C', Event.ALT_MASK)); //ALT + C
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V', Event.ALT_MASK));//ALT +V
		newM.setAccelerator(KeyStroke.getKeyStroke('N', Event.ALT_MASK));
		openM.setAccelerator(KeyStroke.getKeyStroke('O',Event.ALT_MASK));
		saveM.setAccelerator(KeyStroke.getKeyStroke('S',Event.ALT_MASK));
		
	}
	

	public JMenuItem getNewM() {
		return newM;
	}

	public void setNewM(JMenuItem newM) {
		this.newM = newM;
	}

	public JMenuItem getOpenM() {
		return openM;
	}

	public void setOpenM(JMenuItem openM) {
		this.openM = openM;
	}

	public JMenuItem getSaveM() {
		return saveM;
	}

	public void setSaveM(JMenuItem saveM) {
		this.saveM = saveM;
	}

	public JMenuItem getExitM() {
		return exitM;
	}

	public void setExitM(JMenuItem exitM) {
		this.exitM = exitM;
	}

	public JMenuItem getCutM() {
		return cutM;
	}

	public void setCutM(JMenuItem cutM) {
		this.cutM = cutM;
	}

	public JMenuItem getCopyM() {
		return copyM;
	}

	public void setCopyM(JMenuItem copyM) {
		this.copyM = copyM;
	}

	public JMenuItem getPasteM() {
		return pasteM;
	}

	public void setPasteM(JMenuItem pasteM) {
		this.pasteM = pasteM;
	}

	public TryNotepad getNote() {
		return note;
	}

	public void setNote(TryNotepad note) {
		this.note = note;
	}

	

}

//���θ����, ����, ����, ����� ���ϸ޴��� ����
//���ϸ޴��� JBar(��)�� ����