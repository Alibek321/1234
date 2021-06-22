package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int heroesDoktor = 10;
    public static int[] heroesHealth = {250, 250, 250, 250};
    public static int[] heroesDamage = {20,20,20, 0};
    public static String[] heroesAttackType = {" Physical ", " Magical ","Alibek","Doktor"};

    public static void main(String[] args) {

        fightInfo();
        while (!isFinished()) {

            round();
        }


    }

    public static void round() {
        changeBossDefence();
        bossHit();
        HeroesDoktor();
        heroesHit();
        fightInfo();

    }

    public static void changeBossDefence() {
        Random random1 = new Random();
        int randomIndex = random1.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];

    }


    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println(" !!![[[[[GAME OVER]]]]]!!! ");
            return true;
        }
        return false;
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {


                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random random2 = new Random();
                    int koeff = random2.nextInt(9) + 2;
                    if (bossHealth - heroesDamage[i] * koeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * koeff;
                    }
                    System.out.println(heroesAttackType[i] + "  супер удар  " + heroesDamage[i] * koeff);

                } else {
                    if (bossHealth - heroesHealth[i] < 0) {
                        bossHealth = 0;
                    }

                    bossHealth = bossHealth - heroesDamage[i];

                }

                }

            }
        }
    public static void HeroesDoktor(){

        if (heroesHealth[3]<= 0){
            heroesHealth[3] = 0;
        }else {
            for (int i = 0; i < heroesHealth.length; i++) {
                if(heroesHealth[i]>0){
                    heroesHealth[i] = heroesHealth[i]+heroesDoktor;
                }

            }
        }


    }





            //[[[СТАТИСТИКА БОЯ]]]
    public static void fightInfo() {

                System.out.println("............................");
                System.out.println(" boss health :" + bossHealth);
                System.out.println("_________[[vs]]_____________");
                System.out.println(" Warrior health :" + heroesHealth[0]);
                System.out.println(" Magic health :" + heroesHealth[1]);
                System.out.println(" Alibek health :" + heroesHealth[2]);
                System.out.println(" Doktor health :" + heroesHealth[3]);
                System.out.println("............................ ");

            }

}






