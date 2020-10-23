package exception_thread;

public class SingleTon {

	private int num = 3;
	private static SingleTon instance = null;
	
	public static SingleTon getInstance(){ //�̱���޼ҵ�� �������� �̸�
		if(instance == null) {
			synchronized (SingleTon.class) { //Ŭ������ ����ȭ�� ������, ó�������̸� ����
				instance = new SingleTon(); //instance�� �ּҰ��� ������ ��
			}
		}
		return instance; //ó�� ������ �ƴϸ� ���� ��ü��  return������
	}
	
	public static void main(String[] args) {
		//this�� �������� ���� ����...?
		//�̱��� - ����� �Ź� ��ü�� �����ϴ� ���� �ƴ� static�̶�� �޸��� Ư���� �̿��Ͽ� ��ü�� �ѹ��� ����� ����ϴ� �� - ���� : �α���
		
		//new���ѹ����� �̱����� �ƴ�
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();
		
		
		
		System.out.println("*** �̱��� ***"); //static�� �̱���X, static�� ����� �̿��Ͽ� �̱����� ����
		SingleTon cc = SingleTon.getInstance(); //����
		cc.num++;
		System.out.println("aa = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); //����
		aa.num++;
		System.out.println("aa = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
		
	}

}
