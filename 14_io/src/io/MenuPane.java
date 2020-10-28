package io;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuPane extends JMenuBar { //프레임에 붙어야 함(독단 사용 불가)

	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	private TryNotepad note;
	
	public MenuPane() {
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		viewM = new JMenu("보기");
		
		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료");
		
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
		
		
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
		
		//단축키
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

//새로만들기, 열기, 저장, 종료는 파일메뉴에 부착
//파일메뉴는 JBar(나)에 부착
