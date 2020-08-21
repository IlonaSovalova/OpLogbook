import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenPageTest {
    @Test
    public void test_PageOpened() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://40.78.150.2/OptiRampWeb5/OperatorLogbook/");
        Thread.sleep(2000);

       String title= driver.getTitle();

        Assert.assertEquals(title, "OperatorLogbook");
        Thread.sleep(3000);
        driver.quit();
    }

}
