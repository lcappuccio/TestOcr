package org.systemexception.testocr.impl;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.systemexception.testocr.api.Icr;

import java.io.File;
import java.util.Arrays;

/**
 * @author lcappuccio
 * @date 17/06/15 17:46
 */
public class IcrImpl implements Icr {

	private final Tesseract tesseract = new Tesseract();

	public IcrImpl() {
		tesseract.setLanguage("eng");
		tesseract.setConfigs(Arrays.asList("config_numbers_only.cfg"));
		tesseract.setPageSegMode(6);
	}

	@Override
	public String recognize(String imagePath) throws TesseractException {
		File imageFile = new File(imagePath);
		String result = tesseract.doOCR(imageFile).replaceAll("[^0-9]", "").replaceFirst("^0+(?!$)", "");
		System.out.println("File: " + imagePath + ", result: " + result);
		return result;
	}
}
