import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinPage1 extends JFrame implements ActionListener {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;

	JTextField tf1 = new JTextField("ENTER NAME");
	JTextField tf2 = new JTextField("ENTER ID");
	JPasswordField tf3 = new JPasswordField();
	JPasswordField tf4 = new JPasswordField();
	JTextField tf5 = new JTextField("PLEASE ENTER BIRTHDAY");
	JTextField tf6 = new JTextField("PLEASE ENTER PHONEMUNBER");
	JTextField tf7 = new JTextField("PLEASE ENTER NICKNAME");
	JLabel lb1 = new JLabel("NAME");
	JLabel lb2 = new JLabel("ID");
	JLabel lb3 = new JLabel("PASSWORD");
	JLabel lb4 = new JLabel("PASSWORD CHECK");
	JLabel lb5 = new JLabel("BIRTHDAY");
	JLabel lb6 = new JLabel("PHONENUMBER");
	JLabel lb7 = new JLabel("NICKNAME");

	JLabel lb8 = new JLabel("회원가입");

	JButton jb1 = new JButton("가입완료");
	JButton jb2 = new JButton("이전");
	
	JoinPage1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");

		Container c = this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		jp1.setLayout(new GridLayout(7, 1, 20, 20));
		jp2.setLayout(new GridLayout(7, 1, 50, 20));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		jb1.setBounds(200, 20, 70, 70);
//		jp2.setLayout(new FlowLayout(FlowLayout.RIGHT, 30,30));
		this.setLocation(300, 100);
		this.setSize(1000, 800);
		this.setVisible(true);
		c.add(jp1, BorderLayout.WEST);
		c.add(jp2, BorderLayout.CENTER);
		c.add(jp3, BorderLayout.EAST);
		c.add(jp4, BorderLayout.SOUTH);
		c.add(jp5, BorderLayout.NORTH);

		jp1.add(lb1);
		jp1.add(lb2);
		jp1.add(lb3);
		jp1.add(lb4);
		jp1.add(lb5);
		jp1.add(lb6);
		jp1.add(lb7);
		jp1.add(lb8);

		jp2.add(tf1);
		jp2.add(tf2);
		jp2.add(tf3);
		jp2.add(tf4);
		jp2.add(tf5);
		jp2.add(tf6);
		jp2.add(tf7);

		jp4.add(jb1);
		jp4.add(jb2);

		jp5.add(lb8);
//		jb1.addActionListener(this);

		tf3.selectAll();
		jb1.addActionListener(this);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JoinPage1 joinpage1 = new JoinPage1();
	}

	public void actionPerformed(ActionEvent e) {
//		if (actionEvent.getSource() == ok) {
//            String data = nameF.getText(); 
//            System.out.println(data);
//        }
	}
	
}