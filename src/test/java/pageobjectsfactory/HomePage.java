package pageobjectsfactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Daniel on 2015-07-05.
 */
public class HomePage extends BasePage {
    @FindBy(name = "username")
    public WebElement userNameTextBox;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(id = "AccountNavigation")
    public WebElement loginLink;

    @FindBy(css = "div.links-container >a")
    public WebElement userNameLink;

    @FindBy(css = "#UserLoginDropdown > form > fieldset > div.input-group.login-button > input")
    public WebElement loginSubmitButton;

    @FindBy(css = "#WikiHeader > div.buttons > nav")
    public WebElement contributeButton;

    @FindBy(linkText = "Add a Video")
    public WebElement addVideoLink;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((element)));
    }


    public void login(String userName, String password) {
        hoverOver(loginLink);
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
        loginSubmitButton.click();
    }

    public VideoAddPage clickAddVideo() {
        contributeButton.click();
        addVideoLink.click();
        return new VideoAddPage(driver);
    }
}



