
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class main extends JFrame{
	
	public main() {
		
		OUTTER : while(true) {
			ImageIcon icon = new ImageIcon("images/Food.JPG");
			JOptionPane.showMessageDialog(null, null,"Customer Management System", JOptionPane.NO_OPTION, icon);
			String passwd = JOptionPane.showInputDialog("CM Service\n Write PassWord");
			
			String password = "manage1234";
			
			if (passwd == null)
				break OUTTER;
			 else if (password.equals(passwd)) {
					try {
						ManagementSystem.manageSystemMain();
					} catch (Exception e) {
							e.printStackTrace();
					}
				 break OUTTER;
			}else
				JOptionPane.showMessageDialog(null, "Wrong PassWord\n Click the Confirm Button", "Error", JOptionPane.ERROR_MESSAGE);
<<<<<<< HEAD
		}
	}
=======
		}	
}
>>>>>>> parent of 6b4cf4d... Functions Complete

	public static void main(String[] args) {
		main authMainExample = new main();
	}

}




























