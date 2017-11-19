/**
 * @author yaron samuel
 */
package ex0;
/**
 * 
 * @author yaron samuel
 *
 */
public class raw {
	

		private String id = null;
		String date;
		String time;
		double lat;
		double lon;
		double alt;
		String SSID;
		String MAC;
		int Signal;
		int Channel, GSM;
	
		//constructor
		raw(String id) {
			this.id= id;
		}
		raw(String id, String date, String time, double lat, double lon, double alt, String ssid, String mac,
				int signal, int channel, int gsm) {
			this.id = id;
			this.date = date;
			this.time = time;
			this.lat = lat;
			this.lon = lon;
			this.alt = alt;
			SSID = ssid;
			MAC = mac;
			Signal = signal;
			Channel = channel;
			GSM = gsm;
		}
		
		//copy constructor
		private raw(raw r) {
			this.id = r.id;
			this.date = r.date;
			this.time = r.time;
			this.lat = r.lat;
			this.lon = r.lon;
			this.alt = r.alt;
			SSID = r.SSID;
			MAC = r.MAC;
			Signal = r.Signal;
			Channel = r.Channel;
			GSM = r.GSM;
		}
		
		
		
		@Override
		public String toString() {
			return "raw [id=" + id + ", date=" + date + ", time=" + time + ", lat=" + lat + ", lon=" + lon + ", alt="
					+ alt + ", SSID=" + SSID + ", MAC=" + MAC + ", Signal=" + Signal + ", Channel=" + Channel + ", GSM="
					+ GSM + "]";
		}

		



/*		public boolean equals(raw r) {
			if(r != null)
			this.id = r.id;
			this.date = r.date;
			this.time = r.time;
			this.lat = r.lat;
			this.lon = r.lon;
			this.alt = r.alt;
			SSID = r.SSID;
			MAC = r.MAC;
			Signal = r.Signal;
			Channel = r.Channel;
			GSM = r.GSM;
		}*/
	
		//getter and setters
		public String getId() {
			return id;
		}

		/**
		 * 
		 * @param id2
		 */
		public void setId(String id2) {
			this.id = id2;
			
		}

		/**
		 * 
		 * @return
		 * 
		 */
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getAlt() {
			return alt;
		}

		public void setAlt(double alt) {
			this.alt = alt;
		}

		public String getSSID() {
			return SSID;
		}

		public void setSSID(String sSID) {
			SSID = sSID;
		}

		public String getMAC() {
			return MAC;
		}

		public void setMAC(String mAC) {
			MAC = mAC;
		}

		public int getSignal() {
			return Signal;
		}

		public void setSignal(int signal) {
			Signal = signal;
		}

		public int getChannel() {
			return Channel;
		}

		public void setChannel(int channel) {
			Channel = channel;
		}

		public int getGSM() {
			return GSM;
		}

		public void setGSM(int gSM) {
			GSM = gSM;
		}

	
}
