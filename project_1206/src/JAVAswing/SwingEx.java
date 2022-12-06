package JAVAswing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx extends JFrame implements WindowListener, ActionListener {
//	JFrame jf = new JFrame("Swing 연습");	
	JButton jb = new JButton("클릭");

	SwingEx() {
		Container cp = this.getContentPane();

		this.setLocation(500, 500);
		// 윈도우 창 나오는 위치 지정
		this.setSize(400, 300);
		// 윈도우 창 사이즈 지정
		this.setVisible(true);
		// 윈도우 창 표시되게 하는 설정
		this.setTitle("Swing 연습");
		// HTML의 title과 같은 기능(객체 생성시 소괄호 안에 직접 작성도 가능)

		this.add(jb);
		// jb로 생성한 버튼을 jf 윈도우 안에 삽입
		jb.setBounds(30, 30, 80, 70);
		// 안먹는 이유, 레이아웃의 영향을 받기 때문.
		cp.add(jb);
		this.setLayout(null);
		this.addWindowListener(this);
		jb.addActionListener(this);
	}

	public static void main(String[] args) {
		new SwingEx();

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("활성");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭!");
	}

}

//ctrl shift o 자동 임포트