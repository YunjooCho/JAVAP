package exception_thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ExceptionTest2 {

	private int number;
	
	public static void main(String[] args) throws Exception { //�����ο� ����ó���� �ɷ������� ȣ��ο����� ����ó���� �ʿ���
		ExceptionTest2 ex = new ExceptionTest2();
		ex.input();
		ex.output();

	}
	
	public void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� ���� �Է� : ");
		number = Integer.parseInt(br.readLine());
		
	}
	
	public void output() {
		
//		for(int i = number; i <= number ; i++) {
//			for(int j = 1; j <= 9 ; j++) {
//			  int result = i * j;
//			  System.out.println(i + "*" + j + "=" + result);
//			}
//			
//		}
		
		if(number >= 2 && number <= 9) {
			for(int i = 1; i <= 9; i++){
				System.out.println(number + "*" + i + "=" + (number*i));
			}
		}else {
			//System.out.println("���� �ʰ�");
			
			//���α׷��Ӱ� ������ Exception�� �߻�
			//�ڡ��߿�!!�ڡ� throws�� ����(���� �߻��� ����), throw �Ϻη� ����ó�� �߻�
			try {
				//throw new Exception("���� �ʰ�"); //������ Exception�߻�,()�ȿ� ���ϴ� �޽����� �Է��ϸ� error�߻� �� ���� ǥ�õ�
				                                 //������ �߻��ߴٴ� ���� �����ϰ� �˷���
				throw new MakeException("���� �ʰ�"); 
				
			} catch(Exception e){
				e.printStackTrace(); //���� �����޽��� �߻�
			}
		}
	}
	
	
}

