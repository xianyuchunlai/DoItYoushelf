package com.lanou3g;

import com.lanou3g.api.Weather;
import com.lanou3g.game.Game;
import com.lanou3g.tools.URlrequest;
import com.lanou3g.userdo.UserOperate;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

import static com.lanou3g.constant.Constant.*;
import static javafx.application.Platform.exit;


public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, DocumentException {
//        System.out.println("欢迎使用,输入1：注册，输入2：登陆");
//        switch (input.nextInt()) {
//            case CHOICE_ONE:
//                UserOperate.register();
//                break;
//            case CHOICE_TWO:
//                UserOperate.login();
//                break;
//                default:
//                    System.out.println("输入错误，退出系统");
//                    exit();
//                    break;
//        }
        System.out.println("1,查询天气" + "2,查询手机号归属" + "3,手速游戏");
        switch (input.nextInt()) {
            case WEATHER_CODE:
                System.out.println("Please enter the city where you want to check the weather");
                String city = input.nextLine();
                URlrequest.Weather(city);
            case PHONE_CODE:
                System.out.println("Please enter the phone number you want to query");
                String phno = input.nextLine();
                URlrequest.PhoneNum(phno);
            case GAME_CODE:

        }


        input.close();
    }
}
