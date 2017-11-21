package ex0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * 
 * @author Yuval_Gabso
 * wifiListContainer class
 *
 */
public class wifiListContainer {

	private List<wifiList> container;

	/**
	 *  Constructor wifiListContainer
	 */
	public wifiListContainer() {
		this.container = new ArrayList<wifiList>();
	}
		/**
	 * Copy constructor wifiListContainer
	 * @param container
	 */
	public wifiListContainer(List<wifiList> container) {
		this.container = container;
	}
	/**
	 * Getting wifiListFile 
	 * @param fileName
	 */
	public void getWifilistFile(String fileName) {
//		List<wifiList> list = new ArrayList<wifiList>();

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
//				ArrayList<wifiPoint> points = new ArrayList<wifiPoint>() ;



				wifiList wifiline = new wifiList(table[2], table[0], table[1], Double.parseDouble(table[3]),
						Double.parseDouble(table[4]), Double.parseDouble(table[5]));

				for (int j = 6, k = 0; j < table.length || k < 10; j += 4, k++) {
					if (j < table.length && table[j] != null) {
						wifiline.wifiPointAdd(new wifiPoint(table[j],
													table[j + 1],
													Integer.parseInt(table[j + 2]) ,
													Integer.parseInt(table[j + 3])));

					}
				}
				this.container.add(wifiline);

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

	}
	
	public void createWifilist(List<raw> rawlist) {
//		List<wifiList> wifilist = new ArrayList<wifiList>();
		for (int i = 0; i < rawlist.size(); i++) {
			/*
			 * constructor field: public wifiList(String id, String date, String time,
			 * double lat, double lon, double alt, wifiPoint[] list) {
			 * 
			 */

			wifiList r = new wifiList(rawlist.get(i).getId(), rawlist.get(i).getDate(), rawlist.get(i).getTime(),
					rawlist.get(i).getLat(), rawlist.get(i).getLon(), rawlist.get(i).getAlt());


			while (rawlist.size() > i && r.id.equals(rawlist.get(i).getId()) && r.date.equals(rawlist.get(i).getDate())
					&& r.time.equals(rawlist.get(i).getTime()) && r.lat == rawlist.get(i).getLat()
					&& r.lon == rawlist.get(i).getLon() && r.alt == rawlist.get(i).getAlt()) {

				r.wifiPointAdd(new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
						rawlist.get(i).getSignal(), rawlist.get(i).getChannel()));
				i++;

				
			}
			i --;
			
			/*
			 * for debuging
			System.out.println("i: " + i + ",k: " + k + "\n" + r);*/
			this.container.add(r);

		}
	}
	/**
	 * Creating a new wifiListFile
	 */
	public  void createWifiListFile() {
		String[] title = { "Date", "Time", "ID", "Lat", "Lon", "Alt", "SSID1", "MAC1", "Frequncy1", "Signal1", "SSID2",
				"MAC2", "Frequncy2", "Signal2", "SSID3", "MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4",
				"Signal4", "SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6", "Frequncy6", "Signal6", "SSID7",
				"MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8", "Signal8", "SSID9", "MAC9", "Frequncy9",
				"Signal9", "SSID10", "MAC10", "Frequncy10", "Signal10" };

		Path outputFile = Paths.get("testwifilist.csv");
		
		List<wifiList> wifilist = this.container;
		//TODO change the name later 
		
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
				
				for (int j = 0; j < wifilist.get(i).points.size()  && j<10 ; j++) {
					writer.print(',' + wifilist.get(i).points.get(j).SSID + ',' + wifilist.get(i).points.get(j).MAC + ','
							+ wifilist.get(i).points.get(j).Channel + ',' + wifilist.get(i).points.get(j).Signal);
				}
				writer.println();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Filter wifiList according to groupId 
	 * @param list
	 * @param users
	 * @return filtered list
	 */
	public static List<wifiList> filterByIdrgroup(List<wifiList> list, List<String> users) {
		Condition<wifiList> group = new findGroupId(users);
		return (List<wifiList>) filter(list, group);
	}
	/**
	 * Filter wifiList according to location
	 * @param list
	 * @param lat
	 * @param lon
	 * @return filtered list
	 */
	public static List<wifiList> filterByLoc(List<wifiList> list, double lat, double lon) {
//		Condition<wifiList> condition = s -> s.lat == lat && s.lon == lon;
		Condition<wifiList> condition = new findLoction(lat, lon);
		System.out.println(condition);
		return (List<wifiList>) filter(list, condition);
	}
	/**
	 * Filter wifiList according to date
	 * @param list
	 * @param date
	 * @return filtered list
	 */
	public static List<wifiList> filterByDate(List<wifiList> list, String date) {
		Condition<wifiList> condition = s -> s.date.equals(date);
		return (List<wifiList>) filter(list, condition);
	}
	/**
	 * General filter (abstract filter)
	 * @param items
	 * @param condition
	 * @return new list after filtering
	 */
	static <T> Collection<T> filter(Collection<T> items, Condition<T> condition) {
		Collection<T> output = new ArrayList<T>(); // initialize empty list
		for (T item : items) {
			if (condition.test(item)) {
				output.add(item);
			}
		}
		return output;
	}



}
