/**
 * @author yaron samuel
 */

package ex0;

import java.util.Arrays;

public class wifiList {
	
	/*
	 * Time, ID, Lat, Lon, Alt, #WiFi networks (up to 10), SSID1, MAC1, Frequncy1, Signal1,
SSID2, MAC2, Frequncy2, Signal2, ...

	 */
	String id;
	String date;
	String time;
	double lat;
	double lon;
	double alt;
	wifiPoint[] list;

	public wifiList(String id, String date, String time, double lat, double lon, double alt, wifiPoint[] list) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.list = list;
	}
	public wifiList(String id, String date, String time, double lat, double lon, double alt) {
		this.id =  new String(id);
		this.date = date;
		this.time = time;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.list = new wifiPoint[10];
	}

	@Override
	public String toString() {
		return "wifiList [id=" + id + ", date=" + date + ", time=" + time + ", lat=" + lat + ", lon=" + lon + ", alt="
				+ alt + ", list=" + Arrays.toString(list) + "]";
	}



	
	
	/*public String toString() {
		String s =  "wifiList [id=" + id + ", date=" + date + ", time=" + time + ", lat=" + lat + ", lon=" + lon + ", alt="
				+ alt + "]\nlist=";
		 for (wifiPoint wifiPoint : list) {
			s += wifiPoint.toString();
			s+='\n';
		}
		 
		 return s;
	}*/
	
	
	

}
