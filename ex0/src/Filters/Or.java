package Filters;

import ex0.wifiList;

public class Or<T> implements Condition<wifiList>{
	private Condition<T> c1, c2;

	public Or(Condition<T> c1, Condition<T> c2) {
		c1 = c1;
		c2 = c2;
	}

	public boolean test(wifiList rec) {
		return c1.test(rec) || c2.test(rec);
	}

	public String toString() {
		return "("+c1+" or "+c2+")";
	}
}