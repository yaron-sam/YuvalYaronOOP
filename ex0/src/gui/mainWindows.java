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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ex0.wifiListContainer;




public class mainWindows {

	private JFrame frmWifiApAnalysis;
	public static JTextField textField;
	public static Path directoryPath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
	

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindows window = new mainWindows();
//					window.frmWifiApAnalysis.setUndecorated(true);
					window.frmWifiApAnalysis.setVisible(true);
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
		
		
		frmWifiApAnalysis = new JFrame();
		frmWifiApAnalysis.setTitle("WiFi AP analysis");
		frmWifiApAnalysis.setBounds(100, 100, 420, 405);

		frmWifiApAnalysis.getContentPane().setLayout(null);

		
		JButton btnBrowse = new JButton("Add Folder");
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					GUI_Wrapper.choosefolder();
					directoryPath = FileSystems.getDefault().getPath(GUI_Wrapper.folder.getPath());
//					Thread thread = new Thread(new Thread_Watcher());
//					thread.start();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Browse button to select directory
				textField.setText("size of data: " + wifiListContainer.size());

			
			}
		});
		btnBrowse.setBounds(22, 70, 183, 27);
		frmWifiApAnalysis.getContentPane().add(btnBrowse);

		JButton btnBrowse_1 = new JButton("Add CSV File");
		btnBrowse_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Wrapper.chooseCSVFile("wifiList");

				textField.setText("size of data: " + wifiListContainer.size());
				}
		});
		btnBrowse_1.setBounds(22, 109, 183, 27);
		frmWifiApAnalysis.getContentPane().add(btnBrowse_1);

		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				GUI_Wrapper.clearData();
				textField.setText("size of data: " + wifiListContainer.size());
			}
		});
		btnClearData.setBounds(22, 148, 183, 27);
		frmWifiApAnalysis.getContentPane().add(btnClearData);

		JButton btnSaveToCsv = new JButton("Save To CSV");
		btnSaveToCsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Wrapper.saveTOCSV("WigleSorted");	

			}
		});
		btnSaveToCsv.setBounds(22, 187, 183, 27);
		frmWifiApAnalysis.getContentPane().add(btnSaveToCsv);

		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setFont(new Font("Elephant", Font.BOLD, 18));
		lblAlgorithms.setForeground(Color.DARK_GRAY);
		lblAlgorithms.setBounds(249, 124, 114, 48);
		frmWifiApAnalysis.getContentPane().add(lblAlgorithms);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setForeground(Color.DARK_GRAY);
		lblFilters.setFont(new Font("Elephant", Font.BOLD, 18));
		lblFilters.setBounds(261, 7, 114, 48);
		frmWifiApAnalysis.getContentPane().add(lblFilters);

		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setForeground(Color.DARK_GRAY);
		lblDataStructure.setFont(new Font("Elephant", Font.BOLD, 18));
		lblDataStructure.setBounds(22, 14, 162, 34);
		frmWifiApAnalysis.getContentPane().add(lblDataStructure);

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
		frmWifiApAnalysis.getContentPane().add(btnTime);

		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				P_algo1 algo1 = new P_algo1();
				algo1.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(251, 187, 98, 27);
		frmWifiApAnalysis.getContentPane().add(btnAlgorithm);

		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				P_algo2 algo2 = new P_algo2();
				algo2.setVisible(true);

			}
		});
		btnAlgorithm_1.setBounds(251, 226, 98, 27);
		frmWifiApAnalysis.getContentPane().add(btnAlgorithm_1);

		textField = new JTextField();
		textField.setFont(new Font("Georgia Pro Semibold", Font.BOLD, 20));
		textField.setBounds(22, 278, 341, 34);
		frmWifiApAnalysis.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
//		textField.setText("Size of data: " + Database.All_Data.size());

		JButton btnSaveToKml = new JButton("Save To KML");
		btnSaveToKml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

//				try {
//					GUI_Wrapper.saveTOKML("allData");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			}
		});
		btnSaveToKml.setBounds(22, 226, 183, 27);
		frmWifiApAnalysis.getContentPane().add(btnSaveToKml);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.DARK_GRAY);
		editorPane.setBounds(22, 44, 162, 2);
		frmWifiApAnalysis.getContentPane().add(editorPane);

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setBackground(Color.DARK_GRAY);
		editorPane_1.setBounds(251, 44, 97, 2);
		frmWifiApAnalysis.getContentPane().add(editorPane_1);

		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setEditable(false);
		editorPane_2.setBackground(Color.DARK_GRAY);
		editorPane_2.setBounds(234, 161, 136, 2);
		frmWifiApAnalysis.getContentPane().add(editorPane_2);
		
		JLabel lblThisAppsCreate = new JLabel("this apps create by yaron samuel and yuval gabso");
		lblThisAppsCreate.setBounds(109, 341, 285, 14);
		frmWifiApAnalysis.getContentPane().add(lblThisAppsCreate);
		frmWifiApAnalysis.setBackground(Color.WHITE);
		frmWifiApAnalysis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
}
