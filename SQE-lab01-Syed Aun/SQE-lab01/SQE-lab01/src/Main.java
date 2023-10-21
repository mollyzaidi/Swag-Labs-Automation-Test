import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String args[]) throws Exception {
        System.out.println("Hello this is my first lab");
        try {
            System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            String actualTitle = driver.getTitle();
            String expectedtitle = "Swag Labs";
            if (actualTitle.equals(expectedtitle)) {
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expectedtitle + "\n" +
                                "Actual Title: " + actualTitle);

            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expectedtitle + "\n" +
                                "Actual Title: " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


