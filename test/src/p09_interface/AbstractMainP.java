package p09_interface;

public class AbstractMainP {

	public static void main(String[] args) {
		
		//AbstractTestP at = new AbstractTestP(); - Ŭ������ �߻�ȭ�� ���� new������ ��� ����
		//at.setName("ȫ�浿");
		//System.out.println("�̸� = " + at.getName());
		
		//�߻�Ŭ����&�߻�޼ҵ�
		AbstractTestP at = new AbstractTestP() {//�͸� InnerŬ���� 1 - ��Ӿ��� �߻�Ŭ������ ��ü ������ �ǵ��� ����(�������̵� ����)
			@Override
			public void setName(String name) {
				this.name = name;
			}
		}; //��ü������ ��������
		
		//�������̽�&�߻�޼ҵ�
		InterA in = new InterA() {
			public void aa() {};
			public void bb() {};
		};

		
		//�߻�Ŭ����&�Ϲݸ޼ҵ�(��body)
		AbstractExamP exam = new AbstractExamP() {
			public void cc() {}
		};
	}

}
