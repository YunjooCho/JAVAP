package _interface;

public interface InterA {
	//상수
	public static final String NAME = "홍길동";
	public int AGE = 25; //interface안에서만 가능한 static final가 생략된 형태, 상수임
	
	public abstract void aa();//추상메소드
	public void bb();//interface안에서만 abstract 생략 가능, bb()도 추상메소드
	//public void cc() {} - error : body{}가 있으면 일반 메소드이므로 에러발생(인터페이스에는 추상메소드만 올 수 있음)
}
