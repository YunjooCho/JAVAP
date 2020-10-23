package model;

public class UserDTO {
	//��1. �ʵ�
	private int id;
	private String userId;
	private String password;
	private String nickname; 
	
	
	//��2. ĸ��ȭ(�ʵ尡 private�̹Ƿ� ������ ȣ���ϰų� �����Ҷ� ����/���� ���)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean equals(Object o) {
		if(o instanceof UserDTO) {
			UserDTO userDTO = (UserDTO)o;
			if(id == userDTO.id && userId.equals(userDTO.userId)) { //��id�� userId�� ������ �����ι�
				return true;
			}
		}
		return false;
	}
	
}
