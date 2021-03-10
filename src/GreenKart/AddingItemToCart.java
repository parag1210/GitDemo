package GreenKart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItemToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//for implicit wait
		WebDriverWait w = new WebDriverWait(driver, 5);// for explicit wait
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		// addItems(driver,itemNeeded); //calling method without creating object at that
		// time define method as static
		AddingItemToCart a = new AddingItemToCart();// calling method by creating object
		a.addItems(driver, itemNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));// for explicit wait
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));// for explicit wait
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public void addItems(WebDriver driver, String[] itemNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();
			List itemNeededList = Arrays.asList(itemNeeded);
			if (itemNeededList.contains(formatedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == 3) {
					break;
				}
			}

		}

	}

}
