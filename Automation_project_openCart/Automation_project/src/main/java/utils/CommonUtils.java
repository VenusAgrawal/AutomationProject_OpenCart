package utils;

import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils {

	public static String emailGenerator() {
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

	}
	/*
	
	public static boolean compareTwoScreenshots(){
		
		BufferedImage actualBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc_actual.png"));
		BufferedImage expectedBTmg = ImageIO.read(new File(System.getProperty("user.dir")+ "\\Screenshots\\sc_expected.png"));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBTmg, actualBImg);
		
	}*/
	
	public static Properties loadProperties () {
		Properties prop = new Properties();
		try {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");
		prop.load(fr);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

