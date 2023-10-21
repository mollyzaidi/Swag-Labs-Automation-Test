import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddToCart {
    public static final String PRODUCT_NAME = "inventory_item_name";

    public static final String PRODUCT_LIST = "inventory_item";
    public static final String ADD_TO_CART_BUTTON = "btn_primary";
    public static final String SHOPPING_CART_LINK = "shopping_cart_badge";


    public static void AddingToCart(WebDriver driver,List<String> productNames) {
        List<WebElement> productElements = driver.findElements(By.className(PRODUCT_LIST));
        for (String productName : productNames) {
            for (WebElement product : productElements) {
                String currentProductName = product.findElement(By.className(PRODUCT_NAME)).getText();
                if (currentProductName.equals(productName) && productNames.contains(currentProductName)){

                    System.out.println("Titles are Verified!");
                    System.out.println("Adding " + productName + " to the cart.");
                    WebElement addToCartButton = product.findElement(By.className(ADD_TO_CART_BUTTON));
                    addToCartButton.click();
                    break;
                }
            }
        }
    }


    public static int GetCartItemCount(WebDriver driver) {
        WebElement cartBadge = driver.findElement(By.className(SHOPPING_CART_LINK));
        return Integer.parseInt(cartBadge.getText());
    }
}