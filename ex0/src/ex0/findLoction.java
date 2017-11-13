/**
 * @author yaron samuel
 */

package ex0;

public class findLoction implements Condition<wifiList> {

	double lat,lon;
	
	
	public findLoction(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}


	
	
	@Override
	public String toString() {
		return "findLoction [lat=" + lat + ", lon=" + lon + "]";
	}



	@Override
	public boolean test(wifiList s) {
		// TODO Auto-generated method stub
		if(s.lat == lat && s.lon == lon)
			return true;
		else
			return false;
	}

}
