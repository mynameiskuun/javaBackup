package login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.apple.laf.resources.aqua;

public class SignUpGUI extends JFrame {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	boolean run;

	Container con = this.getContentPane();
	JTextField nameF = new JTextField();
	JTextField signUpIdF = new JTextField();
	JPasswordField signUpPwF = new JPasswordField();
	JPasswordField signUpPwCheckF = new JPasswordField();
	JTextField phoneNumberF = new JTextField();
	JTextField birthF = new JTextField();
	JTextField nickNameF = new JTextField();
	JPanel signupPanel = new JPanel();

	JLabel joinL = new JLabel("회원가입");
	JLabel nameL = new JLabel("이름");
	JLabel signUpIdL = new JLabel("아이디");
	JLabel signupPwL = new JLabel("비밀번호");
	JLabel signUpPwCheckL = new JLabel("비밀번호 확인");
	JLabel phoneNumberL = new JLabel("휴대폰 번호");
	JLabel birthL = new JLabel("생년월일");
	JLabel nickNameL = new JLabel("닉네임");
	JLabel nameWarn = new JLabel("이름을 정확히 입력 해 주세요.");
	JLabel idWarn = new JLabel("아이디를 입력 해 주세요. (5자이상 12자 이하)");
	JLabel passWarn = new JLabel("영문,숫자,특수기호를 포함한 8자 이상 20자 이하의 암호를 입력 해 주세요.");
	JLabel passWarn2 = new JLabel("비밀번호가 일치하지 않습니다.");
	JLabel phoneWarn = new JLabel("핸드폰 번호를 입력 해 주세요. ex)010-1234-5678, 하이픈(-) 필수.");
	JLabel birthWarn = new JLabel("생년월일을 입력 해 주세요 ex)2022-12-12");
	JLabel nickWarn = new JLabel("영문, 숫자를 포함한 5자 이상 10자 이하의 닉네임을 입력 해 주세요.");
	JButton doublecheck, ok, cancel, getMember;
	JDBC db;
	JFrame a;

	public SignUpGUI(JDBC db, JFrame a) throws ClassNotFoundException, SQLException {
		this.db = db;
		this.a = a;
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
		nameWarn.setBounds(420, 140, 450, 25);
		signupPanel.add(idWarn);
		idWarn.setBounds(420, 205, 450, 25);
		signupPanel.add(passWarn);
		passWarn.setBounds(420, 265, 450, 25);
		signupPanel.add(passWarn2);
		passWarn2.setBounds(420, 325, 450, 25);
		signupPanel.add(phoneWarn);
		phoneWarn.setBounds(420, 375, 450, 25);
		signupPanel.add(birthWarn);
		birthWarn.setBounds(420, 435, 450, 25);
		signupPanel.add(nickWarn);
		nickWarn.setBounds(420, 495, 450, 25);
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
		nameF.addKeyListener(new nameWarn());
		signUpIdF.addKeyListener(new idWarn());
		signUpPwF.addKeyListener(new passWarn());
		signUpPwCheckF.addKeyListener(new passWarn2());
		phoneNumberF.addKeyListener(new phoneWarn());
		birthF.addKeyListener(new birthWarn());
		nickNameF.addKeyListener(new nickWarn());
		// 각 텍스트필드에 경고메세지 FocusListener 적용
		// ----------------------------------------------------//
		doublecheck.addActionListener(new idDoubleCheck());
		// 중복체크 버튼 클릭 이벤트
		// ----------------------------------------------------//
		ok.addActionListener(new addMember());
		// 확인 버튼 클릭 이벤트
		// ----------------------------------------------------//
		nameWarn.setVisible(false);
		idWarn.setVisible(false);
		passWarn.setVisible(false);
		passWarn2.setVisible(false);
		phoneWarn.setVisible(false);
		birthWarn.setVisible(false);
		nickWarn.setVisible(false);
		// 처음에는 경고메세지 끄고, 텍스트필드에 값이 입력 되는 순간 켜기
		// ----------------------------------------------------//
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				a.setVisible(true);

			}

		});
	}

	// ------------------------경고메세지----------------------------//
	// -------------------------------------------------------------//

	class nameWarn implements KeyListener {

		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String a = nameF.getText();
			String regex = "^[가-힣]{2,9}$";
			if (a.matches(regex)) {
				nameWarn.setVisible(false);
			} else {
				nameWarn.setVisible(true);
			}
		}
	}

// 이름 정규표현식에 맞는지 검사. 이름은 한글만 2자리 이상 9자리 이하로 입력 가능.
	class idWarn implements KeyListener {

		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String a = signUpIdF.getText();
			String regex = "^[a-zA-Z]{1}\\w{4}\\w{0,7}$";
			if (a.matches(regex)) {
				idWarn.setVisible(false);
			} else {
				idWarn.setVisible(true);
			}
		}
	}

// 아이디 정규표현식에 맞는지 검사. 아이디는 특수문자 제외 5자리 이상 12자리 이하만 가능.
	class passWarn implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String a = signUpPwF.getText();
			String regex = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
			if (a.matches(regex)) {
				passWarn.setVisible(false);
			} else {
				passWarn.setVisible(true);
			}
		}

	}

// 패스워드 정규표현식. 패스워드는 8자리 이상 20자리 이하, 특수문자,영문,숫자 최소 1개 이상씩 포함 해야함.
	class passWarn2 implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String a = signUpPwF.getText();
			String b = signUpPwCheckF.getText();
			String regex = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

			if (a.equals(b) && a.matches(regex) && b.matches(regex)) {
				passWarn2.setVisible(false);
			} else {
				passWarn2.setVisible(true);
			}
		}
	}

// 패스워드 확인 란과 일치하는지 검사.
	class phoneWarn implements KeyListener {

		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
			String a = phoneNumberF.getText();
			if (a.matches(regex)) {
				phoneWarn.setVisible(false);
			} else {
				phoneWarn.setVisible(true);
			}
		}
	}

// 핸드폰 번호 정규 표현식과 맞는지 검사.
	class birthWarn implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String regex = "^[1-2]{1}\\d{3}-[0-1]{1}[0-9]{1}-[0-4]{1}\\d{1}$";
			String a = birthF.getText();
			if (a.matches(regex)) {
				birthWarn.setVisible(false);
			} else {
				birthWarn.setVisible(true);
			}
		}
	}

// 생년월일 정규표현식과 맞는지 검사.
	class nickWarn implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			String a = nickNameF.getText();
			String regex = "^\\w+\\d+{8,20}$";
			if (a.matches(regex)) {
				nickWarn.setVisible(false);
			} else {
				nickWarn.setVisible(true);
			}
		}
	}
	// 닉네임 정규표현식과 맞는지 검사.
//------------------------경고메세지----------------------------//
//-------------------------------------------------------------//
//------------------------버튼이벤트---------------------------//

	class idDoubleCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				System.out.print("중복 확인 안됨");
				checkIdMethod4(signUpIdF.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	// 아이디 중복확인 버튼 눌렀을때 checkIdMethod4 검사.

	class addMember implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String a = nameF.getText();
			String b = signUpIdF.getText();
			String c = signUpPwF.getText();
			String d = signUpPwCheckF.getText();
			String ee = phoneNumberF.getText();
			String f = birthF.getText();
			String g = nickNameF.getText();

			if (a.equals("") || b.equals("") || c.equals("") || d.equals("") || ee.equals("") || f.equals("")
					|| g.equals("")) {
				JOptionPane.showMessageDialog(null, "모든 항목을 빠짐없이 입력 해 주세요");
				return;
			}
			// 공백 검사
			if (checkNameMethod(nameF.getText()) == true) {
			} else {
				JOptionPane.showMessageDialog(null, "이름을 정확히 입력 해 주세요");
				return;
			}
			// 이름 검사
			// 아이디 검사

			try {
				if (checkIdMethod0() == true) {
				} else {
					return;
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (checkPwMethod() == true) {
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 정확히 입력 해 주세요");
				return;
			}
			// 비밀번호 검사

			if (checkPwMethod2() == true) {
			} else {
				return;
			}
			// 비밀번호 중복 검사

			if (checkPnumMethod() == true) {
			} else {
				JOptionPane.showMessageDialog(null, "양식에 맞는 핸드폰 번호를 입력 해 주세요.");
				return;
			}
			// 핸드폰번호 검사

			if (checkBirthMethod() == true) {
			} else {
				JOptionPane.showMessageDialog(null, "생년월일을 양식에 맞게 입력 해 주세요.");
				return;
			}
			// 생년월일 검사

			if (checkNickMethod() == true) {
				try {
					insertMember();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, nameF.getText() + "님 회원가입 완료 되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "닉네임을 양식에 맞게 입력 해 주세요");
				return;
			}
			// 닉네임 검사. 맞다면 회원가입 완료.
		}
	}

	// -------------------------------------------------------------//
	// ------------------------버튼이벤트---------------------------//
	boolean checkNameMethod(String name) {
		run = false;
		String regex = "^[가-힣]{2,9}$";
		if (name != "" && name.matches(regex)) {
			run = true;
		} else {
			run = false;
		}
		
		return run;
	}
	// 이름 체크 메소드. 한글 2자리 이상 9자리 이하.

	boolean checkIdMethod0() throws HeadlessException, SQLException {

		boolean run = false;
		boolean a = checkIdMethod1(signUpIdF.getText());
		boolean b = checkIdMethod2(signUpIdF.getText());
		boolean c = checkIdMethod3(signUpIdF.getText());

		if (a) {
			if (b) {
				if (c) {
					run = true;
				} else {
					run = false;
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다");
				}
			} else {
				run = false;
				JOptionPane.showMessageDialog(null, "아이디는 영문,숫자 포함 5-12자리 이내만 가능합니다");
			}
		} else {
			run = false;
			JOptionPane.showMessageDialog(null, "아이디에 특수문자는 사용 가능하지 않습니다");
		}
		return run;
	}
	// 확인 버튼 눌렀을때 아이디 검사하는 메소드. 아래의 3가지 메소드를 이곳에서 한번에 확인함.

	public boolean checkIdMethod1(String id) {
		boolean check = true;
		char alpha;
		int code;
		for (int i = 0; i < id.length(); i++) {
			alpha = id.charAt(i);
			code = (int) alpha;
			if (code >= 0 && code <= 47 || code >= 58 && code <= 64 || code >= 91 && code <= 96
					|| code >= 123 && code <= 127) {
				check = false;
			}
		}
		return check;
	}

	// 아이디 검사 1. 특수문자 들어있는지 안들어있는지.

	public boolean checkIdMethod2(String id) {
		boolean check = true;
		String a = signUpIdF.getText();
		String regex = "^[a-zA-Z]{1}\\w{4}\\w{0,7}$";
		if (a.matches(regex)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	// 아이디 검사 2. 5자리 이상 12자리 이하 정규표현식에 맞는지.
	public boolean checkIdMethod3(String id) throws HeadlessException, SQLException {
		boolean check = false;
		String sql = "select id from student where id = ?";
		pstmt = db.conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			check = false;
		} else {
			check = true;
		}
		return check;
		
	}

	// 아이디 검사 3. db에 있는 아이디 인지 아닌지. (중복확인)

	public int checkIdMethod4(String id) throws SQLException {
		String sql = "select id from student where id = ?";
		String a = signUpIdF.getText();

		
		pstmt = db.conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		int check = 0;

		if (rs.next()) {
			check = 1;
			JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다");
		} else {
			check = 0;
			JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다");
		}
		return check;
	}

	// 중복확인 버튼 눌렀을때 ID 확인하는 메소드. 공란인지 아닌지 확인 및 중복체크.
	public boolean checkPwMethod() {

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
		}
		return run;
		// 비밀번호란, 비밀번호 확인란 서로 일치하는지 확인
		// 비밀번호 일치하지 않으면 flag = false
		//
	}

	public boolean checkPwMethod2() {
		String a = signUpPwF.getText();
		String b = signUpPwCheckF.getText();
		String regex = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

		if (a.matches(regex) && b.matches(regex)) {
			if (a.equals(b)) {
				run = true;
			} else {
				run = false;
			}
		} else {
			run = false;
			JOptionPane.showMessageDialog(null, "   비밀번호를 양식에 맞게 작성 해 주세요.");
		}
		return run;
	}

	public boolean checkBirthMethod() {
		String birth = birthF.getText();
		String regex = "^\\d{4}[-/.?][0-1]{1}[1-9]{1}[-/.?][0-3]{1}\\d{1}$";
		if (birth.matches(regex) == true) {
			run = true;
		} else if (birth.matches(regex) == false) {
			run = false;
		}
		return run;
	}

	// 생년월일 정규표현식에 맞는지 체크. 생년월일은 YYYY-MM-DD 형식. 하이픈 필수
	public boolean checkPnumMethod() {

		String pNum = phoneNumberF.getText();
		String regex = "^010-([1-9]{1}\\d{3})-(\\d{4})$";
		if (pNum.matches(regex) == true) {
			run = true;
		} else if (pNum.matches(regex) == false) {
			run = false;
		}
		return run;
	}
	// 핸드폰번호 정규표현식에 맞는지 체크. 핸드폰 번호는 010으로 시작. 010-1234-1234 형식만 가능.

	public boolean checkNickMethod() {
		String nick = nickNameF.getText();
		String regex = "^\\w{5,10}$";
		if (nick.matches(regex)) {
			run = true;
		} else {
			run = false;
		}
		return run;
	}

	public void insertMember() throws SQLException {
		String Id = signUpIdF.getText();
		String password = signUpPwF.getText();
		String phoneNumber = phoneNumberF.getText();
		String name = nameF.getText();
		String birthday = birthF.getText();
		String nickName = nickNameF.getText();

		stmt = db.conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'" + Id + "','" + password + "','" + phoneNumber
				+ "','" + name + "','" + birthday + "','" + nickName + "','" + null + "')");
		System.out.println(result + "건 입력 성공");
	}

}
