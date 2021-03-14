package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    public OrderSummaryPage(){
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(xpath="//span[normalize-space()='I confirm my order']")
    public WebElement confirmation;
}
