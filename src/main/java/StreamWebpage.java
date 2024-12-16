import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class StreamWebpage {
    @Test
    public static void main(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //driver.findElement(By.xpath("//a/span[text()='4']")).click();
        List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> price;
//        List<String> ogList = productList.stream().map(WebElement::getText).collect(Collectors.toList());
//        List<String> modList = ogList.stream().sorted().collect(Collectors.toList());
//        Assert.assertEquals(ogList, modList);
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Almond")).map(StreamWebpage::getPrice)
                    .toList();
            if(price.isEmpty()){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
            price.forEach(System.out::println);

            //a/span[text()="4"]
        }while(price.isEmpty());
    }

    @Test
    public static String getPrice(WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
