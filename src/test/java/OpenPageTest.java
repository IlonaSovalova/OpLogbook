import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class OpenPageTest {
    @Test
    public void test_PageOpened() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://40.78.150.2/OptiRampWeb5/OperatorLogbook/");
        Thread.sleep(2000);

        String title = driver.getTitle();

        Assert.assertEquals(title, "OperatorLogbook");
        Thread.sleep(3000);
        driver.quit();


    }

    @Test

    public void login_ToOpLogBook_LoggedToApp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sncadmin:1@40.78.150.2/OptiRampWeb5/OperatorLogbook/");
        Thread.sleep(7000);

        WebElement AzureLogbookArrow = driver.findElement(By.xpath("//button[@aria-label=\"toggle AzureLogbook\"]"));
        AzureLogbookArrow.click();

        WebElement PumpFolderArrow = driver.findElement(By.xpath("//*[@id='tn9']/li/div/div[1]/span"));
        PumpFolderArrow.click();
        Thread.sleep(2000);

        WebElement CreateNoteRecordButton = driver.findElement(By.xpath("//button[@mattooltip=\"Create Note Record\"]"));
        CreateNoteRecordButton.click();

        Thread.sleep(3000);

        WebElement CreateNoteRecordDescription = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        long unixTime = System.currentTimeMillis() / 1000L;
        String myDescriptionText = "Testing time is " + unixTime;
        CreateNoteRecordDescription.sendKeys(myDescriptionText);

        Thread.sleep(2000);

        WebElement CreateNoteRecordCriticality = driver.findElement(By.xpath("//*[@placeholder='Criticality']"));
        CreateNoteRecordCriticality.click();
        Thread.sleep(2000);

        WebElement CreateNoteRecordCriticalityNormal = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains (text(),'N - There could be some')]"));
        CreateNoteRecordCriticalityNormal.click();
        Thread.sleep(2000);

//        WebElement CreateNoteRecordEventTime= driver.findElement(By.xpath("//input[@placeholder='Event Time']"));
//        String time = java.time.LocalDateTime.now().toString();
//        CreateNoteRecordEventTime.clear();
//        CreateNoteRecordEventTime.sendKeys(time);
//
//        Thread.sleep(10000);


//        WebElement CreateNoteRecordDueDate = driver.findElement(By.xpath("//input[@placeholder='Due Date']"));
//        CreateNoteRecordDueDate.sendKeys("12/31/2020");
//        Thread.sleep(2000);


        // /label/div/input
        WebElement CreateNoteRecordAuditBox = driver.findElement
                (By.xpath("//mat-dialog-container/ng-component/mat-dialog-content/mat-checkbox/label"));
        CreateNoteRecordAuditBox.click();
        Thread.sleep(2000);

//      WebElement CreateNoteRecordOkButton = driver.findElement(By.xpath("//*[@class='mat-focus-indicator mat-raised-button mat-button-base'][1]/div[2]"));
//      CreateNoteRecordButton.click();
        WebElement CreateNoteRecordOkButton = driver.findElement(By.xpath("//div[@mat-dialog-actions]/button[1]"));
        CreateNoteRecordOkButton.click();
        Thread.sleep(10000);

        WebElement RecordsTableDescriptionSell = driver.findElement(By.xpath("//td[text()='" + myDescriptionText + "']"));
        Thread.sleep(2000);


        WebElement RecordsTableCalendarDateTo = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
//        RecordsTableCalendarDateTo.click();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date()); // Now use today date.
//        c.add(Calendar.DATE, 1);
//        System.out.println(sdf.format(c.getTime()));
//        RecordsTableCalendarDateTo.clear();
//
//        RecordsTableCalendarDateTo.sendKeys(sdf.format(c.getTime()));



                Thread.sleep(10000);

                driver.quit();


    }
}
