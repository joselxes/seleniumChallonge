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


class LogPage extends PageBase {
    private By inputEmailLocator = By.xpath("//div[@class=\"form-group floating-label-form-group\"]/input[@id='user_session_username_or_email']");
    private By inputPasswordLocator = By.xpath("//div[@class=\"form-group floating-label-form-group\"]/input[@id='user_session_password']");
    private By inputSubmitLocator = By.xpath("//div[@class=\"form-group\"]/input[@class='btn btn-primary btn-lg btn-block']");
    private By userNavLocator = By.xpath("//div[@class='dropdown']/a[@class='user']");
    private By userLogoutLocator = By.xpath("//a[contains(text(), 'Log out')]");
    private By showCreateTournamentLocator=By.xpath("//button[@class='trigger btn btn-primary btn-lg btn-block']");
    private By createTournamentLocator=By.xpath("//a[@href='/tournaments/new']");
// 7xpath
    public LogPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }    

    public void clickByText(String resultName){
        By locator = By.xpath("//h2[contains(text),'" + resultName + "')]//ancestor::a[contains(@class,'text-wrapper')]" );
        waitAndReturnElement(locator).click();
    }
    public String searchBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.className("search search-all "));
        return bodyElement.getText();
    }

    // Logs in to the log page with the provided user email and password, and returns a LogPage object
    public LogPage loginLogPage(String userEmail, String userPass) {
        WebElement emailBar = waitAndReturnElement(inputEmailLocator);
        emailBar.sendKeys(userEmail);
        WebElement passwordBar = waitAndReturnElement(inputPasswordLocator);
        passwordBar.sendKeys(userPass);
        WebElement submitButton = waitAndReturnElement(inputSubmitLocator);
        submitButton.click();
        return new LogPage(this.driver);
    }

    // Logs out of the page and returns a LogPage object
    public LogPage logOutPage() {
        WebElement userButton = waitAndReturnElement(userNavLocator);
        userButton.click();
        WebElement logOutButton = waitAndReturnElement(userLogoutLocator);
        logOutButton.click();
        return new LogPage(this.driver);
    }

    // Navigates to the create page and returns a CreateTour object
    public CreateTour gotoCreatePage() {
        WebElement showButton = waitAndReturnElement(showCreateTournamentLocator);
        showButton.click();
        WebElement openCreateButton = waitAndReturnElement(createTournamentLocator);
        openCreateButton.click();
        return new CreateTour(this.driver);
    }

    // compare the cookies
    public boolean resetAndCompareCookies() {

        // Get all the cookies
        String cookiesBefore="";
        cookiesBefore=""+getCookies();
//         System.out.println(cookiesBefore);

        // Delete all cookies
        delCookies();

        // save new cookies values
        String cookiesAfter="";
        cookiesAfter=""+getCookies();
//         System.out.println(cookiesAfter);
//         System.out.println(cookiesBefore.equals(cookiesAfter));
//     send comparison result
        return cookiesBefore.equals(cookiesAfter);
    }

}

