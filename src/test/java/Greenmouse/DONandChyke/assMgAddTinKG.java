package Greenmouse.DONandChyke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class assMgAddTinKG {
	WebDriver driver;

	@Test
	public void AssMgAddTinKg() {
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchUsers();
		invoke.loginAssMg();
		invoke.addTinKG();

	}

}
