package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClientObjectT extends JFrame implements ActionListener, Runnable {
   private JTextField input;
   private JButton send;
   private JTextArea output;
   
   private Socket socket;
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   
   public ChatClientObjectT() {
      output = new JTextArea();
      JScrollPane scroll = new JScrollPane(output);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      output.setEditable(false);
      
      input = new JTextField();
      
      send = new JButton("보내기");
      
      JPanel p = new JPanel();
      p.setLayout(new BorderLayout());
      p.add("Center", input);
      p.add("East", send);
      
      Container con = this.getContentPane();
      con.add("Center",scroll);
      con.add("South",p);
      
      setBounds(700,200,300,300);
      setVisible(true);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            if(ois==null || oos==null) System.exit(0);
            
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.EXIT);
            try {
               oos.writeObject(dto);
               oos.flush();
            } catch (IOException io) {
               io.printStackTrace();
            }
         }
      });
   }//ChatClientObject()
   
   public void service() {      
      String serverIP = JOptionPane.showInputDialog(null,"서버IP를 입력하세요","192.168.0.98");
      if(serverIP==null || serverIP.length()==0){
         System.out.println("서버IP가 입력되지 않았습니다");
         System.exit(0);
      }
      
      //닉네임
      String nickName = JOptionPane.showInputDialog(null,
                                       "닉네임을 입력하세요",
                                       "닉네임",
                                       JOptionPane.INFORMATION_MESSAGE);
      if(nickName==null || nickName.length()==0){
         nickName="guest";
      }
      
      //소켓생성
      try {
         socket = new Socket(serverIP, 9500);

         ois = new ObjectInputStream(socket.getInputStream());
         oos = new ObjectOutputStream(socket.getOutputStream());
         
      } catch (UnknownHostException e) {
         System.out.println("서버를 찾을 수 없습니다");
         e.printStackTrace();
         System.exit(0);
         
      } catch (IOException e) {
         System.out.println("서버를 찾을 수 없습니다");
         e.printStackTrace();
         System.exit(0);
      }
      
      try {
         //서버로 닉네임 보내기
         InfoDTO dto = new InfoDTO();
         dto.setCommand(Info.JOIN);
         dto.setNickName(nickName);
         oos.writeObject(dto);
         oos.flush();

      } catch (IOException e) {
         e.printStackTrace();
      }
      
      //스레드 생성
      Thread t = new Thread(this);
      //스레드 시작 - 스레드 실행(run())
      t.start();
      
      //이벤트
      send.addActionListener(this);
      input.addActionListener(this); //JTextField에서 엔터
      
   }//service()
   
   @Override
   public void run() {
      //서버로부터 받는 쪽
      InfoDTO dto = null;
      
      while(true) {
         try {
            dto = (InfoDTO)ois.readObject();
            
            if(dto.getCommand() == Info.EXIT) {
               ois.close();
               oos.close();
               socket.close();

               System.exit(0);
               
            }else if(dto.getCommand() == Info.SEND) {
               output.append(dto.getMessage() + "\n");
            
               int pos = output.getText().length();
               output.setCaretPosition(pos);
            }
            
         } catch (IOException e) {
            e.printStackTrace();
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
      }//while
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      //서버로 보내는 쪽
      String msg = input.getText();
      
      InfoDTO dto = new InfoDTO();
      
      if(msg.toLowerCase().equals("quit")) {
         dto.setCommand(Info.EXIT);
         
      }else {
         dto.setCommand(Info.SEND);
         dto.setMessage(msg);
      }
      
      try {
         oos.writeObject(dto);
         oos.flush();
      } catch (IOException e1) {
         e1.printStackTrace();
      }
      
      input.setText("");
   }

   public static void main(String[] args) {
      new ChatClientObjectT().service();

   }

}
