package Greenmouse.DONandChyke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class assMgAddTinPound extends reusables {
	WebDriver driver;
	
	@Test
	public void AssMgAddTinPound() 
	{
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchUsers();
		invoke.loginAssMg();
		invoke.addTinPound();
		
	}

}
