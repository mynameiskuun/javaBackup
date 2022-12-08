package project_1208;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WinEx extends JFrame{
	
	JButton jb1 = new JButton("1");
	JButton jb2 = new JButton("2");
	JButton jb3 = new JButton("3");
	JButton jb4 = new JButton("4");
	JButton jb5 = new JButton("5");
	JButton jb6 = new JButton("6");
	JButton jb7 = new JButton("7");
	JButton jb8 = new JButton("8");
	JButton jb11 = new JButton("1");
	JButton jb12 = new JButton("2");
	JButton jb13 = new JButton("3");
	JButton jb14 = new JButton("4");
	JButton jb15 = new JButton("5");
	JButton jb16 = new JButton("6");
	JButton jb17 = new JButton("7");
	JButton jb18 = new JButton("8");
	
	WinEx() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// x누르면 실행 종료
		Container c = this.getContentPane();
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.LEFT, 30,30));
		c.add(jpl, BorderLayout.NORTH);
		this.setLocation(300,300);
		this.setSize(400,300);
		this.setVisible(true);
		jpl.add(jb1);
		jpl.add(jb2);
		jpl.add(jb3);
		jpl.add(jb4);
		jpl.add(jb5);
		jpl.add(jb6);
		jpl.add(jb7);
		jpl.add(jb8);		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(4,2,10,10));
		jp2.add(jb11);
		jp2.add(jb12);
		jp2.add(jb13);
		jp2.add(jb14);
		jp2.add(jb15);
		jp2.add(jb16);
		jp2.add(jb17);
		jp2.add(jb18);
		c.add(jp2,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WinEx();
		
	}

}
