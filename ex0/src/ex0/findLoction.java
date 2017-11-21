/**
 * @author yaron samuel
 * @author Yuval_Gabso
 */

package ex0;

public class findLoction implements Condition<wifiList> {

	double lat,lon;
	
	
	public findLoction(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}


	
	/**
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
		if(s.lat == lat && s.lon == lon)
			return true;
		else
			return false;
	}

}
