import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Functions.*;

import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagementSystem extends JFrame {

	private JFrame jFrame = new JFrame();
	private Vector<Vector<String>> userdataVector = new Vector<Vector<String>>();
	private Vector<String> userdatatitle = new Vector<String>();
//	private String[][] userdataArray = {}; //vector
	private String [] columnNameStr = {"Number", "Name", "Tel", "E-mail", "ID_Number", "Job", "Age", "Gender", "Location","Birth"};
	private JTable table;
	private String[] job = {"", "ABC", "BCD", "CDE", "DEF", "EFG", "FGH" };
	private JPanel contentPane, westpanel, inputpanel, card, personinfo, searchpanel, radiopanel, searchtextpanel, panel, searchbtnpanel, btnpanel;
	private JLabel lblNumber, lblName, lblTel, lblEmail, lblIdnumber, jobLabel, ageLabel, genderLabel, locationLabel, birthLabel;
	private JTextField numberTextField, nameTextField, telTextField, emailTextField, idNumberTextField, jobTextField, searchtext;
	private JTextArea ageTextArea, genderTextArea, locationTextArea, birthTextArea;
	private JMenuBar menuBar;
	private JMenu filemenu, alignmenu, helpmenu;
	private JMenuItem save = new JMenuItem("SAVE");
	private JMenuItem open = new JMenuItem("OPEN");
	private JMenuItem close = new JMenuItem("CLOSE");
	private JMenuItem printinfo = new JMenuItem("INFO");
	private final ButtonGroup buttonGroupForRadio = new ButtonGroup();
	private final ButtonGroup buttonGroupForAlignMenu = new ButtonGroup();
	private JButton searchBtnCard, exitBtn, addBtn, deleteBtn, previousBtn, nextBtn, editBtn, searchBtnBottom;
	private JRadioButton nameRadioBtn, jobRadioBtn, locationRadioBtn;
	private JScrollPane tablescrollpanel;
	private int i, selectedRow;
	private DefaultTableModel model;
	private JCheckBoxMenuItem numberChkMenuItem, nameChkMenuItem, jobChkMenuItem, locationChkItem;
	private TableCellRenderer renderer;

	/**
	 * Launch the application.
	 */
	public static void manageSystemMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementSystem frame = new ManagementSystem();
					frame.jFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagementSystem() {
		
		jFrame.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 12));
		jFrame.setTitle("CardLayoutExample");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 984, 605);

		menuBar = new JMenuBar();
		jFrame.setJMenuBar(menuBar);

		filemenu = new JMenu("File");
		alignmenu = new JMenu("Align");
		helpmenu = new JMenu("Help");

		menuBar.add(filemenu); menuBar.add(alignmenu); menuBar.add(helpmenu); //메뉴바에 표시될 요소 추가
		filemenu.add(save);filemenu.add(open); filemenu.add(close); //파일 메뉴 안에 표시될 요소들 '저장', '열기', '닫기'
		
//		table.setRowSorter();
		
		numberChkMenuItem = new JCheckBoxMenuItem("Number");// 정렬 메뉴의 Number 
		buttonGroupForAlignMenu.add(numberChkMenuItem);
		alignmenu.add(numberChkMenuItem);
		
		nameChkMenuItem = new JCheckBoxMenuItem("Name"); // 정렬 메뉴의 Name
		buttonGroupForAlignMenu.add(nameChkMenuItem);
		alignmenu.add(nameChkMenuItem);
		
		jobChkMenuItem = new JCheckBoxMenuItem("Job"); //정렬 메뉴의 job
		buttonGroupForAlignMenu.add(jobChkMenuItem);
		alignmenu.add(jobChkMenuItem);
		
		locationChkItem = new JCheckBoxMenuItem("Location"); //정렬 메뉴의 Location
		buttonGroupForAlignMenu.add(locationChkItem);
		alignmenu.add(locationChkItem);
		
		helpmenu.add(printinfo);//help 메뉴의 printinfo
		
		showTable(); // Show Table
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jFrame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		westpanel = new JPanel();
		contentPane.add(westpanel, BorderLayout.WEST);
		westpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		inputpanel = new JPanel();
		inputpanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 4), "INPUT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		westpanel.add(inputpanel);
		inputpanel.setLayout(new GridLayout(0, 2, 0, 20));
		
		lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(lblNumber);
		
		numberTextField = new JTextField();
		inputpanel.add(numberTextField);
		numberTextField.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(lblName);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		inputpanel.add(nameTextField);
		
		lblTel = new JLabel("Tel");
		lblTel.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(lblTel);
		
		telTextField = new JTextField();
		telTextField.setColumns(10);
		inputpanel.add(telTextField);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		inputpanel.add(emailTextField);
		
		lblIdnumber = new JLabel("ID_Number");
		lblIdnumber.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblIdnumber.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(lblIdnumber);
		
		idNumberTextField = new JTextField();
		idNumberTextField.setColumns(10);
		inputpanel.add(idNumberTextField);
		
		jobLabel = new JLabel("Job");
		jobLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		jobLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputpanel.add(jobLabel);
		
		JComboBox jobComboBox = new JComboBox();
		jobComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {jobTextField.setText(jobComboBox.getSelectedItem().toString());}
			});
		jobComboBox.setModel(new DefaultComboBoxModel(job));
		inputpanel.add(jobComboBox);
		
		card = new JPanel();
		card.setBorder(new EmptyBorder(5, 5, 5, 5));
		westpanel.add(card);
		card.setLayout(new CardLayout(0, 0));
		
		personinfo = new JPanel();
		personinfo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), "INFO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		card.add(personinfo, "name_26959101905600");
		personinfo.setLayout(new GridLayout(0, 2, 0, 25));
		
		ageLabel = new JLabel("Age : ");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personinfo.add(ageLabel);
		
		ageTextArea = new JTextArea();
		personinfo.add(ageTextArea);
		
		genderLabel = new JLabel("Gender : ");
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personinfo.add(genderLabel);
		
		genderTextArea = new JTextArea();
		personinfo.add(genderTextArea);
		
		locationLabel = new JLabel("Location : ");
		locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personinfo.add(locationLabel);
		
		locationTextArea = new JTextArea();
		personinfo.add(locationTextArea);
		
		birthLabel = new JLabel("Birth : ");
		birthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personinfo.add(birthLabel);
		
		birthTextArea = new JTextArea();
		personinfo.add(birthTextArea);
		
		searchpanel = new JPanel();
		searchpanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		card.add(searchpanel, "name_26984514044300");
		searchpanel.setLayout(new BorderLayout(0, 0));
		
		radiopanel = new JPanel();
		radiopanel.setBorder(null);
		searchpanel.add(radiopanel, BorderLayout.NORTH);
		
		nameRadioBtn = new JRadioButton("Name");
		buttonGroupForRadio.add(nameRadioBtn);
		radiopanel.add(nameRadioBtn);
		
		jobRadioBtn = new JRadioButton("Job");
		buttonGroupForRadio.add(jobRadioBtn);
		radiopanel.add(jobRadioBtn);
		
		locationRadioBtn = new JRadioButton("Location");
		buttonGroupForRadio.add(locationRadioBtn);
		radiopanel.add(locationRadioBtn);
		
		searchtextpanel = new JPanel();
		searchpanel.add(searchtextpanel);
		searchtextpanel.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		searchtextpanel.add(panel, BorderLayout.NORTH);
		
		searchtext = new JTextField();
		panel.add(searchtext);
		searchtext.setColumns(15);
		
		searchbtnpanel = new JPanel();
		searchtextpanel.add(searchbtnpanel, BorderLayout.CENTER);
		
		searchBtnCard = new JButton("Search");
		
		searchbtnpanel.add(searchBtnCard);
		
		exitBtn = new JButton("Exit");
		searchbtnpanel.add(exitBtn);
		
		tablescrollpanel = new JScrollPane();
		contentPane.add(tablescrollpanel, BorderLayout.CENTER);
		
		table.setModel(model);
		tablescrollpanel.setViewportView(table);
		
		btnpanel = new JPanel();
		contentPane.add(btnpanel, BorderLayout.SOUTH);
		btnpanel.setLayout(new GridLayout(0, 6, 0, 0));
		
		jobTextField = new JTextField();
		jobTextField.setText(jobComboBox.getSelectedItem().toString());
		
		addBtn = new JButton("ADD");
		btnpanel.add(addBtn);
		
		deleteBtn = new JButton("DELETE");
		deleteBtn.addActionListener(new RemoveFunction(table) {});
		btnpanel.add(deleteBtn);
		
		previousBtn = new JButton("PREVIOUS");
		btnpanel.add(previousBtn);
		
		nextBtn = new JButton("NEXT");
		btnpanel.add(nextBtn);
		
		editBtn = new JButton("EDIT");
		btnpanel.add(editBtn);
		
		searchBtnBottom = new JButton("SEARCH");
		btnpanel.add(searchBtnBottom);
		
		numberChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Collections.sort(userdataVector, new Comparator<userdataVector.get(0)>() {} );
//				Collections.sort((Comparable)userdataVector.get(0));
				showTable();
			}
		});
		
		nameChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				userdataVector.sort();
				showTable();
			}
		});
		
		jobChkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				userdataVector.sort();
				showTable();
			}
		});
		
		locationChkItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				userdataVector.sort();
				showTable();
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFunction.CreateFunction(table, numberTextField, nameTextField, telTextField, emailTextField,  idNumberTextField, jobTextField);
				jobComboBox.setSelectedIndex(0);
				System.out.println(userdataVector);
			}
		});
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(0);} });
		
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRow = table.getSelectedRow();
				EditFunction.UpdateData(table, nameTextField.getText(), telTextField.getText(), emailTextField.getText(), selectedRow);
				numberTextField.setEnabled(true);
				idNumberTextField.setEnabled(true);
				nameTextField.setText("");
				telTextField.setText("");
				emailTextField.setText("");
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFileFunction.saveFile(jFrame, table);
			}
		});
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFileFunction.OpenFile(jFrame, table);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() { // 검색 카드의 종료 버튼 클릭시 카드 레이아웃 전환
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(card.getLayout());
		        cl.next(card);
			}
		});
		
		searchBtnBottom.addActionListener(new ActionListener() {// 하단의 검색 버튼 클릭시 input 카드 레이아웃에서 검색 카드 레이아웃으로 변환
		public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(card.getLayout());
		        cl.next(card);}});
		
		tablescrollpanel.addMouseListener(new MouseAdapter() { // Disable Selected Row
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
				if (selectedRow <= 0) 
					selectedRow = table.getRowCount()-1;
				else if(selectedRow == -1)
					selectedRow=0;
				else
					selectedRow--;
				
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
			}
		});
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRow ++;	
				if (selectedRow==table.getRowCount()) 
					selectedRow = 0;
				else if(selectedRow<0)
					selectedRow =0;
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
			}
		});
		
		printinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Customer Management System 2020","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				System.out.println("Selected Row : "+selectedRow);
				DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
				
//				TableCellRenderer renderer = new MyTableCellRenderer();
//				try {
//					table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
//				} catch (ClassNotFoundException e1) {e1.printStackTrace();}
		}});
		
		searchBtnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
											
				if ((searchtext.getText().length())==0) {
					JOptionPane.showMessageDialog(null, "Plsase Write the Data of TextField","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (nameRadioBtn.isSelected()) {
					CardLayout cl = (CardLayout)(card.getLayout());
			        cl.next(card);
					for(int i = 0; i<table.getRowCount(); i++){
						if (searchtext.getText().equals(table.getValueAt(i, 1))) 
							selectedRow = i;
					}
					DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
				}
				
				else if (jobRadioBtn.isSelected()) {
					CardLayout cl = (CardLayout)(card.getLayout());
			        cl.next(card);
					for(int i = 0; i<table.getRowCount(); i++){
						if (searchtext.getText().equals(table.getValueAt(i, 5))) 
							selectedRow = i;
					}
					DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
				}
				
				else if (locationRadioBtn.isSelected()) {
					CardLayout cl = (CardLayout)(card.getLayout());
			        cl.next(card);
					for(int i = 0; i<table.getRowCount(); i++){
						if (searchtext.getText().equals(table.getValueAt(i, 8))) 
							selectedRow = i;
					}
					DisplayUserInfo.DisplayUser(table, numberTextField, idNumberTextField, ageTextArea, genderTextArea, locationTextArea, birthTextArea, selectedRow);
				}
//				if (nameRadioBtn.isSelected()) {
//					renderer = new MyTableCellRenderer(table, searchtext.getText(),1);
//					try {table.setDefaultRenderer(Object.class, renderer);} 		
//					catch (Exception e1) {e1.printStackTrace();}
//				}
//				else if (jobRadioBtn.isSelected()) { // 5
//					renderer = new MyTableCellRenderer(table, searchtext.getText(),5);
//					try {table.setDefaultRenderer(Object.class, renderer);} 		
//					catch (Exception e1) {e1.printStackTrace();}
//			}
//				else if (locationRadioBtn.isSelected()) {// 8 
//					renderer = new MyTableCellRenderer(table, searchtext.getText(),8);
//					try {table.setDefaultRenderer(Object.class, renderer);} 		
//					catch (Exception e1) {e1.printStackTrace();}
//			}
				else {
					JOptionPane.showMessageDialog(null, "Please Selected the Radio Data", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
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



























