package p11_collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackTestP {

	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디","대한민국"};
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < groupA.length; i++) {
			stack.push(groupA[i]); //한문장일때는 {}을 생략하는 경우도 있음
		}
		
		while( ! stack.isEmpty()) out.println(stack.pop());
	}

}
