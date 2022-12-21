package login;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertDialogGUI extends JDialog implements ActionListener {

	JDBC db;

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField = new JTextField();
	private JTextField idTextField = new JTextField();
	private JTextField passwordTextField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField birthTextField = new JTextField();
	private JTextField nickNameTextField = new JTextField();
	private JTextField courseNameTextField = new JTextField();

	JButton okButton;
	JButton cancelButton;

	String name;
	String id;
	String password;
	String phoneNumber;
	String birth;
	String nickName;
	String courseName;

	public InsertDialogGUI(JDBC db) {
		this.db = db;
		setTitle("추가페이지");
		setBounds(100, 200, 800, 220);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

//		이름패널
		JPanel namePanel = new JPanel();
		namePanel.setBounds(60, 50, 80, 60);
		contentPanel.add(namePanel);
		namePanel.setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(30, 5, 36, 15);
		namePanel.add(nameLabel);

		nameTextField.setBounds(5, 25, 70, 30);
		namePanel.add(nameTextField);
		nameTextField.setColumns(10);

//		아이디패널~
		JPanel idPanel = new JPanel();
		idPanel.setLayout(null);
		idPanel.setBounds(145, 50, 90, 60);
		contentPanel.add(idPanel);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(30, 5, 48, 15);
		idPanel.add(idLabel);

		idTextField.setColumns(10);
		idTextField.setBounds(5, 25, 80, 30);
		idPanel.add(idTextField);

//		~아이디패널

//		비밀번호패널
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(null);
		passwordPanel.setBounds(240, 50, 100, 60);
		contentPanel.add(passwordPanel);

		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setBounds(30, 5, 64, 15);
		passwordPanel.add(passwordLabel);

		passwordTextField.setColumns(10);
		passwordTextField.setBounds(5, 25, 90, 30);
		passwordPanel.add(passwordTextField);

//		전화번호패널
		JPanel phoneNumberPanel = new JPanel();
		phoneNumberPanel.setLayout(null);
		phoneNumberPanel.setBounds(345, 50, 110, 60);
		contentPanel.add(phoneNumberPanel);

		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setBounds(25, 5, 64, 15);
		phoneNumberPanel.add(phoneNumberLabel);

		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(5, 25, 100, 30);
		phoneNumberPanel.add(phoneNumberTextField);

//		생년월일패널
		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(null);
		birthPanel.setBounds(460, 50, 85, 60);
		contentPanel.add(birthPanel);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(16, 5, 64, 15);
		birthPanel.add(birthLabel);

		birthTextField.setColumns(10);
		birthTextField.setBounds(5, 25, 75, 30);
		birthPanel.add(birthTextField);

//		닉네임패널
		JPanel nickNamePanel = new JPanel();
		nickNamePanel.setLayout(null);
		nickNamePanel.setBounds(550, 50, 80, 60);
		contentPanel.add(nickNamePanel);

		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setBounds(21, 5, 48, 15);
		nickNamePanel.add(nickNameLabel);

		nickNameTextField.setColumns(10);
		nickNameTextField.setBounds(5, 25, 70, 30);
		nickNamePanel.add(nickNameTextField);

//		수강명패널
		JPanel courseNamePanel = new JPanel();
		courseNamePanel.setLayout(null);
		courseNamePanel.setBounds(635, 50, 85, 60);
		contentPanel.add(courseNamePanel);

		JLabel courseNameLabel = new JLabel("수강명");
		courseNameLabel.setBounds(21, 5, 48, 15);
		courseNamePanel.add(courseNameLabel);

		courseNameTextField.setColumns(10);
		courseNameTextField.setBounds(5, 25, 75, 30);
		courseNamePanel.add(courseNameTextField);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("추가하기");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				cancelButton = new JButton("돌아가기");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {
			String name = nameTextField.getText();
			String id = idTextField.getText();
			String password = passwordTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String birth = birthTextField.getText();
			String nickName = nickNameTextField.getText();
			String courseName = courseNameTextField.getText();

			try {
				int result = db.insertDB(name, id, password, phoneNumber, birth, nickName, courseName);
				System.out.println("insertDB(), " + result);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}

		if (e.getSource() == cancelButton) {
			dispose();
		}
	}

}
