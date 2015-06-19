package org.systemexception.testocr.impl;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import org.systemexception.testocr.api.Icr;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lcappuccio
 * @date 17/06/15 17:49
 */
public class IcrImplTest {

	private final Icr sut = new IcrImpl();

	@Test
	public void matchWords() throws Exception {
		File[] imageFiles = getFiles("/crops/words");
		for (File imageFile : imageFiles) {
			System.out.println(imageFile.getAbsolutePath() + "\t" + sut.recognize(imageFile.getAbsolutePath()));
		}
	}

	@Test
	public void matchNumbers50Pct() throws URISyntaxException, TesseractException {
		File[] imageFiles = getFiles("/crops/numbers");
		int matches = 0;
		for (File imageFile : imageFiles) {
			String readedNumber = sut.recognize(imageFile.getAbsolutePath());
			String numberInFile = imageFile.getName().replace(".png", "");
			if (readedNumber.equals(numberInFile)) {
				matches++;
			}
		}
		assert (matches*100/imageFiles.length > 50);
	}

	private File[] getFiles(String path) throws URISyntaxException {
		URL fileUrl = this.getClass().getResource(path);
		Path runningPath = Paths.get(fileUrl.toURI()).toAbsolutePath();
		return runningPath.toAbsolutePath().toFile().listFiles();
	}
}