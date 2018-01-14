package Filters;

import wifiData.wifiList;

public class Time implements Condition<wifiList>{
	private String start, end;
public Time(String start, String end) {
			this.start = start;
			this.end = end;
	}

	
	public boolean test(wifiList rec) {
		boolean ans = false;
		if(rec!=null) {
			String t = rec.getDate()+rec.getTime();
			int ts = start.compareTo(t);
			int te = end.compareTo(t);

			if(ts<=0 && te>0) {ans = true;}
		}
		return ans;
	}

	public String toString() {
		return ""+this.getClass().getName()+" ["+this.start+","+end+"]";
	}


}
		
	
