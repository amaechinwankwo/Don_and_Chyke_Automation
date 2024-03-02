package Greenmouse.DONandChyke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class adminAddAnalysis extends reusables {
	
WebDriver driver;
	
	@Test
	public void addAnalysisList()
	{
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchAdmin();
		invoke.adminLogin();
		invoke.adminAddAnalysis();
		
	}

}
