package modelP;

public class UserDTOP {
	//1.�ʵ弱��
	private  int id;
	private String userId;
	private String password;
	private String nickname;
	
	//2.ĸ��ȭ
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
	
	//3.�������̵�
	//�Ķ���ͷ� �Ѿ�� ��ü�� �� equals�޼ҵ带 �����ϴ� ��ü�� ������ ���Ϸ���
	//1. obj�� �� Ŭ������ ��ü���� Ȯ���Ѵ�
	//2. obj�� �� Ŭ������ ��ü�� �´ٸ�
	//   �ʵ� �� ��� ������ ���ؼ� ���� ������ (���ϱ� ���� ����ȯ ��)
	//   return true ���ش�.
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
