package SwingEx;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭!!!");
	}
	
}

class alert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
public class SwingEx3 extends JFrame{

	JButton jb = new JButton("클릭");

	SwingEx3() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		c.add(jb);
		jb.addActionListener(new Listener());
//		jb.addActionListener(this);
		this.setLocation(500,400);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SwingEx3();
		
	}


//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭!");
//	}
}
