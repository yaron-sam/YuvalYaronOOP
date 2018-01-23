package wifiData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class rawFile {
	
	public static void getFiles(File folder)  {

		String[] files_names = folder.list();

		for(int i = 0; i < files_names.length; i++) {
			if(files_names[i].startsWith("WigleWifi") && files_names[i].endsWith(".csv")) {
				File file = new File(folder+"/"+files_names[i]);
				read(file);

			}
		}
	}
	/**
	 * read raw file.
	 * @param file wigle file (scv format).
	 */
	public static void read(File file) {

		ArrayList<wifiList> wigle_mes = new ArrayList<wifiList>();
		try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
		// get id from the first line
		String line = br.readLine();
		int from = line.indexOf("display=", 0);
		String id = line.substring(line.indexOf("=", from) + 1, line.indexOf(",", from));


		line = br.readLine();

		while((line = br.readLine()) != null) {
			String[] table = line.split(",");

			
			 // condition to skip row: RSSI = -113 8AltitudeMeters = 0
			 
				if (table[5] != "-123" && Double.parseDouble(table[8]) != 0) {
					String[] date = table[3].split(" ");

					if (table[10].equals("WIFI")) {
						String mac = (table[0]);
						String ssid = (table[1]);
						int frequency = Integer.parseInt(table[4]);
						int signal = Integer.parseInt(table[5]);
						

						wifiPoint p = new wifiPoint(ssid, mac,signal, frequency );
						wifiList list = new wifiList(id, date[0], date[1], Double.parseDouble(table[6]),
								Double.parseDouble(table[7]), Double.parseDouble(table[8]));
						list.wifiPointAdd(p);
						
						wigle_mes.add(list);

						line = br.readLine();

					} 
				}
			}

		br.close();
		}catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + file.toString() + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + file.toString() + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		wifiListContainer.buildContainer(wigle_mes);
	}
	
	
}
