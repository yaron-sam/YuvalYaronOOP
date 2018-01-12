/**
 * @author yaron samuel
 * @author Yuval_Gabso
 */

package Filters;

import ex0.wifiList;

public class findLoction implements Condition<wifiList> {

	double lat,lon,r;
	
	/**
	 * Constructor findLocation by getting
	 * @param lat
	 * @param lon
	 */
	public findLoction(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
		 r = 0.005;
	}

	public findLoction(double lat, double lon,double r) {
		this.lat = lat;
		this.lon = lon;
		 this.r = r;
	}

	
	/**
	 *
	 *Print lat and lon
	 */
	@Override
	public String toString() {
		return "findLoction [lat=" + lat + ", lon=" + lon + "]";
	}


	/**
	 * return true if the location is exists else return false
	 * @param s
	 */
	@Override
	public boolean test(wifiList s) {
		// TODO Auto-generated method stub
	//	double result =  6371000 * Math.acos(Math.cos(Math.toRadians(90-this.lat)) * Math.cos(Math.toRadians((90-s.lat))) + Math.sin(Math.toRadians(90-this.lat)) * Math.sin(Math.toRadians(90-s.lat)) * Math.cos(Math.toRadians(this.lon-s.lon)));
double result=Math.sqrt(Math.pow(this.lat-s.getLat(),2)+Math.pow(this.lon-s.getLon(),2));
		if(result<=r)
			return true;
		else
			return false;
	}
}
