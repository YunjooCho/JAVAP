package day0916;

public class CarEx03Array {
	final static int SIZE = 3;
	public static void main(String[] args) {
		CarT[] carArray = new CarT[SIZE]; //이전에 CarT클래스를 만들어져 있어야 함
										  //클래스의 배열은 값이 아니라 클래스들이 모여있는것
			                              //그러므로 아래 초기화를 보면 여러 자료형이 모여있는 것처럼 착각할 수 있음
										  //실상은 클래스가 모여있는 것이고 그 클래스 안에 아래 값들이 들어있는 것이다
		for(int i = 0; i < carArray.length; i++) {
			
			//클래스의 배열은 배열 생성과 초기화 이후에
			//각 위치마다 우리가 생성자를 호출해서 (new)
			//해당 인덱스에 초기화를 해주어야 한다.
			//하지 않으면 NullPointerException이 발생한다.
			carArray[i] = new CarT();//배열 초기화 null -> 0
 			carArray[i].setNumber("00가 000" + i);
			carArray[i].setType("소나타");
			carArray[i].setYear(2020);
			carArray[i].setPrice(7000000);
			carArray[i].setColor("노란색");
		}
		
		for(int i = 0; i < carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}

}
