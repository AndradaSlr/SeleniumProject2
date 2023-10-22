import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
//        launching the specified URL
        driver.get("http://testfasttrackit.info/magento-test/");
//        Locating the elements using name locator for the text box
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("youtube");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/button"));
        searchBox.click();
        WebElement searchResultTextElement = driver.findElement(By.className("note-msg"));
        String actualText = searchResultTextElement.getText();
        String expectedText = "Your search returns no results.";

        Assert.assertEquals(actualText, expectedText, "Search result text is not the expected one");

        driver.quit();




    }

}
