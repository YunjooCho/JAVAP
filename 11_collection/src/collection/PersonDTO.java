package collection;

//2020.10.12
//DTO, VO : 1�κ�
//DAO : �����ͺ��̽�(Database Access Object)
public class PersonDTO implements Comparable<PersonDTO> {//(Comparable)
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) {
		//super(); - �ʿ������(��� ������� ������) ����
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//2020.10.13
	//implement Comparable�� ����(�������̵�)
	@Override
	public int compareTo(PersonDTO o) { //������ ����, ��ü���� ��(Comparable)
		//��������
		/*
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1;
		//else if(this.age == o.age) return 0;
		else return 0;
		*/
		
		//��������
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}
	@Override
	public String toString() {//(Comparable)
		return "�̸� = " + name + " ���� = " + age;
	}
	
	
}
