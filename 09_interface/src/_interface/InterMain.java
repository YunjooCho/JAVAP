package _interface;

//public class InterMain implements InterA, InterB {//���߻�� �ƴ� - extends��� �ȵǾ� ����
public class InterMain implements InterC {
	//The type InterMain must implement the inherited abstract method InterA.bb()
	//�������̽��� ��� �޼ҵ带 �ݵ�� �������̵� �ؾ� ��
	//�׷��� �� Ŭ�������� �������̵� ���� ���� ���, class �տ� abstract���� -> abstract class InterMain... 
	
	//InterA�� �޼ҵ� �������̵�
	public void aa() {}
	public void bb() {}
	
	public void cc() {}
	public void dd() {}
	
	public static void main(String[] args) {
		
	}
}
