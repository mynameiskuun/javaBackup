package project_1208;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WinEx2 extends JFrame{
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JLabel lb1 = new JLabel("NAME");
	JLabel lb2 = new JLabel("ID");
	JLabel lb3 = new JLabel("PASSWORD");
	JLabel lb4 = new JLabel("BIRTHDAY");
	JLabel lb5 = new JLabel("PHONENUMBER");
	JLabel lb6 = new JLabel("NICKNAME");

	JLabel lb7 = new JLabel("회원가입");
	
	JButton jb1 = new JButton("가입완료");
	JButton jb2 = new JButton("이전");
	
	WinEx2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JButton jb1 = new JButton("1");
//		JButton jb2 = new JButton("2");
//		JButton jb3 = new JButton("3");
//		JButton jb4 = new JButton("4");
		
		Container c = this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		jp1.setLayout(new GridLayout(7,1,20,20));
		jp2.setLayout(new GridLayout(7,1,50,20));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		jb1.setBounds(200, 20, 70, 70);
//		jp2.setLayout(new FlowLayout(FlowLayout.RIGHT, 30,30));
		this.setLocation(300,300);
		this.setSize(1000,800);
		this.setVisible(true);
		c.add(jp1,BorderLayout.WEST);
		c.add(jp2,BorderLayout.CENTER);
		c.add(jp3,BorderLayout.EAST);
		c.add(jp4,BorderLayout.SOUTH);
		c.add(jp5,BorderLayout.NORTH);
	
		jp1.add(lb1);
		jp1.add(lb2);
		jp1.add(lb3);
		jp1.add(lb4);
		jp1.add(lb5);
		jp1.add(lb6);
		jp1.add(lb7);
		
		jp2.add(tf1);
		jp2.add(tf2);
		jp2.add(tf3);
		jp2.add(tf4);
		jp2.add(tf5);
		jp2.add(tf6);
		
		jp4.add(jb1);
		jp4.add(jb2);
		
		jp5.add(lb7);
		
	}
	public static void main(String[] args) {
		
		new WinEx2();
	}

}
