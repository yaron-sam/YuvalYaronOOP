/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ex0.Condition;
import ex0.wifiList;
import ex0.wifiPoint;

/**
 * @author Yuval_Gabso
 *
 */
class MacTest {
 ArrayList<wifiList> s;
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
	public <T> List<T> findTest(List<wifiList> item) {
		Condition<wifiList> conditionc = s ->{boolean flag =false;
		for (wifiPoint p:s.points) {
			if(p.getMAC().equals(item))
				flag =true; 	
		}
		return flag;
};
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
