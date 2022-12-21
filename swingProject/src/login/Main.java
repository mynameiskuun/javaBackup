package login;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	
	public static void main(String[] args) {
//		Main main = new Main();
		
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels( )) {
	         if ("Nimbus".equals(info.getName())) { // Nimbus, Windows
	            try {
	               UIManager.setLookAndFeel(info.getClassName());
	            } catch (ClassNotFoundException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            } catch (InstantiationException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            } catch (IllegalAccessException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            } catch (UnsupportedLookAndFeelException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	            break;
	         }
	      }
		new LoginGUI();
		

	}

}
