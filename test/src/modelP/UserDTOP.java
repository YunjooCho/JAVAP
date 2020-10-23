package modelP;

public class UserDTOP {
	//1.필드선언
	private  int id;
	private String userId;
	private String password;
	private String nickname;
	
	//2.캡슐화
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
	
	//3.오버라이딩
	//파라미터로 넘어온 객체가 이 equals메소드를 실행하는 객체와 같은지 비교하려면
	//1. obj가 이 클래스의 객체인지 확인한다
	//2. obj가 이 클래스의 객체가 맞다면
	//   필드 중 몇몇 정보를 비교해서 같을 때에만 (비교하기 위해 형변환 함)
	//   return true 해준다.
	public boolean equals(Object o) {
		if(o instanceof UserDTOP) {
			UserDTOP userDTOP = (UserDTOP)o;
			if(id == userDTOP.id && userId.equals(userDTOP.userId)) {
				return true;
			}
		}
		return false;
	}
}
