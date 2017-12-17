package ex0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User implements PointType {
	
	//list is like: [String mac1,int signal1, mac2
	private Map<String,Integer> input; //input
		
	//we want use map data structe to input list
	
	public User(Map<String, Integer> input) {
		this.input = input;
	}

	@Override
	public <T> List<T> find(List<wifiList> item) {
		// TODO Auto-generated method stub
		
		//filter item to contain row with all mac's (at lost 2)
		Condition<wifiList> conditionc = s -> {
			boolean flag = false;
			for (wifiPoint p : s.points) {
//				if (p.getMAC().equals(this.mac))
					flag = true;
			}
			return flag;
		};
		
		
		//delete all wifipoint that not equal to on of them 
		
		//calc weigth 
		
		//calc user loction
		
		System.out.println("user class");
		System.out.println(this.input.toString());

		return (List<T>) input;
	}

}
