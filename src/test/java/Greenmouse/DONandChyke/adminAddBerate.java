package Greenmouse.DONandChyke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class adminAddBerate extends reusables {
	WebDriver driver;
	
	@Test
	public void addBerateList()
	{
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchAdmin();
		invoke.adminLogin();
		invoke.adminAddBerate();
		//invoke.deleteBerate();
	}

}
