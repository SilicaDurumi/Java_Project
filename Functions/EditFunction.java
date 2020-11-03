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
		
		model.setValueAt(name, selectedrow,1);
		model.setValueAt(tel, selectedrow, 2);
		model.setValueAt(email, selectedrow, 3);
	}
}