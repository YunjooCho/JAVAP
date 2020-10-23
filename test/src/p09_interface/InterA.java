package p09_interface;

public interface InterA {
	public static final String NAME = "홍길동";
	public int AGE = 25;
	
	public abstract void aa(); //추상메소드
	public void bb(); //추상메소드
	//public void cc() {}; - error : {}가 있으면 일반 메소드이므로 에러발생
}
