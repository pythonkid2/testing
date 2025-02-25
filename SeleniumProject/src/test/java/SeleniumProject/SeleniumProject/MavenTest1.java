package SeleniumProject.SeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test;

import junit.framework.TestCase;  

public class MavenTest1 extends TestCase{
	
	public String baseUrl = "https://www.google.com/";  
	String driverPath = "D:\\chrome\\chromedriver_win32\\chromedriver.exe";  
	
	public WebDriver driver ;   
	@Test             
	public void test() {      
		// set the system property for Chrome driver      
		System.setProperty("webdriver.chrome.driver", driverPath);  
		// Create driver object for CHROME browser  
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		driver.get(baseUrl);  
		
		// get the current URL of the page  
		String URL= driver.getCurrentUrl();  
		System.out.print(URL);  
		
		//get the title of the page  
		String title = driver.getTitle();                  
		System.out.println(title);  
		

        waitForMe(2000);
		// Find the search input element
        WebElement searchInput = driver.findElement(By.name("q"));

        waitForMe(1000);
        
        // Enter search text
        searchInput.sendKeys("vilas");

        waitForMe(1000);
        
        // Submit the search form
        searchInput.submit();

        waitForMe(5000);

        // Close the browser
        //driver.quit();
	}   
	
	public void waitForMe(int time) {
		// Wait for a few seconds to see the results
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	@BeforeTest  
	public void beforeTest() {    
		System.out.println("before test");  
	}     
	@AfterTest  
	public void afterTest() {  
		driver.quit();  
		System.out.println("after test");  
	}         	

}
