package org.systemexception.testocr.impl;

import org.junit.Test;
import org.systemexception.testocr.api.Icr;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lcappuccio
 * @date 17/06/15 17:49
 */
public class IcrImplTest {

	@Test
	public void testRecognize() throws Exception {
		IcrImpl sut = new IcrImpl();
		URL fileUrl = this.getClass().getResource("/crops");
		Path runningPath = Paths.get(fileUrl.toURI()).toAbsolutePath();
		File[] imageFiles = runningPath.toAbsolutePath().toFile().listFiles();
		for (int i = 0; i < imageFiles.length; i++) {
			System.out.println(imageFiles[i].getAbsolutePath() +"\t" + sut.recognize(imageFiles[i].getAbsolutePath()));
		}
	}
}