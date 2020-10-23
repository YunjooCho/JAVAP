package abstractMethod;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame{
	
	public WindowTest() {
		//1.������ �����
		setTitle("�̹���"); //Frame�� �޼ҵ�
		//super �� �κ� �� super������ �������� Ȯ�� : �θ�Ŭ������ Frame�� �Ķ���� �ִ� ������ - Frame(String title)
		setBounds(900, 100, 500, 500);//â�� ũ��(��üȭ�鿡���� x��, y��, â��ü�� �ʺ�, â��ü�� ����)
		setVisible(true);//callback
	}
	
	public void paint(Graphics g) {//WindowŬ������ �޼ҵ� �������̵�
		//Toolkit t = Toolkit.getDefaultToolkit(); : �߻�޼ҵ�� new������ �ȵ� 
		//(Calendar cal = cal.getInstance()�� ����)
		//Image img = t.getImage("taji.jpg"); //�̹��� �ҷ�����
		//���� �ڵ� ������ ��ģ ��
		Image img = Toolkit.getDefaultToolkit().getImage("taji.jpg");
		
		//�̹��� �׸��� - Window Ŭ������ paint() : ������ �ȿ� �׸��� �׸� �� ����
		//g.drawImage(img, 100, 100, this);
		//1.���� �̹����� ���� �ִ���
		//2.�������� ��ġ
		//3.��� �׸� �� ����
		
		//�̹��� �۰�
		/*
		g.drawImage(img,
		  50, 50, 400, 400, //ȭ�� ũ�� �ڡڡڡڡڹ����� ����Ű�� ���� ����
		  0, 0, 320, 320, //�̹��� ũ��  �ڡڡڡڡڹ����� ����Ű�� ���� ����
		  this);//this ��� �̹����� �÷��� ������ ����(Ŭ���� ����)
		drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)
		Draws as much of the specified area of the specified image as is currently 
		available, scaling it on the fly to fit inside the specified area of 
		the destination drawable surface.
		Parameters:
		img - the specified image to be drawn. This method does nothing if img is null.
		dx1 - the x coordinate of the first corner of the destination rectangle.
			���� ���� ����(Ŭ���� ���� ���� Ŀ��)
		dy1 - the y coordinate of the first corner of the destination rectangle.
			���� ���� ����(Ŭ���� ���� ���� Ŀ��)
		dx2 - the x coordinate of the second corner of the destination rectangle.
			������ ���� ����(�������� ������ ���� Ŀ��)
		dy2 - the y coordinate of the second corner of the destination rectangle.
			�Ʒ��� ���� ����(�������� �Ʒ��� ���� Ŀ��)
		sx1 - the x coordinate of the first corner of the source rectangle.
			
		sy1 - the y coordinate of the first corner of the source rectangle.
			
		sx2 - the x coordinate of the second corner of the source rectangle.
			���� �ʺ� ����(�������� ������ �ʺ� Ŀ��)
		sy2 - the y coordinate of the second corner of the source rectangle.
			���� ���� ����(�������� ���̰� Ŀ��)
		observer - object to be notified as more of the image is scaled and converted.
			��𿡼� �����Ǿ� �ִ���
		*/
		
		//�Ųٷ�
		g.drawImage(img,
				  50, 50, 400, 400, //ȭ�� ũ��ڡڡڡڡڹ����� ����Ű�� ���� ����
				  320, 320, 0, 0, //�̹��� ũ��ڡڡڡڡڹ����� ����Ű�� ���� ����(���� �� ��ġ, ������ �Ʒ� ��ġ)
				  this);
	}
	
	public static void main(String[] args) {
		
		//2. ������ ����
		new WindowTest(); //�������� ������ �ּҸ� ������ ����(��ȣǥ�� �־� ��ü���� ��� ��밡��)
	}
}

//ToolkitŬ���� - �߻�Ŭ���� newToolkit() X
//ToolkitŬ������ �������
//1.�ڽ� - Sub class�� ����(API)
//2.�޼ҵ� - getDefaultToolkit() �ּҰ��� �Ѱ���
