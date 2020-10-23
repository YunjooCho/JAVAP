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

//BufferedReader, PrintWriter 사용하지 말것
//InfoDTO 객체로 데이터를 넘기고 받고 - ObjectInputStream, ObjectOutputStream (table에 인쇄한 것)