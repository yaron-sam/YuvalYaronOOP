package ex0;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class kml {
	/**
	 * fix format of time to be hh:mm:ss
	 * 
	 * base on https://www.tutorialspoint.com/java/java_date_time.htm
	 * @param time string of time (can be hh:mm or hh:mm:ss) 
	 * @return fix format of time
	 * 
	 */
	public static String timeFormatFix(String time) {
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm");
		if (time.length() == 5) {
//			System.out.print(time + " Parses as ");
			Date t = new Date();
			try {
				t = ft.parse(time);
//				System.out.println(t);
			} catch (ParseException e) {
//				System.out.println("Unparseable using " + ft);
			}
			SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
//			System.out.println("Current Date: " + simple.format(t));
			return simple.format(t);
		} else
			return time;
	}
	
	/**
	 * fix format of time stamp to be "yyyy-MM-dd'T'HH:mm:ss'Z'"
	 * 
	 * base on https://www.tutorialspoint.com/java/java_date_time.htm
	 * @param date time stamp look like dd/MM/yyyy HH:mm:ss
	 * @return fix format of time stamp
	 * 
	 */
	public static String timeStampFormatFix(String date) {
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date t = new Date();
			try {
				t = ft.parse(date);
			} catch (ParseException e) {
			}
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			return simple.format(t);
	}
	
	/**
	 * create kml file from wifiList network.
	 * base on:https://labs.micromata.de/projects/jak/kml-in-the-java-world.html
	 * 		https://github.com/micromata/javaapiforkml/blob/master/src/test/java/de/micromata/jak/examples/Example4.java
	 * 		http://www.massapi.com/source/github/13/21/1321963036/src/kml/src/main/java/org/geoserver/kml/decorator/PlacemarkTimeDecoratorFactory.java.html#133
	 * 		https://developers.google.com/kml/documentation/kmlreference?csw=1#timestamp
	 * https://github.com/micromata/javaapiforkml/blob/master/src/main/java/de/micromata/opengis/kml/v_2_2_0/TimeStamp.java
	 * @param filename name of file name
	 */
	public static void CreateKmlfile(String filename,List<wifiList> container) {

		try {
			System.out.println("working..");

			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument().withName("Wifi Networks");

			for (wifiList l : container) {

				Double longitude = l.getLon();
				Double latitude = l.getLat();
				String date = new String(l.getDate() + " " + timeFormatFix(l.getTime()));
				date = timeStampFormatFix(date);

				String description = "id: <b>" + l.getId() + "</b><br/>date: <b>" + l.getDate() + " " + l.getTime() + "</b>"
						+ "<br/>MAC: " + "<b>" + l.points.get(0).getMAC() + "</b>" + "<br/>Channel: " + "<b>"
						+ l.points.get(0).getChannel() + "</b>" + "<br/>signal: " + "<b>" + l.points.get(0).getSignal() + "</b>";

				Placemark place = document.createAndAddPlacemark().withName(l.points.get(0).getSSID());
				place.createAndSetTimeStamp().withWhen(date);
				place.createAndSetPoint().addToCoordinates(longitude, latitude);
				place.setDescription(description);
			}
			
			
			kml.marshal(new File(filename));
			System.out.println("done!");

		} catch (IOException ex) {
			System.out.print("Error with processing file\n" + ex);
			System.exit(2);
		}
		System.out.println("create kml file: " + filename);

	}
}
