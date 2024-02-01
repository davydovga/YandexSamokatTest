package org.example.pages;

import org.example.CommonPageParams.PageOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderListPageTwo extends PageOptions {

    public OrderListPageTwo(WebDriver driver) {
        super(driver);
    }

    //После нажатия кнопки далее находим поле Когда привезти самокат
    private final By appearanceTime = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");

    //После нажатия кнопки далее находим поле Срок Аренды
    private final By rentTime = By.xpath(".//div[@class='Dropdown-control']");


    //После нажатия кнопки далее находим поле Комментарий для курьера
    private final By courierComment = By.xpath(".//*[@placeholder ='Комментарий для курьера']");

    //Путь к кнопке "Да"
    private final By agreementButton = By.xpath(".//*[text()='Да']");
    //Путь к кнопке "Посмотреть статус"
    private final By statusButton = By.xpath(".//*[text()='Посмотреть статус']");






    //Метод для указании даты получения и комментарию курьеру
    public void setCalendarDateAndCourierComment(String date, String comment) {
        driver.findElement(appearanceTime).click();
        driver.findElement(appearanceTime).sendKeys(date);
        driver.findElement(courierComment).sendKeys(comment);
    }
    //Метод для указания срока аренды
    public void setRentTime(String rentTimeOption) {
        driver.findElement(rentTime).click();
        driver.findElement(By.xpath(".//*[text()='"+ rentTimeOption +"']")).click();

    }
    //Метод для выбора цвета самоката
    public void setVehicleColour(String vehicleColour){
        driver.findElement(By.xpath(".//*[text()='" + vehicleColour + "']//parent::label/input")).click();
    }


    //Метод для нажатия кнопок "Да" и "Посмотреть статус"
    // Метод который проверяет что доступна страница статуса заказа
    public void clickAgreementButton(){ // Метод который проверяет что доступна страница статуса заказа
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(agreementButton));
        driver.findElement(agreementButton).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(statusButton));
        driver.findElement(statusButton).isEnabled();
    }

    public void checkSecondPage(String date, String comment,String rentTimeOption, String vehicleColour){
        OrderListPageOne orderListPageOneObj = new OrderListPageOne(driver); // Нужно для кнопки далее

        setCalendarDateAndCourierComment(date,comment);
        setVehicleColour(vehicleColour);
        setRentTime(rentTimeOption);
        orderListPageOneObj.clickForvardOrOrderButton();
        clickAgreementButton();

    }


}
