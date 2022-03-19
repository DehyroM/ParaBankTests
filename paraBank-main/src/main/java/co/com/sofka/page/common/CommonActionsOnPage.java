package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CommonActionsOnPage {
    private static final Logger LOGGER = Logger.getLogger(CommonActionsOnPage.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is NULL, please check it.\n";
    private WebDriver driver;

    // Explicit Wait:
    private WebDriverWait webDriverExplicitWait;

    private void setWebDriverExplicitWait (WebDriver driver, int seconds){
        try{
            webDriverExplicitWait = new WebDriverWait(driver, seconds);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    // Constructor:

    public CommonActionsOnPage(WebDriver driver, int seconds) {
        try{
            if (driver== null){
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);
            }
            this.driver = driver;
            setWebDriverExplicitWait(driver, seconds);

        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Init POM with Page Factory:
    protected void pageFactoryInitElement(WebDriver driver, Object page){
        PageFactory.initElements(driver, page);
    }

    //Functionalities:

    protected void clearOn(WebElement webElement){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).clear();
    }

    protected void clickOn(WebElement webElement){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).click();
    }

    protected void typeOn(WebElement webElement, CharSequence... keysToSend){
        webDriverExplicitWait.until(visibilityOf(webElement)).sendKeys(keysToSend);
    }

    protected void scrollOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();",webDriverExplicitWait.until(visibilityOf(webElement)));
    }

    protected void doSubmit(WebElement webElement){
        webDriverExplicitWait.until(visibilityOf(webElement)).submit();
    }

    protected String getText(WebElement webElement){
        return webDriverExplicitWait.until(visibilityOf(webElement)).getText();
    }

    protected Boolean isDisplayed(WebElement webElement){
        try{
            return webElement.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
