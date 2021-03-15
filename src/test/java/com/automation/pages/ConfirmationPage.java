package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage{

    public ConfirmationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

}
