package Filters;

import wifiData.wifiList;

/**
 * KALLLL
 * @author Boaz
 *
 */
public class Not<T> implements Condition<wifiList>{
	private static final long serialVersionUID = 1L;

	private Condition<T> filter;

	public Not(Condition<T> f) {
		filter = f;
	}
	public boolean test(wifiList rec) {
		return !(filter.test(rec));
	}

	public String toString() {
		return "NOT("+filter+")";
	}
}
