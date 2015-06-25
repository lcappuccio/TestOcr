package org.systemexception.testocr.provider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author leo
 * @date 24/06/15 14:23
 */
public class ImageProvider {

	private Font fontMonospace, fontSans, fontSerif;
	private final FontRenderContext fontRenderContext;
	private BufferedImage image;
	private final String runningPath;

	public ImageProvider() {
		runningPath = System.getProperty("user.dir") + File.separator;
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY);
		try {
			fontMonospace = getFont("FreeMono.ttf");
			fontSans = getFont("FreeSans.ttf");
			fontSerif = getFont("FreeSerif.ttf");
		} catch (FontFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
		fontRenderContext = image.getGraphics().getFontMetrics().getFontRenderContext();
	}

	/**
	 * Draws the string to the graphics object and invoke a file save
	 *
	 * @param text the text to be drawn, will be the filename
	 */
	public void drawStringAndSaveFile(String text) {
		Font fontSelected = getRandomFont();
		Rectangle2D rectangle = fontSelected.getStringBounds(text, fontRenderContext);
		int imageWidth = (int) (rectangle.getWidth() + rectangle.getWidth() * 0.1);
		int imageHeight = (int) (rectangle.getHeight() + rectangle.getHeight() * 0.1);
		image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_BYTE_GRAY);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.BLACK);
		graphics.setFont(fontSelected);
		graphics.drawString(text, 0, (int) (imageHeight * 0.9));
		// release resources
		graphics.dispose();
		saveFile(text);
	}

	/**
	 * Returns a randomized font type
	 * @return the randomized font
	 */
	private Font getRandomFont() {
		Random rnd = new Random();
		randomizeFontSize();
		int randomFontSelector = rnd.nextInt(3);
		if (randomFontSelector == 0) {
			return fontMonospace;
		}
		if (randomFontSelector == 1) {
			return fontSans;
		}
		return fontSerif;
	}

	/**
	 * Changes the font to a new randomized size
	 */
	private void randomizeFontSize() {
		Random random = new Random();
		int minFontSize = 10;
		int fontSize = random.nextInt(256) + minFontSize;
		fontMonospace =  fontMonospace.deriveFont((float) fontSize);
		fontSans = fontSans.deriveFont((float) fontSize);
		fontSerif = fontSans.deriveFont((float) fontSize);
	}

	/**
	 * Saves the file to disk
	 *
	 * @param fileName the filename, in this case the string drawn will be the filename
	 */
	private void saveFile(final String fileName) {
		String finalFileName = fileName + ".png";
		try {
			ImageIO.write(image, "png", new File(finalFileName));
			System.out.println("Saving file " + runningPath + finalFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Returns a font object given a TrueTypeFont file name
	 *
	 * @param fontFileName the font file name
	 * @return the specified font
	 * @throws IOException
	 * @throws FontFormatException
	 */
	private Font getFont(String fontFileName) throws IOException, FontFormatException {
		String fontPath = ImageProvider.class.getClassLoader().getResource(fontFileName).getPath();
		return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
	}
}
