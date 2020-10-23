package p13_swing;

public class PersonDTOP {
	private String id;
	private String name;
	private String pwd;
	private String tel;
	
	public PersonDTOP(String id, String name, String pwd, String tel) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public String getTel() {
		return tel;
	}
}
