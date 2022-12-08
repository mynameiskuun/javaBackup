package DoubleInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonExample extends JFrame implements ActionListener{
	Button bt;
	JButton btl = new JButton("클릭");
//	JLabel lb = new JLabel("여기에");
	
	ButtonExample() {
		Container c = this.getContentPane();
		bt = new Button("연습", c);
		// 번거롭지만 해야하는 작업
		c.setLayout(null);
		bt.setBounds(100,30,80,50);
		c.add(bt);
//		lb.setBounds(100,200,80,50);
//		c.add(lb);
		btl.setBounds(100, 130, 80, 50);
		c.add(btl);
		this.setLocation(600,500);
		this.setSize(400,300);
		this.setVisible(true);
		bt.addActionListener(this);
		btl.addActionListener(this);
	}
	public static void main(String[] args) {
		new ButtonExample();
		
		
//		Button btn = new Button();
//		
//		btn.setOnClickListener(new CallListener());
//		btn.touch();
//		
//		btn.setOnClickListener(new MessageListener());
//		btn.touch();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		bt.setListener(new CallListener());
		bt.touch();
	}
}
