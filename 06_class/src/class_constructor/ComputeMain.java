package class_constructor;
/*
x와 y의 값을 받아서 합,차,곱,몫을 구하시오

클래스명 : Compute
필드      : x, y, sum, sub, mul, div
메소드   : 생성자를 통해서 데이터를 주입
        calc() - 합, 차, 곱, 몫을 계산
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
[실행결과]
X      Y      SUM      SUB      MUL      DIV
320    258
256	   125
452    365
 */
public class ComputeMain {

	public static void main(String[] args) {
		//객체배열
//		Compute[] ar = new Compute[3]; //여기서 new는 Compute라는 클래스를 생성한 것이 아닌,
//

	    //배열1
		//방 3개인 배열을 생성한 것이다.
//		ar[0] = new Compute(320,258);
//		ar[1] = new Compute(256,125);
//		ar[2] = new Compute(452,365);
		
		//배열2
//		Compute[] ar = {new Compute(320, 258), new Compute(256,125), new Compute(452,365)};
		//배열3
		Compute[] ar = new Compute[]{new Compute(320,258),
                                     new Compute(256, 125),
                                     new Compute(452, 365)};
		//방의 갯수를 지정한 것이 아님(동적할당)
		//이전 방에 추가 되는 것은 어레이리스트, 그냥 배열은 새롭게 배열을 생성하는 것
		
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV\t");
		/*
		for(int i = 0; i < ar.length; i++) {
			ar[i].calc();
			
			System.out.println(ar[i].getX() + "\t" 
					+ar[i].getY() + "\t"
					+ar[i].getSum() + "\t"
					+ar[i].getSub() + "\t"
					+ar[i].getMul() + "\t"
					+String.format("%.2f", ar[i].getDiv()));
		}//for
		*/
//		ar[0].calc();
//		ar[1].calc();
//		ar[2].calc();
		
		for(Compute data : ar) { //length를 안써도 배열의 크기만큼 for문이 돈다.
			data.calc();
			System.out.println(data.getX() + "\t" 
					+data.getY() + "\t"
					+data.getSum() + "\t"
					+data.getSub() + "\t"
					+data.getMul() + "\t"
					+String.format("%.2f", data.getDiv()));
		}
	}

}


//Compute c = new Compute(320, 258);//다른 패키지에 있으면 import가 필요
//c.calc();
//System.out.println(c.getX() + "\t" 
//				+c.getY() + "\t"
//				+c.getSum() + "\t"
//				+c.getSub() + "\t"
//				+ c.getMul() + "\t"
//				+String.format("%.2f", c.getDiv()));
//
//Compute bb = new Compute(256, 125);//다른 패키지에 있으면 import가 필요
//bb.calc();
//System.out.println(bb.getX() + "\t" 
//				+bb.getY() + "\t"
//				+bb.getSum() + "\t"
//				+bb.getSub() + "\t"
//				+bb.getMul() + "\t"
//				+String.format("%.2f", bb.getDiv()));
//
//Compute cc = new Compute(452, 365);//다른 패키지에 있으면 import가 필요
//cc.calc();
//System.out.println(cc.getX() + "\t" 
//				+cc.getY() + "\t"
//				+cc.getSum() + "\t"
//				+cc.getSub() + "\t"
//				+cc.getMul() + "\t"
//				+String.format("%.2f", cc.getDiv()));
//
