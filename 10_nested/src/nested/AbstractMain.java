package nested;

public class AbstractMain {

	public static void main(String[] args) {
		//AbstractTest�� Ŭ������ setName�޼ҵ带 ���� �߻�Ŭ����, �߻�޼ҵ�� ������
		//AbstractTest at = new AbstractTest(); - error
		//�߻�Ŭ����(AbstractTest)�� new���� �ȵ� -> 1. �ڽ�Ŭ������ ����(�ݵ�� Override �ؾ� �Ѵ�) : ����ʿ�  2. �޼ҵ�� ����
//		at.setName("ȫ�浿");
//		System.out.println("�̸� = " + at.getName());
		
		//����1 - �߻�Ŭ����&�߻�޼ҵ�                                     
		AbstractTest at = new AbstractTest() {//�͸� InnerŬ����1 - ��Ӿ��� �߻�Ŭ������ ��ü ������ �ǵ��� ����(�߻�޼ҵ��� Overriding ����)
											  //������ ����� ���ְ� �߻�޼ҵ带 Override����� ��
			public void setName(String name) {//����, Override
				this.name = name;
			}
		};
		//����2 - �������̽�&�߻�޼ҵ�        //�͸�InnerŬ����2
		InterA in  = new InterA() { //InterA�������̽��� �߻�޼ҵ� ����(�������̵�)
									//�� �κ��� �������̽��� new���� �� ���� �ƴ�
									//�͸�Ŭ������ ������ ����
			                        //�޼ҵ��� body�� ���� �� �ִ� ���� Ŭ��������
									//�� ������ �ȵ���̵忡�� ���� ����
			public void aa() {} //�߻�޼ҵ��� �������̵�, �޼ҵ峻���� ����
			public void bb() {} //�߻�޼ҵ��� �������̵�, �޼ҵ峻���� ����
		};
		
		//����3 - �߻�Ŭ����&�Ϲݸ޼ҵ�(��body)
		AbstractExam ae = new AbstractExam() { //�͸�InnerŬ����3
											   //�Ϲݸ޼ҵ尡 �ִ� �Ͱ� ������� Ŭ������ �߻�Ŭ�����̹Ƿ� new������ ���Ұ�
			public void cc() {}
		};
	}
}

//�͸� Ŭ������ �߻�Ŭ����, �������̽����� ��밡�� - new�κп� �߻�Ŭ������ �Ǵ� �������̽����� �;���
//�� �Ʒ��� �ش� �߻�Ŭ����, �ش� �������̽��� �޼ҵ尡 �;���(�������̵��ؾ��ϱ� ������)
//���, �߻�, �������̽�, ��øŬ����