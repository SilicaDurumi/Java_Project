package Functions;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditFunction {
	public static void UpdateData(JTable table, String name , String tel, String email, int selectedrow) {
		if (selectedrow==-1) {
			JOptionPane.showMessageDialog(null, "Please Select the Data","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		boolean runThisFunction = RegexTextEx.EmailCheck(email)&&RegexTextEx.TelephoneNumCheck(tel);
		
		if (runThisFunction) {
			model.setValueAt(name, selectedrow,1);
			model.setValueAt(tel, selectedrow, 2);
			model.setValueAt(email, selectedrow, 3);
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid value found, Please write again","Invalid IDNumer", JOptionPane.ERROR_MESSAGE);
			table.clearSelection();
			return;
		}
	}
}