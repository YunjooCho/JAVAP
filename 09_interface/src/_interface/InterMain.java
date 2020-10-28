package _interface;

//public class InterMain implements InterA, InterB {//다중상속 아님 - extends사용 안되어 있음
public class InterMain implements InterC {
	//The type InterMain must implement the inherited abstract method InterA.bb()
	//인터페이스의 모든 메소드를 반드시 오버라이드 해야 함
	//그러나 본 클래스에서 오버라이드 하지 않을 경우, class 앞에 abstract해줌 -> abstract class InterMain... 
	
	//InterA의 메소드 오버라이드
	public void aa() {}
	public void bb() {}
	
	public void cc() {}
	public void dd() {}
	
	public static void main(String[] args) {
		
	}
}
