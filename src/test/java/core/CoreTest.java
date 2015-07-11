package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * Created by Daniel on 2015-07-05.
 */
public class CoreTest {
    private String browser;
    private String pathToDriver;
    private String baseURL = "http://qm-homework.wikia.com";
    protected WebDriver driver = null;


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = getBrowser();
        driver.get(baseURL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

    private WebDriver getBrowser() {
        Properties props = new Properties();
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("TestConfig.properties");
            props.load(inputStream);
            browser = props.getProperty("TestProps.browser");
            pathToDriver = props.getProperty("TestProps.pathToDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", pathToDriver);
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}



