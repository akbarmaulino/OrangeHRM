package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    String UsernameValid = "Admin";
    String PasswordValid = "admin123";

    public LoginPages(WebDriver webDrivers){
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]")
    private WebElement dashboardList;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
    private WebElement errormessageusername;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")
    private WebElement errormessagepassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    private WebElement errormessage;

    public void enterUsername(String Username){
        if (Username.equals("[empty]")) {
            username.sendKeys("");
        } else {
            username.sendKeys(Username);
        }
    }

    public void enterPassword(String Password) {
        if (Password.equals("[empty]")) {
            password.sendKeys("");
        } else {
            password.sendKeys(Password);
        }
    }

    public void enterUsernamevalid(){
        username.sendKeys(UsernameValid);
    }

    public void enterPasswordValid(){
        password.sendKeys(PasswordValid);
    }

    public void clickLoginButton(){
        logInBtn.click();
    }

    public void usernamefielddisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
    }

    public void passwordfielddisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(password));
    }

    public void loginbuttondisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
    }

    public void dashboardlistisdisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardList));
    }

    public void errormessageisdisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errormessage));
    }

    public void checkErrorMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(errormessagepassword),
                ExpectedConditions.visibilityOf(errormessageusername)
        ));
    }




}
