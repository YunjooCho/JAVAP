package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.google.com/index.html");
		System.out.println("��������  = " + url.getProtocol());
		System.out.println("ȣ��Ʈ = " + url.getHost());
		System.out.println("��Ʈ = " + url.getPort()); //���� URL���� �ƹ��͵� ���縦 ���ؼ� ���� ���ٴ� ���� -1�� ��ȯ��
		System.out.println("�⺻ ��Ʈ  = " + url.getDefaultPort());
		System.out.println("���� = " + url.getFile());
		System.out.println();
		
		
		//IOStream - �Է½�Ʈ��
		//IO�� ������ Ȩ�������� �ҽ��ڵ带 Consoleâ�� ����
		//openStream() - ��ȯ�� : InputStream
		BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
		//������ ���� : BufferedReader bufferkey = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line = buffer.readLine()) != null) {
			System.out.println(line + "\n");
		}//while
		
		buffer.close();
	}

}

//UTF-8
//encoding(euc-kr)