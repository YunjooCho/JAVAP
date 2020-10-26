package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObjectT {
   private ServerSocket ss;
   private List<ChatHandlerObject> list;
   
   public ChatServerObjectT() {
      try {
         ss = new ServerSocket(9500);
         System.out.println("���� �غ� �Ϸ�");
         
         list = new ArrayList<ChatHandlerObject>();
         
         while(true) {
            Socket socket = ss.accept(); //����æ��
            ChatHandlerObject handler = new ChatHandlerObject(socket, list);//������ ����
            handler.start();//������ ���� - ������ ����(run())
            
            list.add(handler);
         }
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new ChatServerObject();
   }

}