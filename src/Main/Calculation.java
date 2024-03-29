package Main;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

import static Main.CalcFrame.*;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Calculation {
    public static InputData inputData;
    public static double ALLOWANCE = (double) 0.05;
    public static int WRITEOFFBOBER = 20;//списание 20 % бобров
    public static int I = 20;
    public static int J = 20;
    public static int K = 20;
    int price1BlackBox = 0;
    int priceLoots1 = 0;
    int priceLoots2 = 0;
    int priceLoots3 = 0;
    int zatracheno = 0;

    public static void FindValue(InputData input) {

        inputData = input;
        int cost1 = input.getLotPrices()[0]; // ввод стоимости лота 1, 2, 3 в рублях
        int cost2 = input.getLotPrices()[1];
        int cost3 = input.getLotPrices()[2];
        int cost1Bobr = input.getLotPrices()[3];
        int cost2Bobr = input.getLotPrices()[4];
        int cost3Bobr = input.getLotPrices()[5];
        int costBudget = input.getCostBudget()[0]; // ввод бюджета в руб.
        int costBudgetBobr = input.getCostBudget()[1]; // ввод бюджета в Б.
        int pricePer1BoxBobr = input.getPricePer1Box(); // ввод цены лота в Б.

        int discount10 = input.getValueOfDiscount()[0]; // скидка в 10 % в рублях ср. знач
        int discount20 = input.getValueOfDiscount()[1]; // скидка в 20 % в рублях ср. знач
        int discount30 = input.getValueOfDiscount()[2]; // скидка в 30 % в рублях ср. знач
        int discount40 = input.getValueOfDiscount()[3]; // скидка в 40 % в рублях ср. знач

        int discount10Bobr = input.getValueOfDiscount()[4];
        int discount20Bobr = input.getValueOfDiscount()[5];
        int discount30Bobr = input.getValueOfDiscount()[6];
        int discount40Bobr = input.getValueOfDiscount()[7];

        double BudgetAllowance = costBudget - costBudget * 0.3 + costBudget * ALLOWANCE; // превысить бюджет на 5% с четом залога 30% на скидки
        double BudgetAllowanceDown = costBudget - costBudget * 0.3 - costBudget * ALLOWANCE; // закупиться меньше бюджета на 5% с четом залога 30% на скидки
        out.println("BudgetAllowance = " + BudgetAllowance);
        out.println("BudgetAllowanceDown  = " + BudgetAllowanceDown);


        // out.println("Цена бокса " + pricePer1BoxBobr + " стоимость лота 1 " + cost1Bobr+ " стоимость лота 2 " + cost2Bobr + " стоимость лота 3 " + cost3Bobr );
        int[] pricesRubVirgin = new int[7];
        pricesRubVirgin[0] = (int) cost1;
        pricesRubVirgin[1] = (int) cost2;
        pricesRubVirgin[2] = (int) cost3;
        pricesRubVirgin[3] = discount10;
        pricesRubVirgin[4] = discount20;
        pricesRubVirgin[5] = discount30;
        pricesRubVirgin[6] = discount40;

        int[] pricesRub = new int[7];
        pricesRub[0] = (int) cost1;
        pricesRub[1] = (int) cost2;
        pricesRub[2] = (int) cost3;
        pricesRub[3] = discount10;
        pricesRub[4] = discount20;
        pricesRub[5] = discount30;
        pricesRub[6] = discount40;


        ArrayList<double[]> maxLoyality = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            double[] temp = new double[11]; // индексы 0,1,2,3,4,5,6 это товары и скидки значение цены в руб/бобр
            temp[7] = -1000000;// абсолютный минимум лояльности
            temp[8] = -1000000;// минимум выгоды компании

            maxLoyality.add(temp);
        }

        int[] costing = new int[8]; // массив цен в бобрах
        costing[0] = cost1Bobr;
        costing[1] = cost2Bobr;
        costing[2] = cost3Bobr;
        costing[3] = discount10Bobr;
        costing[4] = discount20Bobr;
        costing[5] = discount30Bobr;
        costing[6] = discount40Bobr;
        costing[7] = pricePer1BoxBobr;

        if (cost1Bobr + cost2Bobr + cost3Bobr > 3800) {
            for (int i = 3; i < 7; i++) {
                costing[i] += 500;
            }
        }
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                for (int k = 0; k < K; k++) {
                    for (int l = (int) (pricePer1BoxBobr - pricePer1BoxBobr * 0.8); l < pricePer1BoxBobr * 2; l = l + 100) {

                        costing[7] = l;
                        if(fixscheck.isSelected()){
                            costing[7] = pricePer1BoxBobr;
                        }
                        if (costing[7] > costing[1]) {
                            continue;
                        }
                        for (JTextField[] mas : listAboutSetkaForFirstLot) {
                            try {
                                if (i >= Integer.parseInt(mas[0].getText() + "") && i <= Integer.parseInt(mas[1].getText() + "")) {
                                    //   out.println("Цена из сетки " + i + " было " + " pricesRub[0] " +" на " + mas[2].getText());
                                    pricesRub[0] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[0] = pricesRubVirgin[0];
                                }

                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] mas : listAboutSetkaForSecondLot) {
                            try {
                                if (j >= Integer.parseInt(mas[0].getText() + "") && j <= Integer.parseInt(mas[1].getText() + "")) {
                                    //    out.println("Цена из сетки " + i + " было " + " pricesRub[0] " +" на " + mas[2].getText());
                                    pricesRub[1] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[0] = pricesRubVirgin[0];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] mas : listAboutSetkaForTherdLot) {
                            try {
                                if (k >= Integer.parseInt(mas[0].getText() + "") && k <= Integer.parseInt(mas[1].getText() + "")) {
                                    //    out.println("Цена из сетки " + i + " было " +  pricesRub[0]  + " на " + mas[2].getText());
                                    pricesRub[2] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[0] = pricesRubVirgin[0];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        int[] index = new int[3];
                        index[0] = i; // Лот 1
                        index[1] = j; // Лот 2
                        index[2] = k; // Лот 3


                        double totalRub = GetRealCost(index, pricesRub);
                        //double totalBobr= GetRealCost(index, pricesRub);

                        int zatracheno = (int) totalRub;

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index, costing[7]) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);


                        double trueness = getTruetness(costing, index);


                        if ((totalRub > BudgetAllowanceDown && totalRub < BudgetAllowance) && (BenefitsForCompanyPerProcentBobr > 0)) {

                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);


                            if ((temp[7] <= trueness) || trueness < 0.8) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);

                                for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = zatracheno;
                                temp[10] = costing[7];

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

                            }


                        }
                    }

                }

            }
        }


        int number = 0;
        double loyal = maxLoyality.get(number)[7];
        for (int i = 0; i < maxLoyality.size(); i++) {
            double temployal = maxLoyality.get(i)[7];


            if (temployal > loyal) {
                number = i;
                loyal = temployal;

            }
        }

        out.println("Макс " + number + " " + loyal);
        out.println("Лучшая подборка по лояльности: ");
        for (double[] doubles : maxLoyality) {
            int sum = (int) (doubles[0] + doubles[1] + doubles[2]);
            out.println("Такое значение подходит сумма = " + sum + " коэфф " + doubles[0] + " " + doubles[1] + " " + doubles[2] + " " + doubles[3] + " " + doubles[4] + " " + doubles[5]);

        }
        out.println("Цена бокса до " + costing[7]);
        costing[7] = (int) maxLoyality.get(number)[10];
        out.println("Цена бокса после " + costing[7]);
        if ((int) (maxLoyality.get(number)[0] + maxLoyality.get(number)[1] + maxLoyality.get(number)[2]) == 0 & I < 100) {
            I += 20;
            J += 20;
            K += 20;

            FindValue(inputData);
        }


        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    for (int l = 0; l < 15; l++) {


                        int[] index2 = new int[7];
                        index2[0] = (int) maxLoyality.get(number)[0]; // Кол-во Лота 1
                        index2[1] = (int) maxLoyality.get(number)[1]; // Кол-во Лота 2
                        index2[2] = (int) maxLoyality.get(number)[2]; // Кол-во Лота 3
                        index2[3] = i; // Скидка 10
                        index2[4] = j; //  Скидка 20
                        index2[5] = k; //  Скидка 30
                        index2[6] = l; //  Скидка 40

                        for (JTextField[] mas : listAboutSetkaForFirstLot) {
                            try {
                                if (index2[0] >= Integer.parseInt(mas[0].getText() + "") && index2[0] <= Integer.parseInt(mas[1].getText() + "")) {
                                    //   out.println("Цена из сетки " + i + " было " + " pricesRub[0] " +" на " + mas[2].getText());
                                    pricesRub[0] = Integer.parseInt(mas[2].getText() + "");

                                }else {
                                    pricesRub[0] = pricesRubVirgin[0];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] mas : listAboutSetkaForSecondLot) {
                            try {
                                if (index2[1] >= Integer.parseInt(mas[0].getText() + "") && index2[1] <= Integer.parseInt(mas[1].getText() + "")) {
                                    //    out.println("Цена из сетки " + i + " было " + " pricesRub[0] " +" на " + mas[2].getText());
                                    pricesRub[1] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[1] = pricesRubVirgin[1];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }

                        for (JTextField[] mas : listAboutSetkaForTherdLot) {
                            try {
                                if (index2[2] >= Integer.parseInt(mas[0].getText() + "") && index2[2] <= Integer.parseInt(mas[1].getText() + "")) {
                                    //    out.println("Цена из сетки " + i + " было " +  pricesRub[0]  + " на " + mas[2].getText());
                                    pricesRub[2] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[2] = pricesRubVirgin[2];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }


                        double totalRub = GetRealCost(index2, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index2, (int)maxLoyality.get(number)[10]) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);

                        double trueness = getTruetness(costing, index2);
                        // double trueness = getTruetness2(costing, index2);

                        if ((totalRub > costBudget * 0.95 && totalRub < costBudget * 1.05) && (BenefitsForCompanyPerProcentBobr > 0)) {
                            // out.println("Я здесь");
                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);


                            if ((temp[7] <= trueness)) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);
                                out.println("Я здесь2");
                                for (int o = 0; o < index2.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index2[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = totalRub;
                                temp[10] =(int)maxLoyality.get(number)[10];

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

                            }


                        }

                    }

                }

            }


        }

        int[] index2 = new int[7];
        for (int i = 0; i < index2.length; i++) {
            index2[i] = (int) maxLoyality.get(number)[i];
        }

        int totalRub = GetRealCost(index2, pricesRub);
        out.println("Получился результат затрачено " + totalRub + " Допустимо " + costBudget * 0.95 + " " + costBudget * 1.05);
        if (totalRub > costBudget * 0.95 && totalRub < costBudget * 1.05 && maxLoyality.get(number)[0] != 0) {
            // все ок выводим результат
            int maxSum = 0;
            for (int i = 0; i < 7; i++) {
                maxSum += (int) maxLoyality.get(number)[i];
            }
            //Вывод на экран


            priceBLot1.setText(cost1Bobr + "");
            priceBLot2.setText(cost2Bobr + "");
            priceBLot3.setText(cost3Bobr + "");

            countLot1.setText(new BigDecimal((int) maxLoyality.get(number)[0]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot2.setText(new BigDecimal((int) maxLoyality.get(number)[1]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot3.setText(new BigDecimal((int) maxLoyality.get(number)[2]).setScale(0, RoundingMode.UP).doubleValue() + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            if (pricePer1BoxBobr == maxLoyality.get(number)[10]) {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б.");
                buyerValue.setText(pricePer1BoxBobr * maxSum + " Б. или " + pricePer1BoxBobr * maxSum * 2 + " руб.");
            } else {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б." + "рекомендуемая стоимость лота в Б. " + maxLoyality.get(number)[10]);
                buyerValue.setText(maxLoyality.get(number)[10] * maxSum + " Б. или " + maxLoyality.get(number)[10] * maxSum * 2 + " руб. по рек. цене в " + maxLoyality.get(number)[10]);
            }
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");


            countDiscount10.setText(maxLoyality.get(number)[3] + "");
            countDiscount20.setText(maxLoyality.get(number)[4] + "");
            countDiscount30.setText(maxLoyality.get(number)[5] + "");
            countDiscount40.setText(maxLoyality.get(number)[6] + "");
            likelihoodDiscount10.setText(new BigDecimal(maxLoyality.get(number)[3] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount20.setText(new BigDecimal(maxLoyality.get(number)[4] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount30.setText(new BigDecimal(maxLoyality.get(number)[5] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount40.setText(new BigDecimal(maxLoyality.get(number)[6] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");


        } else {
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    for (int k = 0; k < K; k++) {
                        for (int l = (int) (pricePer1BoxBobr - pricePer1BoxBobr * 0.8); l < pricePer1BoxBobr * 3; l = l + 100) {

                            costing[7] = l;
                            if(fixscheck.isSelected()){
                                costing[7] = pricePer1BoxBobr;
                            }
                            for (JTextField[] mas : listAboutSetkaForFirstLot) {
                                if (i >= Integer.parseInt(mas[0].getText() + "") && i <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[0] = Integer.parseInt(mas[2].getText() + "");

                                }else {
                                    pricesRub[0] = pricesRubVirgin[0];
                                }
                            }
                            for (JTextField[] mas : listAboutSetkaForSecondLot) {
                                if (j >= Integer.parseInt(mas[0].getText() + "") && j <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[1] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[1] = pricesRubVirgin[1];
                                }
                            }
                            for (JTextField[] mas : listAboutSetkaForTherdLot) {
                                if (k >= Integer.parseInt(mas[0].getText() + "") && k <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[2] = Integer.parseInt(mas[2].getText() + "");
                                }else {
                                    pricesRub[2] = pricesRubVirgin[2];
                                }
                            }

                            int[] index = new int[3];
                            index[0] = i; // Лот 1
                            index[1] = j; // Лот 2
                            index[2] = k; // Лот 3


                            double totalRub3 = GetRealCost(index, pricesRub);
                            //double totalBobr= GetRealCost(index, pricesRub);

                            int zatracheno = GetRealCost(index, pricesRub);

                            double BenefitsForCompanyBobr = ReceivedOnUsers(index, costing[7]) * 2 - totalRub3;
                            double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub3);


                            double trueness = getTruetness(costing, index);


                            if (totalRub < costBudget * 1.05 && (BenefitsForCompanyPerProcentBobr > 0) && totalRub > costBudget * 0.9) {

                                double[] temp = maxLoyality.get(5);
                                double[] temp1 = maxLoyality.get(4);
                                double[] temp2 = maxLoyality.get(3);
                                //  out.println("Зашел суда " + temp[7]);

                                if ((temp[7] * 0.94 <= trueness)) {
                                    System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                    System.arraycopy(temp, 0, temp1, 0, temp.length);

                                    for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                        temp[o] = index[o];
                                    }

                                    temp[7] = trueness;
                                    temp[8] = BenefitsForCompanyPerProcentBobr;
                                    temp[9] = zatracheno;
                                    temp[10] = costing[7];

                                    maxLoyality.set(3, temp2);
                                    maxLoyality.set(4, temp1);
                                    maxLoyality.set(5, temp);

                                }


                            }

                        }

                    }
                }
            }
            number = 0;
            loyal = maxLoyality.get(number)[7];
            for (int i = 0; i < maxLoyality.size(); i++) {
                double temployal = maxLoyality.get(i)[7];

                if (temployal > loyal) {
                    number = i;
                    loyal = temployal;

                }
            }

            out.println("Макс " + number + " " + loyal);
            out.println("Лучшая подборка по лояльности: ");
            for (double[] doubles : maxLoyality) {
                int sum = (int) (doubles[0] + doubles[1] + doubles[2]);
                out.println("Такое значение подходит сумма = " + sum + " коэфф " + doubles[0] + " " + doubles[1] + " " + doubles[2] + " " + doubles[3] + " " + doubles[4] + " " + doubles[5]);

            }
            int maxSum = 0;
            for (int i = 0; i < 7; i++) {
                maxSum += (int) maxLoyality.get(number)[i];
            }
            priceBLot1.setText(costing[0] + "");
            priceBLot2.setText(costing[1] + "");
            priceBLot3.setText(costing[3] + "");

            countLot1.setText(((int) maxLoyality.get(number)[0]) + "");
            countLot2.setText(((int) maxLoyality.get(number)[1]) + "");
            countLot3.setText(((int) maxLoyality.get(number)[2]) + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            if (pricePer1BoxBobr == maxLoyality.get(number)[10]) {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б.");
                buyerValue.setText(pricePer1BoxBobr * maxSum + " Б. или " + pricePer1BoxBobr * maxSum * 2 + " руб.");

            } else {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б." + " или рек. цена лота в Б. " + maxLoyality.get(number)[10]);
                buyerValue.setText(maxLoyality.get(number)[10] * maxSum + " Б. или " + maxLoyality.get(number)[10] * maxSum * 2 + " руб. по рек. цене в " + maxLoyality.get(number)[10]);
            }
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");

            countDiscount10.setText((int) maxLoyality.get(number)[3] + "");
            countDiscount20.setText((int) maxLoyality.get(number)[4] + "");
            countDiscount30.setText((int) maxLoyality.get(number)[5] + "");
            countDiscount40.setText((int) maxLoyality.get(number)[6] + "");
            likelihoodDiscount10.setText(new BigDecimal(maxLoyality.get(number)[3] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount20.setText(new BigDecimal(maxLoyality.get(number)[4] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount30.setText(new BigDecimal(maxLoyality.get(number)[5] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount40.setText(new BigDecimal(maxLoyality.get(number)[6] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");

        }


    }

    public static void FindMaxBenefValue(InputData input) {

        inputData = input;
        int cost1 = input.getLotPrices()[0]; // ввод стоимости лота 1, 2, 3 в рублях
        int cost2 = input.getLotPrices()[1];
        int cost3 = input.getLotPrices()[2];
        int cost1Bobr = input.getLotPrices()[3];
        int cost2Bobr = input.getLotPrices()[4];
        int cost3Bobr = input.getLotPrices()[5];
        int costBudget = input.getCostBudget()[0]; // ввод бюджета в руб.
        int costBudgetBobr = input.getCostBudget()[1]; // ввод бюджета в Б.
        int pricePer1BoxBobr = input.getPricePer1Box(); // Цена 1 бокса

        int discount10 = input.getValueOfDiscount()[0]; // скидка в 10 % в рублях ср. знач
        int discount20 = input.getValueOfDiscount()[1]; // скидка в 20 % в рублях ср. знач
        int discount30 = input.getValueOfDiscount()[2]; // скидка в 30 % в рублях ср. знач
        int discount40 = input.getValueOfDiscount()[3]; // скидка в 40 % в рублях ср. знач

        int discount10Bobr = input.getValueOfDiscount()[4];
        int discount20Bobr = input.getValueOfDiscount()[5];
        int discount30Bobr = input.getValueOfDiscount()[6];
        int discount40Bobr = input.getValueOfDiscount()[7];

        double BudgetAllowance = costBudget - costBudget * 0.2 ; // превысить бюджет на 5% с четом залога 20% на скидки
        double BudgetAllowanceDown = costBudget - costBudget * 0.2 - costBudget * ALLOWANCE; // закупиться меньше бюджета на 5% с четом залога 20% на скидки
        out.println("BudgetAllowance = " + BudgetAllowance);
        out.println("BudgetAllowanceDown  = " + BudgetAllowanceDown);

        ArrayList<double[]> maxLoyality = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            double[] temp = new double[11]; // индексы 0,1,2,3,4,5,6 это товары и скидки значение цены в руб/бобр
            temp[7] = -1000000;// абсолютный минимум лояльности
            temp[8] = -1000000;// минимум выгоды компании

            maxLoyality.add(temp);
        }

        int[] pricesRubVirgin = new int[7];
        pricesRubVirgin[0] = (int) cost1;
        pricesRubVirgin[1] = (int) cost2;
        pricesRubVirgin[2] = (int) cost3;
        pricesRubVirgin[3] = discount10;
        pricesRubVirgin[4] = discount20;
        pricesRubVirgin[5] = discount30;
        pricesRubVirgin[6] = discount40;

        int[] pricesRub = new int[7];
        pricesRub[0] = (int) cost1;
        pricesRub[1] = (int) cost2;
        pricesRub[2] = (int) cost3;
        pricesRub[3] = discount10;
        pricesRub[4] = discount20;
        pricesRub[5] = discount30;
        pricesRub[6] = discount40;

        int[] costing = new int[8]; // массив цен в бобрах
        costing[0] = cost1Bobr;
        costing[1] = cost2Bobr;
        costing[2] = cost3Bobr;
        costing[3] = discount10Bobr;
        costing[4] = discount20Bobr;
        costing[5] = discount30Bobr;
        costing[6] = discount40Bobr;
        costing[7] = pricePer1BoxBobr;

        if (cost1Bobr + cost2Bobr + cost3Bobr > 3800) {
            for (int i = 3; i < 7; i++) {
                costing[i] += 500;
            }
        }

        for (int i = 1; i < I; i++) {
            for (int j = 1; j < J; j++) {
                for (int k = 1; k < K; k++) {
                    for (int l = (int) (pricePer1BoxBobr - pricePer1BoxBobr * 0.8); l < pricePer1BoxBobr * 2; l = l + 100) {

                        costing[7] = l;
                        if(fixscheck.isSelected()){
                            costing[7] = pricePer1BoxBobr;
                        }
                        if (costing[7] > costing[1]) {
                            continue;
                        }

                        for (JTextField[] jTextFields : listAboutSetkaForFirstLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (i >= Integer.parseInt(mas[0].getText() + "") && i <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[0] = Integer.parseInt(mas[2].getText() + "");

                                }else{
                                    pricesRub[0] = pricesRubVirgin[0];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] jTextFields : listAboutSetkaForSecondLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (j >= Integer.parseInt(mas[0].getText() + "") && j <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[1] = Integer.parseInt(mas[2].getText() + "");
                                }else{
                                    pricesRub[1] = pricesRubVirgin[1];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] jTextFields : listAboutSetkaForTherdLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (k >= Integer.parseInt(mas[0].getText() + "") && k <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[2] = Integer.parseInt(mas[2].getText() + "");
                                }else{
                                    pricesRub[2] = pricesRubVirgin[2];
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }

                        int[] index = new int[7];
                        index[0] = i; // Лот 1
                        index[1] = j; // Лот 2
                        index[2] = k; // Лот 3

                        int e = 3_000_999_9;

                        double totalRub = GetRealCost(index, pricesRub);
                        //double totalBobr= GetRealCost(index, pricesRub);

                        int zatracheno = (int) totalRub;

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index, costing[7]) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);


                        double trueness = getTruetness(costing, index);

                        if (totalRub > BudgetAllowanceDown && (totalRub < BudgetAllowance) && (BenefitsForCompanyPerProcentBobr > 10 && BenefitsForCompanyPerProcentBobr < WRITEOFFBOBER)) {

                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);

                            if (temp[8] <= BenefitsForCompanyPerProcentBobr && BenefitsForCompanyPerProcentBobr < 14) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);

                                for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = zatracheno;
                                temp[10] = costing[7];

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

                            }
                        }

                    }

                }

            }
        }
        int number = 0;
        double loyal = maxLoyality.get(number)[7];
        for (int i = 0; i < maxLoyality.size(); i++) {
            double temployal = maxLoyality.get(i)[7];


            if (temployal > loyal) {
                number = i;
                loyal = temployal;

            }
        }
        out.println("Лучшая подборка по лояльности: ");
        for (int i = 0; i < maxLoyality.size(); i++) {
            int sum = (int) (maxLoyality.get(i)[0] + maxLoyality.get(i)[1] + maxLoyality.get(i)[2]);
            out.println("Такое значение подходит сумма = " + sum + " коэфф " + maxLoyality.get(i)[0] + " " + maxLoyality.get(i)[1] + " " + maxLoyality.get(i)[2] + " " + maxLoyality.get(i)[3] + " " + maxLoyality.get(i)[4] + " " + maxLoyality.get(i)[5]);

        }
        if ((int) (maxLoyality.get(4)[0] + maxLoyality.get(4)[1] + maxLoyality.get(4)[2]) == 0 && (I < 100 || J < 90 || K < 100)) {
            I += 20;
            J += 20;
            K += 20;
            out.println("Рекурсия поиска макс выгоды");
            FindMaxBenefValue(inputData);
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    for (int l = 0; l < 10; l++) {

                        int[] index2 = new int[7];
                        index2[0] = (int) maxLoyality.get(number)[0]; // Лот 1
                        index2[1] = (int) maxLoyality.get(number)[1]; // Лот 2
                        index2[2] = (int) maxLoyality.get(number)[2]; // Лот 3
                        index2[3] = i; // Скидка 10
                        index2[4] = j; //  Скидка 20
                        index2[5] = k; //  Скидка 30
                        index2[6] = l; //  Скидка 40

                        int pricetempPer1Box = (int) maxLoyality.get(number)[10];

                        if(fixscheck.isSelected()){
                            costing[7] = pricePer1BoxBobr;
                        }

                        for (JTextField[] jTextFields : listAboutSetkaForFirstLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (index2[0] >= Integer.parseInt(mas[0].getText() + "") && index2[0] <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[0] = Integer.parseInt(mas[2].getText() + "");

                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] jTextFields : listAboutSetkaForSecondLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (index2[1] >= Integer.parseInt(mas[0].getText() + "") && index2[1] <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[1] = Integer.parseInt(mas[2].getText() + "");
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }
                        for (JTextField[] jTextFields : listAboutSetkaForTherdLot) {
                            try {
                                JTextField[] mas = jTextFields;
                                if (index2[2] >= Integer.parseInt(mas[0].getText() + "") && index2[2] <= Integer.parseInt(mas[1].getText() + "")) {
                                    pricesRub[2] = Integer.parseInt(mas[2].getText() + "");
                                }
                            } catch (NumberFormatException ex) {
                            }
                        }


                        double totalRub = GetRealCost(index2, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index2, pricetempPer1Box) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);

                        //double trueness = getTruetness2(costing, index2);
                        double trueness = getTruetness(costing, index2);

                        if ((totalRub > costBudget * 0.95 && totalRub < costBudget) && (BenefitsForCompanyPerProcentBobr > 0) && BenefitsForCompanyPerProcentBobr < WRITEOFFBOBER) {
                            // out.println("Я здесь");
                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);


                            if ((temp[8] <= BenefitsForCompanyPerProcentBobr)) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);

                                for (int o = 0; o < index2.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index2[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = totalRub;
                                temp[10] = pricetempPer1Box;

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

                            }


                        }

                    }

                }

            }

        }
        int[] index2 = new int[7];
        for (int i = 0; i < index2.length; i++) {
            index2[i] = (int) maxLoyality.get(number)[i];
        }

        int totalRub = GetRealCost(index2, pricesRub);
        out.println("Получился результат затрачено " + totalRub + " Допустимо " + costBudget * 0.95 + " " + costBudget * 1.05);
        if (totalRub > costBudget * 0.95 && totalRub < costBudget * 1.05 && maxLoyality.get(number)[0] != 0) {
            // все ок выводим результат
            int maxSum = 0;
            for (int i = 0; i < 7; i++) {
                maxSum += (int) maxLoyality.get(number)[i];
            }
            //Вывод на экран


            priceBLot1.setText(costing[0] + "");
            priceBLot2.setText(costing[1] + "");
            priceBLot3.setText(costing[2] + "");

            countLot1.setText(new BigDecimal((int) maxLoyality.get(number)[0]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot2.setText(new BigDecimal((int) maxLoyality.get(number)[1]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot3.setText(new BigDecimal((int) maxLoyality.get(number)[2]).setScale(0, RoundingMode.UP).doubleValue() + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");
            if (pricePer1BoxBobr == maxLoyality.get(number)[10]) {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б.");
                buyerValue.setText(pricePer1BoxBobr * maxSum + " Б. или " + pricePer1BoxBobr * maxSum * 2 + " руб.");
            } else {
                stoimost1Lota.setText(pricePer1BoxBobr + " Б." + " или рек. цена лота в Б. " + maxLoyality.get(number)[10]);
                buyerValue.setText(maxLoyality.get(number)[10] * maxSum + " Б. или " + maxLoyality.get(number)[10] * maxSum * 2 + " руб. по рек. цене в " + maxLoyality.get(number)[10]);
            }
            countDiscount10.setText(maxLoyality.get(number)[3] + "");
            countDiscount20.setText(maxLoyality.get(number)[4] + "");
            countDiscount30.setText(maxLoyality.get(number)[5] + "");
            countDiscount40.setText(maxLoyality.get(number)[6] + "");
            likelihoodDiscount10.setText(new BigDecimal(maxLoyality.get(number)[3] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount20.setText(new BigDecimal(maxLoyality.get(number)[4] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount30.setText(new BigDecimal(maxLoyality.get(number)[5] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount40.setText(new BigDecimal(maxLoyality.get(number)[6] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");


        }

    }

    public static double getTruetness(int[] costs, int[] indexs) {
        // массив indexs хранит значения покупки лота 1, лота 2, ... лота7 . То есть если например 4 купили лот1, 8 лот2, 0 чел купили лот 3 и тд
        // массив costs хранить значения цены ПРОДАЖИ семи лотов
        double costLot = costs[7]; // последний элемент хранит стоимость лота
        double loyalty = 0;
        int sumPeopleHappy = Arrays.stream(indexs).sum(); // Сумма всех покупателей, то есть всех лотов которые куплены. То есть кол-во блэкбоксов
        int sumAllPeople = sumPeopleHappy;
        int[] unhappy = new int[indexs.length]; // массив недовольных длиной index.length
        for (int i = 0; i < unhappy.length; i++) {
            unhappy[i] = RoundUP(indexs[i] * (costs[i] - costLot) / costLot); // RoundUP округл вверх

            if (unhappy[i] > 0) {
                unhappy[i] = RoundUP(unhappy[i] / 2.0);
            }
            if (costs[i] == costLot) {
                unhappy[i] = RoundUP(unhappy[i] * 0.25);
            }
            unhappy[i] = Math.abs(unhappy[i]);

            // System.out.println(unhappy[i] + "несчастных");
            sumPeopleHappy -= unhappy[i];
            // System.out.println(sumPeopleHappy + " сумма счастливых");
        }

        loyalty = (double) sumPeopleHappy / sumAllPeople;

        return loyalty;
    }

    public static int RoundUP(double number) {

        return new BigDecimal(number).setScale(0, RoundingMode.UP).intValue();
    }


    private double GetProbability(double i, int[] index) {
        double sum = Arrays.stream(index).sum();
        return i / sum;
    }

    private static int ReceivedOnUsers(int[] indexs, int price) {
        int kol = Arrays.stream(indexs).sum();
        return price * kol;
    }

    private static int GetRealCost(int[] index, int[] prices) {


        int totalRealCost = 0;
        for (int i = 0; i < index.length; i++) {
            //out.println("Кол-во " + index[i] + " * цена " + prices[i]);
            totalRealCost += index[i] * prices[i];
        }
       // out.println("Факт затраты " + totalRealCost);
        return totalRealCost;
    }


}
