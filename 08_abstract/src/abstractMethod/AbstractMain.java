package abstractMethod;

import java.util.Calendar;
import java.util.GregorianCalendar;

public  class AbstractMain extends AbstractTest {

	public void setName(String name) {//�߻�޼ҵ�� ���� �ڽ�Ŭ�������� �������̵� ����� ��
		this.name = name;
	}
	
	public static void main(String[] args) {
		//Ŭ���� ����
		//AbstractTest at = new AbstractTest(); - �߻�Ŭ������ �ڱ��ڽ��� new(����)�� �� ����.
		//���� : �߻�Ŭ���������� �ν��Ͻ��� ������ �� ����.
		//�ڽ� Ŭ���� �̿�
		// 1. �ݵ�� �ڽ�Ŭ������ �θ�Ŭ������ �߻�޼ҵ带 Override�ؾ� �Ѵ�
		
		AbstractTest at = new AbstractMain(); 
		//�߻�Ŭ������ �߻�޼ҵ� ������ �ڱ� �ڽ��� ������ �� �����Ƿ� �ڽ�Ŭ������ �޼ҵ�(�߻�޼ҵ�X)�� ���� ������ �Ѵ� 
		//������, ��� �θ�� �ڽ�Ŭ������ ������ �� �ִ�
		//�θ�Ŭ������ Ʋ�� ������ �ڽ�Ŭ������ ����
		at.setName("ȫ�浿"); //�������̵� - ����(AbstractMain,�ڽ�Ŭ����)�� �޼ҵ常�� ȣ��� �� ����
		System.out.println(at.getName());
	
		
		//Calendar cal = new Calendar(); -error
		Calendar cal = new GregorianCalendar();
		GregorianCalendar gc = new GregorianCalendar();
		
	}
	
	
	

}
