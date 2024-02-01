package org.example.pages;

import org.example.CommonPageParams.PageOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageQuestionsList extends PageOptions {

    public HomePageQuestionsList(WebDriver driver) {
        super(driver);
    }


    //Локатор для всех вопросов
    private final By questionButton = (By.xpath(".//*[@class='accordion__button']"));
    //Локатор для всех ответов
    private final By answerButton = (By.xpath(".//*[@class='accordion__panel']"));

    //Метод получения всех вопросов в виде элементов
    private List<WebElement> questions(){
        return driver.findElements(questionButton);
    }

    //Метод получения всех ответов в виде элементов
    private List<WebElement> answers(){
        return driver.findElements(answerButton);
    }

    //Метод кликает по вопросу
    public HomePageQuestionsList clickToQuestionButton(int numberOfElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questions().get(numberOfElement));
        questions().get(numberOfElement).click();
        return this;
    }
    //Получение текста ответа
    public String getAnswerText(int numberOfElement){
        return answers().get(numberOfElement).getText();
    }

}
