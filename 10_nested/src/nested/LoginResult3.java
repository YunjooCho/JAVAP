package nested;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginResult3 {
   private Frame frame;
   private String id, pwd;
   
   public LoginResult3(String id, String pwd) {
      frame = new Frame() {
         @Override
         public void paint(Graphics g) {
            if(id.equals("angel") && pwd.equals("1004"))
               g.drawString("로그인 성공", 30,100);
            else
               g.drawString("로그인 실패", 30,100);
         }
         
      };
      
      this.id = id;
      this.pwd = pwd;
      
      frame.setBounds(700,200,200,200);
      frame.setVisible(true);
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            frame.setVisible(false);
         }
      });
   }
   
}
