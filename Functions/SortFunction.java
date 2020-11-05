package Functions;

import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;


public class SortFunction  {

	public static void Sort(DefaultTableModel model, int sortby, String [] identify) {
		
		Collections.sort(model.getDataVector(),  new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				if (((Comparable)o1[sortby]).compareTo(o2[sortby])>0)
					return 1;
				else
					return -1;
			}
		});
	}
	
}


























