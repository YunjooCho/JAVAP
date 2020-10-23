package nested;

//추상클래스이지만 추상메소드가 없다
public abstract class AbstractExam {//추상클래스는 추상메소드가 있을수도 있고 없을 수도 있음
	public void cc() {} //추상메소드라면 public abstract void cc();
	public void dd() {} //추상메소드라면 public abstract void dd();
	
}

//추상클래스 - AbstractExam new할 수 없다.
//추상클래스 안에 메소드는 반드시 빈 body로 한다.
//추상클래스이기 때문에 누군가(자식, 익명Inner) override를 해서 사용해야 하기에
//내용을 갖고 있을 필요가 없다
//개발자가 메소드를 선택해서 원하는 메소드만 Override할 수 있다