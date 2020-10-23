package p03_method;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("��ū ���� = " + st.countTokens());
	
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("------------------------------------");
		
		String[] ar = str.split(",");
		for(String data : ar) {
			System.out.println(data);
		}
		System.out.println("ar�迭 ũ�� = " + ar.length);
	}

}
