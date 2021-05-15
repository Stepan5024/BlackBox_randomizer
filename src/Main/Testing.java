package Main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {

        int[] index2 = new int[7];
        index2[0] = 0; // Лот 1
        index2[1] = 11; // Лот 2
        index2[2] = 1; // Лот 3
        index2[3] = 0; // Скидка 10
        index2[4] = 0; //  Скидка 20
        index2[5] = 0; //  Скидка 30
        index2[6] = 0; //  Скидка 40

        int[] costing = new int[8]; // массив цен в бобрах
        costing[0] = 3000;
        costing[1] = 1500;
        costing[2] = 250;
        costing[3] = 250;
        costing[4] = 500;
        costing[5] = 750;
        costing[6] = 1000;
        costing[7] = 1500;
        //System.out.println(RoundUP(-0.2));
        System.out.println("лояльность " + getTruetness(costing, index2));

    }

    public static double getTruetness(int[] costs, int[] indexs) {
        double costLot = costs[7]; // стоимость лота
        double loyalty = 0;
        int sumPeopleHappy = Arrays.stream(indexs).sum();
        int sumAllPeople = sumPeopleHappy;
        int[] unhappy = new int[7];
        for (int i = 0; i < unhappy.length; i++) {
            unhappy[i] = RoundUP(indexs[i] * (costs[i] - costLot) / costLot);
            if(unhappy[i] > 0){
                unhappy[i] = RoundUP(unhappy[i] / 2.0);
            }

            unhappy[i] = Math.abs(unhappy[i]);
            System.out.println(unhappy[i] + "несчастных");
            sumPeopleHappy -= unhappy[i];
            System.out.println(sumPeopleHappy + " сумма счастливых");
        }

        loyalty = (double) sumPeopleHappy / sumAllPeople;

        return loyalty;
    }
    public static int RoundUP(double number){

        return  new BigDecimal(number).setScale(0,RoundingMode.UP).intValue();
    }

}
