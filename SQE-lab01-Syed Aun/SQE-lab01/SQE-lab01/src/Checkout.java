import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Checkout {
    public static final String CHECKOUT_ID = "checkout";
    public static final String CART_ID = "shopping_cart_container";
    public static final String FIRST_NAME = "first-name";
    public static final String LAST_NAME = "last-name";
    public static final String POSTAL_CODE = "postal-code";
    public static final String CONTINUE_ID = "continue";
    public static final String FINISH_ID = "finish";
    public static final String USER_FIRSTNAME = "Syed Aun";
    public static final String USER_LASTNAME = "Zaidi";
    public static final String USER_POSTAL_CODE = "79080";


    public static void CheckingOut(WebDriver driver){
        WebElement cart = driver.findElement(By.id(CART_ID));
        cart.click();
        WebElement checkout = driver.findElement(By.id(CHECKOUT_ID));
        checkout.click();
    }

    public static void Details(WebDriver driver){
        WebElement First_name = driver.findElement(By.id(FIRST_NAME));
        First_name.sendKeys(USER_FIRSTNAME);
        WebElement Last_name = driver.findElement(By.id(LAST_NAME));
        Last_name.sendKeys(USER_LASTNAME);
        WebElement Postal_code = driver.findElement(By.id(POSTAL_CODE));
        Postal_code.sendKeys(USER_POSTAL_CODE);
        WebElement continue_btn = driver.findElement(By.id(CONTINUE_ID));
        continue_btn.click();
    }

    public static void Finish(WebDriver driver)throws Exception{
        Thread.sleep(2000);
        WebElement finish_btn = driver.findElement(By.id(FINISH_ID));
        finish_btn.click();
    }
}
