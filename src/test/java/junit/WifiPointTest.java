
package junit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wifiData.wifiPoint;
/**
 * 
 * @author Yuval_Gabso
 *
 */
public class WifiPointTest {

	wifiPoint p;
	/**
	 * Test if the getter SSID is working properly
	 */
	@BeforeEach
	void setUp() throws Exception {
		p=new wifiPoint("ab","cd",1,2);
	}
	@Test
	public void testGetSSID()
	{
		assertTrue("SSID Not match",p.getSSID().equals("ab"));
	}
	/**
	 * Test if the getter Mac is working properly
	 */
	@Test
	public void testGetMac()
	{
		assertTrue("MAC Not Match",p.getMAC().equals("cd"));
	}
	/**
	 * Test if the getter Signal is working properly
	 */
	@Test
	public void testGetSignal()
	{
		assertTrue("Signal Not Match",p.getSignal()==1);
	}
	/**
	 * Test if the getter Channel is working properly
	 */
	@Test
	public void testGetChannel()
	{
		assertTrue("Channel Not Match",p.getChannel()==2);
	}
}
