package collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackTest {

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź","�����Ʈ","����","���ѹα�"};
		Stack<String> stack = new Stack<String>(); //���ʸ��� ���װ� ������ ���� Ŭ�������� ��
		
		for(int i = 0; i < groupA.length; i++) 
			stack.push(groupA[i]); //�ѹ����϶��� {}�� �����ϴ� ��쵵 ����
								   //��� �߰�
		
		while( ! stack.isEmpty()) //���ÿ� �ڷᰡ ������� �ʴٸ� - ����(FALSE)�� ����, ������ �� ��� while������ ��������
			out.println( stack.pop() ); //�ѹ����϶��� {}�� �����ϴ� ��쵵 ����
		     							//��� ���(����?)
	}

}
