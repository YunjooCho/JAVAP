package network;

enum Info{
	JOIN, EXIT, SEND
}

public class InfoDTO {
	
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