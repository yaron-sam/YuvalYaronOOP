/**
 * 
 */
package Tset;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Filters.Condition;
import wifiData.wifiList;
import wifiData.wifiPoint;

/**
 * @author Yuval_Gabso
 *
 */
class MacTest {
 wifiList s;
@BeforeEach
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		wifiList s = new wifiList("Yaron", "Yuval", "Ariel", 1,2,3);
	}

	/**
	 * @throws java.lang.Exception
	 */
@Test
	public <T> List<T> findTest(List<wifiList> item) {
		
		Condition<wifiList> conditionc = a ->{boolean flag =false;

		for (wifiPoint p:a.getPoints()) {
			if(p.getMAC().equals(item))
				flag =true; 	
		}
		return flag;
};
		int[] arr = {1,44534,353454,4543};
		for (int i : arr) {
			
		}
		return null;
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
