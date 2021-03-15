package com.automation.step_definitions;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs extends BasePage {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get(); ->the same as the below
        Driver.get().get(url);
    }

    @When("the user navigates to Sign In page")
    public void theUserNavigatesToSignInPage() {
        HomePage loginPage = new HomePage();
        loginPage.signIn.click();
    }


}
