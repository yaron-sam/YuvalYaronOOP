
package Filters;

import java.io.Serializable;

import wifiData.wifiList;

/**
 * Function that gets an abstract variable
 *
 * @param <T>
 *
 */
public interface Condition<T> extends Serializable {
	static final long serialVersionUID = 1L;

	boolean test(wifiList item );

	}
