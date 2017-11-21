/**
 * 
 */
package ex0;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yaron samuel
 *
 */
public class pointstest {

	wifiPoint p;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.p=new wifiPoint("ab","cd",1,2);
	}

	@Test
	public void test() {
		assertTrue("SSID Not match",p.getSSID().equals("ab"));
	}
	
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
	

	
	

}
