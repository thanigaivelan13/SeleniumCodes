import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAssignment {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropDown = driver.findElement(By.id("autocomplete"));
        dropDown.sendKeys("ind");
        Thread.sleep(1000);
        dropDown.sendKeys(Keys.DOWN);
        dropDown.sendKeys(Keys.DOWN);
        System.out.println(dropDown.getAttribute("value"));
    }
}
