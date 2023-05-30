import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected By bodyLocator =By.tagName("body");
    protected By footerLocator =By.tagName("footer");
//     protected By titleLocator =By.tagName("//title");

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    // Waits for the element located by the given locator to be visible, and returns the WebElement
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }


    // Retrieves the text of the body element
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(bodyLocator);
        return bodyElement.getText();
    }

    // Retrieves the text of the footer element
    public String getFooterText() {
        WebElement footerElement = this.waitAndReturnElement(footerLocator);
        return footerElement.getText();
    }

    // Retrieves the text of the page title
    public String getTitleText() {
        // Alternative approach: Get the title element using the locator and retrieve its text
        // WebElement tElement = this.waitAndReturnElement(titleLocator);
        // return tElement.getText();

        // Get the title text directly from the WebDriver
        String titleElement = this.driver.getTitle();
        return titleElement;
    }

    // Send the coookies as a String
    public String getCookies() {
        // Get all the cookies
        String cookiesBefore="";
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            cookiesBefore=cookiesBefore+""+cookie.getName();
            cookiesBefore=cookiesBefore+""+cookie.getValue();
            // Delete a specific cookie
            if (cookie.getName().equals("cookieName")) {
                this.driver.manage().deleteCookie(cookie);
            }
        }
        return cookiesBefore;
    }

    // Delete cookies
    public void delCookies() {
        this.driver.manage().deleteAllCookies();

    }



//     public String getTitleText() {
//
//         WebElement tElement = this.waitAndReturnElement(titleLocator);
//         return tElement.getText();
//     }

}