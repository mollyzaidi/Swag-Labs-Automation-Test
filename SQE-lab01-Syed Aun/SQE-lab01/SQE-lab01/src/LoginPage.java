import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String USERNAME_TEXT_BOX_ID = "user-name";
    public static final String PASSWORD_TEXT_BOX_ID = "password";
    private static final String URL = "https://www.saucedemo.com/";
    private static final String LOGIN_BUTTON_ID = "login-button";
    private static final String DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "SQE-lab01/src/driver/chromedriver.exe";


    public static void LoginStart(WebDriver driver) throws Exception{
        try {
            System.setProperty(DRIVER, DRIVER_PATH);
            driver.manage().window().maximize();
            driver.get(URL);
            WebElement usernameTextBox = driver.findElement(By.id(USERNAME_TEXT_BOX_ID));
            usernameTextBox.sendKeys(USERNAME);
            WebElement passwordTextBox = driver.findElement(By.id(PASSWORD_TEXT_BOX_ID));
            passwordTextBox.sendKeys(PASSWORD);
            WebElement loginButton = driver.findElement(By.id(LOGIN_BUTTON_ID));
            loginButton.click();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}
