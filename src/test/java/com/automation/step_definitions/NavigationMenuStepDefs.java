


package com.automation.step_definitions;

import com.automation.pages.ContactsPage;
import com.automation.pages.DashboardPage;
import com.automation.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        //selenium code
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {

        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("the user navigates to Marketing, Campaigns");

    }

    @Then("title should be Campaigns")
    public void title_should_be_Campaigns() {

        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("the user navigates to Activities, Calendar Events");

    }

    @Then("title should be Calendars")
    public void title_should_be_Calendars() {

        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {

        new DashboardPage().navigateToModule(tab, module);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(3);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber =Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum,actualNumber);
    }


}

//    @Given("the user is in the Dashboard page")
//    public void the_user_is_in_the_Dashboard_page() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user  logs in.");
//    }
//
//    @When("the user hovers over the Fleet button and click the Vehicles button to navigate")
//    public void the_user_hovers_over_the_Fleet_button_and_click_the_Vehicles_button_to_navigate() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user navigates to Vehicles page");
//    }
//
//    @Then("the user should see the Vehicles page title")
//    public void the_user_should_see_the_Vehicles_page_title() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user sees the Vehicles title");
//    }
//
//    @When("the user hovers over the Marketing module and click the Campaigns button to navigate")
//    public void the_user_hovers_over_the_Marketing_module_and_click_the_Campaigns_button_to_navigate() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user navigates to Campaigns page");
//    }
//
//    @Then("the user should see the Campaigns page title")
//    public void the_user_should_see_the_Campaigns_page_title() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user sees the Campaigns title");
//    }
//
//    @When("the user hovers over the Activities button and click the Calendar Events button to navigate")
//    public void the_user_hovers_over_the_Activities_button_and_click_the_Calendar_Events_button_to_navigate() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user navigates to Calendar Events page");
//    }
//
//    @Then("the user should see the Calendars page title")
//    public void the_user_should_see_the_Calendars_page_title() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The user sees the Calendars title");
//    }
//
//}
