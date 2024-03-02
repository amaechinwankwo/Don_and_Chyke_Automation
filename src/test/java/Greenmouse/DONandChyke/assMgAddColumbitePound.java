package Greenmouse.DONandChyke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class assMgAddColumbitePound {
	
	WebDriver driver;

	@Test
	public void assMgAddColPound() {
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchUsers();
		invoke.loginAssMg();
		invoke.assAddColumbitePound();

	}


}
