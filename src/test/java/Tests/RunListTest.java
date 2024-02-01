package Tests;

import TestsStartOptions.OptionStart;
import org.example.pages.HomePage;
import org.example.pages.OrderListPageOne;
import org.example.pages.OrderListPageTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class RunListTest extends OptionStart {
    //Добавь необходимые поля
    private final String metroStationName;
    private final String clientName;
    private final String clientSecondName;
    private final String clientAdress;
    private final String clientPhone;
    private final String date;
    private final String comment;
    private final String rentTimeOption;
    private final String vehicleColour;



    public RunListTest(String metroStationName, String clientName, String clientSecondName, String clientAdress, String clientPhone, String date, String comment, String rentTimeOption, String vehicleColour) {
        this.metroStationName = metroStationName;
        this.clientName = clientName;
        this.clientSecondName = clientSecondName;
        this.clientAdress = clientAdress;
        this.clientPhone = clientPhone;
        this.date = date;
        this.comment = comment;
        this.rentTimeOption = rentTimeOption;
        this.vehicleColour = vehicleColour;
    }

    @Parameterized.Parameters
    public static Object[][] getValues() {
        return new Object[][]{
                {"Черкизовская", "Имя", "Фамилия", "Адрес", "78005553535", "20.04.2024", "Комментарий для курьера", "четверо суток", "чёрный жемчуг"},
                {"Сокольники", "Имяями", "Фамилияяили", "Адрес длинный", "78006663939", "11.11.2029", "Если вы это читаете...", "трое суток","серая безысходность"}
        };
    }



    @Test
    public void methodForTestStartsFromTopButton(){
        HomePage homePageObj = new HomePage(driver);
        OrderListPageOne orderListPageOneObj = new OrderListPageOne(driver);
        OrderListPageTwo orderListPageTwoObj = new OrderListPageTwo(driver);

        homePageObj.clickToMakeOrderTopButton(); //Запуск через кнопку вверху страницы
        orderListPageOneObj.checkFirstPage(metroStationName, clientName,clientSecondName ,clientAdress ,clientPhone);
        orderListPageTwoObj.checkSecondPage(date,comment,rentTimeOption, vehicleColour);
    }
    @Test
    public void methodForTestStartsFromOnPageButton(){
        HomePage homePageObj = new HomePage(driver);
        OrderListPageOne orderListPageOneObj = new OrderListPageOne(driver);
        OrderListPageTwo orderListPageTwoObj = new OrderListPageTwo(driver);

        homePageObj.clickToMakeOrderOnPageButton(); //Запуск через кнопку в середине страницы
        orderListPageOneObj.checkFirstPage(metroStationName, clientName,clientSecondName ,clientAdress ,clientPhone);
        orderListPageTwoObj.checkSecondPage(date,comment,rentTimeOption,vehicleColour);
    }
}








