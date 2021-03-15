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

    @FindBy(xpath = "//span[normalize-space()='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//span[.='Order history and details']")
    public WebElement orderHistoryButton;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public WebElement orderDate;

    @FindBy(xpath = "(//a[@class ='color-myaccount'])[1]")
    public WebElement orderReference;

    @FindBy(name = "id_product")
    public WebElement dropdown;

    @FindBy(tagName = "textarea")
    public WebElement commentArea;

    @FindBy(xpath = "//span[.='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "(//tr[@class='first_item item'])[2]/td[2]")
    public WebElement messageText;



}
