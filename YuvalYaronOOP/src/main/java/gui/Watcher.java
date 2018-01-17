package gui;

import java.io.IOException;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;

import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;

import wifiData.rawFile;
import wifiData.wifiListContainer;

/**
 * 
 *
 */
public class Watcher implements Runnable {

	/**
	 * http://www.codejava.net/java-se/file-io/file-change-notification-example-with-watch-service-api
	 */
	@Override
	public void run() {
		try {

			WatchService watchService = mainWindows.directoryPath.getFileSystem().newWatchService();
			mainWindows.directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

			//Start infinite loop to watch changes on the directory
			while (true) {

				WatchKey watchKey = watchService.take();

				// poll for file system events on the WatchKey
				for (final WatchEvent<?> event : watchKey.pollEvents()) {
					
					takeActionOnChangeEvent(event);
				}

				//Break out of the loop if watch directory got deleted
				if (!watchKey.reset()) {
					watchKey.cancel();
					watchService.close();
					break;
				}
			}

		} catch (InterruptedException interruptedException) {
			System.out.println("Thread got interrupted:"+interruptedException);
			return;
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}

	}

	private void takeActionOnChangeEvent(WatchEvent<?> event) {


		System.out.println(event.kind().name());

		GUI_Wrapper.clearData();

		rawFile.getFiles(GUI_Wrapper.folder);
		mainWindows.textField.setText("Size of data: " + wifiListContainer.size());


	}
}

