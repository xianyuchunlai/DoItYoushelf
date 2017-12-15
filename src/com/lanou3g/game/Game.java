package com.lanou3g.game;

import java.util.Random;
import java.util.Scanner;

import static com.lanou3g.constant.Constant.CHOICE_ONE;
import static com.lanou3g.constant.Constant.CHOICE_THREE;
import static com.lanou3g.constant.Constant.CHOICE_TWO;

public class Game {
    static  Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {


       long first = System.currentTimeMillis();

        System.out.println("请选游戏难度1，简单。2，中等。3，复杂。");
        switch (input.nextInt()){
            case CHOICE_ONE:
            Thread.sleep(3000);
                System.out.println("游戏3秒后开始");
                break;
            case CHOICE_TWO:
                Thread.sleep(2000);
                System.out.println("游戏2秒后开始");
                break;
            case CHOICE_THREE:
                Thread.sleep(1000);
                System.out.println("游戏1秒后开始");
                break;
                default:
                    System.out.println("神经病");
        }

    }



}
