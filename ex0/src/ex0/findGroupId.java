
package ex0;

import java.util.Collection;

/**
 * @author yaron samuel
 *
 */
public class findGroupId implements Condition<wifiList> {

	private Collection<String> list;

	public findGroupId(Collection<String> list) {
		this.list = list;
	}

	
	
	
	@Override
	public String toString() {
		return "find Group Users [list=" + list + "]";
	}



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
