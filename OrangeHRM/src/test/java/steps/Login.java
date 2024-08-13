package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPages;


import static org.junit.Assert.assertTrue;

public class Login{
    private WebDriver driver;
    private LoginPages loginPages;

    @Given("User In On Login Page")
    public void userinonloginpage(){
        driver = hooks.getDriver();
        loginPages = new LoginPages(driver);
        loginPages.usernamefielddisplayed();
        loginPages.passwordfielddisplayed();
        loginPages.loginbuttondisplayed();
    }

    @When("User Enter Valid Credential")
    public void userentervalidcredential() throws InterruptedException {
        loginPages.enterUsernamevalid();
        loginPages.enterPasswordValid();
        Thread.sleep(2000);
    }

    @Then("User Click Login")
    public void userclicklogin() throws InterruptedException {
        loginPages.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("User Navigate To Homepage Menu")
    public void usernavigatetohomepagemenu(){
        loginPages.dashboardlistisdisplayed();
    }

    @When("^User Enters (.+) and (.+)$")

    public void userentersusernameandpassword1(String username, String Password) throws InterruptedException {
        loginPages.enterUsername(username);
        loginPages.enterPassword(Password);
        Thread.sleep(2000);
    }

    @When("^User Enters (.+) Username$")
    public void user_enters_username(String username){
        loginPages.enterUsername(username);
    }


    @When("^User Enters (.+) Password$")
    public void user_enters_password(String password){
        loginPages.enterUsername(password);
    }


    @Then("User Should Get Error Message Required Username and Password In Login Page")
    public void user_should_get_error_message_required_username_and_password_in_login_page() {
        loginPages.checkErrorMessages();
    }

    @Then("User Should Get Error Message In Login Page")
    public void userShouldGetOutcomeInLoginPage(){
        loginPages.errormessageisdisplayed();
    }
}
