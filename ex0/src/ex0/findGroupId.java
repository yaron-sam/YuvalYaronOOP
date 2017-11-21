package ex0;


import java.util.Collection;

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
	 *@param s
	 *@return true if id equal to one of the id's in s.
	 */
	@Override
	public boolean test(wifiList s) {
		// TODO Auto-generated method stub
		for (String i : list) {
			if (i.equals(s.id))
				return true;
		}
		return false;
	}

}
