package pageobjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialUserLoginPage extends BasePage{

	@FindBy(css = "#mw-content-text > div > form > fieldset > div.input-group.error.required > div")
	public WebElement userNameErrorDiv;
	
	@FindBy(css = "div.input-group.password-input.error.required > div")
	public WebElement passwordErrorDiv;
	
	public SpecialUserLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
