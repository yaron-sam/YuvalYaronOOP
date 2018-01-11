package Filters;

import ex0.wifiList;

/**
 * KALLLL
 * @author Boaz
 *
 */
public class Not<T> implements Condition<wifiList>{
	private Condition<T> filter;

	public Not(Condition<T> f) {
		filter = f;
	}
	public boolean test(wifiList rec) {
		return !(filter.test(rec));
	}

	public String toString() {
		return "not("+filter+")";
	}
}
