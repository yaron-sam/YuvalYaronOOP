package Filters;

import java.io.Serializable;

import wifiData.wifiList;

public class And<T> implements Condition<wifiList>, Serializable{
	private static final long serialVersionUID = 1L;

	private  Condition<T> c1, c2;

	public And(Condition<T> c1, Condition<T> c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public boolean test(wifiList rec) {
		return c1.test(rec) && c2.test(rec);
	}
	public String toString() {
		return "("+c1+" AND "+c2+")";
	}


}
