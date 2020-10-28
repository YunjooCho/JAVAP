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
         System.out.println("서버 준비 완료");
         
         list = new ArrayList<ChatHandlerObject>();
         
         while(true) {
            Socket socket = ss.accept(); //낚아챈다
            ChatHandlerObject handler = new ChatHandlerObject(socket, list);//스레드 생성
            handler.start();//스레드 시작 - 스레드 실행(run())
            
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
