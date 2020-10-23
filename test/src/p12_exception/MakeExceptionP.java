package p12_exception;

public class MakeExceptionP extends Exception { //개발자가 만든 Exception클래스(상속) - 예외처리를 상속을 받아
	
	//1.필드선언
	private String errorMsg;

	//2.생성자
	public MakeExceptionP() {}
	
	public MakeExceptionP(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	//3.오버라이드
	@Override
	public String toString() {
		return errorMsg;
	}
}
