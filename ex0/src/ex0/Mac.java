package ex0;
/**
 * @author yaron samuel
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import ex0.wifiList;
import ex0.wifiPoint;
import ex0.wifiListContainer;
;

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
	public <T> List<Double> find(List<wifiList> item) {
		// TODO Auto-generated method stub

		
//		Condition<wifiList> conditiona = s ->{
//			boolean flag =false;
//			s.points.forEach(MAC -> {if(MAC.equals(this.mac))
//			flag =true;
//			}); 	
//		};					
		
		Condition<wifiList> conditionc = s -> {
			boolean flag = false;
			for (wifiPoint p : s.points) {
				if (p.getMAC().equals(this.mac))
					flag = true;
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
	
		//filter to row in continer with our mac adress. 
		List<wifiList> filtered =  (List<wifiList>) wifiListContainer.filter(item, conditionc);
		
		/*for(wifiList l:filtered) {
			l.points.removeIf(s->!s.MAC.equals(mac) );
		}*/
		

		filtered.forEach((list) -> list.points.removeIf(s->!s.getMAC().equals(mac) ));
		
		Collections.sort(filtered, ( o1,  o2) -> { 
			if (o1 == null && o2 == null) {
	                return 0;
	            }
	            if (o1 == null) {
	                return 1;
	            }
	            if (o2 == null) {
	                return -1;
	            }
			return o2.points.get(0).getSignal()-o1.points.get(0).getSignal();
		});
		
		double aloc[] = new double[3];
		double w[] = new double[4];
		double totalW=0.0;
		
		//calc weight
		for (int i = 0; i < w.length && i<filtered.size(); i++) {
			w[i]=1/Math.pow((double) filtered.get(i).points.get(0).getSignal(),2);
			totalW+=w[i];
		}
		//calc average of loction
		for (int i = 0; i < w.length && i<filtered.size(); i++) {
			aloc[0] += w[i]*filtered.get(i).getLat();
			aloc[1] += w[i]*filtered.get(i).getLon();
			aloc[2] += w[i]*filtered.get(i).getAlt();
		}
		for (int i = 0; i < aloc.length; i++) {
			aloc[i]=aloc[i]/totalW;
		}
//		ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(aloc));
//		arrayList  = Arrays.asList(aloc);
//
//		List<Double> list =  Arrays.asList(aloc);
//		List<Double> list = new ArrayList<Double>();
	
		return (List<Double>) DoubleStream.of(aloc).boxed().collect(Collectors.toList());

//		return (List<T>) Arrays.asList(aloc);
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
