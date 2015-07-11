package testcases;

import pageobjectsfactory.HomePage;
import pageobjectsfactory.VideoAddPage;


import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Daniel on 2015-07-10.
 */
public class AddVideoTest extends core.CoreTest {

    private HomePage homePage;
    private VideoAddPage videoAddPage;

    @Test
    public void uploadConfirmed() {
        homePage = new HomePage(driver);
        String userName = "TestDaniel";
        String password = "Test123";
        homePage.login(userName, password);

        videoAddPage = homePage.clickAddVideo();
        homePage.waitForElement(videoAddPage.videoUrlTextBox);
        videoAddPage.sumbitVideo("https://www.youtube.com/watch?v=h9tRIZyTXTI");
        String fileName = videoAddPage.flashMessageLink.getText();
        videoAddPage.flashMessageLink.click();
        Assert.assertEquals(true, videoAddPage.isFileNameInUrl(fileName));
    }
}
