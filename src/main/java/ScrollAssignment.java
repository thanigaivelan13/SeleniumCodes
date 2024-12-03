import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class ScrollAssignment {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int rowCount = driver.findElements(By.xpath("//table[@name = \"courses\"]/tbody/tr")).size();
        int columnCount = driver.findElements(By.xpath("//table[@name = \"courses\"]/tbody/tr/th")).size();
        List<WebElement> rowValues = driver.findElements(By.xpath("//table[@name = \"courses\"]/tbody/tr"));
        System.out.println("Row Count is: "+rowCount+", Column Count is: "+columnCount);
        Scanner value = new Scanner(System.in);
        System.out.println("Enter Row number: ");
        int rowNumber = Integer.parseInt(value.nextLine());
        if(rowNumber>rowCount){
            System.out.println("Invalid Row Number");
            System.exit(0);
        }
        System.out.println("Row Value is:\n" + rowValues.get(rowNumber-1).getText());
        //System.out.println("Value is: "+rowNumber);

    }
}
