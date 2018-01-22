package gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Filters.Condition;
import Filters.Time;
import Filters.findGroupId;
import Filters.findLoction;
import Filters.util;
import algo.Mac;
import algo.User;
import algo.fileGenerate;
import dataBase.SQLwhatcher;
import dataBase.mySQL;
import wifiData.kml;
import wifiData.rawFile;
import wifiData.wifiList;
import wifiData.wifiListContainer;

public class GUI_Wrapper {

	public enum CSVType {
		Wigle, Algo1 ,Algo2
		};
	public enum KMLType {
		allData, Filter
			};

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

	public static void chooseWifiListFile()  {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setDialogTitle("Browse the folder to process");


		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		}
		else 
			System.out.println("No Selection ");
		

			file = chooser.getSelectedFile();
			wifiListContainer.getWifilistFile(file.toString()); 
		


	}
	
	public static void chooseNoGPSFile()  {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setDialogTitle("Browse the no GPS file");


		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		} 
		else 
			System.out.println("No Selection ");
		
		nogpsfile = chooser.getSelectedFile();


	}

	public static void clearData() {

		wifiListContainer.delateAll();

	}

	public static void saveTOCSV(CSVType kind)  {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setDialogTitle("enter file name to process");
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(kind ==CSVType.Wigle) {
				savefile = fileChooser.getSelectedFile();
				wifiListContainer.createWifiListFile(savefile.toString()+".csv");		
			}
			else if(kind ==CSVType.Algo1) {
				algorithm1 = fileChooser.getSelectedFile();
				fileGenerate.generateMacloc(algorithm1.toString()+".csv");
			}
			else if(kind ==CSVType.Algo2) {
				algorithm2 = fileChooser.getSelectedFile();
				fileGenerate.generateUserloc(algorithm2.toString()+".csv",nogpsfile.toString() );

			}
		}
	}

	public static void saveTOKML(KMLType type) throws IOException {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML File", "kml","KML");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(type == KMLType.allData) {
				savefile = fileChooser.getSelectedFile();
				kml.CreateKmlfile(savefile.toString()+".kml", wifiListContainer.container);
			}

			if(type == KMLType.Filter) {
				savefile = fileChooser.getSelectedFile();
				kml.CreateKmlfile(savefile.toString()+".kml", filtered);

			}
		}
	}


	public static List<Double> algo1Mac(String mac)  {
		return wifiListContainer.locationOf(new Mac(mac));
	}
	
	public static List<Double> algo2user(List<String> input)  {
		Map<String,Integer> map =new TreeMap<String,Integer>();

		for (int i = 0; i < input.size(); i+=2) {
			map.put(input.get(i), Integer.parseInt(input.get(i+1)));
		}
		return wifiListContainer.locationOf(new User(map));
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

	public static void readFromSQL(String ip, String port, String user, String password, String dbName,	String tableName) {
		
		if (ip.equalsIgnoreCase("enter IP")&& port.equalsIgnoreCase("enter Port")&& user.equalsIgnoreCase("enter user name")
				|| password.equalsIgnoreCase("enter password") && dbName.equalsIgnoreCase("enter Data Base") &&tableName.equalsIgnoreCase("import from table")) {
			mySQL s = new mySQL();
			try {
				s.read();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			mySQL s = new mySQL(ip,port,user,password,dbName,tableName);
			try {
				s.read();
				
				Thread thread = new Thread(new SQLwhatcher());
				thread.start();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		
	}
	
	public static void exportCondition(Condition<wifiList> c) {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("bin File", "bin","BIN");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			Path path = fileChooser.getSelectedFile().toPath();
			path =  path.resolveSibling(fileChooser.getSelectedFile().toString()+ ".bin");
			try {
				util.exportC(c,path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}

	public static Condition<wifiList> importCondition() {
		
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("bin File", "bin","BIN");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogTitle("Browse the folder to process");

		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				return util.importC(fileChooser.getSelectedFile().toPath());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		}
		return null;
	}
	

	
}
