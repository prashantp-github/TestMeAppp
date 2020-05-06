import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class address {
	
	WebDriver driver;
	
@BeforeTest
  public void beforeTest() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jitendra\\Documents\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}
	 
  @AfterTest
  public void afterTest() {
	  System.out.println("after the test");
	  driver.quit();
  }
  
  @Test
  public void aboutus_chn() throws InterruptedException {
	  
	  System.out.println("during the test");
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();  
      act.moveToElement(driver.findElement(By.partialLinkText("Our Offices"))).perform();  
      act.moveToElement(driver.findElement(By.partialLinkText("Chennai"))).click().perform();  
 
      Set<String> windows = driver.getWindowHandles();
      Object[] objects = windows.toArray();
      driver.switchTo().window((String)objects[1]);
      Assert.assertEquals(driver.getTitle(), "Contact Us");  
      driver.switchTo().frame(driver.findElement(By.name("main_page")));
      String address =driver.findElement(By.id("demo3")).getText();
      System.out.println(address);
      Assert.assertTrue(address.contains("Chennai"));
  }
 
}

