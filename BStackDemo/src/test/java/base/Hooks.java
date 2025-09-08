package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
	@Before
	public void setUp()
	{
		DriverFactory.openBrowser();
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		DriverFactory.closeBrowser();
	}
}
