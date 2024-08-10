package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-fullscreen");
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi Donwload\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            File directory = new File("evidence");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9_]", "_");

                // Get count of existing files
                int count = getCountOfFiles(directory, scenarioName);
                // Create new file name with count
                File destFile = new File(directory, scenarioName + "_" + (count + 1) + ".png");

                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot taken and saved to " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

    private int getCountOfFiles(File directory, String baseName) {
        File[] files = directory.listFiles((dir, name) -> name.startsWith(baseName) && name.endsWith(".png"));
        if (files != null) {
            return files.length;
        } else {
            return 0;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
