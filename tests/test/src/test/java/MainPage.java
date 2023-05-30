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


class MainPage extends PageBase {
    private By footerLocator = By.xpath("//footer[@class= 'footer-public']");
    private By loginOpenButtonLocator = By.xpath("//div[@class='item']/a[contains(@class,'link')]");
    private By linkNavLocator = By.xpath("//div[@class='dropdown']/a[@class='link']");
    private By searchTournamentLocator = By.xpath("//form[contains(@class,'search-bar -dark -long')]/input[@class='field']");
    private By searchTournamentButtonLocator = By.xpath("//form[contains(@class,'search-bar -dark -long')]/button[contains(@class,'icon')]");
    private By checkSearchLocator = By.xpath("//div[@data-query='tekken']");
    private By communityLocator = By.xpath("//a[@href='https://challonge.com/communities']");
    private By titleLocator =By.xpath("//title");
// xpath7
// ------------
    private By searchBarOpenButtonLocator = By.className("search-bar-toggler");
    private By searchBarLocator = By.name("search");
//     private By footerBy = By.className("footer-block");
//     private By searchBarTogglerBy = By.xpath("//form[@class='search-bar -dark -long']");
//     private By searchBarBy = By.name("search");

    // Navigates to the specified URL
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://challonge.com/");
    }


    // Opens the search bar by clicking on the search bar open button
    public void openTheSearchBar() {
        WebElement searchBarOpenButton = waitAndReturnElement(searchBarOpenButtonLocator);
        searchBarOpenButton.click();
    }

    // Opens the log page by clicking on the login open button, and returns a LogPage object
    public LogPage openLogPage(String user, String pass) {
        WebElement searchBarOpenButton = waitAndReturnElement(loginOpenButtonLocator);
        searchBarOpenButton.click();
        LogPage logPage = new LogPage(this.driver);
        return logPage.loginLogPage(user, pass);
    }


    // Searches for tournaments based on the provided keys and returns a SearchResultPage object
    public SearchResultPage searchTournamentPage(String keys) {
        WebElement searchField = waitAndReturnElement(searchTournamentLocator);
        searchField.sendKeys(keys);
        WebElement submitSearchButton = waitAndReturnElement(searchTournamentButtonLocator);
        submitSearchButton.click();
        return new SearchResultPage(this.driver);
    }

    // Searches for a specific key and returns a CreateTour object
    public CreateTour search(String keys) {
        WebElement searchBar = waitAndReturnElement(searchBarLocator);
        searchBar.sendKeys(keys);
        return new CreateTour(this.driver);
    }

    public CommunityPage goToCommunityPage() {
        WebElement communityButton = waitAndReturnElement(communityLocator);
        communityButton.click();
        return new CommunityPage(this.driver);
    }

}


