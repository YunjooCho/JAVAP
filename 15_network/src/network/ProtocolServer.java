package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
	
	private ServerSocket ss;
	private BufferedReader br; //Ŭ���̾�Ʈ�� �����ϰ� �޽����� �ְ���� �� �ִ� ����� �ʿ�(������ ������־�� ��)
	private BufferedWriter bw;
	private Socket socket;
	
	public ProtocolServer() {
		try {
			ss = new ServerSocket(9500);//��Ʈ��
			System.out.println("������ �غ� �Ϸ�Ǿ����ϴ�"); //Ŭ���̾�Ʈ�� ���϶����� ������ ��ٸ�(�� �� ���� �� ����)
			
			socket = ss.accept(); //Ŭ���̾�Ʈ�� ����è
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0); //������ �������� ������ѹ���
		}
		
   //-------------------------------------------------------------
		String line, msg;
		while(true) {
			//Ŭ���̾�Ʈ�κ��� ���� �޼��� �б�
			try {
				line = br.readLine(); //Client���� bw.write(msg + "\n")�� '\n'�� �����־�� ���� ���� �о����(�ƴϸ� ������ ���� ã�ƴٴ�)
									  //"100 : angel"    "200 : angel"   "300 : angel : �ȳ�" �� ����
				
				//Ŭ���̾�Ʈ�� ������(�ɰ��� ������)
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) { //Protocol���� ������ ����� �迭 0��°�� ����ִٸ�
					bw.write(ar[1] + "�� ����\n"); //�ٹٲ��� �ؾ� Ŭ���̾�Ʈ�ʿ��� �о����
					System.out.println(ar[1] + "�� ����\n");
					bw.flush();
				}else if(ar[0].equals(Protocol.EXIT)) { //200�� ������ �ٷ� ��������
					bw.write(ar[1] + "�� ����\n"); //���� �޽��� ������ "angel�� ����"
					System.out.println(ar[1] + "�� ����\n");
					bw.flush();
					
					br.close(); //Ŭ���̾�Ʈ�� ���� ���ʿ� ������ �����Ƿ� ���ʴ� close()����� ������(���⼭�� Ŭ���̾�Ʈ�ʸ� ������ ��)
					bw.close();
					socket.close();
					
					System.exit(0); //���α׷� ����
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("[" + ar[1] + "]" + ar[2] + "\n"); //�޽��� ������
					bw.flush();//���ۺ���
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			
		}//while
		
		
	}
	
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
}
