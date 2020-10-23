package loop;

import java.io.IOException;

/*
원하는 단을 입력 : 2  ← System.in.read()
2*1=2
2*2=4
2*3=6
2*4=8
2*5=10
2*6=12
2*7=14
2*8=16
2*9=18
 */
public class ForTest2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("원하는 단을 입력 : ");
		
		int num = System.in.read()-48;
		for(int i = num; i <= num; i++) {
			for(int j = 1; j<= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
		}
		//for(int i = 1; i <= 9; i++){
		//	System.out.println();
	}

}
