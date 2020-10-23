package collection;

//2020.10.12
//DTO, VO : 1인분
//DAO : 데이터베이스(Database Access Object)
public class PersonDTO implements Comparable<PersonDTO> {//(Comparable)
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) {
		//super(); - 필요없으면(상속 사용하지 않으면) 지움
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
	//implement Comparable의 구현(오버라이딩)
	@Override
	public int compareTo(PersonDTO o) { //기준점 설정, 객체끼리 비교(Comparable)
		//오름차순
		/*
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1;
		//else if(this.age == o.age) return 0;
		else return 0;
		*/
		
		//내림차순
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}
	@Override
	public String toString() {//(Comparable)
		return "이름 = " + name + " 나이 = " + age;
	}
	
	
}
