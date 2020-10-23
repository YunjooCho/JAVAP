package inheritance;

import java.awt.Color;
import java.awt.Frame;//��Ű�� �ܿ��
import java.awt.Graphics;


//1.���
public class WindowTest extends Frame {
	
	//2.�⺻������
	public WindowTest() {
		//Frame Ŭ������ �����ڸ� ���ؼ� "���� ���� ������"
		//Frame(String title)�� ���
		//seTitle("���� ���� ������");�� ���� ���
		//String title = "���� ���� ������";
		//String title = new String("���� ���� ������");
		//super(new String("���� ���� ������");
		//4.
		super("���� ���� ������");
		//���� �޼ҵ��� ���� -> �θ� ������ -> �ڽĻ�����
		//�������̵� �ƴ�(�ڽĿ� �Ȱ��� ���°� ����)
		//�θ�(Frame)Ŭ������ �Ķ���Ͱ� �ִ� ������, ù°�ٿ� �Է�
		//super();�Ķ���Ͱ� ���� �����ڴ� �θ��� ����
		//this�� WindowTest�� �� �̹Ƿ�, ������ String title�Ķ���Ͱ� �ִ� �����ڰ� ���� �� ��밡��
		
		//paint() - ������ â �ȿ� �׷��ִ� �޼ҵ�(windowŬ����)
		
		//System.out - �ܼ�â�� ǥ��
		//System.out.println("����"); 
		
		
		//������ �⺻ ������ - ���, �⺻ �۾��� - ����
		//������ �ٲٱ�(static�̱� ������ new�����ʿ�X), Ŭ���� ���� ���̹Ƿ�  this�� �ʿ�
		//this.setBackground(Color.PINK);
		
		//Color�� �����ڸ� ȣ���ؼ� ������ ������ ����
		//Color c = new Color(251, 220, 225); - �޸� �����Ͽ� c�� �ּҰ���, �������� �ٽ� ã�ư� �� ����
		//this.setBackground(c);
		
		//4.
		this.setBackground(new Color(255, 220, 193));//���� ����, �޸� �������� �ʾұ� ������ 1ȸ��
		setForeground(Color.YELLOW);//���ڻ� ����
		
		
		//3.â�� ũ�� ���
		//setSize(300,400); //WindowŬ�������� ��ӹ���
		//setBounds(x�� ��ġ, y�� ��ġ, �ʺ�, ����)
		setBounds(700,100,300,400);//�ػ󵵶� ��������
		setVisible(true);

	}
	
	//3.
	public static void main(String[] args) {
		WindowTest aa = new WindowTest(); // Frame ������ -> WindowTest ������
	}
	
	//������ ������ �Ǹ� JVM(�Ǵ� �ü��)�� ���ؼ� ȣ��Ǵ� �޼ҵ� - Call Back�޼ҵ�
	//java�Ӹ� �ƴ϶� �ȵ���̵忡�� ����
	//�ȵ���̵忡���� JVM�� �ƴ� �޺�ӽſ� ���� ȣ���
	//main()�� �ݹ�޼ҵ� : RunAs�� ȣ��
	//paint�� setVisible(true);�� �� �ѹ� ȣ���
	//5.
	public void paint(Graphics g) {//����, ������ â �ȿ� �۾� ǥ��, WindowŬ������ �������̵� 
		g.drawString("����", 100, 80);
		g.drawLine(70, 120, 200, 300);
		g.drawLine(200,120, 70, 300);
		g.drawRect(70, 130, 120, 100);
		g.drawOval(70, 130, 120, 100);
	}
}



//���
//is~a
//WindowTest is a Frame �������׽�Ʈ�� �������̴�
//WindowTest�� Frame������ �ϰڴ�
//Frame ������ â�� ������ִ� ��(�ȵ���̵忡���� ���)