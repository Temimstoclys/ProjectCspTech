package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Base {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome").toLowerCase();
            try {
                String os = System.getProperty("os.name").toLowerCase();
                String chromedriverPath = "";

                if (os.contains("win")) {
                    chromedriverPath = "src/test/resources/drivers/chromedriver.exe";
                } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                    chromedriverPath = "/usr/local/bin/chromedriver";
                }

                switch (browser) {
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
                        driver = new FirefoxDriver();
                        break;

                    case "edge":
                        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                        driver = new EdgeDriver();
                        break;

                    case "chrome":
                    default:
                        System.setProperty("webdriver.chrome.driver", chromedriverPath);

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--window-size=1920,1080");

                        driver = new ChromeDriver(options);
                        break;
                }

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                System.err.println("Erro ao iniciar o WebDriver (" + browser + "): " + e.getMessage());
                throw new RuntimeException("Falha ao iniciar o driver: " + browser, e);
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
