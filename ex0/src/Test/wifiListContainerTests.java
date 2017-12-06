/**
 * 
 */
package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ex0.wifiList;
import ex0.wifiListContainer;
import ex0.wifiPoint;

/**
 * @author Yuval_Gabso
 *
 */
class wifiListContainerTests extends wifiListContainer {
	ArrayList<wifiList> list;
	@BeforeEach
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
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
	}
	/**
	 * Test method for {@link ex0.wifiListContainer#wifiListContainer()}.
	 */
/*	@Test
	void testWifiListContainer() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#wifiListContainer(java.util.List)}.
	 */
/*	@Test
	void testWifiListContainerListOfwifiList() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#getWifilistFile(java.lang.String)}.
	 */
/*	@Test
	void testGetWifilistFile() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#createWifilist(java.util.List)}.
	 */
/*	@Test
	void testCreateWifilist() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#createWifiListFile()}.
	 */
/*	@Test
	void testCreateWifiListFile() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#filterByIdrgroup(java.util.List)}.
	 */
	@Test
	void testFilterByIdrgroup() {
		
		assertTrue("SSID Not match", list.get(0).getId().equals("anotherID"));
	}

	/**
	 * Test method for {@link ex0.wifiListContainer#filterByLoc(double, double)}.
	 */
/*	@Test
	void testFilterByLoc() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#filterByDate(java.lang.String)}.
	 */
/*	@Test
	void testFilterByDate() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#filter(java.util.Collection, ex0.Condition)}.
	 */
/*	@Test
	void testFilter() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#timeFormatFix(java.lang.String)}.
	 */
/*	@Test
	void testTimeFormatFix() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#timeStampFormatFix(java.lang.String)}.
	 */
	/*@Test
	void testTimeStampFormatFix() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link ex0.wifiListContainer#CreateKmlfile(java.lang.String)}.
	 */
/*	@Test
	void testCreateKmlfile() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
/*	@Test
	void testObject() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#getClass()}.
	 */
/*	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	/*@Test
	void testHashCode() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
/*	@Test
	void testEquals() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#clone()}.
	 */
/*	@Test
	void testClone() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
/*	@Test
	void testToString() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#notify()}.
	 */
/*	@Test
	void testNotify() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#notifyAll()}.
	 */
/*	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#wait(long)}.
	 */
/*	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#wait(long, int)}.
	 */
/*	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#wait()}.
	 */
	/*
	@Test
	void testWait() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link java.lang.Object#finalize()}.
	 */
/*	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}
*/
}
