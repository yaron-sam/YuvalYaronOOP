package ex0;

import java.util.Collection;
import java.util.List;

public class Mac implements PointType {
	
	private String mac;
	
/**
 * Constructor
 * @param mac
 */
	public Mac(String mac) {
		this.mac = mac;
	}
/**
 * gets List<wifiList>item
 * return filtered list
 */

	@Override
	public <T> List<T> find(List<wifiList> item) {
		// TODO Auto-generated method stub
		//String mac = (String) this.mac;
//		wifiList s = new wifiList(mac, mac, mac, 0, 0, 0);
//		s.points.forEach((points)->System.out.println(points.MAC));
		
//		Condition<wifiList> conditiona = s ->{
//			boolean flag =false;
//			s.points.forEach(MAC -> {if(MAC.equals(this.mac))
//			flag =true;
//			}); 	
//		};					
		
	Condition<wifiList> conditionb = s ->{
		boolean flag =false;
		for (wifiPoint p:s.points) {
								if(p.MAC.equals(this.mac))
									flag =true; 	
							}
							return flag;
	};
		
		
		Condition<wifiList> conditionc = s ->{boolean flag =false;
							for (wifiPoint p:s.points) {
								if(p.MAC.equals(this.mac))
									flag =true; 	
							}
							return flag;
	};
		
		
/*		Condition<wifiList> conditiond = new Condition<wifiList>() {
			public boolean test(wifiList s) {
				boolean flag =false;
				for (wifiPoint p:s.points) {
					if(p.MAC.equals(this.mac))
						flag =true; 	
				}
				return flag;
			}
		};*/
		
		List<wifiList> filtered = (List<wifiList>) wifiListContainer.filter(item, conditionc);
		
		//להשאיר רק את המאקים הרלוונטים - למחוק את כל השאר
		//להפעיל את הנוסחא שלנו על מה שיש
		
		System.out.println(mac);
		System.out.println(this.mac);

		//filter to row in continer with our mac adress. 
//		Condition<wifiList> condition = s -> s.equals(this.mac);
//		List<wifiList> filtered = (List<wifiList>) wifiListContainer.filter(item, condition);
		
		//sort filtered
		
		
		//calc mass
		double w1,w2,w3;
		for (int i = 0; i < 3; i++) {
			
		}
		
		return (List<T>) filtered;
	}
	
	  String getMac()
	{
		return this.mac;
	}
/*	public static void main(String[] args) {
		String fileSName="testwifilist.csv";

		// take csv file that we just creat and convert him to new wifi list.
		
		wifiListContainer b = new wifiListContainer(); 

		b.getWifilistFile(fileSName);
		Mac m = new Mac("10");
		m.find(item)
	}*/

}
