/**
 * 
 */
package Tset;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import wifiData.wifiList;
import wifiData.wifiPoint;

/**
 * @author Yuval_Gabso
 * 
 */
class wifiListContainerTest {
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	void setUp() throws Exception {
	}
	@Test
	public void testFindGroupId()
	{
		ArrayList<wifiPoint> p = new ArrayList<wifiPoint>();
		p.add(new wifiPoint("ab", "cd", 1, 2));
		wifiList l = new wifiList("NRD90M.1928188_904.2811", "27/10/2017", "16:16:45", 32.16766122, 34.80988156,
				39.01806582, p);
		wifiList l2 = new wifiList("anotherID", "27/10/2017", "16:20:45", 32.123, 34.1234, 39.555, p);
		wifiList l3 = new wifiList("anotherID2", "29/10/2017", "16:10:45", 32.123, 34.541, 39.555, p);

		ArrayList<wifiList> list = new ArrayList<wifiList>();
		list.add(l);
		list.add(l2);
		list.add(l3);
		assertTrue("SSID Not match", list.get(2).getId().equals("anotherID"));
		//TODO we need to complete the tester
	}


}
