package spiceJet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Search {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("it is disable");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
	    driver.findElement(By.id("divpaxinfo")).click();
	    WebElement Adult = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
	    Select adult = new Select(Adult);
	    adult.selectByValue("5");
	    WebElement Child = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
	    Select child = new Select(Child);
	    child.selectByValue("2");
	    WebElement Infant = driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
	    Select infant = new Select(Infant);
	    infant.selectByVisibleText("1");
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights'")).click();
	}

}
