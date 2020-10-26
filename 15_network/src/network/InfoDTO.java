package network;

import java.io.Serializable;

enum Info{
	JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable { //����ȭ(��ü�� ������ �ۼ���)�� ����
	private static final long serialVersionUID = 1L;//����ȭ�� ������ ������� ������ ������ ������
 	
	private String nickName;
	private String message;
	private Info command;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Info getCommand() {
		return command;
	}
	public void setCommand(Info command) {
		this.command = command;
	}
	

}

//BufferedReader, PrintWriter ������� ����
//InfoDTO ��ü�� �����͸� �ѱ�� �ް� - ObjectInputStream, ObjectOutputStream (table�� �μ��� ��)