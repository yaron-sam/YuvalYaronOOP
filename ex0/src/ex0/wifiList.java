/**
 * @author yaron samuel
 */
package ex0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * wifilist contain sample's data about name loction and time and until 10 most strong wifi network (wifipoint) that
 * Receive in the sample.  
 *
 */
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
	List<wifiPoint> points;
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
	
	public wifiList(wifiList w) {
		this.id = w.id;
		this.date = w.date;
		this.time=w.time;
		this.lat=w.lat;
		this.lon=w.lon;
		this.alt=w.alt;
		this.points= w.points.stream().map(wifiPoint::new).collect(Collectors.toList());
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
	public List<wifiPoint> getPoints() {
//		List<wifiPoint> newlist = new ArrayList<wifiPoint>(this.points.size());
//		for (wifiPoint p : this.points) {
//			newlist.add(new wifiPoint(p));
//		}
//		return newlist;
//		return this.points.stream().map(wifiPoint::new).collect(Collectors.toList());
	
//		List<wifiPoint> copy = new ArrayList<wifiPoint>(this.points);
//		return copy;
		return this.points;
		
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(ArrayList<wifiPoint> points) {
		this.points = points;
	}

	
	/**
	 * check if position and time are equals. (used for marge same  id time loction list) 
	 * @param other wifiList 
	 * @return
	 */
	public boolean compare(wifiList other) {
		
		if (Double.doubleToLongBits(alt) != Double.doubleToLongBits(other.alt))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public void merge(List<wifiPoint> points) {
		for (int i = 0; i < points.size(); i++){	
			this.wifiPointAdd(points.get(i));
		}		
	}
	

//	public static void main(String[] args) {
//		ArrayList<wifiPoint> p = new ArrayList<wifiPoint>();
//		p.add(new wifiPoint("ab", "1", 1, 2));
//		p.add(new wifiPoint("ab", "2", 1, 2));
//		p.add(new wifiPoint("ab", "3", 1, 2));
//		p.add(new wifiPoint("ab", "4", 1, 2));
//		wifiList l = new wifiList("NRD90M.1928188_904.2811", "27/10/2017", "16:16:45", 32.16766122, 34.80988156,
//				39.01806582, p);
//		wifiList lewp =  new wifiList(l);
//		System.out.println(l.equals(lewp));
//		System.out.println(l==lewp);
//
//		List<wifiPoint> newp = l.getPoints();
//		l.points.remove(2);
//		System.out.println(l.points);
//		System.out.println(newp);
//		
//		System.out.println(l.points.get(0)+"vs "+newp.get(0)+" is: " +(l.points.get(0)==newp.get(0)));
//		System.out.println(l.points.get(0)+"vs "+newp.get(0)+" is: " +l.points.get(0).equals(newp.get(0)));
//		
//		wifiList newl = new wifiList(l);
//		l.time ="change";
//		l.points.add(new wifiPoint("new", "5", 1, 2));
//		
//	}
}
