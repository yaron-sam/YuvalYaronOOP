/**
 * 
 */
package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import wifiData.wifiList;
import wifiData.wifiPoint;

/**
 * @author yaron samuel
 *
 */
public class wifiListTest {

	List<wifiPoint> newp;
	wifiList l;
	wifiList lewp;
	@Before
	public void init() {
		ArrayList<wifiPoint> p = new ArrayList<wifiPoint>();
		p.add(new wifiPoint("ab", "1", 1, 2));
		p.add(new wifiPoint("ab", "2", 1, 2));
		p.add(new wifiPoint("ab", "3", 1, 2));
		p.add(new wifiPoint("ab", "4", 1, 2));
		 l = new wifiList("NRD90M.1928188_904.2811", "27/10/2017", "16:16:45", 32.16766122, 34.80988156,
				39.01806582, p);
		lewp =  new wifiList(l);
		System.out.println(l.equals(lewp));
		System.out.println(l==lewp);

		newp = l.getPoints();
		l.getPoints().remove(2);
		System.out.println(l.getPoints());
		System.out.println(newp);
		
	}
	@Test
	public void testPoint() {

		System.out.println(l.getPoints().get(0)+"vs "+newp.get(0)+" is: " +(l.getPoints().get(0)==newp.get(0)));
		System.out.println(l.getPoints().get(0)+"vs "+newp.get(0)+" is: " +l.getPoints().get(0).equals(newp.get(0)));
		assertTrue("copy[point] wifilist dont work well",(l.getPoints().get(0)==newp.get(0)));
	}

	@Test
	public void testList() {

//		System.out.println(l.getPoints().get(0)+"vs "+newp.get(0)+" is: " +(l.getPoints().get(0)==newp.get(0)));
//		System.out.println(l.getPoints().get(0)+"vs "+newp.get(0)+" is: " +l.getPoints().get(0).equals(newp.get(0)));
		assertTrue("copy[List] wifilist dont work well",!(l==lewp));
	}
}
