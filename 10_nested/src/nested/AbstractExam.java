package nested;

//�߻�Ŭ���������� �߻�޼ҵ尡 ����
public abstract class AbstractExam {//�߻�Ŭ������ �߻�޼ҵ尡 �������� �ְ� ���� ���� ����
	public void cc() {} //�߻�޼ҵ��� public abstract void cc();
	public void dd() {} //�߻�޼ҵ��� public abstract void dd();
	
}

//�߻�Ŭ���� - AbstractExam new�� �� ����.
//�߻�Ŭ���� �ȿ� �޼ҵ�� �ݵ�� �� body�� �Ѵ�.
//�߻�Ŭ�����̱� ������ ������(�ڽ�, �͸�Inner) override�� �ؼ� ����ؾ� �ϱ⿡
//������ ���� ���� �ʿ䰡 ����
//�����ڰ� �޼ҵ带 �����ؼ� ���ϴ� �޼ҵ常 Override�� �� �ִ�