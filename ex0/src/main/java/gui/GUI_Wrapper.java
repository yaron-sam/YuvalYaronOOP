package gui;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Filters.Condition;
import Filters.Time;
import Filters.findGroupId;
import Filters.findLoction;
import algo.Mac;
import wifiData.kml;
import wifiData.rawFile;
import wifiData.wifiList;
import wifiData.wifiListContainer;

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
	static List<wifiList> filtered  =new ArrayList<wifiList>();

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
		} else {
			System.out.println("No Selection ");
		}
			
		file = chooser.getSelectedFile();
		wifiListContainer.getWifilistFile(file.toString()); 
		

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
			else if(name.equalsIgnoreCase("Algo1")) {
				file = fileChooser.getSelectedFile();
				wifiListContainer.generateMaclocFile(file.toString()+".csv");
			}
			else if(name.equalsIgnoreCase("Algo2")) {
				wifiListContainer.generateUserlocFile(file.toString()+".csv");

			}
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
				kml.CreateKmlfile(savefile.toString()+".kml", wifiListContainer.container);
			}

			if(name.equalsIgnoreCase("Filter")) {
				savefile = fileChooser.getSelectedFile();
				kml.CreateKmlfile(savefile.toString()+".kml", filtered);

			}
		}
	}


	public static List<Double> algo1Short(String mac)  {
		return wifiListContainer.locationOf(new Mac(mac));
	}




	/**
	 * Filter wifiList according to groupId 
	 * @param users
	 */
	public static Condition<wifiList> idFilter(String id){
		List<String> user = new ArrayList<String>();
		user.add(id);
		findGroupId groupId = new findGroupId(user);
		return groupId;
	}

	public static Condition<wifiList> timeFilter(String start,String end){
		 return new Time(start, end);
		}

	public static Condition<wifiList> positionFilter(double lat,double lon,double radius) 
	{
		return new findLoction(lat, lon, radius);
	}

	public static void Filters(Condition<wifiList> c1)  {
		filtered = wifiListContainer.filter(wifiListContainer.container, c1);
		
	}
	

	
	
}
