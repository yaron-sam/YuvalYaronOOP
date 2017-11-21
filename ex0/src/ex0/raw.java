
package ex0;

public class raw {
	/**
	 * important note: 
	 * we understand that this class is unnecessary, but other hand for now we decide to 
	 * keep it because we don't have enough time to change all the code
	 */

		private String id;
		String date;
		String time;
		double lat;
		double lon;
		double alt;
		String SSID;
		String MAC;
		int Signal;
		int Channel, GSM;

		
		/**
		 * Constructor raw
		 * @param id
		 * @param date
		 * @param time
		 * @param lat
		 * @param lon
		 * @param alt
		 * @param ssid
		 * @param mac
		 * @param signal
		 * @param channel
		 * @param gsm
		 */
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
		
		
		/**
		 * Print all the raw's variables
		 */
		@Override
		public String toString() {
			return "raw [id=" + id + ", date=" + date + ", time=" + time + ", lat=" + lat + ", lon=" + lon + ", alt="
					+ alt + ", SSID=" + SSID + ", MAC=" + MAC + ", Signal=" + Signal + ", Channel=" + Channel + ", GSM="
					+ GSM + "]";
		}

		

		/**
		 * Getter raw.id
		 * @return id
		 */
		public String getId() {
			return id;
		}

		/**
		 * Getter raw.date
		 * @return date
		 * 
		 */
		public String getDate() {
			return date;
		}
		/**
		 * Getter raw.time
		 * @return time
		 */
		public String getTime() {
			return time;
		}
		/**
		 * Getter raw.lat
		 * @return lat
		 */
		public double getLat() {
			return lat;
		}
		/**
		 * Getter raw.lon
		 * @return lon
		 */
		public double getLon() {
			return lon;
		}
		/**
		 * Getter raw.alt
		 * @return alt
		 */
		public double getAlt() {
			return alt;
		}
		/**
		 * Getter raw.ssid
		 * @return ssid
		 */
		public String getSSID() {
			return SSID;
		}
		/**
		 * Getter raw.mac
		 * @return mac
		 */
		public String getMAC() {
			return MAC;
		}
		/**
		 * Getter raw.signal
		 * @return signal
		 */
		public int getSignal() {
			return Signal;
		}
		/**
		 * Getter raw.channel
		 * @return channel
		 */
		public int getChannel() {
			return Channel;
		}
		/**
		 * Getter raw.gsm
		 * @return gsm
		 */
		public int getGSM() {
			return GSM;
		}

}
