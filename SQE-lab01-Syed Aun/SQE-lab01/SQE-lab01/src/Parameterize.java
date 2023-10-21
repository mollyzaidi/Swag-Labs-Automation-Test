import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

public class Parameterize {
    public static final String STATEMENT = "My First Automated Test Case";

    public static final String URL = "https://www.saucedemo.com/";
    public static final String EXPECTED_TITLE = "Swag Labs";
    public static final String EXPECTED_RESULT = "Products";
    public static final String PASSWORD = "secret_sauce";
    public static final String PAGE_TITLE_XPATH = "//*[@id=\"header_container\"]/div[2]/span";
    public static final String PASSWORD_TEXT_BOX_ID = "password";
    public static final String ERROR = "Verification Test Failed!\nActual Output: ";
    public static final String SUCCESS = "Verification Test Passed!\nActual Output: ";
    public static final int TIME = 2000;
    public static WebDriver driver = new ChromeDriver();

    public static void main(String args[]) throws Exception {
        System.out.println(STATEMENT);
        LoginPage.LoginStart(driver);
        VerifyTitle(EXPECTED_TITLE);
        WaitForTime(TIME);
        VerifyProduct(PAGE_TITLE_XPATH,EXPECTED_RESULT );

        List<String> productsToAdd =  Productlisting.ProductlistingStart(driver, 5);

        WaitForTime(TIME);
        AddToCart.AddingToCart(driver,productsToAdd);
        int cartItemCount = AddToCart.GetCartItemCount(driver);
        System.out.println("Items in the cart: " + cartItemCount);
        Checkout.CheckingOut(driver);
        Checkout.Details(driver);
        Checkout.Finish(driver);



        try {
            WebElement passwordTextBox = driver.findElement(By.id(PASSWORD_TEXT_BOX_ID));
            passwordTextBox.sendKeys(PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void WaitForTime(int ms) throws Exception {
        Thread.sleep(ms);
    }

    public static void VerifyTitle(String Title) throws Exception {
        try {
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(Title)) {
                System.out.println(SUCCESS + actualTitle);
            } else {
                System.out.println(ERROR + actualTitle);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void VerifyProduct(String identifier, String EXPECTED_TITLE) throws Exception{
        try {
            WebElement title = driver.findElement(By.xpath(identifier));
            String actualResult = title.getText();
            if (actualResult.equals(EXPECTED_TITLE)) {
                System.out.println(SUCCESS + actualResult);
            } else{
                System.out.println(ERROR + actualResult);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
