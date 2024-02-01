package org.example.pages;

import org.example.CommonPageParams.PageOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageOptions {



    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Локатор кнопки Сделать заказ в верху стрницы
    private final By OrderTopButton = By.xpath(".//button[@class ='Button_Button__ra12g']");

    //Локатор кнопки Сделать заказ в середине стрницы
    private final By OrderOnPageButton = By.xpath(".//div[5]/button[text()='Заказать']");


    //Клик на кнопку в верху стрницы
    public void clickToMakeOrderTopButton(){
        driver.findElement(OrderTopButton).click();
    }

    //Клик на кнопку в середине стрницы
    public void clickToMakeOrderOnPageButton(){
        WebElement element = driver.findElement(OrderOnPageButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(OrderOnPageButton).click();
    }



}
