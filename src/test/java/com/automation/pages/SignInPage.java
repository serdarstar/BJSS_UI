package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    public SignInPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//input[@id='email']")
    public WebElement email;

    @FindBy(css="#passwd")
    public WebElement password;

    @FindBy(xpath="//span[normalize-space()='Sign in']")
    public WebElement signIn;

}
