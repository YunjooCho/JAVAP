package day0910P;

//���� ���� ���α׷�
//�츮�� ����ڷκ��� �Է��� �޵�
//���� �������� ����ڷκ��� ������� ������ �Է� �޾Ƽ�
//���� ����ڰ� ���Ḧ �����ϸ� ���α׷��� ���ᰡ �Ǵ� �������� ������

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05GradeBookP {

	public static void main(String[] args) throws IOException {
		//�޸� ����
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    
	    //Ű����� ���� �Է¹ޱ�
	    int kor = 0, eng = 0, math = 0, tot;
	    String yn;
	    do {
		    do { 
		    	
		    	if(kor > 100 || kor < 0) {
		    		System.out.println("�߸��� �����Դϴ�. �ٽ� �Է��� �ּ���");
		    	}
		    	System.out.println("���� ���� �Է� : ");
		    	kor = Integer.parseInt(bufferedReader.readLine());
		    	
		    }while(kor > 100 || kor < 0);
		    
		    do { 
		    	
		    	if(eng > 100 || eng < 0) {
		    		System.out.println("�߸��� �����Դϴ�. �ٽ� �Է��� �ּ���");
		    	}
		    	System.out.println("���� ���� �Է� : ");
		    	eng = Integer.parseInt(bufferedReader.readLine());
		    	
		    }while(eng > 100 || eng < 0);
	
		    do { 
		
		    	if(math > 100 || math < 0) {
		    		System.out.println("�߸��� �����Դϴ�. �ٽ� �Է��� �ּ���");
		    	}
		    	System.out.println("���� ���� �Է� : ");
		    	math = Integer.parseInt(bufferedReader.readLine());
		
		    }while(math > 100 || math < 0);
		    
		    tot = kor + eng + math;
		    System.out.println("���� : " + tot);
		    System.out.println("��� �Է��Ͻðڽ��ϱ�?(Y/N)");
		    
		    //String �ʱ�ȭ
		    //yn = new String();
		    yn = bufferedReader.readLine().toUpperCase();
	    }while(yn.equals("Y"));
	    System.out.println("���α׷��� �����մϴ�");
	}

}
