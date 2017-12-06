package ex0;

import java.util.Collection;
import java.util.List;

public class Mac implements PointType {
	
	private String mac;
	

	public Mac(String mac) {
		this.mac = mac;
	}


	@Override
	public <T> List<T> find(List<wifiList> item) {
		// TODO Auto-generated method stub
		String mac = (String) this.mac;
		
		System.out.println(mac);
		System.out.println(this.mac);
		wifiListContainer c = new wifiListContainer( item);
//		c.filter(items, condition);

		//filter to row in continer with our mac adress. 
		Condition<wifiList> condition = s -> s.equals(this.mac);
//		List<wifiList> filtered = (List<wifiList>) wifiListContainer.filter(item, condition);
		
		//sort filtered
		
		
		//calc mass
		double w1,w2,w3;
		for (int i = 0; i < 3; i++) {
			
		}
		
		return null;
	}

}
