package exception_thread;

public class MakeException extends Exception { //�����ڰ� ���� ExceptionŬ����(���), Exception�� ����� �޾� ������� ���Ƿ� ó���ϴ� �͵� ����
	
	//1.�ʵ弱��
	private String errorMsg;
	
	
	//2.������(�⺻&�Ű����� �ִ� ������) - �޽����� �޴� ���� �� �޴� ��츦 ����
	//ExceptionTest2Ŭ������ throw new Exception("���� �ʰ�"); //������ Exception�߻� �κ�
	public MakeException() {}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	//3.�������̵�
	@Override
	public String toString() {
		//return getClass() + ":" + errorMsg;
		return errorMsg;
	}
	
	public static void main(String[] args) {
		
	}

}
