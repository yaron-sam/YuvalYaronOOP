package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import Filters.Condition;
import wifiData.wifiList;
import wifiData.wifiListContainer;
import wifiData.wifiPoint;


public class User implements PointType {
	 static final int Nrow =3;
	 static final int power=2;
	 final static int norm=10000;
	 final static double sig_diff=0.4;
	 final static int min_diff=3;
	 final static int no_signal=-120;
	 final static int diff_no_sig=100;

	//list is like: [String mac1,int signal1, mac2,signal 2, mac 3 signal3]
	private Map<String,Integer> input; //input
		
/**
 * constructor to User class	
 * @param input map of mac's and thier signal
 */
	public User(Map<String, Integer> input) {
		this.input = input;

	}



	@Override
	public <T> List<Double> find(List<wifiList> item) {
		
		/*filter item to contain row with all mac's (at lost 2).
		 * we dont get estimated loction base on one mac. 
		 */
		Condition<wifiList> condition = s -> {
			int c = 0;
			for (wifiPoint p : s.getPoints()) {
				if (input.containsKey(p.getMAC()))
					c++;
			}

			if (c>=2)
				return true;
			else
				return false;
		};
		
		List<wifiList> filtered = (List<wifiList>) wifiListContainer.filter(item, condition);


		//delete all wifipoint that not equal to on of them 
		filtered.forEach((list) -> list.getPoints().removeIf(s->!input.keySet().contains(s.getMAC())));
		
		//complate missing macs 

		for (wifiList list : filtered) {

			List<String> filteredMac = list.getPoints().stream()
										.map(p -> p.getMAC())
										.collect(Collectors.toList());

			List<String> inputMac = new ArrayList<String>(input.keySet());

			inputMac.removeAll(filteredMac);
			while (!inputMac.isEmpty()) {
				list.getPoints().add(new wifiPoint("untrue point", inputMac.get(0), no_signal, 0));
				inputMac.remove(0);
			}
		}
		//sort each wifilist to be in alpha beta order.
		filtered.forEach((list) -> list.getPoints().sort((a,b)->a.getMAC().compareTo(b.getMAC())));
		
/*		{//TODO for debugging only
			int i = 0;
			for (wifiList w : filtered) {
				System.out.println(i++ + ": " + w.getTime() + " " + weightCalc(w));
			}
		}*/
		
		//return loction 0 0 0 if we don't find any good sample
		if(filtered.isEmpty()) {
			System.out.println("missing data for"  + input);
			return (List<Double>) Arrays.asList(0.0,0.0,0.0);
		}		
		
		//calc similar weigth 

		List<wifiList> similar = Maxsimiilar(filtered,Nrow);
		
/*		{//TODO for debugging only
			System.out.println(similar);
			int i = 0;
			for (wifiList w : similar)
				System.out.println(i++ + ": " + w.getTime() + " " + weightCalc(w));
		}*/
				
		//calc average of loction
		double aloc[] = new double[3];
		double totalW=0.0;
		

				for (int i = 0; i < similar.size(); i++) {
					aloc[0] += weightCalc(similar.get(i))*similar.get(i).getLat();
					aloc[1] += weightCalc(similar.get(i))*similar.get(i).getLon();
					aloc[2] += weightCalc(similar.get(i))*similar.get(i).getAlt();
//					System.out.println(aloc[0]+" " +aloc[1]+" " +aloc[2] );
				}
		for (wifiList w : similar) {
			totalW+=weightCalc(w);
		}
		for (int i = 0; i < aloc.length; i++) {
			aloc[i]=aloc[i]/totalW;
		}		
		
		
		return (List<Double>) DoubleStream.of(aloc).boxed().collect(Collectors.toList());

	}
	/**
	 * calculate weight to wifilist
	 * @param l wifilist
	 * @return weight to wifilist
	 */
	private double weightCalc(wifiList l) {
		int[] dif = new int[input.size()];
		double[] w = new double[input.size()];
		int i=0;
		for (wifiPoint p : l.getPoints()) {
			if(p.getSignal() ==no_signal)
				dif[i++]  = diff_no_sig;	
			else
				dif[i++]  = Math.max(Math.abs(p.getSignal() - input.get(p.getMAC())), min_diff);
		}
		double pi =1;
		for ( i = 0; i < w.length; i++) {
			w[i] = norm/(Math.pow(dif[i], sig_diff)*Math.pow(input.get(l.getPoints().get(i).getMAC()),power));
			pi=pi*w[i];
		}
	
		return pi;
		
	}
	/**
	 * Generate list with max simlarity value
	 * @param list list of wifilist
	 * @param n number of sample we want to have in return list
	 * @return list with max simlarity value
	 */
	private List<wifiList> Maxsimiilar(List<wifiList> list ,int n){
		List<wifiList> max =new ArrayList<wifiList>(n);
		Comparator<wifiList> c = (a,b)-> (int)Math.signum((weightCalc(b)-weightCalc(a)));
		wifiList temp;
		for (int i = 0; i < n; i++) {
			max.add(list.get(i));
		}
		max.sort(c);
		
		for (int i = n; i < list.size(); i++) {
			temp  = list.get(i);
			if(weightCalc(temp) > weightCalc(max.get(n-1))) {
				max.set(n-1, temp);
			}
			max.sort(c);
		}
		
		return max;
		
	}

}
