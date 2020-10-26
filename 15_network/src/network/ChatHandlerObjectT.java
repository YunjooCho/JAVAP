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
      
      //ois ���� ���� �����Ǿ�� �Ѵ�(�ȱ׷��� ����޼����� �� ���)
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
   }
   
   @Override
   public void run() {
      //Ŭ���̾�Ʈ�� ���� �޴� ��
      InfoDTO dto = null;
      String nickName = null;
      
      while(true) {
         try {
            dto = (InfoDTO)ois.readObject();
            
            if(dto.getCommand() == Info.JOIN) {
               //��� Ŭ���̾�Ʈ����(�� ����) ����޼����� ������ 
               InfoDTO sendDTO = new InfoDTO();
               sendDTO.setCommand(Info.SEND);
               nickName = dto.getNickName();
               sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");
               broadcast(sendDTO);
               
            }else if(dto.getCommand() == Info.EXIT) {
               InfoDTO sendDTO = new InfoDTO();
               
               //quit�� ���� Ŭ���̾�Ʈ���� quit�� ������(������)
               sendDTO.setCommand(Info.EXIT);
               oos.writeObject(sendDTO);
               oos.flush();
               
               ois.close();
               oos.close();
               socket.close();
               
               //���� Ŭ���̾�Ʈ������  ����޼��� ������
               list.remove(this);
               
               sendDTO.setCommand(Info.SEND);
               sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");
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
