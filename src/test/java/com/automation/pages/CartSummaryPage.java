package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {

    public CartSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="cart_summary")
    public WebElement cartSummary;

    @FindBy(xpath="//td[@id='total_product']")
    public WebElement totalProduct;




}
