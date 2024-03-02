package Greenmouse.DONandChyke;

import org.testng.annotations.Test;

public class adminDeleteAnalysis {

	@Test
	public void addBerateList()
	{
		reusables invoke = new reusables();
		invoke.init();
		invoke.launchAdmin();
		invoke.adminLogin();
		invoke.adminDelAnalysis();
		
	}


}
