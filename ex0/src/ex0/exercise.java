/**
 * @author yaron samuel
 * @author yuval gabso
 * date 9/11/17
 * 
 * ***description***:
 * this program create by yaron samuel and yuval gabso. 
 * the program create as exercise #0 to oop course, ariel university.
 * 
 * i worte this from yuval
 */

package ex0;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class exercise {
	public static void main(String[] args) {

		
		Path folder = Paths.get("C:\\Users\\yaron samuel\\Documents\\GIT\\YuvalYaronOOP\\ex0\\data\\testfile");
		List<String> paths = readFolder(folder);

		paths.removeIf(x -> !x.endsWith("csv"));
		System.out.println("file list after remove: " + paths +'\n');		
				
		/*
		 * create raw list from one file 
		 */
		List<raw> rawlist = new ArrayList<raw>();
		for (String string : paths) {
			List<raw> temp = getRawfile(string);
			rawlist = union(rawlist, temp);
		}
		
		/*
		 *  convert raw list to wifi list with all the curract field.
		 */
		List<wifiList> wifilist = new ArrayList<wifiList>();
		wifilist = createWifilist(rawlist);

		/*
		 *  export the wifi list to csv file
		 */
		createWifiListFile(wifilist);

		/*
		 *  take csv file that we just creat and convert him to new wifi list.
		 */
		wifilist = getWifilistFile("testwifilist.csv");

		/*
		 * such filter of wifi list. i filter by: id group, date and location. 
		 */
		List<String> str = new ArrayList<String>();
		Collections.addAll(str, "a", "d", "ONEPLUS A3003_28_171012");
		List<wifiList> res1;
		List<wifiList> res2;
		List<wifiList> res3;
		res1 = filterByIdrgroup(wifilist, str);
//		System.out.println("\nfilter by id group\n"+ res1 + "\n");
		
		res2 = filterByLoc(wifilist, 32.09048524, 34.87696121);
		System.out.println("found " +res2.size() + " in  this loction");
//		System.out.println("filter by loction\n" + res2 + '\n');
		
		res3 = filterByDate(wifilist, "28/10/2017");
//		System.out.println("filter by date\n" + res3 + '\n');
		
		/*
		 * ****for now the part of take the filtered lists and convert them to kml file. 
		 */
		createKmlfile(res1,"Idfilterkml");
		createKmlfile(res2,"locfilterkml");
		createKmlfile(res3,"datefilterkml");


	}
	/*
	 * this code base on code we found.
	 * https://stackoverflow.com/questions/18725039/java-create-a-kml-file-and-insert-elements-in-existing-file
	 */
	public static void createKmlfile(List<wifiList> list, String filename) {
		String kmlstart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>\n" + "<Folder><name>Wifi Networks</name>\n";

		String temp = kmlstart;
		for (wifiList r : list) {

			String kmlelement = "\t<Placemark>\n" + "\t<name>" + r.points.get(0).SSID + "</name>\n" + "\t<description>"
					+ "id: <b>" + r.id + "</b><br/>date: <b>" + r.date + " " + r.time + "</b>" + "<br/>MAC: " + "<b>"
					+ r.points.get(0).MAC + "</b>" + "<br/>Channel: " + "<b>" + r.points.get(0).Channel + "</b>" + "<br/>signal: "
					+ "<b>" + r.points.get(0).Signal + "</b>" + "</description>\n" + "\t<Point>\n" + "\t\t<coordinates>"
					+ r.lon + "," + r.lat + "</coordinates>\n" + "\t</Point>\n" + "\t</Placemark>\n";

			temp = temp + kmlelement;
		}

		/*
		 * <Placemark> <name><![CDATA[dbwguest]]></name> <description><![CDATA[BSSID:
		 * <b>ce:d7:19:0e:ff:95</b><br/>Capabilities: <b>[ESS]</b><br/>Frequency:
		 * <b>2462</b><br/>Timestamp: <b>1509211940000</b><br/>Date: <b>2017-10-28
		 * 20:32:20</b>]]></description><styleUrl>#green</styleUrl> <Point>
		 * <coordinates>34.80794003,32.16721229</coordinates></Point> </Placemark>
		 */

		String kmlend = "</Folder>\n" + "</Document></kml>";

		temp = temp + kmlend;

		Writer fwriter;

		try {

			fwriter = new FileWriter(filename + ".kml");
			fwriter.write(temp);
			fwriter.flush();
			fwriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("create kml file: "+ filename);
	}
	
	




	

	
	public static List<raw> getRawfile(String fileName) {
		// The name of the file to open.
		//String fileName = "testwifipoint.txt";
		//	String fileName = "0WigleWifi_20171028203300.csv";
		// String fileName = "test1.txt";

		int rssi;
		// This will reference one line at a time
		String line;
		List<raw> r = new ArrayList<raw>();
		List<String> st = new ArrayList<String>();
		List<String> temp = new ArrayList<String>(2);
		String[] table = new String[11];
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// get id from the first line
			line = bufferedReader.readLine();
			int from = line.indexOf("display=", 0);
			String id = line.substring(line.indexOf("=", from) + 1, line.indexOf(",", from));

			line = bufferedReader.readLine();
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				table = line.split(",");
				/*
				 * -113 0 not ok value, dont get them MAC 1SSID 2AuthMode 3FirstSeen 4Channel
				 * 5RSSI 6CurrentLatitude 7CurrentLongitude 8AltitudeMeters 9AccuracyMeters
				 * 10Type
				 * 
				 */

				/*
				 * condition to skip row: RSSI = -113 8AltitudeMeters = 0
				 */
				if (table[5] != "-123" && Double.parseDouble(table[8]) != 0) {

					String[] date = table[3].split(" ");
					if (table[10].equals("GSM"))
						rssi = Integer.parseInt(table[5]);
					else
						rssi = 0;

					/*
					 * String id, String date, String time, double lat, double lon, double alt,
					 * String ssid, String mac, int signal, int channel, int gsm
					 */
					raw rawLine = new raw(id, date[0], date[1], Double.parseDouble(table[6]),
							Double.parseDouble(table[7]), Double.parseDouble(table[8]), table[1], table[0],
							Integer.parseInt(table[5]), Integer.parseInt(table[4]), rssi);
					// System.out.println(rawLine);
					r.add(rawLine);

					/*
					 * if(rawLine.getGSM()!=0) { System.out.print(i++ +": ");
					 * System.out.println(rawLine); }
					 */

				}

			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return r;
	}


	
	public static <T> List<T> union(Collection<T> a, Collection<T> b) {
		List<T> c = new ArrayList<T>();
		c.addAll(a);
		c.addAll(b);
		return c;
	}
	
	static List<String> readFolder(Path folder) {
		List<Path> files = new ArrayList<Path>();
		try {
			Files.newDirectoryStream(folder).forEach(
					// file -> System.out.println(file)
					file -> files.add(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> fileString = new ArrayList<String>();
		String s;
		for (Path p : files) {
			s = p.toString();
			fileString.add(s);
		}
		return fileString;
	}
}
