package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObjectT extends Thread {
   private Socket socket;
   private List<ChatHandlerObjectT> list;
   
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   
   public ChatHandlerObjectT(Socket socket, List<ChatHandlerObjectT> list) throws IOException {
      this.socket = socket;
      this.list = list;
      
      //ois 보다 먼저 생성되어야 한다(안그러면 입장메세지가 안 뜬다)
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
   }
   
   @Override
   public void run() {
      //클라이언트로 부터 받는 쪽
      InfoDTO dto = null;
      String nickName = null;
      
      while(true) {
         try {
            dto = (InfoDTO)ois.readObject();
            
            if(dto.getCommand() == Info.JOIN) {
               //모든 클라이언트에게(나 포함) 입장메세지를 보내기 
               InfoDTO sendDTO = new InfoDTO();
               sendDTO.setCommand(Info.SEND);
               nickName = dto.getNickName();
               sendDTO.setMessage(nickName+"님 입장하였습니다");
               broadcast(sendDTO);
               
            }else if(dto.getCommand() == Info.EXIT) {
               InfoDTO sendDTO = new InfoDTO();
               
               //quit를 보낸 클라이언트에게 quit를 보내기(나에게)
               sendDTO.setCommand(Info.EXIT);
               oos.writeObject(sendDTO);
               oos.flush();
               
               ois.close();
               oos.close();
               socket.close();
               
               //남은 클라이언트에게즈  퇴장메세지 보내기
               list.remove(this);
               
               sendDTO.setCommand(Info.SEND);
               sendDTO.setMessage(nickName+"님 퇴장하였습니다");
               broadcast(sendDTO);
               
               break;
               
            }else if(dto.getCommand() == Info.SEND) {
               InfoDTO sendDTO = new InfoDTO();
               sendDTO.setCommand(Info.SEND);
               sendDTO.setMessage("["+nickName+"] "+dto.getMessage());
               broadcast(sendDTO);
            }
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }//while
      
   }
   
   public void broadcast(InfoDTO sendDTO) {
      for(ChatHandlerObjectT handler : list) {
         try {
            handler.oos.writeObject(sendDTO);
            handler.oos.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }//for
   }
}
