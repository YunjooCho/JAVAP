package if_switch;
/*
3���� ����(a,b,c)�� �Է¹޾Ƽ� ������� ����Ͻÿ�

[������]
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
				//�޸� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				//�Է�
				System.out.println("a �Է� :");
				int a = Integer.parseInt(br.readLine());
				System.out.println("b �Է� :");
				int b = Integer.parseInt(br.readLine());
				System.out.println("c �Է� :");
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
