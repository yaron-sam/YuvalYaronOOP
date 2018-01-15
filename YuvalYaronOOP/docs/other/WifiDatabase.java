/**
 * 
 */
package other;

/**
 * @author Yuval_Gabso
 *
 */

import java.util.*;
import java.util.stream.Collectors;

public class WifiDatabase {
	private List<WifiSample> samples = new ArrayList<>();
	
	public void addAll(WifiSample... samples) { 
		Collections.addAll(this.samples, samples); 
	}
	
	/**
	 * Returns the n rows with the highest y values. 
	 * Implemented using the collection methods.
	 */
	public List<WifiSample> nRowsWithHighestY() {
		samples.sort(
			Comparator.comparing(sample -> -sample.getMac2())
		);
		return samples.subList(0, 3);
	}
	
	/**
	 * Returns the k rows with the highest y values.
	 * Implemented using Streams.
	 */
	public List<WifiSample> kRowsWithHighestY(int k,List<WifiSample>input) {
		return samples
			.stream()
			.sorted(Comparator.comparing(sample -> similarity(sample,input)))
			.limit(k)
			.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		WifiDatabase db = new WifiDatabase();
		db.addAll(
			new WifiSample(1,2,3),	
			new WifiSample(4,5,6),	
			new WifiSample(3,1,2),	
			new WifiSample(6,4,5),	
			new WifiSample(2,3,1),	
			new WifiSample(5,6,4)	
		);
		System.out.println(db.nRowsWithHighestY(3));
		System.out.println(db.kRowsWithHighestY(3));
	}
	/*
	//new WifiSample(6,4,5),	
	new WifiSample(2,3,1),	
	//new WifiSample(5,6,4)
*/
}
