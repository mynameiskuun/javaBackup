package project_1214;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Win extends JFrame{
	JButton jb = new JButton("새 창");
	JButton jb1 = new JButton("검색");
	JButton jb2 = new JButton("검색2");
	JTextArea ta = new JTextArea(7,20);
	JFrame fr1;
	
	Win() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jb);
		c.add(jb2);
		c.add(ta);
		this.setSize(400,300);
		this.setLocation(500,500);
		this.setVisible(true);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentDao dao = new StudentDao();
				dao.connection();
				List<Student> list = dao.select();
				for(Student stu : list) {
					ta.append(stu.toString()+"\n");
//					System.out.println(stu);
				}
			}
			
		});
//		ta.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jb.setEnabled(false);
				System.out.println("클릭!");
				fr1 = new JFrame("새 창");
				JButton bt1 = new JButton("닫기");
				Container c = fr1.getContentPane();
				c.setLayout(new FlowLayout());
				c.add(bt1);
				fr1.setSize(400,300);
				fr1.setLocation(500,500);
				fr1.setVisible(true);
				bt1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						fr1.setVisible(false);
						jb.setEnabled(true);
						System.out.println("닫기");
					}
				});
			}
		});
	}
	
	public static void main(String[] args) {
		new Win();
		
	}
}
