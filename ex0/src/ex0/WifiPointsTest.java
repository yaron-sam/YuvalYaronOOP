/**
 * 
 */
package ex0;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yuval_Gabso
 *
 */
class WifiPointsTest {
//????????????????????????????????this shit doesnt work, if you have any solution?
	@Before
	public void init() {
		wifiPoint p=new wifiPoint("ab","cd",1,2);
	}
	/**
	 * @throws java.lang.Exception
	 */
	/**
	 * Test if the getter SSID is working properly
	 */
	@Test
	public void testGetSSID()
	{
		wifiPoint p=new wifiPoint("ab","cd",1,2);
		assertTrue("SSID Not match",p.getSSID().equals("ab"));
	}
	/**
	 * Test if the getter Mac is working properly
	 */
	@Test
	public void testGetMac()
	{
		wifiPoint p=new wifiPoint("ab","cd",1,2);
		assertTrue("MAC Not Match",p.getMAC().equals("cd"));
	}
	/**
	 * Test if the getter Signal is working properly
	 */
	@Test
	public void testGetSignal()
	{
		wifiPoint p=new wifiPoint("ab","cd",1,2);
		assertTrue("Signal Not Match",p.getSignal()==1);
	}
	/**
	 * Test if the getter Channel is working properly
	 */
	@Test
	public void testGetChannel()
	{
		wifiPoint p=new wifiPoint("ab","cd",1,2);
		assertTrue("Channel Not Match",p.getSignal()==2);
	}

}
