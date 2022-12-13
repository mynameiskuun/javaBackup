
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Win extends JFrame {
	JLabel lb = new JLabel("여기");
	JTextField tf = new JTextField("검색", 10);
	JButton bt = new JButton("클릭");
	Win() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lb);
		c.add(bt);
		c.add(tf);
		Thread th = new Thread() {
			public void run() {
				for (;;) {
					LocalDateTime now = LocalDateTime.now();
					lb.setText(now.getSecond()+"초");
				}
			}
		};
		th.start();
		bt.addActionListener((e) -> {

			
				try {
					int num = Integer.parseInt(tf.getText());
//					return;
//					System.out.println(num);
					if (num >= 100) {
						throw new MyNumException("100 이상");
					} else {
						JOptionPane.showMessageDialog(null, num);
					}
		
				} catch(NumberFormatException ev) {
					JOptionPane.showMessageDialog(null, "숫자만 입력!");
//					ev.printStackTrace();
//					System.out.println("숫자만 입력!");
				} catch(MyNumException ev2) {
					JOptionPane.showMessageDialog(null, ev2.getMessage()+" 입력 바람");
				}finally {
					JOptionPane.showMessageDialog(null, "끝!");
				}
				
			}
			
		);
		bt.addActionListener((e) -> {
		
				try {
					int num = Integer.parseInt(tf.getText());
//					return;
//					System.out.println(num);
					if (num >= 100) {
						throw new MyNumException("100 이상");
					} else {
						JOptionPane.showMessageDialog(null, num);
					}
		
				} catch(NumberFormatException ev) {
					JOptionPane.showMessageDialog(null, "숫자만 입력!");
//					ev.printStackTrace();
//					System.out.println("숫자만 입력!");
				} catch(MyNumException ev2) {
					JOptionPane.showMessageDialog(null, ev2.getMessage()+" 입력 바람");
				}finally {
					JOptionPane.showMessageDialog(null, "끝!");
				}
		
		
		});
		
		tf.addFocusListener(new FocusListener() {
		
			@Override
			public void focusGained(FocusEvent e) {
				tf.setText("");
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setLocation(500, 400);
		this.setSize(400, 300);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Win();

	}

}
