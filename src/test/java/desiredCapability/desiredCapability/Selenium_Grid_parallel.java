package desiredCapability.desiredCapability;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Selenium_Grid_parallel 
{
	WebDriver driver1;
	Platform WIN10;
	String nodeURL;
	
	@Parameters({"machineName"})
	@BeforeMethod()
	public void setUp(String portNO) throws InterruptedException, NullPointerException, MalformedURLException
	{			
		if(portNO.equalsIgnoreCase("node1"))
		{
			nodeURL = "http://192.168.99.1:5568/wd/hub";
			System.out.println("Firefox Browser Test Environment created");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap);			
			driver1.manage().window().maximize();
			
			driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else 
		if(portNO.equalsIgnoreCase("node2"))
		{
			nodeURL = "http://192.168.99.1:5566/wd/hub";
			System.out.println("Chrome Browser Test Environment created");
			DesiredCapabilities cap1 = DesiredCapabilities.chrome();			
			cap1.setBrowserName("chrome");
			cap1.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap1);			
			driver1.manage().window().maximize();
		
			driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		if(portNO.equalsIgnoreCase("node3"))
		{
			nodeURL = "http://192.168.99.1:5569/wd/hub";
			System.out.println("Internet Browser Test Environment created");
			DesiredCapabilities cap2 = DesiredCapabilities.internetExplorer();
			cap2.setBrowserName("internet explorer");
			//cap2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap2.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap2);			
			driver1.manage().window().maximize();
			
		}
		else	
        System.err.println("Provide correct port no");
	}
	
	@Test
	public void test1()
	{
		driver1.get("https://google.com");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
			driver1.quit();
			System.out.println("Closing the Browser");
			System.out.println("**************************************************************");
	}
}