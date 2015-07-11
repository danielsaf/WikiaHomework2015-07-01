package testcases;


import core.CoreTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectsfactory.HomePage;
import pageobjectsfactory.SpecialUserLoginPage;
import static org.testng.Assert.assertEquals;

/**
 * Created by Daniel on 2015-07-05.
 */
public class LoginTest extends core.CoreTest {
    private HomePage homePage;

    @Test
    public void loggedInUsernameShown() {
        homePage = new HomePage(driver);
        String userName = "TestDaniel";
        String password = "Test123";

        homePage.login(userName, password);
        homePage.waitForElement(homePage.userNameLink);
        Assert.assertEquals(homePage.userNameLink.getAttribute("title"), "TestDaniel - My page");
    }

    @Test
    public void errorWhenInvalideUserNameGiven() {
        homePage = new HomePage(driver);
        String userName = "TestDanielFail";
        String password = "Test123";

        homePage.login(userName, password);
        SpecialUserLoginPage specialUserLoginPage = new SpecialUserLoginPage(driver);

        assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/Special:UserLogin");
        String errorMessage = "Hm, we don't recognize this name. Don't forget usernames are case sensitive.";
        Assert.assertEquals(specialUserLoginPage.userNameErrorDiv.getText(), errorMessage);
    }

    @Test
    public void errorWhenInvalidePasswordGiven() {
        homePage = new HomePage(driver);
        String userName = "TestDaniel";
        String password = "Test123Fail";

        homePage.login(userName, password);
        SpecialUserLoginPage specialUserLoginPage = new SpecialUserLoginPage(driver);

        assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/Special:UserLogin");
        String errorMessage = "Oops, wrong password. Make sure caps lock is off and try again.";
        Assert.assertEquals(specialUserLoginPage.passwordErrorDiv.getText(), errorMessage);
    }

}







