package Greenmouse.DONandChyke;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reusables {
	WebDriver driver;
	ExtentReports extent;

	// initialize Chrome driver
	public WebDriver init() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		return driver;
	}

	// generate Extent report
	@BeforeTest
	public ExtentReports report() {

		// Note this two classes in building report : ExtentReports ,
		// ExtentSparkReporter

		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		// main class ExtentReports to drive all report execution

		// ExtentReports extent = new ExtentReports();

		// Declare the class variable global to be called/access in another method

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Daniel");

		return extent;
	}

	// Admin Launch
	public void launchAdmin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://donandchyke.com.ng/admin/login");
	}

	// Admin Login
	public void adminLogin() {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("admin@donandchyke.com.ng");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Password");
		driver.findElement(By.xpath("//label[text()='Remember Me']")).click();
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	// Admin Add Manager
	public void addManager() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Staff']")).click();
		driver.findElement(By.xpath("//a[text()='Add Staff']")).click();

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager']")).click();

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Manager Daniel");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("08076765654");
		driver.findElement(By.cssSelector("input[name='email']")).clear();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("greenmouseapp+mgDaniel@gmail.com");

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Male']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();
		Thread.sleep(3000);
	}

	// Admin Add Assistant Manager
	public void addAsstManager() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Staff']")).click();
		driver.findElement(By.xpath("//a[text()='Add Staff']")).click();

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Assistant Manager']")).click();

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Assitant Manager Daniel");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("08076765654");
		driver.findElement(By.cssSelector("input[name='email']")).clear();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("greenmouseapp+assmgDan@gmail.com");

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Male']")).click();

		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Dandytech@2022");
		driver.findElement(By.cssSelector("input[name='password_confirmation']")).sendKeys("Dandytech@2022");

		// driver.findElement(By.cssSelector("input[id='checkbox1']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();
		Thread.sleep(3000);

	}

	// Admin Add Accountant
	public void addAccountant() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Staff']")).click();
		driver.findElement(By.xpath("//a[text()='Add Staff']")).click();

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Accountant']")).click();

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Accountant Daniel");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("05076765624");
		driver.findElement(By.cssSelector("input[name='email']")).clear();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("greenmouseapp+acctDan@gmail.com");

		driver.findElement(By.xpath("(//button[@tabindex='-1'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Male']")).click();

		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Dandytech@2022");
		driver.findElement(By.cssSelector("input[name='password_confirmation']")).sendKeys("Dandytech@2022");

		// driver.findElement(By.cssSelector("input[id='checkbox1']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();
		Thread.sleep(3000);

	}

	// Admin Add Berate Price List
	public void adminAddBerate() {
		driver.findElement(By.xpath("//span[text()='Rates List']")).click();
		driver.findElement(By.xpath("//span[text()='Berating']")).click();
		driver.findElement(By.xpath("//a[text()='Add']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("18.8");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("330000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4710");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("18.9");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("329000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4700");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.0");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("327000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4670");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.1");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("325000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4640");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.2");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("323000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4610");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.3");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("321000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4585");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.4");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("318000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4540");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.5");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("314000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4485");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.6");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("310000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4425");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.7");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("283000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4040");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.8");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("281000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("4010");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("19.9");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("279000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3985");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.0");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("277000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3955");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.1");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("274000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3910");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.2");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("272000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3885");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.3");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("270000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3855");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.4");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("266000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3800");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='grade']")).sendKeys("20.5");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("264000");
		driver.findElement(By.cssSelector("input[name='unit_price']")).sendKeys("3770");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();

	}

	// Admin Delete Berate
	public void adminDeleteBerate() {
		driver.findElement(By.xpath("//span[text()='Rates List']")).click();
		driver.findElement(By.xpath("//span[text()='Berating']")).click();

		int k = 1;
		while (k <= 7) {
			driver.findElement(By.xpath("(//span[@data-toggle='modal'])[2]")).click();
			driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			k++;
		}

		System.out.println(k);

	}

	public void adminAddAnalysis() {
		driver.findElement(By.xpath("//span[text()='Rates List']")).click();
		driver.findElement(By.xpath("//span[text()='Analysis']")).click();
		driver.findElement(By.xpath("//a[text()='Add']")).click();

		driver.findElement(By.cssSelector("input[name='percentage_min']")).sendKeys("25");
		driver.findElement(By.cssSelector("input[name='percentage_max']")).sendKeys("40");
		driver.findElement(By.cssSelector("input[name='dollar']")).sendKeys("12.00");
		driver.findElement(By.cssSelector("input[name='exchange']")).sendKeys("650");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='percentage_min']")).sendKeys("41");
		driver.findElement(By.cssSelector("input[name='percentage_max']")).sendKeys("50");
		driver.findElement(By.cssSelector("input[name='dollar']")).sendKeys("12.50");
		driver.findElement(By.cssSelector("input[name='exchange']")).sendKeys("650");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='percentage_min']")).sendKeys("51");
		driver.findElement(By.cssSelector("input[name='percentage_max']")).sendKeys("100");
		driver.findElement(By.cssSelector("input[name='dollar']")).sendKeys("13.00");
		driver.findElement(By.cssSelector("input[name='exchange']")).sendKeys("650");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();

	}

	// Admin Delete Analysis
	public void adminDelAnalysis() {
		driver.findElement(By.xpath("//span[text()='Rates List']")).click();
		driver.findElement(By.xpath("//span[text()='Analysis']")).click();

		int k = 0;
		while (k < 3) {
			driver.findElement(By.xpath("(//span[@data-toggle='modal'])[2]")).click();
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			k++;
		}

	}

	// Assistant Manager launch App
	public void launchUsers() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://donandchyke.com.ng/");
	}

	// Assistant Manager Login
	public void loginAssMg() {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("greenmouseapp+assmgDan@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Dandytech@2022");
		driver.findElement(By.xpath("//label[text()='Remember Me']")).click();
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	// Assistant Manager Add Berate Pound
	public void addTinPound() {
		driver.findElement(By.xpath("//span[text()='Payment receipt']")).click();
		driver.findElement(By.xpath("//span[text()='Tin']")).click();

		driver.findElement(By.xpath("//a[text()='Add']")).click();
		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Bejamin Musa");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("73");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput.sendKeys(filePath);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Ola");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("278");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput2 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath2 = "/Users/user/Desktop/Icons/qualitative-research.png";
		fileInput2.sendKeys(filePath2);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Bejamin Musa");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("360");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput3 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath3 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput3.sendKeys(filePath3);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Grace");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("222");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/12/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput4 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath4 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput4.sendKeys(filePath4);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("John");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.9']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("35");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput5 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath5 = "/Users/user/Desktop/Icons/qualitative-research.png";
		fileInput5.sendKeys(filePath5);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Chris");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='18.9']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("72");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput6 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath6 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput6.sendKeys(filePath6);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Henry");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.0']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("444");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput7 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath7 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput7.sendKeys(filePath7);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Sunny");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.0']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("681");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput8 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath8 = "/Users/user/Desktop/Icons/qualitative-research.png";
		fileInput8.sendKeys(filePath8);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Mary");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.1']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("158");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput9 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath9 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput9.sendKeys(filePath9);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Success");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.1']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("125");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput10 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath10 = "/Users/user/Desktop/Icons/qualitative-research.png";
		fileInput10.sendKeys(filePath10);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Mark");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.2']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("421");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput11 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath11 = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput11.sendKeys(filePath11);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[1]")).sendKeys("Godwin");
		driver.findElement(By.xpath("//div[text()='-- Select Grade --']")).click();
		driver.findElement(By.xpath("//span[text()='19.2']")).click();
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='pounds']")).sendKeys("296");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[1]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[1]")).sendKeys("rep001");
		// Locate the file input element
		WebElement fileInput12 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[1]"));
		// Provide the file path to be uploaded
		String filePath12 = "/Users/user/Desktop/Icons/qualitative-research.png";
		fileInput12.sendKeys(filePath12);
		driver.findElement(By.xpath("(//button[@name='save'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();

	}

	// Assistant Manager add Tin in KG
	public void addTinKG() {
		driver.findElement(By.xpath("//span[text()='Payment receipt']")).click();
		driver.findElement(By.xpath("//span[text()='Tin']")).click();
		driver.findElement(By.xpath("//a[text()='KG']")).click();
		driver.findElement(By.xpath("//a[text()='Add']")).click();
		driver.findElement(By.xpath("//a[text()='TIN (KG)']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Daniel");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("50");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("70");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/08/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 2");
		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput.sendKeys(filePath);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("David");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='18.8']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("30");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("57");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("oiri5");
		// Locate the file input element
		WebElement fileInput2 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath2 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput2.sendKeys(filePath2);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Obum");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='18.9']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("45");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("320");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 3");
		// Locate the file input element
		WebElement fileInput3 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath3 = "//Users/user//Desktop//Icons//qualitative-research.png";
		fileInput3.sendKeys(filePath3);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("John");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.0']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("75");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("201");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 4");
		// Locate the file input element
		WebElement fileInput4 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath4 = "//Users/user//Desktop//Icons//qualitative-research.png";
		fileInput4.sendKeys(filePath4);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Grace");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.0']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("50");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("45");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 5");
		// Locate the file input element
		WebElement fileInput5 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath5 = "//Users//user//Desktop//Icons//qualitative-research.png";
		fileInput5.sendKeys(filePath5);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("John");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.1']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("30");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("50");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/08/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 6");
		// Locate the file input element
		WebElement fileInput6 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath6 = "//Users//user//Desktop//Icons//qualitative-research.png";
		fileInput6.sendKeys(filePath6);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Marthins");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.1']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("65");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("450");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 7");
		// Locate the file input element
		WebElement fileInput7 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath7 = "//Users//user//Desktop//Icons//qualitative-research.png";
		fileInput7.sendKeys(filePath7);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Paul");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.2']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("70");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("85");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/08/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 8");
		// Locate the file input element
		WebElement fileInput8 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath8 = "//Users//user//Desktop//Icons//qualitative-research.png";
		fileInput8.sendKeys(filePath8);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Mary");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.2']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("39");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("145");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 9");
		// Locate the file input element
		WebElement fileInput9 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath9 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput9.sendKeys(filePath9);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Dany");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.3']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("50");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("70");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 10");
		// Locate the file input element
		WebElement fileInput10 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath10 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput10.sendKeys(filePath10);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Paul");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.4']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("35");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("106");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/09/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 11");
		// Locate the file input element
		WebElement fileInput11 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath11 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput11.sendKeys(filePath11);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Ike");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.4']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("50");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("90");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/12/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 12");
		// Locate the file input element
		WebElement fileInput12 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath12 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput12.sendKeys(filePath12);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Oke");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.5']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("60");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("345");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/08/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 13");
		// Locate the file input element
		WebElement fileInput13 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath13 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput13.sendKeys(filePath13);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.xpath("(//input[@name='supplier'])[2]")).sendKeys("Sunny");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.4']")).click();
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("85");
		driver.findElement(By.xpath("(//input[@value='kg'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='kg']")).sendKeys("155");
		driver.findElement(By.xpath("(//div[text()='-- Select Manager --'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("(//input[@name='date_of_purchase'])[2]")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("(//input[@name='receipt_no'])[2]")).sendKeys("ReceptNo 14");
		// Locate the file input element
		WebElement fileInput14 = driver.findElement(By.xpath("(//input[@name='receipt_image'])[2]"));
		// Provide the file path to be uploaded
		String filePath14 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput14.sendKeys(filePath14);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();

	}

	public void assAddColumbitePound() {
		driver.findElement(By.xpath("//span[text()='Payment receipt']")).click();
		driver.findElement(By.xpath("//span[text()='Columbite']")).click();
		driver.findElement(By.xpath("//a[text()='Add']")).click();

		driver.findElement(By.cssSelector("input[name='supplier']")).sendKeys("Daniel");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='19.5']")).click();
		driver.findElement(By.cssSelector("input[name='percentage']")).sendKeys("30");
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='pounds'])[1]")).sendKeys("45");
		driver.findElement(By.xpath("//div[text()='-- Select Manager --']")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("//input[@name='date_of_purchase']")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("//input[@name='receipt_no']")).sendKeys("receipt 1");
		WebElement fileInput = driver.findElement(By.xpath("//input[@name='receipt_image']"));
		String filePath = "C:\\Users\\user\\Downloads\\Screenshot (7).png";
		fileInput.sendKeys(filePath);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='supplier']")).sendKeys("Peace");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='20.1']")).click();
		driver.findElement(By.cssSelector("input[name='percentage']")).sendKeys("50");
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='pounds'])[1]")).sendKeys("55");
		driver.findElement(By.xpath("//div[text()='-- Select Manager --']")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("//input[@name='date_of_purchase']")).sendKeys("06/10/2023");
		driver.findElement(By.xpath("//input[@name='receipt_no']")).sendKeys("receipt 2");
		WebElement fileInput2 = driver.findElement(By.xpath("//input[@name='receipt_image']"));
		String filePath2 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput2.sendKeys(filePath2);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='supplier']")).sendKeys("Obi");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='20.1']")).click();
		driver.findElement(By.cssSelector("input[name='percentage']")).sendKeys("45");
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='pounds'])[1]")).sendKeys("86");
		driver.findElement(By.xpath("//div[text()='-- Select Manager --']")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("//input[@name='date_of_purchase']")).sendKeys("06/11/2023");
		driver.findElement(By.xpath("//input[@name='receipt_no']")).sendKeys("receipt 3");
		WebElement fileInput3 = driver.findElement(By.xpath("//input[@name='receipt_image']"));
		String filePath3 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput3.sendKeys(filePath3);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='supplier']")).sendKeys("Sunny");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='20.2']")).click();
		driver.findElement(By.cssSelector("input[name='percentage']")).sendKeys("60");
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='pounds'])[1]")).sendKeys("51");
		driver.findElement(By.xpath("//div[text()='-- Select Manager --']")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("//input[@name='date_of_purchase']")).sendKeys("06/12/2023");
		driver.findElement(By.xpath("//input[@name='receipt_no']")).sendKeys("receipt 3");
		WebElement fileInput4 = driver.findElement(By.xpath("//input[@name='receipt_image']"));
		String filePath4 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput4.sendKeys(filePath4);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.findElement(By.cssSelector("input[name='supplier']")).sendKeys("Ada");
		driver.findElement(By.xpath("//div[text()='-- Select Berating --']")).click();
		driver.findElement(By.xpath("//span[text()='20.5']")).click();
		driver.findElement(By.cssSelector("input[name='percentage']")).sendKeys("70");
		driver.findElement(By.xpath("(//input[@value='pound'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='pounds'])[1]")).sendKeys("299");
		driver.findElement(By.xpath("//div[text()='-- Select Manager --']")).click();
		driver.findElement(By.xpath("//span[text()='Manager Daniel']")).click();
		driver.findElement(By.xpath("//input[@name='date_of_purchase']")).sendKeys("06/12/2023");
		driver.findElement(By.xpath("//input[@name='receipt_no']")).sendKeys("receipt 4");
		WebElement fileInput5 = driver.findElement(By.xpath("//input[@name='receipt_image']"));
		String filePath5 = "//Users//user//Desktop/Icons//qualitative-research.png";
		fileInput5.sendKeys(filePath5);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//a[text()='Back']")).click();

	}
	
	
	

	
}
