package exception_thread;

class JoinTest implements Runnable {

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
//==================================================================================
public class JoinMain {

	public static void main(String[] args) {
		//������ ����
		JoinTest jt = new JoinTest();
		Thread thread = new Thread(jt); //jt�κп��� this�� �Է��ؼ��� �ȵ�
		System.out.println("�����带 �����ϰڽ��ϴ�");
		//������ ����
		thread.start();
		try {
			thread.join(); //��JOIN
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�����尡 ����˴ϴ�");
		//main�� ������ ��׶��忡�� ������� ���ư��� ������ ������� �ʴ´�.
		
		//<�����>
		//�����带 �����ϰڽ��ϴ�
		//�����尡 ����˴ϴ�
		//1
		//2
		//3
		//4
		//5
		
		//<����>
		//�����带 �����ϰڽ��ϴ�
		//1
		//2
		//3
		//4
		//5
		//�����尡 ����˴ϴ�
		//���󰪿� ���� ������� ������ ���� : start()���� �ٷ� run()���� ���� ���� �ƴ�
		//                          ������� Background���� ��� ��
		
		//join()�� �Է��ϸ� ���󰪴�� ������� ��µ�
	}

}
