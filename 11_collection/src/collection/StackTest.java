package collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackTest {

	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄","쿠웨이트","사우디","대한민국"};
		Stack<String> stack = new Stack<String>(); //제너릭은 좌항과 우항이 같은 클래스여야 함
		
		for(int i = 0; i < groupA.length; i++) 
			stack.push(groupA[i]); //한문장일때는 {}을 생략하는 경우도 있음
								   //요소 추가
		
		while( ! stack.isEmpty()) //스택에 자료가 비어있지 않다면 - 부정(FALSE)의 부정, 스택이 다 비면 while문에서 빠져나옴
			out.println( stack.pop() ); //한문장일때는 {}을 생략하는 경우도 있음
		     							//요소 출력(삭제?)
	}

}
