package nested;

public abstract class AbstractTest { //POJO(Plain Old Java Object) : �⺻����
									 //�߻�޼ҵ尡 �ֱ� ������ �߻�Ŭ������ ��
	String name;
	
//	public void setName(String name) {//���� - �޴���, ������ �ʿ�
//		this.name = name;
//	}
	public abstract void setName(String name);//�߻�Ŭ����
	
	
	public String getName() {//����
		return name;
	}
}

//�߻�޼ҵ尡 ������ �ݵ�� �߻�Ŭ������
//�߻�Ŭ������� �ؼ� �ݵ�� �߻�޼ҵ尡 �ִ� ���� �ƴ�