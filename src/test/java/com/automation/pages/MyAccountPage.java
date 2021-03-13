package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BasePage {

    public MyAccountPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "days")
    public WebElement days;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    public WebElement homeButton;


    public Select days(){
        return new Select(days);
    }


}
