/**
 * @author yaron samuel
 * @author yuval gabso
 * date 9/11/17
 * 
 * ***description***:
 * this program create by yaron samuel and yuval gabso. 
 * the program create as exercise #0 to oop course, ariel university.
 * 
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

		
		Path folder = Paths.get("C:\\Users\\yaron samuel\\eclipse-workspace\\ex0\\data\\testfile");
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
		
		// convert raw list to wifi list with all the curract field.
		List<wifiList> wifilist = new ArrayList<wifiList>();
		wifilist = createWifilist(rawlist);

		// export the wifi list to csv file
		createWifiListFile(wifilist);

		// take csv file that we just creat and convert him to new wifi list.
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
		System.out.println("\nfilter by id group\n"+ res1 + "\n");
		
		res2 = filterByLoc(wifilist, 32.09048524, 34.87696121);
		System.out.println("filter by loction\n" + res2 + '\n');
		
		res3 = filterByDate(wifilist, "28/10/2017");
		System.out.println("filter by date\n" + res3 + '\n');
		
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

			String kmlelement = "\t<Placemark>\n" + "\t<name>" + r.list[0].SSID + "</name>\n" + "\t<description>"
					+ "id: <b>" + r.id + "</b><br/>date: <b>" + r.date + " " + r.time + "</b>" + "<br/>MAC: " + "<b>"
					+ r.list[0].MAC + "</b>" + "<br/>Channel: " + "<b>" + r.list[0].Channel + "</b>" + "<br/>signal: "
					+ "<b>" + r.list[0].Signal + "</b>" + "</description>\n" + "\t<Point>\n" + "\t\t<coordinates>"
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
	
	

	public static List<wifiList> filterByIdrgroup(List<wifiList> list, List<String> users) {
		Condition<wifiList> group = new findGroupId(users);
		return (List<wifiList>) filter(list, group);
	}

	public static List<wifiList> filterByLoc(List<wifiList> list, double lat, double lon) {
//		Condition<wifiList> condition = s -> s.lat == lat && s.lon == lon;
		Condition<wifiList> condition = new findLoction(lat, lon);
		System.out.println(condition);
		return (List<wifiList>) filter(list, condition);
	}

	public static List<wifiList> filterByDate(List<wifiList> list, String date) {
		Condition<wifiList> condition = s -> s.date.equals(date);
		return (List<wifiList>) filter(list, condition);
	}

	public static List<wifiList> getWifilistFile(String fileName) {
		List<wifiList> list = new ArrayList<wifiList>();

		String line;
		String[] table = new String[11];

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				table = line.split(",");

				/*
				 * 0Date 1Time 2ID 3Lat 4Lon 5Alt 6SSID1 7MAC1 8Frequncy1 9Signal1 SSID2 MAC2
				 * Frequncy2 Signal2 SSID3 MAC3 Frequncy3 Signal3 SSID4 MAC4 Frequncy4 Signal4
				 * SSID5 MAC5 Frequncy5 Signal5 SSID6 MAC6 Frequncy6 Signal6 SSID7 MAC7
				 * Frequncy7 Signal7 SSID8 MAC8 Frequncy8 Signal8 SSID9 MAC9 Frequncy9 Signal9
				 * SSID10 MAC10 Frequncy10 Signal10 public wifiList(String id, String date,
				 * String time, double lat, double lon, double alt, wifiPoint[] list)
				 */
				wifiPoint[] points = new wifiPoint[10];

				for (int j = 6, k = 0; j < table.length || k < 10; j += 4, k++) {
					if (j < table.length && table[j] != null) {
						points[k] = new wifiPoint();
						points[k].SSID = table[j];
						points[k].MAC = table[j + 1];
						points[k].Channel = Integer.parseInt(table[j + 2]);
						points[k].Signal = Integer.parseInt(table[j + 3]);
					}
				}

				wifiList wifiline = new wifiList(table[2], table[0], table[1], Double.parseDouble(table[3]),
						Double.parseDouble(table[4]), Double.parseDouble(table[5]), points);

				list.add(wifiline);

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

		return list;

	}

	public static void createWifiListFile(List<wifiList> wifilist) {
		String[] title = { "Date", "Time", "ID", "Lat", "Lon", "Alt", "SSID1", "MAC1", "Frequncy1", "Signal1", "SSID2",
				"MAC2", "Frequncy2", "Signal2", "SSID3", "MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4",
				"Signal4", "SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6", "Frequncy6", "Signal6", "SSID7",
				"MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8", "Signal8", "SSID9", "MAC9", "Frequncy9",
				"Signal9", "SSID10", "MAC10", "Frequncy10", "Signal10" };

		Path outputFile = Paths.get("testwifilist.csv");
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outputFile));
			for (int i = 0; i < title.length; i++) {
				writer.print(title[i]);
				if (i != title.length - 1)
					writer.print(',');

			}
			writer.println();
			for (int i = 0; i < wifilist.size(); i++) {
				writer.print(wifilist.get(i).date + ',' + wifilist.get(i).time + ',' + wifilist.get(i).id + ','
						+ wifilist.get(i).lat + ',' + wifilist.get(i).lon + ',' + wifilist.get(i).alt);
				for (int j = 0; j < 10 && wifilist.get(i).list[j] != null; j++) {
					writer.print(',' + wifilist.get(i).list[j].SSID + ',' + wifilist.get(i).list[j].MAC + ','
							+ wifilist.get(i).list[j].Channel + ',' + wifilist.get(i).list[j].Signal);
				}
				writer.println();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<wifiList> createWifilist(List<raw> rawlist) {
		List<wifiList> wifilist = new ArrayList<wifiList>();
		for (int i = 0; i < rawlist.size(); i++) {
			/*
			 * constructor field: public wifiList(String id, String date, String time,
			 * double lat, double lon, double alt, wifiPoint[] list) {
			 * 
			 */
			wifiPoint[] list = new wifiPoint[10];

			wifiList r = new wifiList(rawlist.get(i).getId(), rawlist.get(i).getDate(), rawlist.get(i).getTime(),
					rawlist.get(i).getLat(), rawlist.get(i).getLon(), rawlist.get(i).getAlt());

			int k = 0;

			while (rawlist.size() > i && r.id.equals(rawlist.get(i).getId()) && r.date.equals(rawlist.get(i).getDate())
					&& r.time.equals(rawlist.get(i).getTime()) && r.lat == rawlist.get(i).getLat()
					&& r.lon == rawlist.get(i).getLon() && r.alt == rawlist.get(i).getAlt()) {

				if (k == 0) {
					list[k] = new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
							rawlist.get(i).getSignal(), rawlist.get(i).getChannel());
					k++;
				} else {
					if (k < 10) {

						list[k] = new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
								rawlist.get(i).getSignal(), rawlist.get(i).getChannel());
						Arrays.sort(list, new sortSignal());
						k++;
					} else { // k=10 this mean we need to replace
						int index = -1;
						for (int j = list.length - 1; j > 0; j--) {
							if (rawlist.get(i).getSignal() < list[j].Signal) {
								index = j;
								break;
							}
						}
						if (index != -1 || index == 0)
							list[index] = new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
									rawlist.get(i).getSignal(), rawlist.get(i).getChannel());
						if (index == 0)
							list[9] = new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
									rawlist.get(i).getSignal(), rawlist.get(i).getChannel());
						Arrays.sort(list, new sortSignal());
						k++;
					}
				}
				i++;
			}
			i = i + k - 2;
			r.list = list;
			/*
			 * for debuging
			System.out.println("i: " + i + ",k: " + k + "\n" + r);*/
			wifilist.add(r);

		}
		return wifilist;
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

	static <T> Collection<T> filter(Collection<T> items, Condition<T> condition) {
		Collection<T> output = new ArrayList<T>(); // initialize empty list
		for (T item : items) {
			if (condition.test(item)) {
				output.add(item);
			}
		}
		return output;
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
