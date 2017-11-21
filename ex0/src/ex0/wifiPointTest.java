/**
 * 
 */
package ex0;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class wifiPointTest {
	static wifiPoint p;
	@BeforeClass
	public static void init() {
		this.p=new wifiPoint("ab","cd",1,2);
	}
	@Test
	public void TestGetSSID()
	{
		assertEquals("Not Match","ab" ,p.getSSID());
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
