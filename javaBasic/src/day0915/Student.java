package day0915;



public class Student {
	//�л��� �ʵ带 ������
	//�ʵ�� ����ó��
	//�츮�� ������Ÿ�� �ʵ��̸��� �������ָ� �ȴ�.
	
	//�л��� �̸�
	private String name; //�ʵ� //private�� �ٴ� ����, StudentEx01.java������ ������ �� ���� ��
	//name�� ���� ����
	public void setName(String name) {
		this.name = name;//s1, s2�� this�� ��
	}
	//name�� ���� ����
	public String getName() {
		return name;
	}
		
	//�л��� ��������
	private int korean;  //�ʵ�
	//korean�� ���� ����
	public void setKorean(int korean) {
		this.korean = korean;
	}
	//korean�� ���� ����
	public int getKorean() {
		return korean;
	}
	
    //�л��� ��������
	private int english; //�ʵ�
	//english�� ���� ����
	public void setEnglish(int english) {
		this.english = english;
	}
	//english�� ���� ����
	public int getEnglish() {
		return english;
	}
	
	//�л��� ��������
	private int math;    //�ʵ�
	//���������� ���� ����
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	
	//�л��� ������ȣ
	private int id;      //�ʵ�
	//������ȣ�� ���� ����
	public void setId(int id) {
		this.id = id;
	}
	//������ȣ�� ���� ����
	public int getId() {
		return id;
	}


	//�޼ҵ带 ������
	//1. ������ ���ϴ� �޼ҵ�
	public int calculateSum() { //���� ������ ��ü ������ �Ǿ��ֱ� ������ �Ķ���Ͱ� �ʿ����, ()�� ��ĭ
		return korean + english + math;//�Ķ���͸� ���� �ʴ� ��� ���⼭ ���� �����
	}
	
	//2. ����� ���ϴ� �޼ҵ�
	public double calculateAverage() {
		return calculateSum() / 3.0;
	}
	
	//�Ķ���Ͱ� �ִ� ������(��ü �ʱ�ȭ)-�����ڸ��� Ŭ������� ����
	public Student(String name, int id, int korean, int english, int math) {//()�ȿ� ����ִ� �͵��� �Ķ����
		//���� �̸��� ���� ��
		//�Ķ���ʹ�  �ʵ庸�� ȣ�� �켱������ ����
		//���� ���� �̸����� ������ �� �ʵ带 ȣ���� ������
		//��Ȯ�ϰ� "�ش� ��ü�� �ʵ�"��� �������־�� �Ѵ�
		//�̷������� this.�ʵ�� ������ �� �ִ�(this�� ���� �� 31���� ()�� �Ķ���͸� ������ �°���)
		//�� this�� �� �޼ҵ带 �����ϴ� Ŭ������ ��ü �ڽ��� ����Ű�� �ȴ�(s1,s2)
		System.out.println();
		System.out.println("�Ķ���Ͱ� �ִ� ������");
		this.name = name;
		this.id = id;
		this.korean = korean;
		this.english = english;
		this.math = math;
			
		//name = "abc"; //�ʵ��� name�� �ƴ� �Ķ������ name
		
	}
	
	//�Ķ���Ͱ� ���� ������
	public Student() {
		
		
		id = -1; //�ʱ�ȭ
		korean = -1;//�ʱ�ȭ
		english = -1;//�ʱ�ȭ
		math = -1;//�ʱ�ȭ
		
		name = new String(); //String�����ڷ� �ʱ�ȭ, �ƹ��͵� ǥ��ȵ�
		//�� Ȯ���� ���� �Է� name = "���߱�";
		
		//System.out.println("�Ķ���Ͱ� ���� ������ ���� �޼ҵ�(calculateSum): " + calculateSum()); //������ �ʱ�ȭ �� �� �����ڰ� �ִ� Ŭ���� �� �żҵ带 �ҷ��ü� �ִ�
	}
	//static keyword�� �ش� �ʵ� Ȥ�� �޼ҵ带
	//��ü���� ���� ���� ȣ���� �� �ְ� ������ش�.
	//�ٸ� �� ����ƽ�̶� Ű����� �ش� �޼ҵ带
	//���α׷� ���࿵���� ������ ���Խ�Ű�� ���̱� ������
	//���� �ش� �޼ҵ尡 ���ο��� �ٸ� �޼ҵ峪 �ʵ带 ����ϰ� �ȴٸ�
	//�� �ٸ� �޼ҵ峪 �ʵ嵵 ���������� ����ƽ�� �ٿ���
	//���� ������ ���Խ����־�� �Ѵ�.
	//��ǥ���� �� : Integer.parseInt(br.readLine()); -parseInt�޼ҵ�, new��� ����
	
	//equals() �޼ҵ� ����
	//java.lang.Object�� ��ӹ޾ұ� ������ ����� ����
	//StudentEx01���� ���� ���� �־ ��ü�񱳽�(s2.equals(s3)) false�� ������ ���� �ذ��� ���� �������̵� �ǽ�
	public boolean equals(Object obj) { //���� ��Ű���� Ex01Class.java����
		//�Ķ���ͷ� �Ѿ�� ��ü�� �� equals�޼ҵ带 �����ϴ� ��ü�� ������ ���Ϸ���
		//1. obj�� �� Student Ŭ������ ��ü���� Ȯ���Ѵ�
		//2. obj�� Student Ŭ������ ��ü�� �´ٸ�
		//   �ʵ� �� ��� ������ ���ؼ� ���� ������
		//   return true ���ش�.
		
		//1. obj�� StudentŬ������ü���� Ȯ���Ҷ�����
		//	 instanceof Ŭ�����̸� �̶� �ڵ�� Ȯ�� �����ϴ�
		//   instanceof : �ش� Ŭ������ ��ü���� �ƴ����� Ȯ���ϴ� ���๮
		if(obj instanceof Student) {
			//obj�� CarT Ŭ������ ��ü�̹Ƿ�
			//obj�� ī�� ����ȯ ������ �� �ִ�.
			Student st = (Student)obj; //�ʵ尡 �����Ƿ� Ŭ������ CarT�� �ٲ���(����ȯ)
			                           //���� �θ�Ŭ�����̹Ƿ� �ڽ�Ŭ������ �°� �������̵�
			if(name.equals(st.name) && id == st.id){ //�ʵ�� 
				return true;
			}
		}
		return false;
		
	}
	public String toString() { //�������̵�, ��ü ��ü�� ���� ���������� �̻��� ���·� ���
		                       //��ü�� �ʵ峻���� ��Ʈ��({}���� ���)���� �ٲ���
		
		return "�̸� : "+ name
				+", �й� : " + id 
				+", ���� : " + korean + "��"
				+", ���� : " + english + "��"
				+", ���� : " + math + "��";
	
	}
	
}
