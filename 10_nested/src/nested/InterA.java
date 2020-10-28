package nested;

public interface InterA {
	public abstract void aa(); //abstract생략 가능(인터페이스 특성상)
	public void bb();
}

//interface를 사용하려면 main메소드가 있는 곳에서 implement 인터페이스명으로 불러야 함
//익명클래스를 통해서 본 인터페이스의 추상메소드를 구현(AbstractMain 참조)
//인터페이스는 상속이다(X)
//인터페이스는 상속과 비슷하다(O)
