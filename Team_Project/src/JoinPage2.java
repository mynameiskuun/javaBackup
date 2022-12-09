import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinPage2 extends JFrame implements ActionListener {

	Connection conn;
	Statement stmt;
	ResultSet rs;

	Data data = new Data();

	Container con = this.getContentPane();
	JTextField nameF = new JTextField();
	JTextField signUpIdF = new JTextField();
	JPasswordField signUpPwF = new JPasswordField();
	JPasswordField signUpPwCheckF = new JPasswordField();
	JTextField phoneNumberF = new JTextField();
	JTextField birthF = new JTextField();
	JTextField nickNameF = new JTextField();
	JLabel nameL = new JLabel("이름");
	JLabel signUpIdL = new JLabel("아이디");
	JLabel signupPwL = new JLabel("비밀번호");
	JLabel signUpPwCheckL = new JLabel("비밀번호 확인");
	JLabel phoneNumberL = new JLabel("휴대폰 번호");
	JLabel birthL = new JLabel("생년월일");
	JLabel nickNameL = new JLabel("닉네임");
	JButton doublecheck, ok, cancel;
	JPanel signupPanel = new JPanel();

	public JoinPage2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");
		setBounds(50, 50, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정
		setVisible(true);
		con.add(signupPanel, BorderLayout.CENTER);
		this.add(signupPanel);
		signupPanel.setVisible(true);
		signupPanel.setLayout(null);
		this.add(signupPanel);
		signupPanel.add(nameL);
		nameL.setBounds(350, 20, 100, 30);
		signupPanel.add(nameF);
		nameF.setBounds(420, 25, 120, 25);
		signupPanel.add(signUpIdL);
		signUpIdL.setBounds(350, 80, 100, 30);
		signupPanel.add(signUpIdF);
		signUpIdF.setBounds(420, 85, 120, 25);
		signupPanel.add(signupPwL);
		signupPwL.setBounds(350, 140, 100, 30);
		signupPanel.add(signUpPwF);
		signUpPwF.setBounds(420, 145, 120, 25);
		signupPanel.add(signUpPwCheckL);
		signUpPwCheckL.setBounds(320, 200, 100, 30);
		signupPanel.add(signUpPwCheckF);
		signUpPwCheckF.setBounds(420, 205, 120, 25);
		signupPanel.add(phoneNumberL);
		phoneNumberL.setBounds(350, 260, 100, 30);
		signupPanel.add(phoneNumberF);
		phoneNumberF.setBounds(420, 265, 120, 25);
		signupPanel.add(birthL);
		birthL.setBounds(350, 320, 100, 30);
		signupPanel.add(birthF);
		birthF.setBounds(420, 325, 120, 25);
		signupPanel.add(nickNameL);
		nickNameL.setBounds(350, 380, 100, 30);
		signupPanel.add(nickNameF);
		nickNameF.setBounds(420, 385, 120, 25);

		doublecheck = new JButton("중복체크");
		signupPanel.add(doublecheck);
		doublecheck.setBounds(570, 83, 90, 30);
		ok = new JButton("확인");
		signupPanel.add(ok);
		ok.setBounds(350, 440, 90, 30);
		cancel = new JButton("취소");
		signupPanel.add(cancel);
		cancel.setBounds(500, 440, 90, 30);

		doublecheck.addActionListener(new DoubleCheckMethod());
		// 중복체크 버튼 누르면 중복체크 함수 실행
		ok.addActionListener(new JoinMethod());
		// 확인 버튼 누르면 DB에 업로드
	}

	void insert(String name, String id, String phoneNumber, String birth, String ninkName, String passWord)
			throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'" + name + "','" + id + "','" + phoneNumber
				+ "','" + birth + "','" + ninkName + "','" + passWord + "')");
		System.out.println(result + "건 입력 성공");
	} // insert method

	int checkId(String id) throws SQLException {

		stmt = conn.createStatement();
		int result = stmt.executeUpdate("select * from student where id=?");

		if (rs.next()) {
			JOptionPane.showMessageDialog(null, "ID 중복");
			System.out.println("중복");
		} else {
			JOptionPane.showMessageDialog(null, id + "는 사용 가능합니다");
			System.out.println("ID OK");

		}
		return result;
	}

	class DoubleCheckMethod implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				checkId(signUpIdF.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class JoinMethod implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "회원가입 OK");
//			checkId("asd");
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ok) {
			data.name = nameF.getText();
			data.id = signUpIdF.getText();
			data.phoneNumber = phoneNumberF.getText();
			data.birth = birthF.getText();
			data.ninkName = nickNameF.getText();
//			char[] a = new char[2];
//			String a = signUpPwF.getText();
//			String b = signUpPwCheckF.getText();
//			
//			if(a.equals(b) ) {
//				System.out.println(a);
//			}
//			String a = signUpPwF.getText();
//			String b = signUpPwCheckF.getText();
//			if (a.equals(b)) {
//				System.out.println(a);
//			}

			String str = "";
			char str1[] = signUpPwF.getPassword();
			char str2[] = signUpPwCheckF.getPassword();
			boolean flag = true;
			for (int i = 0; i < str1.length; i++) {
				if (str1[i] != str2[i]) {
					flag = false;
					break;
				}
				str += str1[i];

			}
			if (flag) {
				System.out.println(str);
//				String str = new String(signUpPwF.getPassword());
//				System.out.println(str);
//				data.password = new String(signUpPwF.getPassword());
				try {
					insert(data.name, data.id, data.phoneNumber, data.birth, data.ninkName, str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("암호 불일치");
			}
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new JoinPage2();

	}
}