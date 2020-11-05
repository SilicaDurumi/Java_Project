package Functions;

import java.util.Comparator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SortFunction  {

	public static void Sort(DefaultTableModel model, int sortby, JTable table) {
		model.getDataVector().sort(new Comparator<Vector<Object>>() {
			@Override
			public int compare(Vector<Object> o1, Vector<Object> o2) {
				if (((Comparable<Object>)o1.get(sortby)).compareTo(o2.get(sortby))>0)
					return 1;
				else
					return -1;
			}
		});
		table.repaint();
	}
	
}


























