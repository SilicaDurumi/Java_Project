package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;


public class SortFunction implements ActionListener {
	Vector<Vector<String>> userdataVector;
	int sortby;
	
	public SortFunction(Vector<Vector<String>> userdata, int i) {
		this.userdataVector = userdata;
		sortby = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Arrays.sort(userdataVector,  new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {//	 If user Click the Title; Column Sort Execute : change o1 [0], o2[0] => o1 [i], o2[i]
				if (((Comparable)o1[sortby]).compareTo(o2[sortby])>0)
					return 1;
				else
					return -1;
			}
		
		});
	}
//	showClass.table.getmodel();
	
}


























