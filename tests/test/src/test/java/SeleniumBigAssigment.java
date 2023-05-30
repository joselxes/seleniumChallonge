import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  
import java.util.Random;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Random;

public class SeleniumBigAssigment {
    public WebDriver driver;
    public RandomVar ran;
    public String wrongUser="jar@gmail.com";
    public String wrongPass="SuperSecretPassword!";
    public String correctUser="joselxes";
    public String correctPass="ps3ps2psp";
    public String mainTitle="Challonge - Tournament Brackets - Single & Double Elimination, Round Robin, Swiss, Group Stage";


  @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    // Test case to verify incorrect user login
    public void testIncorrectUser() {
        MainPage mainPage = new MainPage(this.driver);

        // Open the log page with incorrect user credentials
        LogPage loggedPage = mainPage.openLogPage(wrongUser, wrongPass);

        // Assert that the error message is displayed
        Assert.assertTrue(loggedPage.getBodyText().contains("Username or email is not valid"));
    }

    @Test
    // Test case to verify user logout functionality
    public void testLogOutUser() {
        MainPage mainPage = new MainPage(this.driver);

        // Open the log page with correct user credentials
        LogPage loggedPage = mainPage.openLogPage(correctUser, correctPass);

        // Assert that the correct user is displayed on the logged page
        Assert.assertTrue(loggedPage.getBodyText().contains(correctUser));

        // Perform logout action and navigate to the logout page
        LogPage toLogOutPage = loggedPage.logOutPage();

        // Assert that the logout page displays the login prompt
        Assert.assertTrue(toLogOutPage.getBodyText().contains("Log in"));
    }

    @Test
    // Test case to search for tournaments
    public void testTournamentSearch() {
        MainPage mainPage = new MainPage(this.driver);
        // Search for tournaments using the keyword "tekken"
        SearchResultPage resultPage = mainPage.searchTournamentPage("tekken");
        // Assert that the search result page contains the expected text related to tournaments

        Assert.assertTrue(resultPage.searchText().contains("Tournaments"));
        Assert.assertTrue(resultPage.searchText().contains("Events"));
        Assert.assertTrue(resultPage.searchText().contains("Communities"));
    }


    @Test
    // Test case to create a random tournament
    public void testCreateRandomTour() {
        // Generate a random date and random tournament name
        String randomDate = ran.generateRandomDate();
        String tourRandomName = ran.generateRandomText(10);

        // Instantiate the main page and open the log page with correct credentials
        MainPage mainPage = new MainPage(this.driver);
        LogPage loggedPage = mainPage.openLogPage(correctUser, correctPass);

        // Navigate to the create tournament page
        CreateTour createPage = loggedPage.gotoCreatePage();

        // Create a new tournament with the random tournament name, URL, game, and date
        CreateTour seeNewTourPage = createPage.createTournament(tourRandomName, "kTourUrltest1", "TEKKEN 7", randomDate);

        // Assert that the created tournament name is displayed on the page
        Assert.assertTrue(seeNewTourPage.getBodyText().contains(tourRandomName));

        // Assert that the last 8 characters of the random date are displayed on the page
        Assert.assertTrue(seeNewTourPage.getBodyText().contains(randomDate.substring(randomDate.length() - 8)));
        Assert.assertTrue(mainPage.getTitleText().contains(tourRandomName));
    }

    @Test
    // Test case to verify the title of the main page
    public void testTitleMainPage() {
        MainPage mainPage = new MainPage(this.driver);

        // Print the title of the main page
        System.out.println(mainPage.getTitleText());

        // Generate a random date
        String randomDate = ran.generateRandomDate();
        System.out.println(randomDate);

        // Assert that the title of the main page contains the expected mainTitle
        Assert.assertTrue(mainPage.getTitleText().contains(mainTitle));
    }

    @Test
    // Test case when a button changes its value when the mouse is above
    public void testHover() {
        MainPage mainPage = new MainPage(this.driver);

        // Print the title of the main page
        CommunityPage communityPage = mainPage.goToCommunityPage();
        Assert.assertTrue(communityPage.checkHover());

    }

    @Test
    // Test case when a button changes its value when the mouse is above
    public void testCookies() {

        MainPage mainPage = new MainPage(this.driver);

        // Open the log page with correct user credentials
        LogPage loggedPage = mainPage.openLogPage(correctUser, correctPass);

        // Assert that the correct user is displayed on the logged page
        Assert.assertTrue(loggedPage.getBodyText().contains(correctUser));

        // Perform logout action and navigate to the logout page
        LogPage toLogOutPage = loggedPage.logOutPage();

        // Assert that the logout page displays the login prompt
        Assert.assertTrue(toLogOutPage.getBodyText().contains("Log in"));

        Assert.assertTrue(!toLogOutPage.resetAndCompareCookies());

    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
