package exception_thread;

public class SingleTon {

	private int num = 3;
	private static SingleTon instance = null;
	
	public static SingleTon getInstance(){ //싱글톤메소드로 보편적인 이름
		if(instance == null) {
			synchronized (SingleTon.class) { //클래스를 동기화로 막아줌, 처음실행이면 생성
				instance = new SingleTon(); //instance가 주소값을 가지게 됨
			}
		}
		return instance; //처음 실행이 아니면 만든 객체를  return시켜줌
	}
	
	public static void main(String[] args) {
		//this가 영역값을 갖고 있음...?
		//싱글톤 - 실행시 매번 객체를 생성하는 것이 아닌 static이라는 메모리의 특성을 이용하여 객체를 한번만 만들어 사용하는 것 - 예시 : 로그인
		
		//new시켜버리면 싱글톤이 아님
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();
		
		
		
		System.out.println("*** 싱글톤 ***"); //static이 싱글톤X, static의 기능을 이용하여 싱글톤을 만듦
		SingleTon cc = SingleTon.getInstance(); //생성
		cc.num++;
		System.out.println("aa = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); //생성
		aa.num++;
		System.out.println("aa = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
		
	}

}
