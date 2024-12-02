import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverScope {

	public static void main(String[] args) throws InterruptedException {
		
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thani\\Downloads\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());//Prints the total link count in the page
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));//Limit to particular element
		
		System.out.println(footer.findElements(By.tagName("a")).size());//Count of links from that particular element
		
		WebElement footerColumn1 = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(footerColumn1.findElements(By.tagName("a")).size());
		
		int sizeOfColumn = footerColumn1.findElements(By.tagName("a")).size();
		
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		for(int i=1;i<sizeOfColumn;i++) {
			
			footerColumn1.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
			Thread.sleep(3000);
		}
		
		Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            System.out.println(driver.switchTo().window(window).getTitle());

        }
		
	}

}
