/**
 * @author yaron samuel
 */
package ex0;

import java.util.ArrayList;
import java.util.Arrays;

public class wifiList {
	
	/**
	 * Time, ID, Lat, Lon, Alt, #WiFi networks (up to 10), SSID1, MAC1, Frequncy1, Signal1,
	SSID2, MAC2, Frequncy2, Signal2, ...
	 */
	private String id;
	private String date;
	private String time;
	private double lat;
	private double lon;
	private double alt;
	private ArrayList<wifiPoint> points;
/**
 * Constructor wifiList (with all variable)
 * @param id
 * @param date
 * @param time
 * @param lat
 * @param lon
 * @param alt
 * @param points
 */
	public wifiList(String id, String date, String time, double lat, double lon, double alt, ArrayList<wifiPoint> points) {
		this.id = id;
		this.date = date;
		this.time=time;
		this.lat=lat;
		this.lon=lon;
		this.lat=lat;
		this.points=points;
	}
	
	/**
	 * Constructor wifiList (without array of wifiPoint)
	 * @param id
	 * @param date
	 * @param time
	 * @param lat
	 * @param lon
	 * @param alt
	 */
	public wifiList(String id, String date, String time, double lat, double lon, double alt) {
		this.id = id;
		this.date = date;
		this.time=time;
		this.lat=lat;
		this.lon=lon;
		this.alt=alt;
		this.points=new ArrayList<wifiPoint>();   
	}
	
	/**
	 * Function that add wifiPoint p to  wifilist.
	 * @param p wifiPoint we want to add.
	 */
	public void wifiPointAdd(wifiPoint p) {
		getPoints().add(p);
		getPoints().sort( new sortSignal());
		while (getPoints().size() > 10) {
			getPoints().remove(10);
		}
	}
	/**
	 * Print wifiList. mostly useful for debugging and developed.  
	 */
	@Override
	public String toString() {
		return "wifiList [id=" + getId() + ", date=" + date + ", time=" + getTime() + ", lat=" + getLat() + ", lon=" + getLon() + ", alt="
				+ getAlt() + ", points=" + Arrays.deepToString(getPoints().toArray()) + "]";
	}

	/**
	 * getter for ID
	 * 
	 * @return ID
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * getter for date
	 * 
	 * @return date
	 */
	public String getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}
	/**
	 * getter for Lat
	 * @return
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * getter for Lon
	 * @return
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	

	/**
	 * @return the alt
	 */
	public double getAlt() {
		return alt;
	}

	
	/**
	 * @return the points
	 */
	public ArrayList<wifiPoint> getPoints() {
		return this.points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(ArrayList<wifiPoint> points) {
		this.points = points;
	}

}
