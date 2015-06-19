package org.systemexception.testocr.api;

import net.sourceforge.tess4j.TesseractException;

/**
 * @author lcappuccio
 * @date 17/06/15 17:44
 */
public interface Icr {

	/**
	 * Recognizes elements in an image
	 *
	 * @param imagePath the absolute image path
	 * @return the readed value
	 * @throws TesseractException
	 */
	String recognize(String imagePath) throws TesseractException;
}
