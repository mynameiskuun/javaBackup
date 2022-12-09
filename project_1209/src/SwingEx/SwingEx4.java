package SwingEx;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SwingEx4 extends JFrame{

	class ex4 implements ActionListener{
		
		ex4(int a){
			System.out.println("asd");
			this.a = a;
		}
		
		int a;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ㅁㄴㅇ" + a);
		}
	}
	
	JButton jb = new JButton("클릭");

	SwingEx4() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		jb.addActionListener(new ex4(10));
		this.setLocation(500,400);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingEx4();
	}
}
