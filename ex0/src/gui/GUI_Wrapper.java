package gui;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import ex0.rawFile;
import ex0.wifiListContainer;

public class GUI_Wrapper {

	
	//private static final String DefaultTableModel = null;
	public static File folder=new File("");
	public static File file = new File("");
	public static File nogpsfile = new File("");
	public static File combfile = new File("");
	public static File savefile = new File("");
	public static File savefolder = new File("");
	public static File algorithm1 = new File("");
	public static File algorithm2 = new File("");


	public static void choosefolder() throws IOException, ParseException {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Browse the folder to process");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

		} else {
			System.out.println("No Selection");
		}

		folder = chooser.getSelectedFile();

		if (!folder.isDirectory()) {
			folder = folder.getParentFile();
		}

		rawFile.getFiles(folder);

	}

	public static void chooseCSVFile(String name)  {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Browse the folder to process");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);


		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		}
		else {
			System.out.println("No Selection ");
		}
		if(name.equals("wifiList"))
		{
			file = chooser.getSelectedFile();
			wifiListContainer.getWifilistFile(file.getPath()); 
		}
		else if(name.equalsIgnoreCase("no gps file"))
		{
			nogpsfile = chooser.getSelectedFile();

		}
		else if(name.equalsIgnoreCase("combfile"))
		{
			combfile = chooser.getSelectedFile();

		}
	}

	public static void clearData() {

		wifiListContainer.delateAll();

	}

	public static void saveTOCSV(String name)  {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(name.equalsIgnoreCase("WigleSorted")) {
				savefile = fileChooser.getSelectedFile();
				wifiListContainer.createWifiListFile(savefile.toString()+".csv");		
			}
//			else if(name.equalsIgnoreCase("Algo1")) {
//				algorithm1 = fileChooser.getSelectedFile();
//				Algorithm_Main.ChooseAlgo1();
//			}
//
//			else if(name.equalsIgnoreCase("Algo2")) {
//				algorithm2 = fileChooser.getSelectedFile();
//				Algorithm_Main.ChooseAlgo2();
//			}
		}
	}

	public static void saveTOKML(String name) throws IOException {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML File", "kml","KML");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(name.equalsIgnoreCase("allData")) {
				savefile = fileChooser.getSelectedFile();
				wifiListContainer.CreateKmlfile(savefile.toString()+".kml");
			}

//			if(name.equalsIgnoreCase("TimeFilter")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.time_data, savefile+".kml");
//
//			}
//
//			if(name.equalsIgnoreCase("IDFilter")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.id_data, savefile+".kml");
//
//			}
//
//			if(name.equalsIgnoreCase("PositionFilter")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.position_data, savefile+".kml");
//
//			}
//
//			if(name.equalsIgnoreCase("And")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.filters_data, savefile+".kml");
//				Filter.filters_data.clear();
//
//			}
//			
//			if(name.equalsIgnoreCase("Or")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.filters_data, savefile+".kml");
//				Filter.filters_data.clear();
//
//			}
//
//			
//			if(name.equalsIgnoreCase("Not")) {
//				savefile = fileChooser.getSelectedFile();
//				KMLFile.KML(Filter.filters_data, savefile+".kml");
//				Filter.filters_data.clear();
//
//			}



		}
	}

//	public static void saveTOFolder(String name) throws IOException {
//
//		JFileChooser chooser = new JFileChooser();
//		chooser.setCurrentDirectory(new java.io.File("."));
//		chooser.setDialogTitle("Choose folder to save");
//		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		chooser.setAcceptAllFileFilterUsed(false);
//
//		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//
//		} else {
//			System.out.println("No Selection");
//		}
//
//		if(name.equalsIgnoreCase("idfilter"))
//		{
//			savefolder = chooser.getSelectedFile();
//			KMLFile.KML(Filter.id_data, savefolder + "\\ID_Filter.kml");
//			Filter.data.clear();
//		}
//
//		if(name.equalsIgnoreCase("timefilter"))
//		{
//			savefolder = chooser.getSelectedFile();
//			KMLFile.KML(Filter.time_data, savefolder + "\\Time_Filter.kml");
//			Filter.data.clear();
//		}
//
//		if(name.equalsIgnoreCase("positionfilter"))
//		{
//			savefolder = chooser.getSelectedFile();
//			KMLFile.KML(Filter.position_data, savefolder + "\\Position_Filter.kml");
//			Filter.data.clear();
//		}
//
//	}

	public static void exportAlgo1() throws IOException, ParseException {
		saveTOCSV("Algo1");
	}
	public static void exportAlgo2() throws IOException, ParseException {
		saveTOCSV("Algo2");		
	}

//	public static Position algo1Short(String mac) throws IOException {
//		return Algorithm_Main.algo1_Mac(mac);
//
//	}

//	public static void algo2Short(ArrayList<String> Allm_Alls) throws IOException, ParseException {
//
//		Mac mac;
//		Signal signal;
//		Record_Mac_Signal ms;
//		ArrayList<Record_Mac_Signal> three_ms = new ArrayList<Record_Mac_Signal>();
//
//		for (int i = 0; i < Allm_Alls.size()-1; i+=2) {
//
//			mac = new Mac(Allm_Alls.get(i));
//			signal = new Signal(Allm_Alls.get(i+1));
//			ms = new Record_Mac_Signal(mac, signal);
//			three_ms.add(ms);
//		}
//
//		Algorithm_Main.algo2_all(three_ms);
//	}
//
//	/**
//	 * Analyze Line with " " bugs, and send the MAC and Signal to Algorithm 2.
//	 * @param line from "nogps" file.
//	 * @throws IOException
//	 * @throws ParseException
//	 */
//	public static void algo2Line(String line) throws IOException, ParseException {
//
//		String word="";
//		ArrayList<String> str = new ArrayList<String>();
//		Record_Mac_Signal ms;
//		ArrayList<Record_Mac_Signal> ams = new ArrayList<Record_Mac_Signal>();
//
//		for (int i = 0; i < line.length(); i++) {
//			if((line.charAt(i)!='	') && (line.charAt(i)!=' '))word+=line.charAt(i);
//			else {
//				str.add(word);
//				word="";
//			}
//		}
//
//		for (int i = 8; i < str.size()-2; i++) {
//			if(ams.size() < 3) {
//				if(str.get(i).length()>4)
//				{
//					if(str.get(i).charAt(2) == ':') {
//						Mac mac = new Mac(str.get(i));
//						Signal signal = new Signal(str.get(i+2));
//						ms = new Record_Mac_Signal(mac,signal);		
//						ams.add(ms);
//					}
//				}
//
//			}
//			else
//				break;
//
//		}
//		Algorithm_Main.algo2_all(ams);
//
//	}


//	public static void idFilter(String id) throws IOException, ParseException
//	{
//		ID_Filter f = new ID_Filter(id);
//		ID_Filter.idFilter(f);
//	}
//
//	public static void timeFilter(String start,String end) throws ParseException, IOException
//	{
//		Time_Filter f = new Time_Filter(start, end);
//		Time_Filter.timeFilter(f);
//	}
//
//	public static void positionFilter(String lat,String lon,String radius) throws IOException, ParseException
//	{
//		Position_Filter f = new Position_Filter(lat, lon, radius);
//		Position_Filter.positionFilter(f);
//	}
//
//	public static void Filters(Position_Filter posOb, ID_Filter idOb, Time_Filter timeOb, String name) throws ParseException {
//
//		if(name.equalsIgnoreCase("Or")) {
//			
//			Or_Filter.direct(timeOb, posOb, idOb);
//		}
//		else if(name.equalsIgnoreCase("And")) {
//
//			And_Filter.direct(timeOb, posOb, idOb);
//		}
//
//		else if(name.equalsIgnoreCase("Not")) {
//
//			Not_Filter.direct(timeOb, posOb, idOb);
//		}
//	}
}
