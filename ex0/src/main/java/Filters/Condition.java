
package Filters;

import wifiData.wifiList;

/**
 * Function that gets an abstract variable
 * @author Yuval_Gabso
 *
 * @param <T>
 *
 */
public interface Condition<T> {
	boolean test(wifiList item );

	}
