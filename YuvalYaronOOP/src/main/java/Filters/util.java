package Filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import wifiData.wifiList;
/**
 * utiite to Filter package. use for import and export the Condition.
 * @author yaron samuel
 *
 */
public class util {

	@SuppressWarnings("unchecked")
	public static Condition<wifiList> importC(Path path) throws IOException, ClassNotFoundException {
		InputStream fis = Files.newInputStream(path);
		ObjectInputStream ois = new ObjectInputStream( fis);
		
		Condition<wifiList> c = (Condition<wifiList>) ois.readObject();
		return c;

	}

	public static void exportC(Condition<wifiList> c,Path path) throws IOException {

		OutputStream fos = Files.newOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(c);
	}
	

}
