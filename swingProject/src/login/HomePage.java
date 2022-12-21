package login;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame {
   JDBC db;
   JButton jbMy = new JButton("마이페이지 바로가기");
   JButton jbCourse = new JButton("수강신청 바로가기");
   JButton jbLogout = new JButton("로그아웃");
//   JLabel home = new JLabel("회원 홈");
   

   HomePage(JDBC db) {
      this.db = db;
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container cp = this.getContentPane();
      this.setVisible(true);
      jbMy.setBounds(250, 230, 200, 200);
      jbCourse.setBounds(550, 230, 200, 200);
      jbLogout.setBounds(650, 520, 100, 50);
      
//      home.setBounds(80, 80, 600, 100);
//      home.setFont(new Font("굴림",Font.BOLD,30));
//      cp.add(home);
      
      cp.add(jbMy);
      cp.add(jbCourse);
      cp.add(jbLogout);
      this.setLayout(null);
      this.setLocation(100, 100);
      this.setSize(1000, 800);
     
    
      
      jbCourse.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			try {
				MemberRequestClassGUI requestClass = new MemberRequestClassGUI(db);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	  
      });
      
      jbMy.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			try {
				MemberMyPageGUI myPage = new MemberMyPageGUI(db);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
    	  
      });
      
      jbLogout.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			LoginGUI login = new LoginGUI();
			
			login.jframe.setVisible(true);
			
		}
    	  
      });
   }
//   public static void main(String[] args) {
//      new HomePage();
//   }
}
   
