package exception_thread;

//5.���
public class SnackTest extends Thread {
	
	//1.�ʵ弱��
	private String str;
	
	
	//2.������
	public SnackTest(String str) {
		this.str = str;
	}
	
	
	//3.�޼ҵ� - 8. �ݹ����� ���� //�ڡ�start()���� ȣ��?
	public void run() {
		//9.������ �帧 Ȯ���Ҽ� �ְ� ����
		//11.i�� �� �߰�
		for(int i = 1; i <= 5; i++) { //���⼭ i�� ��� 1,2,3...�����ϴ� ���� �ƴ϶�
			                          //����� i = 1,2,3....
			                          //��īĨ i = 1,2,3....
			 						  //��Ĩ i = 1,2,3... �̷��� ���� ����� ��
			System.out.println(str + "\t" + "i - " + i + "\t"+Thread.currentThread()); //�ڡ�str�� ���� ���� 5���� �����µ� �� ����� �ٸ�?
			                                                                            //�ڡ�Thread.currentThread()�� �帧�� �����ִ� �� �ƴ���?
		}
	}
	
	
	//4.��ü����
	public static void main(String[] args) {
		//6.������ ���� - ��ü�������� �������� ����
		SnackTest aa = new SnackTest("�����"); //������ ���� Thread-0
		SnackTest bb = new SnackTest("��īĨ"); //������ ���� Thread-1
		SnackTest cc = new SnackTest("��Ĩ");  //������ ����  Thread-2
		
//		aa.run();
//		bb.run();
//		cc.run(); //������(���������� ������� ����)
		
		//10.������ �̸� �ο�
		aa.setName("�����"); //Thread-0
		bb.setName("��īĨ"); //Thread-1
		cc.setName("��Ĩ");  //Thread-2
		
		//13.�켱���� 1~10 �ο�(default : 5) - 1~10������ �߰�(11,12,13...)�ϰų� ���ϼ�(3,5...)�� ����
		//aa.setPriority(Thread.MAX_PRIORITY); //MAX_PRIORITY�� �ִ����(final static)�̹Ƿ� 10��(1~10���� �����ű�)
		//�ڡڳ����� 1,5,10�� ������ ������ ���ڴ� ���� �������?? �� �켱������ �ִµ� ������ ������ ����??
		aa.setPriority(10); //���� �켱������ ����
		bb.setPriority(Thread.MIN_PRIORITY); //1 ���� �켱������ ����
		cc.setPriority(Thread.NORM_PRIORITY); //5 �߰� �켱����
		
		
		
		
		//7.�����带 ������ �غ�
		aa.start(); //������ ����-> ������ ����(run())
		//12.join() & ����ó��
//		try {
//			aa.join(); //join()�� ���� �� error - interrupt, ������ �ش� ��ü�� ���α׷��� ���������� ��� ����
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		} 
		bb.start();
		cc.start();
	}

}
