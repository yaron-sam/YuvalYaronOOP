
package ex0;

public class raw {
	/**
	 * important note: 
	 * we understand that this class is unnecessary, but other hand for now we decide to 
	 * keep it because we don't have enough time to change all the code
	 */

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

		

	
		public String getId() {
			return id;
		}



		/**
		 * 
		 * @return
		 * 
		 */
		public String getDate() {
			return date;
		}



		public String getTime() {
			return time;
		}



		public double getLat() {
			return lat;
		}



		public double getLon() {
			return lon;
		}



		public double getAlt() {
			return alt;
		}


		public String getSSID() {
			return SSID;
		}



		public String getMAC() {
			return MAC;
		}



		public int getSignal() {
			return Signal;
		}



		public int getChannel() {
			return Channel;
		}


		public int getGSM() {
			return GSM;
		}

}
