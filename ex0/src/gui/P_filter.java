package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;



@SuppressWarnings("serial")
public class P_filter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JComboBox comboBox_8;
	private JComboBox comboBox_9;
	private JComboBox comboBox_10;
	private JComboBox comboBox_11;
//	private ID_Filter idOb;
//	private Time_Filter timeOb;
//	private Position_Filter posOb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_filter frame = new P_filter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public P_filter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 622);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton radioButton_3 = new JRadioButton("OR");
		radioButton_3.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		radioButton_3.setActionCommand("enable");
		radioButton_3.setEnabled(false);

		radioButton_3.setBounds(278, 422, 83, 29);
		contentPane.add(radioButton_3);


		JRadioButton radioButton_4 = new JRadioButton("AND");
		radioButton_4.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		radioButton_4.setBounds(177, 422, 83, 29);
		contentPane.add(radioButton_4);
		radioButton_4.setEnabled(false);

		JRadioButton radioButton_5 = new JRadioButton("NOT");
		radioButton_5.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		radioButton_5.setBounds(78, 422, 97, 29);
		contentPane.add(radioButton_5);
		radioButton_5.setEnabled(false);
		radioButton_5.setSelected(true);

		ButtonGroup bt1=new ButtonGroup();
		bt1.add(radioButton_3);
		bt1.add(radioButton_4);
		bt1.add(radioButton_5);



		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");

			}
		});
		textField.setBounds(29, 120, 146, 26);
		contentPane.add(textField);
		textField.setText("Name Of Device");
		textField.setColumns(10);



		JCheckBox rdbtnNewRadioButton = new JCheckBox("Time");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(rdbtnNewRadioButton.isSelected()) {

					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					comboBox_6.setEnabled(true);
					comboBox_7.setEnabled(true);
					comboBox_8.setEnabled(true);
					comboBox_9.setEnabled(true);
					comboBox_10.setEnabled(true);
					comboBox_11.setEnabled(true);


				}

				else if(!rdbtnNewRadioButton.isSelected()) {


					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);
					comboBox_9.setEnabled(false);
					comboBox_10.setEnabled(false);
					comboBox_11.setEnabled(false);

				}

			}
		});
		rdbtnNewRadioButton.setBounds(293, 54, 155, 29);
		contentPane.add(rdbtnNewRadioButton);

//		JCheckBox chckbxT = new JCheckBox("ID");
//		chckbxT.setBounds(32, 28, 97, 23);
//		contentPane.add(chckbxT);
		
		JCheckBox rdbtnId = new JCheckBox("ID");
		rdbtnId.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(rdbtnId.isSelected()) {

					textField.setEnabled(true);
					textField.setVisible(true);
					textField.setEditable(true);
					textField.setText("Name Of Device");


				}

				else if(!rdbtnId.isSelected()) {

					textField.setEnabled(false);
					textField.setVisible(true);
					textField.setEditable(false);
					textField.setText("Name Of Device");


				}

			}
		});
		rdbtnId.setBounds(36, 54, 155, 29);
		contentPane.add(rdbtnId);



		JCheckBox rdbtnPosition = new JCheckBox("Position");
		rdbtnPosition.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(rdbtnPosition.isSelected()) {

					textField_3.setEnabled(true);
					textField_3.setVisible(true);
					textField_3.setEditable(true);
					textField_3.setText("Lat");
					textField_4.setEnabled(true);
					textField_4.setVisible(true);
					textField_4.setEditable(true);
					textField_4.setText("Lon");
					textField_5.setEnabled(true);
					textField_5.setVisible(true);
					textField_5.setEditable(true);
					textField_5.setText("Radius");

				}

				else if(!rdbtnPosition.isSelected()) {

					textField_3.setEnabled(false);
					textField_3.setVisible(true);
					textField_3.setEditable(false);
					textField_3.setText("Lat");
					textField_4.setEnabled(false);
					textField_4.setVisible(true);
					textField_4.setEditable(false);
					textField_4.setText("Lon");
					textField_5.setEnabled(false);
					textField_5.setVisible(true);
					textField_5.setEditable(false);
					textField_5.setText("Radius");


				}


			}
		});
		rdbtnPosition.setBounds(586, 54, 155, 29);
		contentPane.add(rdbtnPosition);


		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(566, 120, 166, 26);
		contentPane.add(textField_3);
		textField_3.setText("Lat");


		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_4.setText("");
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(566, 186, 166, 26);
		contentPane.add(textField_4);
		textField_4.setText("Lon");


		textField_5 = new JTextField();
		textField_5.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_5.setText("");
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(566, 250, 166, 26);
		contentPane.add(textField_5);
		textField_5.setText("Radius");

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblFilters.setBounds(341, 16, 145, 20);
		contentPane.add(lblFilters);

		JCheckBox rdbtnOnoff = new JCheckBox("Logic Options (ON/OFF)");
		rdbtnOnoff.setSelected(false);
		rdbtnOnoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnOnoff.isSelected())
				{

					radioButton_3.setEnabled(true);
					radioButton_4.setEnabled(true);
					radioButton_5.setEnabled(true);
				}
				else
				{
					radioButton_3.setEnabled(false);
					radioButton_4.setEnabled(false);
					radioButton_5.setEnabled(false);
				}
			}
		});
		rdbtnOnoff.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnOnoff.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOnoff.setBounds(11, 392, 261, 25);
		contentPane.add(rdbtnOnoff);

		JButton btnNewButton_1 = new JButton("Save To KML File");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(rdbtnId.isSelected()) {

					String id = textField.getText();

					if(id.equalsIgnoreCase("Name Of Device") || id.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Invalid ID Input", "Message", JOptionPane.INFORMATION_MESSAGE);

					}
					else {

//						try {
//							if(!rdbtnOnoff.isSelected()){
//								GUI_Wrapper.idFilter(id);
//								GUI_Wrapper.saveTOFolder("idfilter");
//							}
//							else {
//
//								idOb = new ID_Filter(id);	
//							}
//
//						} catch (IOException | ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}

					}
				}
				else if(!rdbtnId.isSelected()) {
//					idOb = new ID_Filter();
				}

				if(rdbtnNewRadioButton.isSelected())	
				{
					String begin_hour = (String)comboBox.getSelectedItem();
					String begin_minute = (String)comboBox_1.getSelectedItem();
					String begin_second = (String)comboBox_2.getSelectedItem();
					String begin_day = (String)comboBox_3.getSelectedItem();
					String begin_month = (String)comboBox_4.getSelectedItem();
					String begin_year = (String)comboBox_5.getSelectedItem();

					String end_hour = (String)comboBox_9.getSelectedItem();
					String end_minute = (String)comboBox_10.getSelectedItem();
					String end_second = (String)comboBox_11.getSelectedItem();
					String end_day = (String)comboBox_6.getSelectedItem();
					String end_month = (String)comboBox_7.getSelectedItem();
					String end_year = (String)comboBox_8.getSelectedItem();

					if(begin_hour=="Hour" || begin_minute=="Minute" || begin_second=="Second" || begin_day=="Day"
							|| begin_month=="Month" || begin_year=="Year" || end_hour=="Hour"
							|| end_minute=="Minute" || end_second=="Second" || end_day=="Day"
							|| end_month=="Month" || end_year=="Year") {

						JOptionPane.showMessageDialog(null, "Invalid Time Input", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					else {

						String begin_time = begin_year + "-" + begin_month + "-" + begin_day +" "+
								begin_hour +":"+ begin_minute +":"+ begin_second;

						String end_time = end_year + "-" + end_month + "-" + end_day +" "+
								end_hour +":"+ end_minute +":"+ end_second;


//						try {
//							if(!rdbtnOnoff.isSelected()){
//								GUI_Wrapper.timeFilter(begin_time, end_time);
//								GUI_Wrapper.saveTOFolder("timefilter");
//							}
//							else {
//								timeOb = new Time_Filter(begin_time, end_time);
//							}
//						} catch (ParseException | IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}
				}
				else if(!rdbtnNewRadioButton.isSelected()) {
//					timeOb = new Time_Filter("" , "");
				}


				if(rdbtnPosition.isSelected())
				{
					String lat = textField_3.getText();
					String lon = textField_4.getText();
					String radius = textField_5.getText();

					if(lat.equalsIgnoreCase("Lat") || lat.equalsIgnoreCase("") 
							|| lon.equalsIgnoreCase("Lon") || lon.equalsIgnoreCase("")
							|| radius.equalsIgnoreCase("Radius") || radius.equalsIgnoreCase("")) {

						JOptionPane.showMessageDialog(null, "Invalid Position Input", "Message", JOptionPane.INFORMATION_MESSAGE);

					}
					else {
//						try {
//							if(!rdbtnOnoff.isSelected()){
//								GUI_Wrapper.positionFilter(lat, lon, radius);
//								GUI_Wrapper.saveTOFolder("positionfilter");
//							}
//							else {
//
//								posOb = new Position_Filter(lat, lon, radius);
//							}
//						} catch (IOException | ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}
				}
				else if(!rdbtnPosition.isSelected()) {
//					posOb = new Position_Filter();
				}

				if(rdbtnOnoff.isSelected()) {
					if(radioButton_4.isSelected()) {
//						try {
//							GUI_Wrapper.Filters(posOb, idOb, timeOb, "And");
//							try {
//								GUI_Wrapper.saveTOKML("And");
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}

					else if(radioButton_3.isSelected()) {
//						try {
//							GUI_Wrapper.Filters(posOb, idOb, timeOb, "Or");
//							try {
//								GUI_Wrapper.saveTOKML("Or");
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}

					else if(radioButton_5.isSelected()) {
//						try {
//							GUI_Wrapper.Filters(posOb, idOb, timeOb, "Not");
//							try {
//								GUI_Wrapper.saveTOKML("Not");
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}
				}



			}
		});
		btnNewButton_1.setBounds(167, 511, 424, 25);
		contentPane.add(btnNewButton_1);

		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hour", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		comboBox.setBounds(234, 172, 73, 26);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Minute", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_1.setBounds(322, 172, 88, 26);
		contentPane.add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Second", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_2.setBounds(425, 172, 83, 26);
		contentPane.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_3.setBounds(234, 135, 73, 26);
		contentPane.add(comboBox_3);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_4.setBounds(322, 135, 88, 26);
		contentPane.add(comboBox_4);

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_5.setBounds(425, 135, 83, 26);
		contentPane.add(comboBox_5);

		comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_6.setBounds(234, 271, 73, 26);
		contentPane.add(comboBox_6);

		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_7.setBounds(322, 271, 88, 26);
		contentPane.add(comboBox_7);

		comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_8.setBounds(425, 271, 83, 26);
		contentPane.add(comboBox_8);

		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Hour", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		comboBox_9.setToolTipText("");
		comboBox_9.setBounds(234, 308, 73, 26);
		contentPane.add(comboBox_9);

		comboBox_10 = new JComboBox();
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"Minute", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_10.setBounds(322, 308, 88, 26);
		contentPane.add(comboBox_10);

		comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Second", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_11.setBounds(425, 308, 83, 26);
		contentPane.add(comboBox_11);

		JLabel lblNewLabel = new JLabel("Begin");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(234, 99, 97, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblEnd.setBounds(234, 234, 97, 20);
		contentPane.add(lblEnd);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.DARK_GRAY);
		editorPane.setBounds(322, 40, 97, 2);
		contentPane.add(editorPane);
		editorPane.setEditable(false);
		



	}
}
