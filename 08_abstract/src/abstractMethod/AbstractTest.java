package abstractMethod;

public abstract class AbstractTest { //POJO(Plain Old Java Object)형식 - 기본틀
	                        //추상메소드를 가지고 있는 클래스는 반드시 추상클래스여야 한다
	//필드명
	protected String name;
	
	//캡슐화
	public abstract void setName(String name);//추상메소드(메소드의 {}body가 없음)
//	public void setName(String name) {//구현
//		this.name = name;
//	}
// {} - 메소드의  Body
	
	public String getName() {//구현
		return name;
	}
}


//1.;으로 메소드 작성 종료({}사용안함)
//2.메소드에 abstact 선언
//3.클래스에 abstact 선언
