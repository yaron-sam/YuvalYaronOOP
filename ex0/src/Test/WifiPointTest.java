/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ex0.wifiPoint;

/**
 * @author yaron samuel
 *
 */
public class WifiPointTest {

	wifiPoint p;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.p=new wifiPoint("ab","cd",1,2);
	}
	/**
	 * Test if the getter SSID is working properly
	 */
	@Test
	public void test() {
		assertTrue("SSID Not match",p.getSSID().equals("ab"));
	}
	/**
	 * Test if the getter MAC is working properly
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
		assertTrue("Channel Not Match",p.getChannel()==2);
	}
	

	
	

}
