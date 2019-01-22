package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import utility.data.StaticData;

public class TestRunner {
	
	public static void main(String[] args) throws Exception {
		TestNG runner=new TestNG();
		List<String> list = new ArrayList<String>();
		
		list.add(StaticData.readProperty("xmlPath"));
		runner.setTestSuites(list);
		runner.run();
	}

}
