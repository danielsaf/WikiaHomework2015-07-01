package pageobjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Daniel on 2015-07-05.
 */
public class VideoAddPage extends BasePage{
    @FindBy(id = "wpWikiaVideoAddUrl")
    public WebElement videoUrlTextBox;

    @FindBy(css = "#mw-content-text > form > div > input[type='submit']")
    public WebElement addButton;


    @FindBy(css = "div.banner-notification  > div.msg > a")
    public WebElement flashMessageLink;


    public VideoAddPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sumbitVideo(String videoUrl) {
        videoUrlTextBox.sendKeys(videoUrl);
        addButton.click();
    }

    public boolean isFileNameInUrl(String fileName) {
        String fileNameNoSpace = fileName.replace(" ", "_");
        String url = driver.getCurrentUrl();
        if (url.contains(fileNameNoSpace))
            return true;
        return false;
    }
}
