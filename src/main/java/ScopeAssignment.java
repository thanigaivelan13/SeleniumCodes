import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeAssignment {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thani\\Downloads\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement option = driver.findElement(By.xpath("//label[@for='bmw']"));
		
		String optionValue = option.getText();
		
		option.findElement(By.tagName("input")).click();
		
		WebElement checkBoxOption = driver.findElement(By.id("dropdown-class-example"));
		
		List <WebElement> options = checkBoxOption.findElements(By.tagName("option"));

        for (WebElement webElement : options) {

            String text = webElement.getText();

            if (optionValue.equals(text)) {

                webElement.click();

                driver.findElement(By.id("name")).sendKeys(text);

                driver.findElement(By.id("alertbtn")).click();

                String alertMessage = driver.switchTo().alert().getText();

                boolean value = alertMessage.contains(text);

                if (value) {

                    System.out.println("Alert contains the text");

                } else {

                    System.out.println("Alert doesn't contain the text");
                }

                break;

            }

        }
		
		
	}

}
