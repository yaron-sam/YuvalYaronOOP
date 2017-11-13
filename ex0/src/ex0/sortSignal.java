/**
 * @author yaron samuel
 */
package ex0;

import java.util.Comparator;

public class sortSignal implements Comparator<wifiPoint>{


		public int compare(wifiPoint o1, wifiPoint o2) {
			//System.out.println("ID: " + o1 +"vs "+ o2); for debuging
 
			if (o1 == null && o2 == null) {
	                return 0;
	            }
	            if (o1 == null) {
	                return 1;
	            }
	            if (o2 == null) {
	                return -1;
	            }
			//System.out.println("ans =" +  (o1.getSignal()-o2.getSignal())); for debuging

			return o1.getSignal()-o2.getSignal();
		}

	}

