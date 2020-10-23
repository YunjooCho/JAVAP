package model;

public class UserDTO {
	//▶1. 필드
	private int id;
	private String userId;
	private String password;
	private String nickname; 
	
	
	//▶2. 캡슐화(필드가 private이므로 정보를 호출하거나 설정할때 겟터/셋터 사용)
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
			if(id == userDTO.id && userId.equals(userDTO.userId)) { //▶id와 userId가 같으면 동일인물
				return true;
			}
		}
		return false;
	}
	
}
