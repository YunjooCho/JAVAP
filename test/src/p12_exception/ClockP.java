package p12_exception;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockP extends Frame implements Runnable {

	public ClockP() {
		this.setFont(new Font("µ∏øÚ", Font.BOLD, 24));
		setForeground(Color.RED);
		setBounds(700,200,300,100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Thread t = new Thread(this);
		t.start();
	}
	
	
	@Override
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void paint(Graphics g) {
		SimpleDateFormat sd = new SimpleDateFormat("HHΩ√ mm∫– ss√ ");
		Date date = new Date();
		g.drawString(sd.format(date), 60, 65);
	}

	public static void main(String[] args) {
		
		new ClockP();
	}
}
