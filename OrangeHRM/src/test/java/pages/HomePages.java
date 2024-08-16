package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePages {
    WebDriver driver;

    public HomePages(WebDriver webDrivers){
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")
    private WebElement inputSearch;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li")
    private WebElement Profile;


    public void clickButtonByIndex(int index) {
        String xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[" + index + "]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void clickAdminButton() {
        clickButtonByIndex(1);
    }

    public void clickPIMButton(){
        clickButtonByIndex(2);
    }

    public void clickLeaveButton(){
        clickButtonByIndex(3);
    }

    public void clickTimeButton(){
        clickButtonByIndex(4);
    }

    public void clickRecruitmentButton(){
        clickButtonByIndex(5);
    }

    public void clickMyInfoButton(){
        clickButtonByIndex(6);
    }

    public void clickPerformanceButton(){
        clickButtonByIndex(7);
    }

    public void clickDashboardButton(){
        clickButtonByIndex(8);
    }

    public void clickDirectoryButton(){
        clickButtonByIndex(9);
    }

    public void clickMaintenanceButton(){
        clickButtonByIndex(10);
    }

    public void clickClaimButton(){
        clickButtonByIndex(11);
    }

    public void clickBuzzButton(){
        clickButtonByIndex(12);
    }
}
