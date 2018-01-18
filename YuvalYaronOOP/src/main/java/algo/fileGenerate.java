package algo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import wifiData.wifiList;
import wifiData.wifiListContainer;
import wifiData.wifiPoint;

public class fileGenerate {

	 private static Map<String,List<Double>> map;
	 private static List<wifiList> noLoctionData;

	
	public static void generateMacloc(String file_name) {
		map=new TreeMap<String,List<Double>>();
		List<wifiList> copy = new ArrayList<wifiList>(wifiListContainer.container); //This does a shallow copy


//		for (wifiList sample : container) {
//			System.out.println(sample.getPoints().size());
//		}
		
		for (wifiList sample : copy) {
//			System.out.println(sample.getPoints().size());
			for (wifiPoint p : sample.getPoints()) {
//				System.out.println(p.getMAC());
				if (!map.containsKey(p.getMAC()))
					map.put(p.getMAC(), wifiListContainer.locationOf(new Mac(p.getMAC())));
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

    public static void generateUserloc (String file_name, String noLoctionfile) {
    	
    	getNoLocionData(noLoctionfile);
    	
		Map<String,Integer> map =new TreeMap<String,Integer>();
    	for (wifiList list : noLoctionData) {
    		for (wifiPoint p : list.getPoints()) {
      		  map.put(p.getMAC(), p.getSignal());
			}
    		PointType userdata  = new User(map);
    		
    		list.setLoction(wifiListContainer.locationOf(userdata));
		
    		createFile(file_name);
		}
   	 
    }
    
    
	/**
	 * Getting wifiListFile and enter him to wifilist List.
	 * @param fileName
	 */
    private static void getNoLocionData(String fileName) {
		noLoctionData = new ArrayList<wifiList>();

		
		String line;
		String[] table;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				table = line.split(",");

		
				wifiList wifiline = new wifiList(table[2], table[0], table[1], 0,
						0, 0);

				for (int j = 6; j < table.length; j += 4) {
					if (j < table.length && table[j] != null) {
						wifiline.wifiPointAdd(new wifiPoint(table[j],
													table[j + 1],
													Integer.parseInt(table[j + 3]) ,
													Integer.parseInt(table[j + 2])));

					}
				}
				noLoctionData.add(wifiline);
				

			}

			// close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}

	}
	/**
	 * Creating a new wifiListFile
	 */
	private static void createFile(String fileName) {
		String[] title = { "Date", "Time", "ID", "Lat", "Lon", "Alt", "SSID1", "MAC1", "Frequncy1", "Signal1", "SSID2",
				"MAC2", "Frequncy2", "Signal2", "SSID3", "MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4",
				"Signal4", "SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6", "Frequncy6", "Signal6", "SSID7",
				"MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8", "Signal8", "SSID9", "MAC9", "Frequncy9",
				"Signal9", "SSID10", "MAC10", "Frequncy10", "Signal10" };

		Path outputFile = Paths.get(fileName);
		
		//TODO change the name later 
		List<wifiList> wifilist = noLoctionData;

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
				
				for (int j = 0; j < wifilist.get(i).getPoints().size()  && j<10 ; j++) {
					writer.print(',' + wifilist.get(i).getPoints().get(j).getSSID() + ',' + wifilist.get(i).getPoints().get(j).getMAC() + ','
							+ wifilist.get(i).getPoints().get(j).getChannel() + ',' + wifilist.get(i).getPoints().get(j).getSignal());
				}
				writer.println();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

