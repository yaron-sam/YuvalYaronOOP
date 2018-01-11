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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Filters.Condition;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * 
 * wifiListContainer class
 * this class contain all the method that create the wifilist network table and filter by some rules.
 *
 */
/**
 * @author yaron samuel
 *
 */
/**
 * @author yaron samuel
 *
 */
/**
 * @author yaron samuel
 *
 */
public class wifiListContainer {

	 public static final List<wifiList> container = new ArrayList<wifiList>();
	 private Map<String,List<Double>> map;

	 
//	/**
//	 *  Constructor empty wifiListContainer.
//	 */
//	public wifiListContainer() {
//		this.container = new ArrayList<wifiList>();
//	}
//	
//		/**
//	 * Copy constructor wifiListContainer.
//	 * @param item wifiListContainer we wand to copy
//	 */
//	public wifiListContainer(List<wifiList> item) {
//		this.container = item;
//	}
//	
	/**
	 * Getting wifiListFile and enter him to wifilist container.
	 * @param fileName
	 */
	public static void getWifilistFile(String fileName) {

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
													Integer.parseInt(table[j + 3]) ,
													Integer.parseInt(table[j + 2])));

					}
				}
				container.add(wifiline);
				

			}

			// close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}

	}
/*	public void createWifilist(List<raw> rawlist) {
//		List<wifiList> wifilist = new ArrayList<wifiList>();
		for (int i = 0; i < rawlist.size(); i++) {
			
			 // constructor field: public wifiList(String id, String date, String time,
			 // double lat, double lon, double alt, wifiPoint[] list) {
			  
			 

			wifiList r = new wifiList(rawlist.get(i).getId(), rawlist.get(i).getDate(), rawlist.get(i).getTime(),
					rawlist.get(i).getLat(), rawlist.get(i).getLon(), rawlist.get(i).getAlt());


			while (rawlist.size() > i && r.getId().equals(rawlist.get(i).getId()) && r.getDate().equals(rawlist.get(i).getDate())
					&& r.getTime().equals(rawlist.get(i).getTime()) && r.getLat() == rawlist.get(i).getLat()
					&& r.getLon() == rawlist.get(i).getLon() && r.getAlt() == rawlist.get(i).getAlt()) {

				r.wifiPointAdd(new wifiPoint(rawlist.get(i).getSSID(), rawlist.get(i).getMAC(),
						rawlist.get(i).getSignal(), rawlist.get(i).getChannel()));
				i++;

				
			}
			i --;
			

			this.container.add(r);

		}
	}*/
	
	public static void buildContainer(ArrayList<wifiList> data) {


		ArrayList<wifiList> sorted_data = new ArrayList<wifiList>();

		for(int i = 0; i < data.size()-1; i++) {

			if(data.get(i).compare(data.get(i+1)) == true) {
				data.get(i+1).merge(data.get(i).getPoints());
			}
			else {		
				sorted_data.add(data.get(i));
			}			
		}


		container.addAll(sorted_data);
		sorted_data.clear();
		data.clear();
	}
	
	public static int size() {
		return container.size();
	}
	
	/**
	 * Creating a new wifiListFile
	 */
	public static  void createWifiListFile(String fileName) {
		String[] title = { "Date", "Time", "ID", "Lat", "Lon", "Alt", "SSID1", "MAC1", "Frequncy1", "Signal1", "SSID2",
				"MAC2", "Frequncy2", "Signal2", "SSID3", "MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4",
				"Signal4", "SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6", "Frequncy6", "Signal6", "SSID7",
				"MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8", "Signal8", "SSID9", "MAC9", "Frequncy9",
				"Signal9", "SSID10", "MAC10", "Frequncy10", "Signal10" };

		Path outputFile = Paths.get(fileName);
		
		List<wifiList> wifilist = container;
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
				//TODO print wifilist in the class
				writer.print(wifilist.get(i).getDate() + ',' + wifilist.get(i).getTime() + ',' + wifilist.get(i).getId() + ','
						+ wifilist.get(i).getLat() + ',' + wifilist.get(i).getLon() + ',' + wifilist.get(i).getAlt());
				
				for (int j = 0; j < wifilist.get(i).points.size()  && j<10 ; j++) {
					writer.print(',' + wifilist.get(i).points.get(j).getSSID() + ',' + wifilist.get(i).points.get(j).getMAC() + ','
							+ wifilist.get(i).points.get(j).getChannel() + ',' + wifilist.get(i).points.get(j).getSignal());
				}
				writer.println();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void delateAll() {
		container.clear();
	}
	
/*	*//**
	 * Filter wifiList according to groupId 
	 * @param users
	 *//*
	public void filterByIdrgroup( List<String> users) {
		Condition<wifiList> group = new findGroupId(users);
		this.container = (ArrayList<wifiList>)  filter(this.container, group);
	}
	*//**
	 * Filter wifiList according to location
	 * @param lat latitude
	 * @param lon longitude
	 *//*
	public void filterByLoc( double lat, double lon) {
//		Condition<wifiList> condition = s -> s.lat == lat && s.lon == lon;
		Condition<wifiList> condition = new findLoction(lat, lon);
		System.out.println(condition);
		this.container = (ArrayList<wifiList>) filter(this.container, condition);
	}
	*//**
	 * Filter wifiList according to date
	 * @param date
	 *//*
	public void filterByDate( String date) {
		Condition<wifiList> condition = s -> s.getDate().equals(date);
		this.container = (ArrayList<wifiList>) filter(this.container, condition);
	}*/
	
	
	/**
	 * General filter (abstract filter)
	 * @param items
	 * @param condition
	 * @return new list after filtering
	 */
	static <T> List<wifiList> filter(Collection<wifiList> items, Condition<T> condition) {
		List<wifiList> output = new ArrayList<wifiList>(); // initialize empty list
		for (wifiList item : items) {
			if (condition.test(item)) {
//				output.add(item);
				output.add(new wifiList(item));

			}
		}
		return output;
	}


	public List<Double> locationOf( PointType pointtype) {
		List<Double> loc  =  new ArrayList<Double>();
		loc = pointtype.find(this.container);
//		System.out.println(loc);
		return loc;
		}
	

//filter(wifiListContainer L,findLocation(lat,lon));

	/**
	 * fix format of time to be hh:mm:ss
	 * 
	 * base on https://www.tutorialspoint.com/java/java_date_time.htm
	 * @param time string of time (can be hh:mm or hh:mm:ss) 
	 * @return fix format of time
	 * 
	 */
	public static String timeFormatFix(String time) {
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
	public static String timeStampFormatFix(String date) {
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
	public static void CreateKmlfile(String filename) {

		try {
			System.out.println("working..");

			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument().withName("Wifi Networks");

			for (wifiList l : container) {

				Double longitude = l.getLon();
				Double latitude = l.getLat();
				String date = new String(l.getDate() + " " + timeFormatFix(l.getTime()));
				date = timeStampFormatFix(date);

				String description = "id: <b>" + l.getId() + "</b><br/>date: <b>" + l.getDate() + " " + l.getTime() + "</b>"
						+ "<br/>MAC: " + "<b>" + l.points.get(0).getMAC() + "</b>" + "<br/>Channel: " + "<b>"
						+ l.points.get(0).getChannel() + "</b>" + "<br/>signal: " + "<b>" + l.points.get(0).getSignal() + "</b>";

				Placemark place = document.createAndAddPlacemark().withName(l.points.get(0).getSSID());
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
	
	void generateMaclocFile(String file_name) {
		map=new TreeMap<String,List<Double>>();
		List<wifiList> copy = new ArrayList<wifiList>(this.container); //This does a shallow copy


		for (wifiList sample : container) {
			System.out.println(sample.getPoints().size());
//			System.out.println(sample.points.size());
		}
//		System.out.println("*********************");
		for (wifiList sample : copy) {
//			System.out.println(sample.getPoints().size());
			for (wifiPoint p : sample.getPoints()) {
//				System.out.println(p.getMAC());
				if (!map.containsKey(p.getMAC()))
					map.put(p.getMAC(), locationOf(new Mac(p.getMAC())));
			}
		}
		System.out.println("number of diffrent mac: " + map.size());
		try {
			PrintWriter pw = new PrintWriter(file_name);
			StringBuilder sb = new StringBuilder();
			sb.append("Mac adrees,Lat,Lon,Alt\n");
			map.forEach((mac,a) ->{
				sb.append(mac+","+a.get(0)+","+a.get(1)+","+a.get(2)+"\n");
				}
			);
			pw.print(sb);
			pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("create mac loction file: "+file_name);
	}

    void generateUserlocFile (String file_name) {
   	 
    }	
    

/*	public static void main(String[] args) {
		wifiListContainer c  = new wifiListContainer();
		
//		String inputfileSName="testwifilist.csv";
		String inputfileSName="input_BM2.csv";
//		String inputfileSName="input_BM2.csv";


		// take csv file that we just creat and convert him to new wifi list.
		
	
		c.getWifilistFile(inputfileSName);
		
		c.generateMaclocFile("macLoctionBm2.csv");
		
		
		Map<String,Integer> list =new TreeMap<String,Integer>();

		list.put("mac10",-50);
		list.put("mac20",-70);
		list.put("mac30",-90);
//		list.put("ec:8c:a2:26:d3:68",-73);
//		list.put("24:c9:a1:35:a5:e8",-89);
//		list.put("1c:b9:c4:16:05:38",-90);
		PointType p2  = new User(list);

		c.locationOf(p2);
			
	 * 
	 * 
		PointType p  = new Mac("yaron");
		c.locationOf(p);
		
//		another way to call mac interface
		c.locationOf( new Mac("hh") );		

		
//629.8955133 ver
		
		//user testing
		Map<String,Integer> list =new TreeMap<String,Integer>();
  
		list.put("mac1",-50);
		list.put("mac2",-70);
		list.put("mac3",-70);
		list.put("mac4",-60);
		list.put("mac5",-40);
		list.put("mac6",-10);
		PointType p2  = new User(list);

		c.locationOf(p2);


	}*/

}
