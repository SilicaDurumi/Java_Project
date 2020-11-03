import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.UserDataHandler;

import Functions.*;

import javax.swing.JTextArea;
import java.awt.event.MouseEvent;
public class ManagementSystem extends JFrame {

	private JFrame jFrame = new JFrame();
	private String[][] userdata = {}; //vector
	private Vector<Vector<String>> userdataVector = new Vector<Vector<String>>();
	private Vector<String> userdatatitle = new Vector<String>();
//	private String[][] userdataArray = {}; //vector
	private String [] columnNameStr = {"Number", "Name", "Tel", "E-mail", "ID_Number", "Job", "Age", "Gender", "Location","Birth"};
	private JTable table;
	private String[] job = {"", "ABC", "BCD", "CDE", "DEF", "EFG", "FGH" };
	
public class ManagementSystem extends JFrame {
		menuBar.add(filemenu); menuBar.add(alignmenu); menuBar.add(helpmenu); //메뉴바에 표시될 요소 추가
		filemenu.add(save);filemenu.add(open); filemenu.add(close); //파일 메뉴 안에 표시될 요소들 '저장', '열기', '닫기'
		
//		table.setRowSorter();
		
		numberChkMenuItem = new JCheckBoxMenuItem("Number");// 정렬 메뉴의 Number 
		buttonGroupForAlignMenu.add(numberChkMenuItem);
		alignmenu.add(numberChkMenuItem);
public class ManagementSystem extends JFrame {
		buttonGroupForAlignMenu.add(locationChkItem);
		alignmenu.add(locationChkItem);
		
		model = new DefaultTableModel(userdata, columnNameStr);
		table = new JTable(userdata, columnNameStr);
		
		helpmenu.add(printinfo);//help 메뉴의 printinfo
		
		showTable(); // Show Table
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jFrame.setContentPane(contentPane);
@ -181,10 +190,8 @@ public class ManagementSystem extends JFrame {
		
		JComboBox jobComboBox = new JComboBox();
		jobComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jobTextField.setText(jobComboBox.getSelectedItem().toString());	
			}
		});
			public void actionPerformed(ActionEvent arg0) {jobTextField.setText(jobComboBox.getSelectedItem().toString());}
			});
		jobComboBox.setModel(new DefaultComboBoxModel(job));
		inputpanel.add(jobComboBox);
		
@ -273,7 +280,6 @@ public class ManagementSystem extends JFrame {
		contentPane.add(btnpanel, BorderLayout.SOUTH);
		btnpanel.setLayout(new GridLayout(0, 6, 0, 0));
		
		
		jobTextField = new JTextField();
		jobTextField.setText(jobComboBox.getSelectedItem().toString());
		
@ -296,7 +302,40 @@ public class ManagementSystem extends JFrame {
		searchBtnBottom = new JButton("SEARCH");
		btnpanel.add(searchBtnBottom);
		
		addBtn.addActionListener(new CreateFunction(table, numberTextField, nameTextField, telTextField, emailTextField,  idNumberTextField, jobTextField) {});
		numberChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Collections.sort(userdataVector, new Comparator<userdataVector.get(0)>() {} );
				showTable();
			}
		});
		
		nameChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(userdataVector, ((Comparator)userdataVector.get(1)));
				showTable();
			}
		});
		
		jobChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(userdataVector, ((Comparator)userdataVector.get(5)));
				showTable();
			}
		});
		
		locationChkItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(userdataVector, ((Comparator)userdataVector.get(8)));
				showTable();
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFunction.CreateFunction(table, numberTextField, nameTextField, telTextField, emailTextField,  idNumberTextField, jobTextField);
				jobComboBox.setSelectedIndex(0);
			}
		});
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(0);} });
@ -304,6 +343,7 @@ public class ManagementSystem extends JFrame {
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRow = table.getSelectedRow();
				EditFunction.UpdateData(table, nameTextField.getText(), telTextField.getText(), emailTextField.getText(), selectedRow);
				numberTextField.setEnabled(true);
				idNumberTextField.setEnabled(true);
				nameTextField.setText("");
@ -320,6 +360,7 @@ public class ManagementSystem extends JFrame {
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFileFunction.OpenFile(jFrame, table);
			}
		});
		
@ -335,23 +376,103 @@ public class ManagementSystem extends JFrame {
				CardLayout cl = (CardLayout)(card.getLayout());
		        cl.next(card);}});
		
		tablescrollpanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				selectedRow = table.getSelectedRow(); 
				table.clearSelection();
				idNumberTextField.setEnabled(true);
				numberTextField.setEnabled(true);
				ageTextArea.setText("");
				genderTextArea.setText("");
				locationTextArea.setText("");
				birthTextArea.setText("");
				System.out.println("Selected Row : "+selectedRow);
			}
		});
		
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedRow == -1) 
					selectedRow = 0;
				else
					selectedRow--;
				
				System.out.println("Selected Row : "+selectedRow);
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
			}
		});
		
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedRow==-1)
					selectedRow = 0;
				else
					selectedRow ++;
				
				System.out.println("Selected Row : "+selectedRow);
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
			}
		});
		
		printinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Customer Management System 2020","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			public void mousePressed(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				System.out.println("Selected Row : "+selectedRow);
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
				}});
		}});
		
	}
	public void SortUser(Object[][] arr, int sortby) {
		Arrays.sort(arr, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				if (((Comparable) o1[sortby]).compareTo(o2[sortby]) > 0)
					return 1;
		searchBtnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameRadioBtn.isSelected())
					SearchFunction.SearchData(table, searchtext, 1);// By Name
				else if (jobRadioBtn.isSelected())
					SearchFunction.SearchData(table, searchtext, 5);// By Job
				else if (locationRadioBtn.isSelected()) 
					SearchFunction.SearchData(table, searchtext, 8);// By Location
				else
					return -1;
					JOptionPane.showMessageDialog(null, "Please Selected the Radio Data", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
}
//		userdataVector.sort();
	public void showTable() {
		for (int i = 0; i < columnNameStr.length; i++) 
			userdatatitle.add(columnNameStr[i]);
			
		model = new DefaultTableModel(userdataVector, userdatatitle); // Show Table
		table = new JTable(userdataVector, userdatatitle); // Show Table
	}

}


























