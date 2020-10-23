package exception_thread;

//import horse.race.RaceFrame;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
public class Snake extends JFrame implements ActionListener
{
	CenterPanel center;
	JTextField scoT;
	int score;
	//RaceFrame rf;
	JButton startGame;
	
	public Snake(){
	    //this.rf= rf;
		setName("�� �����̶��");
		setBounds(200,200,500,540);
		
		JPanel all = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridLayout(1,3));//����, ����ð�, �÷��̽ð�
		center = new CenterPanel(this);
		JPanel bottom = new JPanel();

		JPanel[] topPart = new JPanel[3];

		topPart[0] = new JPanel();
		JLabel scoL = new JLabel("���� : ");
		scoT = new JTextField(7);
		scoT.setFocusable(false);
		topPart[0].add(scoL);
		topPart[0].add(scoT);

		topPart[1] = new JPanel();
		//JLabel nowTimeL = new JLabel("����ð� : ");
		//topPart[1].add(nowTimeL);

		topPart[2] = new JPanel();
		//JLabel playTimeL = new JLabel("�÷��̽ð� : ");
		//topPart[2].add(playTimeL);

		for(int i=0;i<topPart.length;i++){
			top.add(topPart[i]);
		}
		startGame = new JButton("�� ��");
		startGame.addActionListener(this);
//		JButton newGame = new JButton("�� ����");
//		newGame.addActionListener(this);

		bottom.add(startGame);
//		bottom.add(newGame);

		

		all.add("North",top);
		all.add("Center",center); // Calvas
		all.add("South",bottom);
		
		add(all);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		center.repaint();

	}//constructor
	public void actionPerformed(ActionEvent  e){
		center.startGame();
		startGame.setVisible(false);
		
	}


	public static void main(String[] args) 
	{
		Snake sk = new Snake();

	}
}
class SetxyList
{
	int x, y;
	public SetxyList(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}

@SuppressWarnings("serial")
class CenterPanel extends Canvas implements ActionListener, KeyListener
{
	int x=11, y=9;
	int xPlus=-1, yPlus=0;
	boolean goStop = true, move = true;//�ʱ� ���۽� ����
	//int[][] xy = new int[100][2];
	int xyNum = 5;//�� ����
	int frogNum = 10;
	int delay = 300;//�� �ӵ� ����
	int sel;
	boolean frogSet = false;
	Snake sk;


	ArrayList<SetxyList> xyList = new ArrayList<SetxyList>();
	ArrayList<SetxyList> frogList = new ArrayList<SetxyList>();

	SnakeThread st = new SnakeThread(this);
	Thread th = new Thread(st);
	Image image;
	Image bufferImage;
	Graphics bufferGraphics;
	
	public CenterPanel(Snake sk){
		this.sk =sk;
		image = Toolkit.getDefaultToolkit().getImage("packman.jpg");
		setFocusable(true);
		addKeyListener(this);
		xyReset();
		repaint();
	}
	public void startGame(){
		requestFocus();
		frogListSet();
		th.start();
	}


	public void focusLost (FocusEvent  e){
		requestFocus();
	}
	public void frogListSet(){	//x<1|x>23|y<1|y>19
		frogNum = 10;
		for (int i=0;i<frogNum;i++){
			int rndX = (int)(Math.random()*22)+1;
			int rndY = (int)(Math.random()*19)+1;
			
			for(int j=0;j<i;j++){
				if (j==0) continue;
				if (rndX==frogList.get(j).x&&rndY==frogList.get(j).y){
					i--; continue;
				}
			}
			frogList.add(new SetxyList(rndX,rndY));
		}
		frogSet = true;
	}


	public void xyReset(){
		for (int i=0;i<xyNum;i++){
			xyList.add(new SetxyList(x+i+1,y));
//			System.out.println(x+i+1+" "+y);
		}
	}
	public void xySet(){
		xyList.remove(xyNum-1);
		xyList.add(0, new SetxyList(x,y));
		
		x += xPlus;
		y += yPlus;
	}	
	public void endOfLine(){
		if (x<1|x>22|y<1|y>19){
//			System.out.println("��");
			move=false;
			JOptionPane.showMessageDialog(this, sk.score+"�� �ݾ��� �����Ǿ����ϴ�.", "game over",
				JOptionPane.WARNING_MESSAGE);
			//sk.rf.setMoney(sk.score);
			//sk.rf.setMoneyDB();
			sk.dispose();
		}
	}
	public void snakeBody(){
		//System.out.println("�첿�� ã����!");
		for(int i=0;i<xyNum;i++){
			if (x==xyList.get(i).x&&y==xyList.get(i).y){
//				System.out.println("�첿�� ����!");
				move=false;
				JOptionPane.showMessageDialog(this, sk.score+"�� �ݾ��� �����Ǿ����ϴ�.", "game over",
					JOptionPane.WARNING_MESSAGE);
				//sk.rf.setMoney(sk.score);
				//sk.rf.setMoneyDB();
				sk.dispose();
			}
		}
	}
	public void frogEat(){
//		System.out.println("������ ���鷯");
		for(int i=0;i<frogNum;i++){
			if (x==frogList.get(i).x&&y==frogList.get(i).y){
//				System.out.println("������ �Դ�!");
				frogList.remove(i);
				
				frogNum--;
				sk.score += 10;
				delay -= 5;
				sk.scoT.setText(""+sk.score);
				//move=false;
				
				xyList.add(0, new SetxyList(x,y));
				
				
				xyNum++;
//				System.out.println(frogNum);
				if (frogNum<=0) frogListSet();
			}
		}
		//System.out.println("������ �� ����");
	}

	public void paint(Graphics  g){
		//System.out.println("paint");
		g.drawImage(bufferImage,0,0,this);
		endOfLine();
		snakeBody();
		if (frogSet == true){
			frogEat(); 
		}
	}
	public void update(Graphics g){
		bufferImage = createImage(this.getWidth(),this.getHeight());
		bufferGraphics = bufferImage.getGraphics();
		bufferGraphics.drawRect(10,10,460,400);
		if (frogSet == true){
			if (move==false) return;
		}
		
		xySet();
		//System.out.print("["+x+" "+y+"]");
		
		bufferGraphics.drawOval(x*20,y*20,18,18);
		bufferGraphics.fillOval(x*20+5,y*20+5,4,3);
		bufferGraphics.fillOval(x*20+10,y*20+5,4,3);
		
		//bufferGraphics.drawImage(image,x*20,y*20,x*20+20,y*20+20,sel*50,0,sel*50+50,50,this);

		for (int i=0;i<xyNum;i++){ // ���� �׸���
			bufferGraphics.drawRect(xyList.get(i).x*20+4,xyList.get(i).y*20+4,10,10);
			bufferGraphics.fillRect(xyList.get(i).x*20+6,xyList.get(i).y*20+6,6,6);
			//System.out.print("�� ["+xyList.get(i).x+" "+xyList.get(i).y+"]");
		}
		if (frogSet == true){
			for (int i=0;i<frogNum;i++){ // �������� �׸���
				bufferGraphics.drawOval(frogList.get(i).x*20+4,frogList.get(i).y*20+4,10,10);
				bufferGraphics.fillRect(frogList.get(i).x*20+6,frogList.get(i).y*20+6,6,6);
				//System.out.print("������ ["+frogList.get(i).x+" "+frogList.get(i).y+"]");
			}
		}

		//System.out.println();
		paint(g);
	}
	public void keyPressed (KeyEvent  e){
		//System.out.println("keyPressed");
		move=true;
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			//System.out.println("LEFT");
			xPlus = -1;
			yPlus = 0;
			sel = 0;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			xPlus = 1;
			yPlus = 0;
			sel = 2;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			xPlus = 0;
			yPlus = -1;
			sel = 4;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			xPlus = 0;
			yPlus = 1;
			sel = 6;
		}
	}
	public void keyReleased (KeyEvent  e){
	//System.out.println("keyReleased");
	}
	public void keyTyped (KeyEvent  e){
	//System.out.println("keyTyped");
	}

	public void actionPerformed(ActionEvent e){
		//System.out.println(e);
	}

}
class SnakeThread extends Thread
{	
	CenterPanel p;
	public SnakeThread(CenterPanel p){
		this.p = p;
	}

	public void run(){
	    try {
		sleep(2000);
	    } catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
		//System.out.println("Thread_run");
		while(p.goStop){
			if (p.sel%2!=0) p.sel--; else p.sel++;
			p.repaint();
			//System.out.println("running");
			try{
				sleep(p.delay);
			}catch(Exception e){}
		}
	}
}