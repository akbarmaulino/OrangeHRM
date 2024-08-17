package steps;


import org.openqa.selenium.WebDriver;
import pages.AdminPages;
import io.cucumber.java.en.*;
import pages.HomePages;

public class Admin {

    private WebDriver driver;
    private AdminPages adminPages;
    private HomePages homePages;


    @Given("User In On Admin Page")
    public void user_in_on_admin_page() throws InterruptedException {
        driver = hooks.getDriver();
        homePages = new HomePages(driver);
        adminPages = new AdminPages(driver);
        homePages.clickAdminButton();
        Thread.sleep(10000);
    }


    @Given("User Click Job")
    public void user_click_job() throws InterruptedException {
       adminPages.ClickHeaderJobTitles();
    }

    @When("Click Add In Job Titles")
    public void click_add_in_job_titles() {
        adminPages.ClickAddJobTitles();
    }

    @When("User Click Delete Job titles")
    public void user_click_delete_job_titles() throws InterruptedException {
       adminPages.ClickDeleteJobTitle();
    }
    @When("User Click Selected Job Title")
    public void user_click_selected_job_title() throws InterruptedException {
        adminPages.clickTopTwoElements();
    }

    @When("User Click Selected All Job Title")
    public void user_click_selected_all_job_title() throws InterruptedException {
        adminPages.clickAllElementsFromList();
    }

    @And("Click Delete")
    public void click_delete() throws InterruptedException {
        adminPages.ConfrimDeleteJobTitle();
    }

    @And("User Fill Job Title")
    public void user_fill_job_title() {
        adminPages.InputJobTitles();
    }

    @And("User Fill Job Description")
    public void user_fill_job_description() {
        adminPages.InputJobDescription();
    }

    @And("User Fill Job Specification")
    public void user_fill_job_spesification() {
        adminPages.InputFile();
    }

    @And("User Fill Note")
    public void user_fill_note() {
       adminPages.InputNote();
    }

    @And("User Click Save")
    public void user_click_save() throws InterruptedException {
        adminPages.SaveJobTitles();
    }

    @Then("User Success To Add New Job Title")
    public void user_success_to_add_new_job_title() {
        adminPages.SuccesToCreateJobTitles();
    }

    @Then("User Success To Delete Job Title")
    public void user_success_to_delete_job_title() throws InterruptedException {
        adminPages.SuccessDeleteJobTitles();
    }
    @Then("Job Title Success To Select")
    public void job_title_success_to_select_success_to_checkbox() throws InterruptedException {
        adminPages.checkTopTwoElementsFromList();
    }


    @Then("All Job Title Success To Select")
    public void all_job_title_success_to_select() throws InterruptedException {
        adminPages.clickAndVerifyAllCheckboxes();
    }


}
