package pageobjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Daniel on 2015-07-05.
 */
public class BasePage {
    public final WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void hoverOver(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

}
