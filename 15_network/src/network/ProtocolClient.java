package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	private BufferedReader keyboard;//Ű����
	
	public ProtocolClient() throws IOException {
		try {
			socket = new Socket("192.168.0.17", 9500); //IP : ���ּ� ��Ʈ(9500) : �̸� - ��Ʈ
													   //IP�� Ʋ���� ���� "Ŭ���̾�Ʈ�� ������ �� �����ϴ�"������ ��
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
			
		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�"); 
			e.printStackTrace();
			System.exit(0);
		}

//-----------------------------------------------------------------------------------------------
		String msg, line;
		while(true) {
			//������ ������ ��(Output) - bw
			msg = keyboard.readLine();
			bw.write(msg + "\n"); //"100 : angel"    "200 : angel"   "300 : angel : �ȳ�"
								  // bw : ������ ������ ������ �ǽ�
								  // readLine()�� ���͸� �ν����� ����
								  // ���������� readLine()���� �о���϶� ����(������ ��)�� ã�� ���� ��(Lock�ɸ�)
								  // ->����ȵ� (����å���� ���͸� �Ϻη� �־���("\n")
			bw.flush(); //���۸� ���� ���÷� �ٽ� �޽����� ������ �ϹǷ� ���۸� ��������
			
			
			
			//�����κ��� �޴� ��(Input) - br
			line = br.readLine();   //"angle�� ����"    "angel�� ����"    "[angel] �ȳ�" - Protocol.java�� ����� ���� ������
			System.out.println(line);
			
			String[] ar = msg.split(":"); //":"�� �������� ������ -> �迭�� ���� (StringTokenizer)
			if(ar[0].equals(Protocol.EXIT)) {
				br.close(); //Ŭ���̾�Ʈ�� ���� ���ʿ� ������ �����Ƿ� ���ʴ� close()����� ������(���⼭�� Ŭ���̾�Ʈ�ʸ� ������ ��)
				bw.close();
				socket.close();
				
				keyboard.close();
				System.exit(0);
			}
			
		}//while
		
	}//ProtocolClient()
	
	public static void main(String[] args) throws IOException {
		new ProtocolClient(); //error - java.net.ConnectException: Connection timed out: connect
	}

}







