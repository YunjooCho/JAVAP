package exception_thread;

public class MakeException extends Exception { //개발자가 만든 Exception클래스(상속), Exception은 상속을 받아 사용자의 임의로 처리하는 것도 가능
	
	//1.필드선언
	private String errorMsg;
	
	
	//2.생성자(기본&매개변수 있는 생성자) - 메시지를 받는 경우와 안 받는 경우를 상정
	//ExceptionTest2클래스의 throw new Exception("범위 초과"); //강제로 Exception발생 부분
	public MakeException() {}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	//3.오버라이드
	@Override
	public String toString() {
		//return getClass() + ":" + errorMsg;
		return errorMsg;
	}
	
	public static void main(String[] args) {
		
	}

}
