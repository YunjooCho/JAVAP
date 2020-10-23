package exception_thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ExceptionTest2 {

	private int number;
	
	public static void main(String[] args) throws Exception { //구현부에 예외처리가 걸려있으면 호출부에서도 예외처리가 필요함
		ExceptionTest2 ex = new ExceptionTest2();
		ex.input();
		ex.output();

	}
	
	public void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단을 입력 : ");
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
			//System.out.println("범위 초과");
			
			//프로그래머가 강제로 Exception을 발생
			//★★중요!!★★ throws는 예방(에러 발생을 방지), throw 일부러 예외처리 발생
			try {
				//throw new Exception("범위 초과"); //강제로 Exception발생,()안에 원하는 메시지를 입력하면 error발생 시 같이 표시됨
				                                 //에러가 발생했다는 것을 강력하게 알려줌
				throw new MakeException("범위 초과"); 
				
			} catch(Exception e){
				e.printStackTrace(); //빨간 에러메시지 발생
			}
		}
	}
	
	
}

