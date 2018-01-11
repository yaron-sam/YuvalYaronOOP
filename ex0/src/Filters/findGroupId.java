package Filters;


import java.util.Collection;

import ex0.wifiList;
/**
 * 
 * 
 * findGroupId is implements Condition, creates new wifiList with the necessary data by filtering according to GroupId condition
 *
 */
public class findGroupId implements Condition<wifiList> {

	private Collection<String> list;

	public findGroupId(Collection<String> list) {
		this.list = list;
	}

	
	
	/**
	 * Print User's list
	 */
	@Override
	public String toString() {
		return "find Group Users [list=" + list + "]";
	}


	/**
	 * test if id equal to one of the id's list.
	 *@param s
	 *@return true if id equal to one of the id's in s.
	 */
	@Override
	public boolean test(wifiList s) {
		for (String i : list) {
			if (i.equals(s.getId()))
				return true;
		}
		return false;
	}

}
