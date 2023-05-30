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


class CreateTour extends PageBase {

//     private By showHostLocator=By.xpath("//select[@name='tournament[organization_id]']");
//     private By fillGroupTypeLocator=By.xpath("//div[@class='control']//input[@id='tournament_group_stages_enabled_false']");
//     private By fillTournamentFormatLocator=By.xpath("//div[@class='single-stage form-select']/select[@id='tournament_tournament_type']/option[@value='single elimination']");
//     private By fillSelectHostLocator=By.xpath("//option[text()='joselxes']");
    private By fillTournamentNameLocator=By.xpath("//div[@class='control']/input[@class='auto-focus form-control']");
    private By fillUrlLocator=By.xpath("//div[@class='input-group']/input[@name='tournament[url]']");
    private By fillDescriptionLocator=By.xpath("//textarea[@name='tournament[description]']");
    private By fillGameNameLocator=By.xpath("//div[@class='control']//input[@name='tournament[game_name]']");
    private By openFillTournamentFormatLocator=By.xpath("//div[@class='single-stage form-select']//select[@id='tournament_tournament_type']");
    private By fillCheckThirdPlaceLocator=By.xpath("//input[@id='tournament_hold_third_place_match']");
    private By fillRegisterAsTeamLocator=By.xpath("//input[@id='tournament_teams']");
    private By fillStarTimeLocator=By.xpath("//div[@class='control']//input[@id='tournament_start_at']");//"2023/06/14 3:54 PM"
    private By fillVotingEnableLocator=By.xpath("//div[@class='control']//input[@id='tournament_voting_enabled']");
    private By saveAndContinueLocator=By.xpath("//input[contains(@value,'Save and Continue')]");
// 10 xpath

    public CreateTour(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }
public CreateTour createTournament (String kTourName, String kTourUrl, String kGameName, String kTourDate) {
    // Find and fill the tournament name text field with the provided value
    WebElement fillTournamentNameText = waitAndReturnElement(fillTournamentNameLocator);
    fillTournamentNameText.sendKeys(kTourName);

    // Find and fill the URL text field with the provided value
    WebElement fillUrlText = waitAndReturnElement(fillUrlLocator);
    fillUrlText.sendKeys(kTourUrl);

    // Find and fill the game name text field with the provided value
    WebElement fillGameNameText = waitAndReturnElement(fillGameNameLocator);
    fillGameNameText.sendKeys(kGameName);

    // Find and click the button to open the tournament format field
    WebElement openFillTournamentFormatButton = waitAndReturnElement(openFillTournamentFormatLocator);
    openFillTournamentFormatButton.click();

    // Find and fill the start time text field with the provided value (tournament date)
    WebElement fillStarTimeText = waitAndReturnElement(fillStarTimeLocator);
    fillStarTimeText.sendKeys(kTourDate);

    // Find and click the "Save and Continue" button
    WebElement saveAndContinueButton = waitAndReturnElement(saveAndContinueLocator);
    saveAndContinueButton.click();
//     showHostButton.click();
//     WebElement fillSelectHostButton= waitAndReturnElement(fillSelectHostLocator);
//     fillSelectHostButton.click();
//     WebElement fillDescriptionText= waitAndReturnElement(fillDescriptionLocator);
//     fillDescriptionText.sendKeys(kDescription);
//     WebElement fillGroupTypeButton= waitAndReturnElement(fillGroupTypeLocator);
//     fillGroupTypeButton.click();
//     WebElement fillTournamentFormatButton= waitAndReturnElement(fillTournamentFormatLocator);
//     fillTournamentFormatButton.click();
//
//     WebElement fillCheckThirdPlaceButton = waitAndReturnElement(fillCheckThirdPlaceLocator);
//     fillCheckThirdPlaceButton.click();
//     if (!fillCheckThirdPlaceButton.isSelected()) {
//         // Select the checkbox
//         fillCheckThirdPlaceButton.click();
//     }

//     WebElement fillRegisterAsTeamButton= waitAndReturnElement(fillRegisterAsTeamLocator);
//     if (!fillRegisterAsTeamButton.isSelected()) {
//         // Select the checkbox
//         fillRegisterAsTeamButton.click();
//     }
//     WebElement showHostButton= waitAndReturnElement(showHostLocator);


    return new CreateTour(this.driver);

    }


//         return bodyElement.getText();


}
