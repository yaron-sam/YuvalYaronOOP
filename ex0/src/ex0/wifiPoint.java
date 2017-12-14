package ex0;


public class wifiPoint {
	private String SSID;
	private  String MAC;
	private  int Signal;
	private  int Channel;
	

	/**
	 * Contractor of wifiPoint 
	 * @param SsSID
	 * @param SAC
	 * @param Signal
	 * @param Channel
	 */
	public wifiPoint(String SSID, String MAC, int Signal, int Channel) {
		this.SSID = SSID;
		this.MAC =MAC;
		this.Signal =Signal;
		this.Channel =Channel;
	}
	/**
	 * Print SSID, MAC, Signal and channel from wifiPoint
	 */
	@Override
	public String toString() {
		return "wifiPoint [SSID=" + SSID + ", MAC=" + MAC + ", Signal=" + Signal + ", Channel=" + Channel + "]";
	}
	/**
	 * Getter wifiPoint.ssid
	 * @return  ssid
	 */
	public String getSSID() {
		return SSID;
	}
	/**
	 * Getter wifiPoint.mac
	 * @return mac
	 */
	public String getMAC() {
		return MAC;
	}
	/**
	 * Getter wifiPoint.signal
	 * @return signal
	 */
	public int getSignal() {
		return Signal;
	}
	/**
	 * Getter wifiPoint.channel
	 * @return channel
	 */
	public int getChannel() {
		return Channel;
	}
	
	
}
