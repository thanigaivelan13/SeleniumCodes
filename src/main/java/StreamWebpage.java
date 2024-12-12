import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamWebpage {
    @Test
    public static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//a/span[text()='4']")).click();
        List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
//        List<String> ogList = productList.stream().map(WebElement::getText).collect(Collectors.toList());
//        List<String> modList = ogList.stream().sorted().collect(Collectors.toList());
//        Assert.assertEquals(ogList, modList);
        List<String> price = productList.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s))
                .toList();
        price.forEach(s -> System.out.println(s));
        //a/span[text()="4"]
    }

    public static String getPrice(WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
