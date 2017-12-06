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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * this is example for all the program.
 * we describe the action in report #0 .
 * we want in the next exercise to changethe part of raw function
 * so just for now they still hare.  
 *
 */
public class example {
	public static void main(String[] args) {

		Path folder = Paths.get("C:\\Users\\yaron samuel\\Documents\\GIT\\YuvalYaronOOP\\ex0\\data\\data");
		List<String> paths = readFolder(folder);

		paths.removeIf(x -> !x.endsWith("csv"));
		System.out.println("file list after remove: " + paths + '\n');

		/*
		 * create raw list from one file
		 */
		List<raw> rawlist = new ArrayList<raw>();
		for (String string : paths) {
			List<raw> temp = getRawfile(string);
			rawlist = union(rawlist, temp);
		}

		/*
		 * convert raw list to wifi list with all the curract field.
		 */
		wifiListContainer c = new wifiListContainer(); 
		c.createWifilist(rawlist);

		// export the wifi list to csv file

		String fileSName="testwifilist.csv";
		c.createWifiListFile(fileSName); 

		// take csv file that we just creat and convert him to new wifi list.
		
		
		wifiListContainer b = new wifiListContainer(); 

		b.getWifilistFile(fileSName);

		// such filter of wifi list. i filter by: id group, date and location.

		List<String> str = new ArrayList<String>();
		Collections.addAll(str, "a", "d", "ONEPLUS A3003_28_171012");
	
		b.filterByIdrgroup(str);
		b.CreateKmlfile( "Idfilter.kml");
		// System.out.println("\nfilter by id group\n"+ res1 + "\n");

		b.filterByLoc(32.1678190337, 34.8061381649);
		b.CreateKmlfile( "locfilter.kml");
		//System.out.println("found " + res2.size() + " in  this loction");
		// System.out.println("filter by loction\n" + res2 + '\n');

		b.filterByDate("28/10/2017");
		b.CreateKmlfile( "datefilter.kml");
		// System.out.println("filter by date\n" + res3 + '\n');

		// for now the part of take the filtered lists and convert them to kml file.

		
		
		

/*		// for junit test for wifipoint test******
		ArrayList<wifiPoint> p = new ArrayList<wifiPoint>();
		p.add(new wifiPoint("ab", "cd", 1, 2));
		wifiList l = new wifiList("NRD90M.1928188_904.2811", "27/10/2017", "16:16:45", 32.16766122, 34.80988156,
				39.01806582, p);
		wifiList l2 = new wifiList("anotherID", "27/10/2017", "16:20:45", 32.123, 34.1234, 39.555, p);
		wifiList l3 = new wifiList("anotherID2", "29/10/2017", "16:10:45", 32.123, 34.541, 39.555, p);

		List<wifiList> list = new ArrayList<wifiList>();
		list.add(l);
		list.add(l2);
		list.add(l3);
		//****************
*/	}

	/*
	 * this code base on code we found.
	 * https://stackoverflow.com/questions/18725039/java-create-a-kml-file-and-
	 * insert-elements-in-existing-file
	 */

	public static List<raw> getRawfile(String fileName) {
		// The name of the file to open.
		// String fileName = "testwifipoint.txt";
		// String fileName = "0WigleWifi_20171028203300.csv";
		// String fileName = "test1.txt";

		int rssi;
		// This will reference one line at a time
		String line;
		List<raw> r = new ArrayList<raw>();
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
