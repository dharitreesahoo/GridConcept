package desiredCapability.desiredCapability;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabDEmo {
   
   
    	public static final String USERNAME = "dharitree.sahoo";
    	  public static final String ACCESS_KEY = "07cb5e3a-946a-4201-9d89-d4ae17a1b5a5";
    	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    	  
    	  public static void main(String[] args) throws Exception {
    	  
    	    DesiredCapabilities caps = DesiredCapabilities.chrome();
    	    caps.setCapability("platform", "Windows 10");
    	    caps.setCapability("version", "latest");
    	    caps.setCapability("name", "Googletest");
    	  
    	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    	    driver.get("https://google.com");
    }


}
