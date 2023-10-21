import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Productlisting {
    public static final String PRODUCT_LIST = "inventory_item";
    public static final String PRODUCT_NAME = "inventory_item_name";
    public static final String PRODUCT_PRICE = "inventory_item_price";

    public static List<String> ProductlistingStart(WebDriver driver, int numberOfProductsToSelect) throws Exception {
        List<WebElement> productElements = driver.findElements(By.className(PRODUCT_LIST));
        int numberOfProducts = productElements.size();
        List<String> productNames = new ArrayList<>();
        List<String> productPrice = new ArrayList<>();



        if (numberOfProductsToSelect <= numberOfProducts)   {
            Random random = new Random();
            for (int i = 0; i < numberOfProductsToSelect; i++) {
                int randomIndex = random.nextInt(numberOfProducts);
                WebElement randomProduct = productElements.get(randomIndex);
                Thread.sleep(100);
                String productTitle = randomProduct.findElement(By.className(PRODUCT_NAME)).getText();
                String productPrices = randomProduct.findElement(By.className(PRODUCT_PRICE)).getText();
                if (!productNames.containsAll(Collections.singleton(productTitle))) {
                    productNames.add(productTitle);
                    productPrice.add(productPrices);
                }
            }
            System.out.println("Product Titles: " + productNames + " Product Prices: " + productPrice);
            return productNames;

        } else {
            System.out.println("Desired number of products to select is greater than the number of available products.");
        }
        return null;
    }
}
