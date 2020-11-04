package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SortFunction implements ActionListener {
	Vector<Vector<String>> userdataVector;
	int sortby;
	JTable table;
	
	public SortFunction(JTable table,Vector<Vector<String>> userdata, int i) {
		this.userdataVector = userdata;
		this.table = table;
		sortby = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		userdataVector.sort();
		model.setDataVector(userdataVector, userdataVector.get(0));
	}
}


























