package utility.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StaticData {
	
	public static String xlspath=null;
	public static String fileName=null;
	public static String pom="POM";
	public static String suitData="SuitData";
	public static String data="Data";
	public static String envDetails="EnvDetails";
	public static String pageTitle="PageTitle";
	
	public static String readProperty(String key) throws IOException {
		String value = "";
		File f1 = new File(".\\test_data\\PropData.properties");
		FileInputStream f2 = new FileInputStream(f1);
		Properties p = new Properties();
		p.load(f2);
		value = p.getProperty(key);
		return value;
	}
}