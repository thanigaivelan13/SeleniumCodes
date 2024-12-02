import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) throws InterruptedException {

		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thani\\Downloads\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Implicit Wait
		
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size()); // Finds the total number of iframe tags
		
//		driver.switchTo().frame(0); //Frame by index
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))); //Frame by find Element
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement destination = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, destination).build().perform();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
