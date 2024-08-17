package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AdminPages {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    private WebElement buttonAddJobTitles;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    private WebElement inputJobTitles;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
    private WebElement inputJobDescription;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/input")
    private WebElement inputFile;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")
    private WebElement inputNote;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")
    private WebElement saveJobTitles;

    @FindAll(@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div/div[2]"))
    private List<WebElement> ListJobTitles;

    @FindAll(@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i"))
    private List<WebElement> CheckboxJobTitles;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    private WebElement confrimDeleteJobTitles;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div[1]/div/label/span/i")
    private WebElement selectAllJobsList;

    public AdminPages(WebDriver webDrivers){
        driver = webDrivers;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickButtonHeaderByIndex(int index) {
        String xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[" + index + "]";
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    //User Management

    public void ClickHeaderUserManagement(){clickButtonHeaderByIndex(1);}

    //Job

    public void ClickListJob(int index){
        String xpath = " //*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[" + index + "]";
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    //Job Titles


    public void ClickHeaderJobTitles(){
        clickButtonHeaderByIndex(2);
        ClickListJob(1);
    }

    public void ClickAddJobTitles(){
        wait.until(ExpectedConditions.visibilityOf(buttonAddJobTitles));
        buttonAddJobTitles.click();
    }

    public void InputJobTitles(){
        wait.until(ExpectedConditions.visibilityOf(inputJobTitles));
        inputJobTitles.sendKeys("Test Job Title");
    }

    public void InputJobDescription(){
        inputJobDescription.sendKeys("TestJobDescription");
    }

    public void InputFile(){
        inputFile.sendKeys("D:\\Belajar\\Belajar QA\\Kerjaan Sendiri\\OrangeHRM\\OrangeHRM\\Image\\Test.png");
    }

    public void InputNote(){inputNote.sendKeys("TestNote");}

    public void SaveJobTitles() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(saveJobTitles));
        saveJobTitles.click();
        Thread.sleep(10000);
    }

    public void SuccesToCreateJobTitles() {
        boolean textFound = false;
        String Text = "";
        for (WebElement element : ListJobTitles) {
            String text = element.getText();
            if (text.equals("Test Job Title")) {
                System.out.println("Text from element: " + text);
                textFound = true;
                Text = text;
            }
        }
        if(!textFound){
            System.out.println("Text Not Found");
            System.out.println(Text);
        }
    }

    public void ClickDeleteJobTitle() throws InterruptedException {
        Thread.sleep(10000);
        for (WebElement element : ListJobTitles) {
            String text = element.getText();
            if (text.equals("Test Job Title")) {
                System.out.println("Text from element: " + text);

                // Temukan tombol hapus berdasarkan posisi relatif
                WebElement parentElement = element.findElement(By.xpath("..")); // Mengambil elemen parent
                WebElement deleteButton = parentElement.findElement(By.xpath(".//button[1]/i")); // Menyesuaikan XPath berdasarkan tombol hapus di dalam parent

                // Klik tombol hapus
                deleteButton.click();
            }
        }
        Thread.sleep(10000);

    }

    public void ConfrimDeleteJobTitle(){
        wait.until(ExpectedConditions.visibilityOf(confrimDeleteJobTitles));
        confrimDeleteJobTitles.click();
    }

    public void SuccessDeleteJobTitles() throws InterruptedException {
        Thread.sleep(10000);
        boolean textFound = false;
        for (WebElement element : ListJobTitles) {
            String text = element.getText();
            if (text.equals("Test Job Title")) {
                System.out.println("Text from element: " + text);
                textFound = true;
            }
        }
        if(!textFound){
            System.out.println("Text Success To Delete");
        }
    }

    public void clickTopTwoElements()throws InterruptedException {
        // Menggunakan pola XPath umum dengan indeks
        Thread.sleep(10000);
        for (int i=1; i <= 2; i++) {
            String xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[" + i + "]/div/div[1]/div/div/label/span/i";
            try {
                WebElement element= driver.findElement(By.xpath(xpath));
                element.click(); // Klik elemen berdasarkan XPath yang dihasilkan
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + xpath);
            }
        }
        Thread.sleep(10000); // Tunggu 10 detik setelah mengklik
    }

    public void clickAllElementsFromList()throws InterruptedException {
        // Menggunakan pola XPath umum dengan indeks
        Thread.sleep(10000);
        selectAllJobsList.click(); // Klik elemen berdasarkan XPath yang dihasilkan
        Thread.sleep(10000);
    }


    public void checkTopTwoElementsFromList()throws InterruptedException {
        String[] xpaths = {
                "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i",
                "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div[1]/div/div/label/span/i"
        };


        for (int i = 0; i < 2; i++) {
            try {
                WebElement checkboxElement= driver.findElement(By.xpath(xpaths[i] + "/ancestor::label/input")); // Menemukan elemen input checkbox
                if (checkboxElement.isSelected()) {
                    System.out.println("Checkbox at XPath is checked.");
                }else {
                    System.out.println("Checkbox at XPath is NOT checked.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + xpaths[i]);
            }
        }
        Thread.sleep(10000);
    }

    public void clickAndVerifyAllCheckboxes()throws InterruptedException {
        Thread.sleep(10000);

        List<WebElement> checkboxes = CheckboxJobTitles;
        boolean allChecked = true;
        for (WebElement checkbox : checkboxes) {
            try {
                WebElement parentCheckbox= checkbox.findElement(By.xpath("./ancestor::label/input"));
                if (parentCheckbox.isSelected()) {
                    System.out.println("Checkbox is checked.");
                } else {
                    System.out.println("Checkbox is NOT checked.");
                    allChecked = false; // Menandai bahwa tidak semua checkbox sudah dicentang
                }
            } catch (Exception e) {
                System.out.println("Error interacting with checkbox: " + e.getMessage());
            }
        }
        if (allChecked) {
            System.out.println("All checkboxes are successfully checked.");
        } else {
            System.out.println("Some checkboxes are not checked.");
        }
        Thread.sleep(10000); // Tunggu 10 detik setelah memverifikasi semua checkbox
    }




























public void ClickHeaderJobPayGrades(){
        clickButtonHeaderByIndex(2);
        ClickListJob(2);
    }

    public void ClickHeaderJobEmploymentStatus(){
        clickButtonHeaderByIndex(2);
        ClickListJob(3);
    }

    public void ClickHeaderJobCategory(){
        clickButtonHeaderByIndex(2);
        ClickListJob(4);
    }

    public void ClickHeaderJobWorkShift(){
        clickButtonHeaderByIndex(2);
        ClickListJob(5);
    }








}
