import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class CommunityPage extends PageBase {
    private By signUpLocator=By.xpath("//a[@class='btn btn-sm btn-primary']");
//     private By signUpLocator=By.xpath("//div[child::a[@class='btn btn-sm btn-primary']]");


// 10 xpath

    public CommunityPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public Boolean checkHover () {
        // Find the element to hover over
        WebElement buttonSignUpToHover = waitAndReturnElement(signUpLocator);

        // Create an instance of Actions class and pass the WebDriver instance
        Actions actions = new Actions(this.driver);
        // Retrieve the button's color before the hover action
        String colorBeforeHover = buttonSignUpToHover.getCssValue("background-color");

        // Perform the hover action
        actions.moveToElement(buttonSignUpToHover).perform();

        // Retrieve the button's color after the hover action
        String colorAfterHover = buttonSignUpToHover.getCssValue("background-color");
//         System.out.println(colorBeforeHover);
//         System.out.println(colorAfterHover);

        // Compare the colors to check if they are different
        boolean colorChanged = !colorBeforeHover.equals(colorAfterHover);
        return colorChanged;

    }


//         return bodyElement.getText();


}
