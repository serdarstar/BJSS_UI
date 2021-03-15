package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentShippingPage {

    public PaymentShippingPage(){
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(xpath="//input[@id='cgv']")
    public WebElement agreeToTerms;

    @FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckout;
}
