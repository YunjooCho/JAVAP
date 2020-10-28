package nested;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginResult2 extends Frame {
   private Login login;
   
   public LoginResult2(Login login) {
      this.login = login;
      
      setBounds(700,200,200,200);
      setVisible(true);
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            setVisible(false);
         }
      });
   }
   
   @Override
   public void paint(Graphics g) {
      String id = login.getId();
      String pwd = login.getPwd();
      
      if(id.equals("angel") && pwd.equals("1004"))
         g.drawString("로그인 성공", 30,100);
      else
         g.drawString("로그인 실패", 30,100);
   }
}
