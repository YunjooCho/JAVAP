package nested;

public abstract class AbstractTest { //POJO(Plain Old Java Object) : 기본형식
									 //추상메소드가 있기 때문에 추상클래스가 됨
	String name;
	
//	public void setName(String name) {//구현 - 메뉴판, 생성이 필요
//		this.name = name;
//	}
	public abstract void setName(String name);//추상클래스
	
	
	public String getName() {//구현
		return name;
	}
}

//추상메소드가 있으면 반드시 추상클래스임
//추상클래스라고 해서 반드시 추상메소드가 있는 것은 아님
