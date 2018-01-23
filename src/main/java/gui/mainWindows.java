package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import wifiData.wifiListContainer;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.SystemColor;




public class mainWindows {

	private JFrame apps;
	public static JTextField textField;
	public static Path directoryPath;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtUserName;
	private JTextField txtTable;
	private JTextField txtDB;
	private JTextField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
	

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindows window = new mainWindows();
					window.apps.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		apps = new JFrame();
		apps.setTitle("WiFi AP analysis");
		apps.setBounds(100, 100, 566, 405);

		apps.getContentPane().setLayout(null);

		
		JButton btnBrowse = new JButton("Add Folder");
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					GUI_Wrapper.choosefolder();
					directoryPath = FileSystems.getDefault().getPath(GUI_Wrapper.folder.getPath());

					Thread thread = new Thread(new Watcher());
					thread.start();
					
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}
				textField.setText("size of data: " + wifiListContainer.size());

			
			}
		});
		btnBrowse.setBounds(22, 70, 183, 27);
		apps.getContentPane().add(btnBrowse);

		JButton btnBrowse_1 = new JButton("Add CSV File");
		btnBrowse_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Wrapper.chooseWifiListFile();

				textField.setText("size of data: " + wifiListContainer.size());
				}
		});
		btnBrowse_1.setBounds(22, 109, 183, 27);
		apps.getContentPane().add(btnBrowse_1);

		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				GUI_Wrapper.clearData();
				textField.setText("size of data: " + wifiListContainer.size());
			}
		});
		btnClearData.setBounds(22, 148, 183, 27);
		apps.getContentPane().add(btnClearData);

		JButton btnSaveToCsv = new JButton("Save To CSV");
		btnSaveToCsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Wrapper.saveTOCSV(GUI_Wrapper.CSVType.Wigle);	

			}
		});
		btnSaveToCsv.setBounds(22, 187, 183, 27);
		apps.getContentPane().add(btnSaveToCsv);

		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setFont(new Font("Elephant", Font.BOLD, 18));
		lblAlgorithms.setForeground(Color.DARK_GRAY);
		lblAlgorithms.setBounds(249, 124, 114, 48);
		apps.getContentPane().add(lblAlgorithms);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setForeground(Color.DARK_GRAY);
		lblFilters.setFont(new Font("Elephant", Font.BOLD, 18));
		lblFilters.setBounds(261, 7, 114, 48);
		apps.getContentPane().add(lblFilters);

		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setForeground(Color.DARK_GRAY);
		lblDataStructure.setFont(new Font("Elephant", Font.BOLD, 18));
		lblDataStructure.setBounds(22, 14, 162, 34);
		apps.getContentPane().add(lblDataStructure);

		JButton btnTime = new JButton("Filter");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				P_filter filter = new P_filter();
				filter.setVisible(true);

			}
		});
		btnTime.setBounds(251, 70, 98, 27);
		apps.getContentPane().add(btnTime);

		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				P_algo1 algo1 = new P_algo1();
				algo1.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(251, 187, 98, 27);
		apps.getContentPane().add(btnAlgorithm);

		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				P_algo2 algo2 = new P_algo2();
				algo2.setVisible(true);

			}
		});
		btnAlgorithm_1.setBounds(251, 226, 98, 27);
		apps.getContentPane().add(btnAlgorithm_1);

		textField = new JTextField();
		textField.setFont(new Font("Georgia Pro Semibold", Font.BOLD, 20));
		textField.setBounds(22, 278, 341, 34);
		apps.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText("Size of data: " + wifiListContainer.container.size());

		JButton btnSaveToKml = new JButton("Save To KML");
		btnSaveToKml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					GUI_Wrapper.saveTOKML(GUI_Wrapper.KMLType.allData);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		btnSaveToKml.setBounds(22, 226, 183, 27);
		apps.getContentPane().add(btnSaveToKml);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.DARK_GRAY);
		editorPane.setBounds(22, 44, 162, 2);
		apps.getContentPane().add(editorPane);

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setBackground(Color.DARK_GRAY);
		editorPane_1.setBounds(251, 44, 97, 2);
		apps.getContentPane().add(editorPane_1);

		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setEditable(false);
		editorPane_2.setBackground(Color.DARK_GRAY);
		editorPane_2.setBounds(234, 161, 136, 2);
		apps.getContentPane().add(editorPane_2);
		
		JLabel lblThisAppsCreate = new JLabel("this apps create by yaron samuel and yuval gabso");
		lblThisAppsCreate.setBounds(72, 341, 285, 14);
		apps.getContentPane().add(lblThisAppsCreate);
		
		JLabel lblImportFromDb = new JLabel("import from DB");
		lblImportFromDb.setForeground(Color.DARK_GRAY);
		lblImportFromDb.setFont(new Font("Elephant", Font.PLAIN, 14));
		lblImportFromDb.setBounds(405, 9, 155, 48);
		apps.getContentPane().add(lblImportFromDb);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setEditable(false);
		editorPane_4.setBackground(Color.DARK_GRAY);
		editorPane_4.setBounds(392, 44, 136, 2);
		apps.getContentPane().add(editorPane_4);
		
		txtIp = new JTextField();
		txtIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtIp.setText("enter IP");
		txtIp.setBounds(405, 73, 123, 20);
		apps.getContentPane().add(txtIp);
		txtIp.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("enter Port");
		txtPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort.setColumns(10);
		txtPort.setBounds(405, 104, 123, 20);
		apps.getContentPane().add(txtPort);
		
		txtUserName = new JTextField();
		txtUserName.setText("enter user name");
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setColumns(10);
		txtUserName.setBounds(405, 141, 123, 20);
		apps.getContentPane().add(txtUserName);
		
		txtTable = new JTextField();
		txtTable.setText("enter table");
		txtTable.setHorizontalAlignment(SwingConstants.CENTER);
		txtTable.setColumns(10);
		txtTable.setBounds(405, 244, 123, 20);
		apps.getContentPane().add(txtTable);
		
		txtDB = new JTextField();
		txtDB.setText("enter Data Base");
		txtDB.setHorizontalAlignment(SwingConstants.CENTER);
		txtDB.setColumns(10);
		txtDB.setBounds(405, 211, 123, 20);
		apps.getContentPane().add(txtDB);
		
		txtPassword = new JTextField();
		txtPassword.setText("enter password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setColumns(10);
		txtPassword.setBounds(405, 180, 123, 20);
		apps.getContentPane().add(txtPassword);
		
		JButton btnImprtFromTable = new JButton("import from table");
		btnImprtFromTable.setToolTipText("if empty, the data come from oop_course_ariel.ex4_db table.");
		btnImprtFromTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnImprtFromTable.setBounds(400, 278, 136, 27);
		apps.getContentPane().add(btnImprtFromTable);
		
		btnImprtFromTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = txtIp.getText();
				String port = txtPort.getText();
				String user = txtUserName.getText();
				String password = txtPassword.getText();
				String dbName = txtDB.getText();
				String tableName = txtTable.getText();
				
				GUI_Wrapper.readFromSQL(ip,port,user,password,dbName,tableName);
				textField.setText("Size of data: " + wifiListContainer.container.size());

			}
		});
		
		apps.setBackground(Color.WHITE);
		apps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
}
