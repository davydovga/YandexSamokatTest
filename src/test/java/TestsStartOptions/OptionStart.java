package TestsStartOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OptionStart {

    protected WebDriver driver;

    @Before
    public void beforeEachTest (){
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));


    }

    private void setCookie(Cookie settedCookie){
        driver.manage().addCookie(settedCookie);
        driver.navigate().refresh();
    }
    @After
    public void closeBrowserAfterTest (){
        driver.quit();
    }
    private WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "mozila":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Неизвестный браузер");
        }
    }
}
