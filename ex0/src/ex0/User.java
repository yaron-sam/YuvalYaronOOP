package ex0;

import java.util.ArrayList;
import java.util.List;

public class User implements PointType {
	
	private ArrayList<String> list;
	

	public User(ArrayList<String> list) {
		this.list = list;
	}


	@Override
	public <T> List<T> find(List<wifiList> item) {
		// TODO Auto-generated method stub
		
		
		System.out.println("user class");
		System.out.println(this.list.toString());

		return null;
	}

}
