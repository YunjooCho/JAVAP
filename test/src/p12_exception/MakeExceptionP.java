package p12_exception;

public class MakeExceptionP extends Exception { //�����ڰ� ���� ExceptionŬ����(���) - ����ó���� ����� �޾�
	
	//1.�ʵ弱��
	private String errorMsg;

	//2.������
	public MakeExceptionP() {}
	
	public MakeExceptionP(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	//3.�������̵�
	@Override
	public String toString() {
		return errorMsg;
	}
}
