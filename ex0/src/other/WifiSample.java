/**
 * 
 */
package other;

/**
 * @author Yuval_Gabso
 *
 */

public class WifiSample {
	private double Mac1,Mac2,Mac3;
	
	public WifiSample(double Mac1, double Mac2, double Mac3) {
		this.Mac1 =Mac1;
		this.Mac2 = Mac2;
		this.Mac3 = Mac3;
	}
	
	@Override public String toString() {
		return "("+Mac1+","+Mac2+","+Mac3+")";
	}

	double getMac2() { return Mac2; }
}
