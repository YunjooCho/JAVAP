package _interface;

public interface InterA {
	//���
	public static final String NAME = "ȫ�浿";
	public int AGE = 25; //interface�ȿ����� ������ static final�� ������ ����, �����
	
	public abstract void aa();//�߻�޼ҵ�
	public void bb();//interface�ȿ����� abstract ���� ����, bb()�� �߻�޼ҵ�
	//public void cc() {} - error : body{}�� ������ �Ϲ� �޼ҵ��̹Ƿ� �����߻�(�������̽����� �߻�޼ҵ常 �� �� ����)
}
