package Functions;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OpenFileFunction {
	public static void OpenFile(JFrame frame, JTable table) {//use vector
		
		FileDialog openFile;
		openFile = new FileDialog(frame, "OPEN", FileDialog.LOAD);
	    openFile.setVisible(true);
	    
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    String path = openFile.getDirectory()+ openFile.getFile();
	    
	    if (path.equals("nullnull")) {
			JOptionPane.showMessageDialog(null, "Please Selecte the file","Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
	    int removeRowCount = model.getRowCount();
	    for (int i = 0; i < removeRowCount; i++) 
			model.removeRow(0);
	    
	    try{
	    	int count =0;
	    	String strforcount ="";
	    	String str = "";
	    	Object[][] userdataInput ;
	        BufferedReader buffread, reader;
	        StringTokenizer stringTokenizer, tokenizer;
	      
	        reader = new BufferedReader(new FileReader(path));

	        while ((strforcount = reader.readLine())!=null) {
	        	tokenizer = new StringTokenizer(strforcount);
	        	count++;
	        	tokenizer.nextToken("\n");
			}
        	reader.close();
	        
        	
	        buffread = new BufferedReader(new FileReader(path));
	        userdataInput = new Object[count][model.getColumnCount()];
	        int j = 0;
	        while ((str=buffread.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(str);
	        		for (int i = 0; i < model.getColumnCount(); i++) 
						userdataInput[j][i]= stringTokenizer.nextToken(" ### ");
	        		stringTokenizer.nextToken("\n");
	        		 model.addRow(userdataInput[j]);
	        		if (j>count) 
						break;
	        		j++;
	        }

	        buffread.close();
	        String Filename = openFile.getFile();
	        frame.setTitle(Filename);
	       
	       } catch(Exception e1){System.out.println(e1.toString());}
	}
}














