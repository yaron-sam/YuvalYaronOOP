package ex0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * 
 * wifiListContainer class
 * this class contain all the method that create the wifilist network table and filter by some rules.
 *
 */
public class wifiListContainer {

	private List<wifiList> container;

	/**
	 *  Constructor empty wifiListContainer.
	 */
	public wifiListContainer() {
		this.container = new ArrayList<wifiList>();
	}
	
		/**
	 * Copy constructor wifiListContainer.
	 * @param container wifiListContainer we wand to copy
	 */
	public wifiListContainer(List<wifiList> container) {
		this.container = container;
	}
	
	/**
	 * Getting wifiListFile and enter him to wifilist container.
	 * @param fileName
	 */
	public void getWifilistFile(String fileName) {

		String line;
		String[] table = new String[11];

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();
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

			// close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

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


			while (rawlist.size() > i && r.getId().equals(rawlist.get(i).getId()) && r.getDate().equals(rawlist.get(i).getDate())
					&& r.time.equals(rawlist.get(i).getTime()) && r.lat == rawlist.get(i).getLat()
					&& r.lon == rawlist.get(i).getLon() && r.alt == rawlist.get(i).getAlt()) {

				r.wifiPointAdd(new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
						rawlist.get(i).getSignal(), rawlist.get(i).getChannel()));
				i++;

				
			}
			i --;
			

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
				writer.print(wifilist.get(i).getDate() + ',' + wifilist.get(i).time + ',' + wifilist.get(i).getId() + ','
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
	 * @param users
	 */
	public void filterByIdrgroup( List<String> users) {
		Condition<wifiList> group = new findGroupId(users);
		this.container = (List<wifiList>)  filter(this.container, group);
	}
	/**
	 * Filter wifiList according to location
	 * @param lat latitude
	 * @param lon longitude
	 */
	public void filterByLoc( double lat, double lon) {
//		Condition<wifiList> condition = s -> s.lat == lat && s.lon == lon;
		Condition<wifiList> condition = new findLoction(lat, lon);
		System.out.println(condition);
		this.container = (List<wifiList>) filter(this.container, condition);
	}
	/**
	 * Filter wifiList according to date
	 * @param date
	 */
	public void filterByDate( String date) {
		Condition<wifiList> condition = s -> s.getDate().equals(date);
		this.container = (List<wifiList>) filter(this.container, condition);
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


	/**
	 * fix format of time to be hh:mm:ss
	 * 
	 * base on https://www.tutorialspoint.com/java/java_date_time.htm
	 * @param time string of time (can be hh:mm or hh:mm:ss) 
	 * @return fix format of time
	 * 
	 */
	public String timeFormatFix(String time) {
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm");
		if (time.length() == 5) {
//			System.out.print(time + " Parses as ");
			Date t = new Date();
			try {
				t = ft.parse(time);
//				System.out.println(t);
			} catch (ParseException e) {
//				System.out.println("Unparseable using " + ft);
			}
			SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
//			System.out.println("Current Date: " + simple.format(t));
			return simple.format(t);
		} else
			return time;
	}
	
	/**
	 * fix format of time stamp to be "yyyy-MM-dd'T'HH:mm:ss'Z'"
	 * 
	 * base on https://www.tutorialspoint.com/java/java_date_time.htm
	 * @param date time stamp look like dd/MM/yyyy HH:mm:ss
	 * @return fix format of time stamp
	 * 
	 */
	public String timeStampFormatFix(String date) {
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date t = new Date();
			try {
				t = ft.parse(date);
			} catch (ParseException e) {
			}
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			return simple.format(t);
	}
	
	/**
	 * create kml file from wifiList network.
	 * base on:https://labs.micromata.de/projects/jak/kml-in-the-java-world.html
	 * 		https://github.com/micromata/javaapiforkml/blob/master/src/test/java/de/micromata/jak/examples/Example4.java
	 * 		http://www.massapi.com/source/github/13/21/1321963036/src/kml/src/main/java/org/geoserver/kml/decorator/PlacemarkTimeDecoratorFactory.java.html#133
	 * 		https://developers.google.com/kml/documentation/kmlreference?csw=1#timestamp
	 * https://github.com/micromata/javaapiforkml/blob/master/src/main/java/de/micromata/opengis/kml/v_2_2_0/TimeStamp.java
	 * @param filename name of file name
	 */
	public void CreateKmlfile(String filename) {

		try {
			System.out.println("working..");

			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument().withName("Wifi Networks");

			for (wifiList l : this.container) {

				Double longitude = l.lon;
				Double latitude = l.lat;
				String date = new String(l.getDate() + " " + timeFormatFix(l.time));
				date = timeStampFormatFix(date);

				String description = "id: <b>" + l.getId() + "</b><br/>date: <b>" + l.getDate() + " " + l.time + "</b>"
						+ "<br/>MAC: " + "<b>" + l.points.get(0).MAC + "</b>" + "<br/>Channel: " + "<b>"
						+ l.points.get(0).Channel + "</b>" + "<br/>signal: " + "<b>" + l.points.get(0).Signal + "</b>";

				Placemark place = document.createAndAddPlacemark().withName(l.points.get(0).SSID);
				place.createAndSetTimeStamp().withWhen(date);
				place.createAndSetPoint().addToCoordinates(longitude, latitude);
				place.setDescription(description);
			}
			
			
			kml.marshal(new File(filename));
			System.out.println("done!");

		} catch (IOException ex) {
			System.out.print("Error with processing file\n" + ex);
			System.exit(2);
		}
		System.out.println("create kml file: " + filename);

	}


}
