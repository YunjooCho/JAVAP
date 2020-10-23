package p11_collection;

public class PersonDTOP implements Comparable<PersonDTOP> {
	
	//1.�ʵ� ����
	private String name;
	private int age;
	
	//2.������
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
		return "�̸� = " + name + " ���� = " + age;
	}

	//Comparable �������̽� ����
	@Override
	public int compareTo(PersonDTOP o) {
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}
}
