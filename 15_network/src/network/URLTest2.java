package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	
	
	//private static String line; 21�� �� ���⼭ �����ص� ����� �Ȱ��� ����, �ʱ�ȭ ���ʿ�
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
		//InputStreamReader - �� ������, Ű����, ���� ���� ���� ������ �޾Ƶ��� ��
		//BufferedReader - �� �� �� �о��
		String line = null; //���������� �����Ⱚ�� �������
		int index;
		int count = 0;
		while((line = buffer.readLine()) != null) { //�� ������(Ȩ������)�� �ҽ��ڵ�� �������̹Ƿ� ����(null)�� �������� �о���̱� ���� while�� ���
			line = line.toLowerCase();//������ �����͸� ���� �ҹ��ڷ� �ٲ���(�� �������� �ƴ� console�� �ҷ����� �ִ� ���� �ٲ�)
									  //line = �� ���༭ ������ �������
			index = 0;
			while((index = line.indexOf("14k", index)) != -1) { //ó�� �ѹ� ã�Ƶ� �����ε����� �����Ƿ� ������ �� �̻� ã�� ����, 
								 							 //�ش� ���ڸ� ã���� �����ε����� �� ���� ��ġ���� ã����  �ؾ���
								    						 //14k 3�����̹Ƿ� indexOf()�� ����� + 3�� �ؾ���
				index += ("14k".length()); //"14k".length() = 3(14k�� ���ڼ�)
				count++;
			}
		}//while
		System.out.println("14k�� ���� = " + count);
		buffer.close();
	}
}


//��ҹ��� �������� �� ã������ 14k 14K
//meta ����
//Script - Java Script


//�� Ǯ��
//while((line = buffer.readLine()) != null) { //�� ������(Ȩ������)�� �ҽ��ڵ�� �������̹Ƿ� ����(null)�� �������� �о���̱� ���� while�� ���
//	System.out.println(line + "\n");
//	while(line.indexOf("14K") > 0 || line.indexOf("14k") >= 0) {
//		count++;
//	}
//}//while