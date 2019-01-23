package testCases;

import org.testng.annotations.Test;
import actions.SG_GPS_Navigation;

public class TC05 extends SuitClass {
	
	@Test
	public void checkSGGPSNavigation() throws Exception {
		new SG_GPS_Navigation().SgGPSNavigatio(super.testExector);
	}
}