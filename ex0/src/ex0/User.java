package ex0;

import java.util.ArrayList;
import java.util.List;

public class User implements PointType {
	
	private ArrayList<String> list; //input
	//list is like: [String mac1,int signal1, mac2
	
	//we want use map data structe to input list
	
	public User(ArrayList<String> list) {
		this.list = list;
	}


	@Override
	public <T> List<T> find(List<wifiList> item) {
		// TODO Auto-generated method stub
		
		//filter item to contain row with all mac's (at lost 2)
		//delete all wifipoint that not equal to on of them 
		
		//calc weigth 
		
		//calc user loction
		
		
		System.out.println("user class");
		System.out.println(this.list.toString());

		return (List<T>) list;
	}

}
