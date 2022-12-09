package SwingEx;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx5 extends JFrame{

	JButton jb = new JButton("클릭");

	SwingEx5() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		jb.setBounds(100, 30, 80, 40);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("클릭!!");
			}
			
		});
		c.add(jb);
		this.setLocation(500,400);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingEx5();
	}
}
