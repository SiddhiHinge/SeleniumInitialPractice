import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Assignment1 {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ChromeOptions chrome = new ChromeOptions();
        WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"),chrome);
        webDriver.navigate().to("https://www.youtube.com/");
        webDriver.findElement(By.xpath("//input[@id='search']")).sendKeys("podtest");
        webDriver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

        Thread.sleep(5000);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.navigate().to("https://www.facebook.com/");
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("harrypotter@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Test@123");
        Thread.sleep(5000);
        String buttonName = webDriver.findElement(By.xpath("//button[@name='login']")).getText();
        if(buttonName.equals("Log in")){
            System.out.println(buttonName);
            webDriver.findElement(By.xpath("//button[@name='login']")).click();
        }else{
            System.out.println("Not correct button to click !");
        }

        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.navigate().to("https://timesofindia.indiatimes.com/");
        Thread.sleep(5000);
        int count_of_anchortag = webDriver.findElements(By.xpath("//a[contains(@href,'https')]")).size();
        System.out.println("Count of Anchor tag = "+count_of_anchortag);
    }
}
