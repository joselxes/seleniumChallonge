import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.List;

class SearchResultPage extends PageBase {
    private By wrapLocator=By.xpath("//div[@class='list-wrapper']");

//     1xpath
    public SearchResultPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }    

    public void clickByText(String resultName){
        By locator = By.xpath("//h2[contains(text),'" + resultName + "')]//ancestor::a[contains(@class,'text-wrapper')]" );
        waitAndReturnElement(locator).click();
    }
    // Retrieves the text content of certain elements
    public String searchText() {
        // Find all elements with the specified XPath expression
        List<WebElement> elements = this.driver.findElements(wrapLocator);

        // Initialize an empty string to store the concatenated text
        String wrapString = "";

        // Iterate through each element and concatenate its text to the wrapString
        for (WebElement element : elements) {
            wrapString = wrapString + " " + element.getText();
            // System.out.println(element.getText());
        }
        // System.out.println(wrapString);

        // Return the concatenated string
        return wrapString;
    }


}
