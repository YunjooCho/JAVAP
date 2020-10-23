package if_switch;
/*
3개의 숫자(a,b,c)를 입력받아서 순서대로 출력하시오

[실행결과]
a : 68
b : 50
c : 45
45, 50, 68

a : 30
b : 50
c : 45
30, 45, 50
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IfTest3 {

	public static void main(String[] args) throws IOException {
				//메모리 생성
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				//입력
				System.out.println("a 입력 :");
				int a = Integer.parseInt(br.readLine());
				System.out.println("b 입력 :");
				int b = Integer.parseInt(br.readLine());
				System.out.println("c 입력 :");
				int c = Integer.parseInt(br.readLine());
				
				if (a < b) {
					if (a < c) {
						if (b < c) {
							System.out.println(a + "," + b + "," + c);
						}
						else {
							System.out.println(a + ","+ c + "," + b);
						}
					}else {
						System.out.println(c + "," + a + "," + b);
					}
				}else if (b < c){
					if(b < a) {
						if(a < c) {
							    System.out.println(b + "," + a + "," + c);
							}else {
								System.out.println(b +  "," + c + "," + a);
							}
					}else {
						if (a < b) {
							System.out.println(c + "," + a + "," + b);
						}else {
							System.out.println(c + "," + b + "," + a);
						}
					}
				}else {
					if(a < b) {
						System.out.println(c + "," + a + "," + b);
					}else {
						System.out.println(c + "," + b + "," + a);
					}
				}
			
				
			}

		}
