package p11_collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackTestP {

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź", "�����Ʈ", "����","���ѹα�"};
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < groupA.length; i++) {
			stack.push(groupA[i]); //�ѹ����϶��� {}�� �����ϴ� ��쵵 ����
		}
		
		while( ! stack.isEmpty()) out.println(stack.pop());
	}

}
