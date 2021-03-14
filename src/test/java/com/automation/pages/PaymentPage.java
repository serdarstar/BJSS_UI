package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public PaymentPage(){
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(className="bankwire")
    public WebElement wireTransfer;



}
