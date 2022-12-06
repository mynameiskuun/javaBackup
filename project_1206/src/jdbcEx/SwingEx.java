package jdbcEx;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx extends JFrame implements ActionListener{

	Scanner scan = new Scanner(System.in);
	
	JButton sel = new JButton("검색");
	JButton del = new JButton("삭제");
	JButton mod = new JButton("수정");
	JButton cre = new JButton("생성");
	
	Jdbc stu;
	
	SwingEx() throws ClassNotFoundException, SQLException {
		stu = new Jdbc();
		// 접속완료 메소드
		
		Container con = this.getContentPane();
	
		con.add(mod);
		con.add(cre);
		con.add(sel);
		con.add(del);
		
		cre.setBounds(30,5,50,50);
		mod.setBounds(80,5,50,50);
		del.setBounds(130,5,50,50);
		sel.setBounds(180,5,50,50);
		
		this.setVisible(true);
		this.setSize(750, 300);
		this.setLocation(30, 30);
		
		sel.addActionListener(this);
		del.addActionListener(this);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new SwingEx();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sel) {
//			System.out.println("sel 버튼 클릭!");
			try {
				stu.selectAll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getSource() == del) {
//			System.out.println("del 버튼 클릭!");
			try {
				stu.delete("김사랑");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getSource() == mod) {
			System.out.println("수정할 아이디");
			int id = scan.nextInt();
			try {
				if(id == stu.rs.getInt(id)) {
					String newName = scan.next();
					String newHak = scan.next();
					String newAdd = scan.next();
					stu.update("newName","newHak","newAdd",id);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if(e.getSource() == del) {
			System.out.println("삭제할 이름");
			String name = scan.next();
			try {
				if(name.equals(stu.rs.getInt(name))) {
					stu.delete(name);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	

}

12/06

//1. instanceof
//2. 익명 구현 객체
//3. 인터페이스 구현
//4. 예외
//5. buffet
//6. mysql
