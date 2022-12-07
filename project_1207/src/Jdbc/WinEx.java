package Jdbc;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WinEx extends JFrame implements ActionListener{
	JTextField tf = new JTextField();
	JButton jb = new JButton("검색");
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane();
	Jdbc jdbc;
	
	WinEx() throws ClassNotFoundException, SQLException {
		jdbc = new Jdbc();
		Container c = this.getContentPane();
		c.setLayout(null);
		tf.setBounds(100, 20, 80, 30);
		c.add(tf);
		jb.setBounds(200, 20, 70, 70);
		c.add(jb);
		tf.setBounds(300, 20, 80, 30);
		c.add(tf);
		jb.setBounds(400, 20, 70, 70);
		c.add(jb);
//		ta.setBounds(30, 100, 400, 150);
//		c.add(ta);
		
//		c.add(new JScrollPane(ta));
		this.setSize(1000,800);
		this.setVisible(true);
		this.setLocation(0, 0);
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new WinEx();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			jdbc.delete(tf.getText());
			jdbc.selectAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
