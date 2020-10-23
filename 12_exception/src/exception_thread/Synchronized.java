package exception_thread;

//1.���
public class Synchronized extends Thread { //�� Ŭ������ �����尡 ��
	
	//6.�ʵ�
	private static int count; //��ü 3���� count�ʵ带 ����
	
	public static void main(String[] args) {
		
		//2.������ ����
		Synchronized aa = new Synchronized();
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		
		//3.������ �̸�����
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		//4.������ ����
		aa.start();
		bb.start();
		cc.start();
		
	}
	
	//5.run()�޼ҵ� �������̵� -  run()�� ������ ��ü�� ����
	@Override
		//public synchronized void run() { //����ȭ X sychronizedŰ���带 �Է��������� �ұ�
		  public void run() {
			synchronized(Synchronized.class) { //����ȭ O ���� �ٸ� ��ü(Ŭ����)�� ����ȭ ��Ű�ڴٴ� �ǹ� - �ϳ��� Ŭ�������ϸ� ���(�̱���ó���� ���)
		      //synchronized(this){ //����ȭ X - this�� �� �ٸ�(������ ��ü aa, bb, cc)
				for(int i = 1; i <= 5; i++) {
					count++;
					System.out.println(Thread.currentThread().getName() + " : " + count);
					//�޼ҵ忡 <sychronized>�ɱ� ��
					//���������� �����ϱ� ������ aa : 2 cc : 2�� ���� �ߺ����� ������ ��쵵 ����
					//��¼����� count�� ������ ���� �ʱ⵵ ��
					
					//�޼ҵ忡 <sychronaize>�� ��
					//������ �ߺ��Ǵ� count�� ��� - ����ȭ�� ����� �ɸ��� ���� ����
					
					//synchronized(Synchronized.class) {}�� �Է��� ��
					//����ȭ�� ����� ����
				}//for
			}
		}
}


//��ATMTest�� �ٸ� ���� ATMTest�� ��� �ϳ��� Ŭ����(atm)�� ���� - �� ��� ������ ����ȭ ����� �� ����,
//  ���⿡���� ���� aa, bb, cc�� ������ Ŭ������ �����߱� ������ ������ run()�� ���� ��