package Filters;

import wifiData.wifiList;

public class Or<T> implements Condition<wifiList>{
	private Condition<T> c1, c2;

	public Or(Condition<T> c1, Condition<T> c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	public boolean test(wifiList rec) {
		return c1.test(rec) || c2.test(rec);
	}

	public String toString() {
		return "("+c1+" or "+c2+")";
	}
}