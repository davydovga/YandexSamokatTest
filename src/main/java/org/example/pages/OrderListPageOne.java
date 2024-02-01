package org.example.pages;

import org.example.CommonPageParams.PageOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderListPageOne extends PageOptions {

    public OrderListPageOne(WebDriver driver) {
        super(driver);
    }

    //Находим стоку Имя
    private final By name = By.xpath(".//input[@placeholder ='* Имя']");

    //Находим строку Фамилия
    private final By secondName = By.xpath(".//input[@placeholder ='* Фамилия']");

    //Находим строку адрес
    private final By adress = By.xpath(".//input[@placeholder ='* Адрес: куда привезти заказ']");

    //Находим строку метро
    private final By metro = By.xpath(".//input[@placeholder ='* Станция метро']");


    //Находим строку телефона
    private final By phoneNum = By.xpath(".//input[@placeholder ='* Телефон: на него позвонит курьер']");

    //Находим кнопки Далее\Заказать на первой и второй страницах
    private final By forvardOrOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");



    //Метод заполнения имени, фамилии, адреса и телефона
    public void SendNameValue(String clientName, String clientSecondName, String clientAdress, String clientPhone){
        driver.findElement(name).sendKeys(clientName);
        driver.findElement(secondName).sendKeys(clientSecondName);
        driver.findElement(adress).sendKeys(clientAdress);
        driver.findElement(phoneNum).sendKeys(clientPhone);

    }
    //Метод заполнения станции метро
    public void clickAndSetMetroStation(String metroStationName){
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(metroStationName);
        WebElement element = driver.findElement(By.xpath(".//div[text()='"+ metroStationName +"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[text()='"+ metroStationName +"']")).click();
    }

    //Метод нажатия кнопки далее
    public void clickForvardOrOrderButton() {
        driver.findElement(forvardOrOrderButton).click();
    }

    //Метод в котором все методы выше вызываются в нужном порядке
    public void checkFirstPage(String metroStationName, String clientName, String clientSecondName, String clientAdress, String clientPhone){
        SendNameValue(clientName, clientSecondName, clientAdress, clientPhone);
        clickAndSetMetroStation(metroStationName);
        clickForvardOrOrderButton();

    }



}
