package abstractMethod;

public abstract class AbstractTest { //POJO(Plain Old Java Object)���� - �⺻Ʋ
	                        //�߻�޼ҵ带 ������ �ִ� Ŭ������ �ݵ�� �߻�Ŭ�������� �Ѵ�
	//�ʵ��
	protected String name;
	
	//ĸ��ȭ
	public abstract void setName(String name);//�߻�޼ҵ�(�޼ҵ��� {}body�� ����)
//	public void setName(String name) {//����
//		this.name = name;
//	}
// {} - �޼ҵ���  Body
	
	public String getName() {//����
		return name;
	}
}


//1.;���� �޼ҵ� �ۼ� ����({}������)
//2.�޼ҵ忡 abstact ����
//3.Ŭ������ abstact ����