import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class w1e extends JFrame {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;

	Container con = this.getContentPane();
	JTextField nameF = new JTextField();
	JTextField signUpIdF = new JTextField();
	JPasswordField signUpPwF = new JPasswordField();
	JPasswordField signUpPwCheckF = new JPasswordField();
	JTextField phoneNumberF = new JTextField();
	JTextField birthF = new JTextField();
	JTextField nickNameF = new JTextField();
	// ------------------------//
	JLabel joinL = new JLabel("회원가입");
	// ------------------------//
	JLabel nameL = new JLabel("이름");
	JLabel signUpIdL = new JLabel("아이디");
	JLabel signupPwL = new JLabel("비밀번호");
	JLabel signUpPwCheckL = new JLabel("비밀번호 확인");
	JLabel phoneNumberL = new JLabel("휴대폰 번호");
	JLabel birthL = new JLabel("생년월일");
	JLabel nickNameL = new JLabel("닉네임");
	JButton doublecheck, ok, cancel, getMember;
	JPanel signupPanel = new JPanel();
	JLabel nameWarn = new JLabel("이름을 입력 해 주세요");
	JLabel idWarn = new JLabel("아이디를 입력 해 주세요");
	JLabel passWarn = new JLabel("비밀번호는 4자 이상 20자 이하 입니다");
	JLabel phoneWarn = new JLabel("핸드폰 번호를 입력 해 주세요.");
	JLabel birthWarn = new JLabel("생년월일을 입력 해 주세요");
	JLabel nickWarn = new JLabel("닉네임을 입력 해 주세요");

	boolean run;

	public w1e() throws ClassNotFoundException, SQLException {
		getConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정

		setBounds(50, 50, 1000, 800);
		setVisible(true);
		con.add(signupPanel, BorderLayout.CENTER);
		this.add(signupPanel);
		signupPanel.setVisible(true);
		signupPanel.setLayout(null);
		this.add(signupPanel);
		signupPanel.add(joinL);
		joinL.setBounds(450, 10, 1000, 100);
		joinL.setPreferredSize(new Dimension(600, 100));
		signupPanel.add(nameL);
		nameL.setBounds(320, 100, 100, 30);
		signupPanel.add(nameF);
		nameF.setBounds(420, 105, 120, 25);
		signupPanel.add(signUpIdL);
		signUpIdL.setBounds(320, 170, 100, 30);
		signupPanel.add(signUpIdF);
		signUpIdF.setBounds(420, 175, 120, 25);
		signupPanel.add(signupPwL);
		signupPwL.setBounds(320, 230, 100, 30);
		signupPanel.add(signUpPwF);
		signUpPwF.setBounds(420, 235, 120, 25);
		signupPanel.add(signUpPwCheckL);
		signUpPwCheckL.setBounds(320, 290, 100, 30);
		signupPanel.add(signUpPwCheckF);
		signUpPwCheckF.setBounds(420, 295, 120, 25);
		signupPanel.add(phoneNumberL);
		phoneNumberL.setBounds(320, 340, 100, 30);
		signupPanel.add(phoneNumberF);
		phoneNumberF.setBounds(420, 345, 120, 25);
		signupPanel.add(birthL);
		birthL.setBounds(320, 400, 100, 30);
		signupPanel.add(birthF);
		birthF.setBounds(420, 405, 120, 25);
		signupPanel.add(nickNameL);
		nickNameL.setBounds(320, 460, 100, 30);
		signupPanel.add(nickNameF);
		nickNameF.setBounds(420, 465, 120, 25);
		signupPanel.add(nameWarn);
		nameWarn.setBounds(420, 140, 250, 25);
		signupPanel.add(idWarn);
		idWarn.setBounds(420, 205, 250, 25);
		signupPanel.add(passWarn);
		passWarn.setBounds(420, 265, 250, 25);
		signupPanel.add(phoneWarn);
		phoneWarn.setBounds(420, 375, 250, 25);
		signupPanel.add(birthWarn);
		birthWarn.setBounds(420, 435, 250, 25);
		signupPanel.add(nickWarn);
		nickWarn.setBounds(420, 495, 250, 25);
		// 필드, 라벨 레이아웃

		doublecheck = new JButton("중복체크");
		signupPanel.add(doublecheck);
		doublecheck.setBounds(570, 173, 90, 30);
		ok = new JButton("확인");
		signupPanel.add(ok);
		ok.setBounds(350, 530, 90, 30);
		cancel = new JButton("취소");
		signupPanel.add(cancel);
		cancel.setBounds(500, 530, 90, 30);
		// 버튼 레이아웃
		// ----------------------------------------------------//
		nameF.addFocusListener(new nameWarn());
		signUpIdF.addFocusListener(new idWarn());
		signUpPwF.addFocusListener(new passWarn());
		phoneNumberF.addFocusListener(new phoneWarn());
		birthF.addFocusListener(new birthWarn());
		nickNameF.addFocusListener(new nickWarn());
		// 각 텍스트필드에 경고메세지 FocusListener 적용
		// ----------------------------------------------------//
		doublecheck.addActionListener(new idDoubleCheck());
		// 중복체크 버튼 클릭 이벤트
		// ----------------------------------------------------//
		ok.addActionListener(new addMember());
		// 확인 버튼 클릭 이벤트
		// ----------------------------------------------------//
		nameWarn.setVisible(true);
		idWarn.setVisible(true);
		passWarn.setVisible(true);
		phoneWarn.setVisible(true);
		birthWarn.setVisible(true);
		nickWarn.setVisible(true);
		// 회원가입 시작부터 경고메세지 켜기
		// ----------------------------------------------------//
	}

	
	
	
	class nameWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = nameF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					nameWarn.setVisible(false);
				} else {
					run = false;
					nameWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = nameF.getText();
			if (a.matches(regex)) {
				run = false;
				nameWarn.setVisible(false);
			} else {
				run = false;
				nameWarn.setVisible(true);
			}
		}

	}

	class idWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = signUpIdF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					idWarn.setVisible(false);
				} else {
					run = false;
					idWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = signUpIdF.getText();
			if (a.matches(regex)) {
				run = false;
				idWarn.setVisible(false);
			} else {
				run = false;
				idWarn.setVisible(true);
			}
		}

	}
	
	class passWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = signUpPwF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					passWarn.setVisible(false);
				} else {
					run = false;
					passWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = signUpPwF.getText();
			if (a.matches(regex)) {
				run = false;
				passWarn.setVisible(false);
			} else {
				run = false;
				passWarn.setVisible(true);
			}
		}

	}
	
	class phoneWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = phoneNumberF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					phoneWarn.setVisible(false);
				} else {
					run = false;
					phoneWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = phoneNumberF.getText();
			if (a.matches(regex)) {
				run = false;
				phoneWarn.setVisible(false);

			} else {
				run = false;
				phoneWarn.setVisible(true);
			}
		}

	}
	
	class birthWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = birthF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					birthWarn.setVisible(false);
				} else {
					run = false;
					birthWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = birthF.getText();
			if (a.matches(regex)) {
				run = false;
				birthWarn.setVisible(false);
			} else {
				run = false;
				birthWarn.setVisible(true);
			}
		}

	}

	class nickWarn implements FocusListener {

		public void focusGained(FocusEvent e) {
			boolean run = true;
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = nickNameF.getText();
			while (run) {
				if (a.matches(regex)) {
					run = false;
					nickWarn.setVisible(false);
				} else {
					run = false;
					nickWarn.setVisible(false);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = nickNameF.getText();
			if (a.matches(regex)) {
				run = false;
				nickWarn.setVisible(false);
			} else {
				run = false;
				nickWarn.setVisible(true);
			}
		}

	}
	class idDoubleCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				checkIDMethod(signUpIdF.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	// 중복확인

	class addMember implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String a = nameF.getText();
			String b = signUpIdF.getText();
			String ee = phoneNumberF.getText();
			String f = birthF.getText();
			String g = nickNameF.getText();
			String asd = "";
			String asd2 = "";

			for (int i = 0; i < signUpPwF.getPassword().length; i++) {
				asd = asd + signUpPwF.getPassword()[i];
			}
			for (int i = 0; i < signUpPwCheckF.getPassword().length; i++) {
				asd2 = asd2 + signUpPwCheckF.getPassword()[i];
			}

			if (a.equals("") || b.equals("") || asd.equals("") || asd2.equals("") || ee.equals("") || f.equals("")
					|| g.equals("")) {
				JOptionPane.showMessageDialog(null, "모든 항목을 빠짐없이 입력 해 주세요");
			} else if (a != null && b != null && asd != null && asd2 != null && ee != null && f != null && g != null)
				try {
					if (checkIDMethod(signUpIdF.getText()) != false) {
//						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다");
					} else if (passCheck() == false) {
//						JOptionPane.showMessageDialog(null, "비밀번호를 정확히 입력 해 주세요");
					} else if (phoneNumCheck() == false) {
						JOptionPane.showMessageDialog(null, "핸드폰 번호를 정확히 입력 해 주세요. 예) 010-1234-4567");
					} else if (birthCheck() == false) {
						JOptionPane.showMessageDialog(null, "생년월일을 정확히 입력 해 주세요. 예) 2022-12-12");
					} else {
						JOptionPane.showMessageDialog(null, nameF.getText() + "님 가입 완료 되었습니다.");
						insertMember();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
//			try {
//				if(checkIDMethod(signUpIdF.getText()) == false) {
//					if (passCheck() == true) {
//						if(a.equals("") || b.equals("")  || c.equals("")  || d.equals("") || ee.equals("")  || f.equals("")) {
//							JOptionPane.showMessageDialog(null, "모든 항목을 빠짐없이 입력 해 주세요");
//							try {
//								insertMember();
//							} catch (SQLException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} 
//					} else {
//						JOptionPane.showMessageDialog(null, "비밀번호를 정확히 입력 해 주세요");
//					}
//				} else {
//					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다");
//				}
//			} catch (HeadlessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
	// 회원정보 DB에 등록

	public boolean checkIDMethod(String id) throws SQLException {
		int check = 0;
		char alpha;
		int code;

		String sql = "select id from student where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if (check == 0) {
			for (int i = 0; i < id.length(); i++) {
				alpha = id.charAt(i);
				code = (int) alpha;
				if (code >= 0 && code <= 47 || code >= 58 && code <= 64 || code >= 91 && code <= 96
						|| code >= 123 && code <= 127) {
					check = 1;
					run = true;
					JOptionPane.showMessageDialog(null, "아이디에 특수문자는 포함될 수 없습니다.");
				}
			}
			if (check == 0) {
				if (rs.next()) {
					run = true;
					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다");
				} else {
					run = false;
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다");
				}
			}
		}
		return run;
	}
	// ID 특수문자 포함 안되게
	// ID OK면 DB에 있는 아이디인지 체크

	public boolean passCheck() {

		String str = "";
		char str1[] = signUpPwF.getPassword();
		char str2[] = signUpPwCheckF.getPassword();
		boolean run = false;
		boolean flag = true;

		if (str1.length == str2.length) {
			for (int i = 0; i < str1.length; i++) {
				if (str1[i] != str2[i]) {
					flag = false;
					break;
				}
				str += str1[i];
			}
			if (flag) {
				run = true;
			} else {
				run = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호를 확인 해 주세요");
		}
		return run;
		// 비밀번호란, 비밀번호 확인란 서로 일치하는지 확인
		// 비밀번호 length 다르면
	}

	// ------------------------//
	public boolean birthCheck() {
		String birth = birthF.getText();
		String regex = "^\\d{4}[-/.?][0-1]{1}[1-9]{1}[-/.?][0-3]{1}\\d{1}$";
		if (birth.matches(regex) == true) {
			System.out.println("ok");
			run = true;
		} else if (birth.matches(regex) == false) {
			System.out.println("birthnope");
			run = false;
		}
		return run;
	}

	public boolean phoneNumCheck() {

		String pNum = phoneNumberF.getText();
		String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
		if (pNum.matches(regex) == true) {
			System.out.println("ok");
			run = true;
		} else if (pNum.matches(regex) == false) {
			System.out.println("pnumnope");
			run = false;
		}
		return run;
	}

	// ------------------------//
	public void insertMember() throws SQLException {

		String Id = signUpIdF.getText();
		String password = signUpPwF.getText();
		String phoneNumber = phoneNumberF.getText();
		String name = nameF.getText();
		String birthday = birthF.getText();
		String nickName = nickNameF.getText();

		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'" + Id + "','" + password + "','" + phoneNumber
				+ "','" + name + "','" + birthday + "','" + nickName + "','" + null + "')");
		System.out.println(result + "건 입력 성공");
	}

	// 확인버튼 눌렀을때 DB로 값들 전송
	public void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choongang", "root", "mysql");
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			System.out.println("DB연결 에러발생" + e.getMessage());
		}
	}
	// DB접속

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new w1e();

	}
}
