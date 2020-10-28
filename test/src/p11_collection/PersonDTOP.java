package p11_collection;

public class PersonDTOP implements Comparable<PersonDTOP> {
	
	//1.필드 선언
	private String name;
	private int age;
	
	//2.생성자
	public PersonDTOP(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "이름 = " + name + " 나이 = " + age;
	}

	//Comparable 인터페이스 구현
	@Override
	public int compareTo(PersonDTOP o) {
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}
}
