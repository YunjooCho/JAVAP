package p11_collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueTestP {

	public static void main(String[] args) {
		
		String[] item = {"�ҳ�Ÿ", "������","���Ծ�"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String s : item) {
			q.offer(s); //����߰� 
		}
		
		out.println("q�� ũ�� : " + q.size() + "\n");
		String data = "";
		
		while((data = q.poll()) != null){
			out.println(data + "����!");
			out.println("q�� ũ�� : " + q.size() + "\n");
		}//while
		

	}

}
