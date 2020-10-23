package p12_exception;

class JoinTestP implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

//====================================================================================
public class JoinMainP {

	public static void main(String[] args) {
		
		JoinTestP jt = new JoinTestP(); //������ ����
		Thread thread = new Thread(jt);
		System.out.println("�����带 �����ϰڽ��ϴ�");
		
		thread.start();//������ ����
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("�����尡 ����˴ϴ�");

	}

}
