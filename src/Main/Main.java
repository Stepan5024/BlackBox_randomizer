package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Main extends JFrame {

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

    static String pricefor1count = "Цена 1 шт. руб.";
    public static JTextField priceLot1 = new JTextField(pricefor1count);
    JTextField priceLot2 = new JTextField(pricefor1count);
    JTextField priceLot3 = new JTextField(pricefor1count);

    String textbudget = "Бюджет р.";
    JTextField budgetInput = new JTextField(textbudget);

    String priceBfor1count = "Цена 1 шт. Б.";
    String priceBfor1count3 = "Б.";
    JTextField priceBLot1 = new JTextField(priceBfor1count);
    JTextField priceBLot2 = new JTextField(priceBfor1count);
    JTextField priceBLot3 = new JTextField(priceBfor1count);
    JTextField stoimost1Lota = new JTextField(priceBfor1count3);
    String textcount = "Кол-во";
    JTextField countLot1 = new JTextField(textcount);
    JTextField countLot2 = new JTextField(textcount);
    JTextField countLot3 = new JTextField(textcount);
    JTextField countDiscount10 = new JTextField(textcount);
    JTextField countDiscount20 = new JTextField(textcount);
    JTextField countDiscount30 = new JTextField(textcount);
    JTextField countDiscount40 = new JTextField(textcount);

    String likelihood = "Вероятность";
    JTextField likelihoodLot1 = new JTextField(likelihood);
    JTextField likelihoodLot2 = new JTextField(likelihood);
    JTextField likelihoodLot3 = new JTextField(likelihood);
    JTextField likelihoodDiscount10 = new JTextField(likelihood);
    JTextField likelihoodDiscount20 = new JTextField(likelihood);
    JTextField likelihoodDiscount30 = new JTextField(likelihood);
    JTextField likelihoodDiscount40 = new JTextField(likelihood);

    String textCountBox = "шт.";
    JTextField CountBoxInput = new JTextField(textCountBox);


    JLabel loyaltyValue = new JLabel("");
    JLabel benefitsValue = new JLabel("");

    String textActualCost = "руб.";
    JTextField ActualCostInput = new JTextField(textActualCost);
    JLabel buyerValue = new JLabel("");

    public Main() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Список компонентов формы
        JLabel lot1 = new JLabel("Лот 1");
        JLabel lot2 = new JLabel("Лот 2");
        JLabel lot3 = new JLabel("Лот 3");
        JLabel discount10 = new JLabel("Скидка 10%");
        JLabel discount20 = new JLabel("Скидка 20%");
        JLabel discount30 = new JLabel("Скидка 30%");
        JLabel discount40 = new JLabel("Скидка 40%");


        JLabel budget = new JLabel("Бюджет");
        JLabel ActualСosts = new JLabel("Фактические затраты руб.");
        JLabel CountBoxs = new JLabel("Следует закупить Блэк Боксов шт.");


        JLabel buyer = new JLabel("Спишется Б. у покупателей");

        JButton solution = new JButton("Рассчитать");
        JButton clear = new JButton("Очистить");
        JLabel stoimost1Bobr = new JLabel("По цене в Б.");
        JLabel loyalty = new JLabel("Лояльность");
        JLabel benefits = new JLabel("Выгода для компании в списании Б.");
        priceLot1.setForeground(Color.RED); // цвет текста обязательного поля стоймости товара в рублях
        priceLot2.setForeground(Color.RED);
        priceLot3.setForeground(Color.RED);


        budgetInput.setForeground(Color.RED);


        JCheckBox cbLoyalnost = new JCheckBox("Повысить лояльность");
        JCheckBox cbBobrs = new JCheckBox("Списать макс. Бобров");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JProgressBar progressBar = new JProgressBar();
        progressBar.setToolTipText("Нажмите кнопку расчитать");

        Thread t = new Thread(() -> {

            while (true) {
                if (priceLot1.hasFocus() && priceLot1.getText().compareTo(pricefor1count) == 0) {

                    priceLot1.setText("");
                    priceLot1.setForeground(Color.black);

                } else if (priceLot2.hasFocus() && priceLot2.getText().compareTo(pricefor1count) == 0) {

                    priceLot2.setText("");
                    priceLot2.setForeground(Color.black);

                } else if (priceLot3.hasFocus() && priceLot3.getText().compareTo(pricefor1count) == 0) {

                    priceLot3.setText("");
                    priceLot3.setForeground(Color.black);

                } else if (budgetInput.hasFocus() && budgetInput.getText().compareTo(textbudget) == 0) {

                    budgetInput.setText("");
                    budgetInput.setForeground(Color.black);

                } else if (stoimost1Lota.hasFocus() && stoimost1Lota.getText().compareTo(priceBfor1count3) == 0) {
                    stoimost1Lota.setText("");
                } else if (priceBLot1.hasFocus() && priceBLot1.getText().compareTo(priceBfor1count) == 0) {
                    priceBLot1.setText("");
                } else if (priceBLot2.hasFocus() && priceBLot2.getText().compareTo(priceBfor1count) == 0) {
                    priceBLot2.setText("");
                } else if (priceBLot3.hasFocus() && priceBLot3.getText().compareTo(priceBfor1count) == 0) {
                    priceBLot3.setText("");
                } else if (!priceLot1.hasFocus() && priceLot1.getText().compareTo("") == 0) {

                    priceLot1.setText(pricefor1count);
                    priceLot1.setForeground(Color.RED);

                } else if (!priceLot2.hasFocus() && priceLot2.getText().compareTo("") == 0) {

                    priceLot2.setText(pricefor1count);
                    priceLot2.setForeground(Color.RED);

                } else if (!priceLot3.hasFocus() && priceLot3.getText().compareTo("") == 0) {

                    priceLot3.setText(pricefor1count);
                    priceLot3.setForeground(Color.RED);

                } else if (!budgetInput.hasFocus() && budgetInput.getText().compareTo("") == 0) {

                    budgetInput.setText(textbudget);
                    budgetInput.setForeground(Color.RED);

                } else if (!priceBLot1.hasFocus() && priceBLot1.getText().compareTo("") == 0) {

                    priceBLot1.setText(priceBfor1count);

                } else if (!priceBLot2.hasFocus() && priceBLot2.getText().compareTo("") == 0) {

                    priceBLot2.setText(priceBfor1count);

                } else if (!priceBLot3.hasFocus() && priceBLot3.getText().compareTo("") == 0) {

                    priceBLot3.setText(priceBfor1count);

                } else if (!(likelihoodLot1.getText().compareTo("Вероятность") == 0)) {
                    progressBar.setIndeterminate(false);
                }

            }
        });
        t.start();
        JButton settings = new JButton("Настройки параметров");
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int m = Integer.parseInt(JOptionPane.showInputDialog(Main.this,
                            new String[]{"Целевое списание бобров",
                                    "Введите число целевого списания Б., по умолчанию оно равно 20:"},
                            "Назначить процент целевого списания бобров от бюджета",
                            JOptionPane.DEFAULT_OPTION));

                    WRITEOFFBOBER = m;
                } catch (NumberFormatException ex) {
                    WRITEOFFBOBER = 20;
                }
            }
        });


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int weight = 510;
        int height = 500;
        int x = (int) ((dimension.getWidth() - weight) / 2);
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x, y, weight, height);

        // Определение менеджера расположения
        JPanel panel = new JPanel();
        panel.setLayout(null);
        lot1.setBounds(30, 10, 100, 20);
        panel.add(lot1);
        lot2.setBounds(30, 40, 100, 20);
        panel.add(lot2);
        lot3.setBounds(30, 70, 100, 20);
        panel.add(lot3);
        priceLot1.setBounds(80, 10, 100, 20);
        panel.add(priceLot1);
        priceLot2.setBounds(80, 40, 100, 20);
        panel.add(priceLot2);
        priceLot3.setBounds(80, 70, 100, 20);
        panel.add(priceLot3);


        priceBLot1.setBounds(200, 10, 110, 20);
        panel.add(priceBLot1);
        priceBLot2.setBounds(200, 40, 110, 20);
        panel.add(priceBLot2);
        priceBLot3.setBounds(200, 70, 110, 20);
        panel.add(priceBLot3);

        countLot1.setBounds(330, 10, 50, 20);
        panel.add(countLot1);
        countLot2.setBounds(330, 40, 50, 20);
        panel.add(countLot2);
        countLot3.setBounds(330, 70, 50, 20);
        panel.add(countLot3);

        likelihoodLot1.setBounds(400, 10, 80, 20);
        panel.add(likelihoodLot1);
        likelihoodLot2.setBounds(400, 40, 80, 20);
        panel.add(likelihoodLot2);
        likelihoodLot3.setBounds(400, 70, 80, 20);
        panel.add(likelihoodLot3);

        discount10.setBounds(200, 100, 100, 20);
        panel.add(discount10);
        discount20.setBounds(200, 120, 100, 20);
        panel.add(discount20);
        discount30.setBounds(200, 140, 100, 20);
        panel.add(discount30);
        discount40.setBounds(200, 160, 100, 20);
        panel.add(discount40);
        countDiscount10.setBounds(330, 100, 50, 20);
        panel.add(countDiscount10);
        countDiscount20.setBounds(330, 120, 50, 20);
        panel.add(countDiscount20);
        countDiscount30.setBounds(330, 140, 50, 20);
        panel.add(countDiscount30);
        countDiscount40.setBounds(330, 160, 50, 20);
        panel.add(countDiscount40);
        likelihoodDiscount10.setBounds(400, 100, 80, 20);
        panel.add(likelihoodDiscount10);
        likelihoodDiscount20.setBounds(400, 120, 80, 20);
        panel.add(likelihoodDiscount20);
        likelihoodDiscount30.setBounds(400, 140, 80, 20);
        panel.add(likelihoodDiscount30);
        likelihoodDiscount40.setBounds(400, 160, 80, 20);
        panel.add(likelihoodDiscount40);

        budget.setBounds(30, 190, 80, 20);
        panel.add(budget);
        budgetInput.setBounds(90, 190, 80, 20);
        panel.add(budgetInput);
        ActualСosts.setBounds(180, 190, 180, 20);
        panel.add(ActualСosts);
        ActualCostInput.setBounds(380, 190, 80, 20);
        panel.add(ActualCostInput);

        CountBoxs.setBounds(30, 210, 240, 20);
        panel.add(CountBoxs);
        CountBoxInput.setBounds(260, 210, 50, 20);
        panel.add(CountBoxInput);

        loyalty.setBounds(30, 240, 80, 20);
        panel.add(loyalty);
        loyaltyValue.setBounds(120, 240, 70, 20);
        panel.add(loyaltyValue);
        benefits.setBounds(200, 240, 240, 20);
        panel.add(benefits);
        benefitsValue.setBounds(450, 240, 70, 20);
        panel.add(benefitsValue);

        buyer.setBounds(30, 260, 190, 20);
        panel.add(buyer);
        buyerValue.setBounds(220, 260, 190, 20);
        panel.add(buyerValue);

        settings.setBounds(90, 300, 180, 30);
        panel.add(settings);

        cbLoyalnost.setBounds(280, 290, 170, 30);
        panel.add(cbLoyalnost);
        cbBobrs.setBounds(280, 320, 170, 30);
        panel.add(cbBobrs);

        stoimost1Bobr.setBounds(340, 210, 230, 20);
        panel.add(stoimost1Bobr);
        stoimost1Lota.setBounds(400, 210, 50, 20);
        panel.add(stoimost1Lota);

        solution.setBounds(140, 360, 200, 30);
        panel.add(solution);
        clear.setBounds(380, 360, 100, 30);
        //panel.add(clear);

        progressBar.setBounds(140, 400, 200, 20);
        panel.add(progressBar);

        add(panel);
        setTitle("Калькулятор рамдомайзера BlackBox©");
        solution.addActionListener(e -> {
            if ((priceLot1.getText().compareTo(priceBfor1count) == 0 || priceLot2.getText().compareTo(priceBfor1count) == 0 || priceLot3.getText().compareTo(priceBfor1count) == 0 || budgetInput.getText().compareTo(textbudget) == 0)) {
                JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Введите значения в поля:",
                                " Стоимость лота 1, 2, 3",
                                " Бюджета"},
                        "Заполните данные",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                //  try {


                if (cbBobrs.isSelected() && cbLoyalnost.isSelected()) {

                    out.println("Баланс найдем");
                    JOptionPane.showMessageDialog(Main.this,
                            new String[]{"Следует выбрать алгоритм расчета",
                                    " Чекбокс 1  выбран",
                                    " Чекбокс 2  выбран"},
                            "Выберите один тип",
                            JOptionPane.WARNING_MESSAGE);
                } else if (cbBobrs.isSelected()) {

                    out.println("Спишем макс. бобров");
                    progressBar.setIndeterminate(true);
                    Thread t2 = new Thread(() -> {

                        FindMaxBenefValue();

                    });
                    t2.start();
                    solution.setEnabled(false);
                    solution.setText("Расчитано");

                } else if (cbLoyalnost.isSelected()) {


                    out.println("Повысим лояльность");
                    progressBar.setIndeterminate(true);
                    Thread t2 = new Thread(() -> {

                        FindValue();

                    });
                    t2.start();

                    solution.setEnabled(false);
                    solution.setText("Расчитано");
                } else {


                    JOptionPane.showMessageDialog(Main.this,
                            new String[]{"Следует выбрать алгоритм расчета",
                                    " Чекбокс 1 не выбран",
                                    " Чекбокс 2 не выбран"},
                            "Выберите тип",
                            JOptionPane.WARNING_MESSAGE);
                }
               /* } catch (Exception ex) {
                    System.out.println(ex + " Главное искл в чек боксах");
                    JOptionPane.showMessageDialog(Main.this,
                            new String[]{"Значения следует ввести как числа",
                                    " Стоимости лота 1, 2, 3",
                                    " Бюджета"},
                            "Корректные данные введите",
                            JOptionPane.WARNING_MESSAGE);
                }*/
            }

        });


    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel((LookAndFeel) Class.forName(UIManager.getCrossPlatformLookAndFeelClassName()).newInstance());
            new Main().setVisible(true); //start  application
        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
       /* double[] costs = new double[7];
        costs[0] = 850;
        costs[1] = 200;
        costs[2] = 61;
        costs[3] = 425;
        costs[4] = 14;
        costs[5] = 7;
        costs[6] = 26;
        System.out.println(Main.getTruetness(costs));*/
    }

    public static double getTruetness(int[] costs, int[] indexs) {
        double costLot = costs[7]; // стоимость лота
        double loyalty = 0;

        double k1 = (costs[0] - costLot) / costLot;
        double k2 = (costs[1] - costLot) / costLot;
        double k3 = (costs[2] - costLot) / costLot;
        // double k4 = (costs[3] - costLot) / costLot;

        double kol_1 = k1 * indexs[0];
        double kol_2 = k2 * indexs[1];
        double kol_3 = k3 * indexs[2];
        // double kol_4 = k4 * indexs[3];

        int vsego = Arrays.stream(indexs).sum();

        loyalty = (vsego + kol_2 + kol_3) / (vsego);
        /*double[] coefficients = new double[4]; // массив коэффицентов разности валюты выигрыша к стоимости BlackBox
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = (costs[i] - costLot) / costLot;
        }

        int[] unhappy = new int[4]; // массив кол-ва недовльных в среднем выигрышем
        for (int i = 0; i < unhappy.length; i++) {
            unhappy[i] = (int) coefficients[i] * indexs[i];
        }

        double joyful = Arrays.stream(indexs).sum(); // посчитаем сумму довольных,
        joyful += Arrays.stream(unhappy).asDoubleStream().sum();// вычитая из общей массы участников массива недовольных
        double loyalty = joyful / Arrays.stream(indexs).sum(); // отношение довольных к общей массе участников
*/
        return loyalty * 100;

    }


    public static double getTruetness2(int[] costs, int[] indexs) {
        double costLot = costs[7]; // стоимость лота
        double loyalty = 0;

        double k1 = (costs[0] - costLot) / costLot;
        double k2 = (costs[1] - costLot) / costLot;
        double k3 = (costs[2] - costLot) / costLot;
        double k4 = (costs[3] - costLot) / costLot;
        double k5 = (costs[4] - costLot) / costLot;
        double k6 = (costs[5] - costLot) / costLot;
        double k7 = (costs[6] - costLot) / costLot;


        double kol_1 = k1 * indexs[0];
        double kol_2 = k2 * indexs[1];
        double kol_3 = k3 * indexs[2];
        double kol_4 = k4 * indexs[3];
        double kol_5 = k5 * indexs[4];
        double kol_6 = k6 * indexs[5];
        double kol_7 = k7 * indexs[6];


        int vsego = Arrays.stream(indexs).sum();

        loyalty = (vsego + kol_2 + kol_3 + kol_4 + kol_5 + kol_6 + kol_7) / (vsego);
        /*double[] coefficients = new double[4]; // массив коэффицентов разности валюты выигрыша к стоимости BlackBox
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = (costs[i] - costLot) / costLot;
        }

        int[] unhappy = new int[4]; // массив кол-ва недовльных в среднем выигрышем
        for (int i = 0; i < unhappy.length; i++) {
            unhappy[i] = (int) coefficients[i] * indexs[i];
        }

        double joyful = Arrays.stream(indexs).sum(); // посчитаем сумму довольных,
        joyful += Arrays.stream(unhappy).asDoubleStream().sum();// вычитая из общей массы участников массива недовольных
        double loyalty = joyful / Arrays.stream(indexs).sum(); // отношение довольных к общей массе участников
*/
        return loyalty * 100;

    }

    public void FindValue() {


        double cost1 = Double.parseDouble(priceLot1.getText()); // ввод стоимости лота 1, 2, 3 в рублях
        double cost2 = Double.parseDouble(priceLot2.getText());
        double cost3 = Double.parseDouble(priceLot3.getText());
        double costBudget = Double.parseDouble(budgetInput.getText()); // ввод бюджета в руб.

        int discount10 = 500; // скидка в 10 % в рублях ср. знач
        int discount20 = 1000; // скидка в 20 % в рублях ср. знач
        int discount30 = 1500; // скидка в 30 % в рублях ср. знач
        int discount40 = 2000; // скидка в 40 % в рублях ср. знач

        int discount10Bobr = discount10 / 2;
        int discount20Bobr = discount20 / 2;
        int discount30Bobr = discount30 / 2;
        int discount40Bobr = discount40 / 2;

        double BudgetAllowance = costBudget - costBudget * 0.2 + costBudget * ALLOWANCE; // превысить бюджет на 5% с четом залога 20% на скидки
        double BudgetAllowanceDown = costBudget - costBudget * 0.2 - costBudget * ALLOWANCE; // закупиться меньше бюджета на 5% с четом залога 20% на скидки
        out.println("BudgetAllowance = " + BudgetAllowance);
        out.println("BudgetAllowanceDown  = " + BudgetAllowanceDown);


        int cost1Bobr = (int) (cost1 / 2);
        int cost2Bobr = (int) (cost2 / 2);
        int cost3Bobr = (int) (cost3 / 2);
        if (cost3Bobr < 0.15 * cost2) {
            cost3Bobr = (int) (0.15 * cost2);
        }


        if (priceBLot1.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost1Bobr = (int) Double.parseDouble(priceBLot1.getText());
            } catch (Exception ex) {
                out.println(ex + " ошибка при преобразовании цены одного лота 1 в число в Б.");
                priceBLot1.setText("");
                /*JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        if (priceBLot2.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost2Bobr = (int) Double.parseDouble(priceBLot2.getText());
            } catch (Exception ex) {
                out.println(ex + " ошибка при преобразовании цены одного лота 2 в число в Б.");
               /* JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        if (priceBLot3.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost3Bobr = (int) Double.parseDouble(priceBLot3.getText());
            } catch (Exception ex) {
                out.println(ex + " ошибка при преобразовании цены одного лота 3 в число");
               /* JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        int pricePer1BoxBobr = (int) cost1Bobr / 2; // цена в бобрах;
        if (stoimost1Lota.getText().compareTo("Б.") != 0) {
            try {
                pricePer1BoxBobr = (int) Double.parseDouble(stoimost1Lota.getText());
                out.println("Соимость бокса одного " + pricePer1BoxBobr);
            } catch (Exception ex) {
                out.println(ex + " ошибка при преобразовании цены одного бокса в число");
                /*JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значение в поле цены Блэк Бокса следует ввести как число",
                        },
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }


        price1BlackBox = pricePer1BoxBobr;
        priceLoots1 = cost1Bobr;
        priceLoots2 = cost2Bobr;
        priceLoots3 = cost3Bobr;
        // out.println("Цена бокса " + pricePer1BoxBobr + " стоимость лота 1 " + cost1Bobr+ " стоимость лота 2 " + cost2Bobr + " стоимость лота 3 " + cost3Bobr );
        int[] pricesRub = new int[7];
        pricesRub[0] = (int) cost1;
        pricesRub[1] = (int) cost2;
        pricesRub[2] = (int) cost3;
        pricesRub[3] = discount10;
        pricesRub[4] = discount20;
        pricesRub[5] = discount30;
        pricesRub[6] = discount40;

        int[] pricesBobr = new int[7];
        pricesBobr[0] = (int) cost1Bobr;
        pricesBobr[1] = (int) cost2Bobr;
        pricesBobr[2] = (int) cost3Bobr;
        pricesBobr[3] = discount10Bobr;
        pricesBobr[4] = discount20Bobr;
        pricesBobr[5] = discount30Bobr;
        pricesBobr[6] = discount40Bobr;

        ArrayList<double[]> maxLoyality = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            double[] temp = new double[10]; // индексы 0,1,2,3,4,5,6 это товары и скидки значение цены в руб/бобр
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

        for (int i = 1; i < I; i++) {
            for (int j = 1; j < J; j++) {
                for (int k = 1; k < K; k++) {


                    int[] index = new int[3];
                    index[0] = i; // Лот 1
                    index[1] = j; // Лот 2
                    index[2] = k; // Лот 3


                    double totalRub = GetRealCost(index, pricesRub);
                    //double totalBobr= GetRealCost(index, pricesRub);

                    zatracheno = GetRealCost(index, pricesRub);

                    double BenefitsForCompanyBobr = ReceivedOnUsers(index, pricePer1BoxBobr) * 2 - totalRub;
                    double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);


                    double trueness = getTruetness(costing, index);


                    if ((totalRub > BudgetAllowanceDown && totalRub < BudgetAllowance) && (BenefitsForCompanyPerProcentBobr > 0)) {

                        double[] temp = maxLoyality.get(5);
                        double[] temp1 = maxLoyality.get(4);
                        double[] temp2 = maxLoyality.get(3);


                        if ((temp[7] <= trueness)) {
                            System.arraycopy(temp1, 0, temp2, 0, temp.length);
                            System.arraycopy(temp, 0, temp1, 0, temp.length);

                            for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                temp[o] = index[o];
                            }

                            temp[7] = trueness;
                            temp[8] = BenefitsForCompanyPerProcentBobr;

                            temp[9] = zatracheno;

                            maxLoyality.set(3, temp2);
                            maxLoyality.set(4, temp1);
                            maxLoyality.set(5, temp);

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

        if ((int) (maxLoyality.get(number)[0] + maxLoyality.get(number)[1] + maxLoyality.get(number)[2]) == 0 & I < 100) {
            I += 20;
            J += 20;
            K += 20;


            FindValue();
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


                        double totalRub = GetRealCost(index2, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index2, pricePer1BoxBobr) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);

                        double trueness = getTruetness2(costing, index2);

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


            priceBLot1.setText(priceLoots1 + "");
            priceBLot2.setText(priceLoots2 + "");
            priceBLot3.setText(priceLoots3 + "");

            countLot1.setText(new BigDecimal((int) maxLoyality.get(number)[0]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot2.setText(new BigDecimal((int) maxLoyality.get(number)[1]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot3.setText(new BigDecimal((int) maxLoyality.get(number)[2]).setScale(0, RoundingMode.UP).doubleValue() + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            stoimost1Lota.setText(price1BlackBox + "");
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");
            buyerValue.setText(price1BlackBox * maxSum + " Б. или " + price1BlackBox * maxSum * 2 + " руб.");

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
                        int[] index = new int[3];
                        index[0] = i; // Лот 1
                        index[1] = j; // Лот 2
                        index[2] = k; // Лот 3


                        double totalRub3 = GetRealCost(index, pricesRub);
                        //double totalBobr= GetRealCost(index, pricesRub);

                        zatracheno = GetRealCost(index, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index, pricePer1BoxBobr) * 2 - totalRub3;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub3);


                        double trueness = getTruetness(costing, index);


                        if (totalRub < costBudget * 1.05 && (BenefitsForCompanyPerProcentBobr > 0)) {

                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);
                            out.println("Зашел суда " + temp[7]);

                            if ((temp[7] <= trueness)) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);

                                for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = zatracheno;

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

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
            priceBLot1.setText(priceLoots1 + "");
            priceBLot2.setText(priceLoots2 + "");
            priceBLot3.setText(priceLoots3 + "");

            countLot1.setText(((int) maxLoyality.get(number)[0]) + "");
            countLot2.setText(((int) maxLoyality.get(number)[1]) + "");
            countLot3.setText(((int) maxLoyality.get(number)[2]) + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            stoimost1Lota.setText(price1BlackBox + "");
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");
            buyerValue.setText(price1BlackBox * maxSum + " Б. или " + price1BlackBox * maxSum * 2 + " руб.");

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

    private double GetProbability(double i, int[] index) {
        double sum = Arrays.stream(index).sum();
        return i / sum;
    }

    private int ReceivedOnUsers(int[] indexs, int price) {
        int kol = Arrays.stream(indexs).sum();
        return price * kol;
    }

    private int GetRealCost(int[] index, int[] prices) {
        int totalRealCost = 0;
        for (int i = 0; i < index.length; i++) {
            totalRealCost += index[i] * prices[i];
        }
        return totalRealCost;
    }

    public void FindMaxBenefValue() {


        double cost1 = Double.parseDouble(priceLot1.getText());
        double cost2 = Double.parseDouble(priceLot2.getText());
        double cost3 = Double.parseDouble(priceLot3.getText());

        double costBudget = Double.parseDouble(budgetInput.getText());


        int discount10 = 500; // скидка в 10 % в рублях ср. знач
        int discount20 = 1000; // скидка в 20 % в рублях ср. знач
        int discount30 = 1500; // скидка в 30 % в рублях ср. знач
        int discount40 = 2000; // скидка в 40 % в рублях ср. знач
        int discount10Bobr = discount10 / 2;
        int discount20Bobr = discount20 / 2;
        int discount30Bobr = discount30 / 2;
        int discount40Bobr = discount40 / 2;

        int cost1Bobr = (int) (cost1 / 2);
        int cost2Bobr = (int) (cost2 / 2);
        int cost3Bobr = (int) (cost3 / 2);
        if (cost3Bobr < 0.15 * cost2) {
            cost3Bobr = (int) (0.15 * cost2);
        }

        if (priceBLot1.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost1Bobr = (int) Double.parseDouble(priceBLot1.getText());
            } catch (Exception ex) {
                out.println(ex + " преобразование текста в поле цена лота в Б. к числу");
               /* JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как число в поле цена лота 1 в Б.",

                        },
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        if (priceBLot2.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost2Bobr = (int) Double.parseDouble(priceBLot2.getText());
            } catch (Exception ex) {
                out.println(ex + " преобразование текста в поле цена лота  2 в Б. к числу");
                /*JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        if (priceBLot3.getText().compareTo(priceBfor1count) != 0) {
            try {
                cost3Bobr = (int) Double.parseDouble(priceBLot3.getText());
            } catch (Exception ex) {
                out.println(ex + " преобразование текста в поле цена лота 3 в Б. к числу");
                /*JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        int pricePer1BoxBobr = (int) cost1 / 4; // цена в бобрах
        if (stoimost1Lota.getText().compareTo("Б.") != 0) {
            try {
                pricePer1BoxBobr = (int) Double.parseDouble(stoimost1Lota.getText());
                out.println("Соимость бокса одного " + pricePer1BoxBobr);
            } catch (Exception ex) {
                out.println(ex + " преобразование текста в поле стоимости одного блэк бокса в Б. к числу");
                /*JOptionPane.showMessageDialog(Main.this,
                        new String[]{"Значения следует ввести как числа",
                                " Стоимости лота 1, 2, 3",
                                " Бюджета"},
                        "Корректные данные введите",
                        JOptionPane.WARNING_MESSAGE);*/
            }

        }
        price1BlackBox = pricePer1BoxBobr;
        priceLoots1 = cost1Bobr;
        priceLoots2 = cost2Bobr;
        priceLoots3 = cost3Bobr;

        int[] pricesRub = new int[7];
        pricesRub[0] = (int) cost1;
        pricesRub[1] = (int) cost2;
        pricesRub[2] = (int) cost3;
        pricesRub[3] = discount10;
        pricesRub[4] = discount20;
        pricesRub[5] = discount30;
        pricesRub[6] = discount40;

        int[] pricesBobr = new int[7];
        pricesBobr[0] = (int) cost1Bobr;
        pricesBobr[1] = (int) cost2Bobr;
        pricesBobr[2] = (int) cost3Bobr;
        pricesBobr[3] = discount10Bobr;
        pricesBobr[4] = discount20Bobr;
        pricesBobr[5] = discount30Bobr;
        pricesBobr[6] = discount40Bobr;

        int[] costing = new int[8]; // массив цен в бобрах
        costing[0] = cost1Bobr;
        costing[1] = cost2Bobr;
        costing[2] = cost3Bobr;
        costing[3] = discount10Bobr;
        costing[4] = discount20Bobr;
        costing[5] = discount30Bobr;
        costing[6] = discount40Bobr;
        costing[7] = pricePer1BoxBobr;

        ArrayList<double[]> maxLoyality = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            double[] temp = new double[10]; // индексы 0,1,2,3,4,5,6 это товары и скидки значение цены в руб/бобр
            temp[7] = -1000000;// абсолютный минимум лояльности
            temp[8] = -1000000;// минимум выгоды компании

            maxLoyality.add(temp);
        }
        double BudgetAllowance = costBudget - costBudget * 0.2 + costBudget * ALLOWANCE; // превысить бюджет на 5% с четом залога 20% на скидки
        double BudgetAllowanceDown = costBudget - costBudget * 0.2 - costBudget * ALLOWANCE; // закупиться меньше бюджета на 5% с четом залога 20% на скидки

        for (int i = 1; i < I; i++) {
            for (int j = 1; j < J; j++) {
                for (int k = 1; k < K; k++) {


                    int[] index = new int[7];
                    index[0] = i; // Лот 1
                    index[1] = j; // Лот 2
                    index[2] = k; // Лот 3


                    double totalRub = GetRealCost(index, pricesRub);
                    //double totalBobr= GetRealCost(index, pricesRub);

                    zatracheno = GetRealCost(index, pricesRub);

                    double BenefitsForCompanyBobr = ReceivedOnUsers(index, pricePer1BoxBobr) * 2 - totalRub;
                    double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);


                    double trueness = getTruetness(costing, index);

                    if (totalRub > BudgetAllowanceDown && (totalRub < BudgetAllowance) && (BenefitsForCompanyPerProcentBobr > 10 && BenefitsForCompanyPerProcentBobr < WRITEOFFBOBER)) {

                        double[] temp = maxLoyality.get(5);
                        double[] temp1 = maxLoyality.get(4);
                        double[] temp2 = maxLoyality.get(3);

                        if (temp[8] <= BenefitsForCompanyPerProcentBobr) {
                            System.arraycopy(temp1, 0, temp2, 0, temp.length);
                            System.arraycopy(temp, 0, temp1, 0, temp.length);

                            for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                temp[o] = index[o];
                            }

                            temp[7] = trueness;
                            temp[8] = BenefitsForCompanyPerProcentBobr;
                            temp[9] = zatracheno;

                            maxLoyality.set(3, temp2);
                            maxLoyality.set(4, temp1);
                            maxLoyality.set(5, temp);

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
        if ((int) (maxLoyality.get(1)[0] + maxLoyality.get(1)[1] + maxLoyality.get(1)[2]) == 0 && (I < 100 || J < 90 || K < 100)) {
            I += 20;
            J += 20;
            K += 20;

            FindMaxBenefValue();
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


                        double totalRub = GetRealCost(index2, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index2, pricePer1BoxBobr) * 2 - totalRub;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub);

                        double trueness = getTruetness2(costing, index2);

                        if ((totalRub > costBudget * 0.95 && totalRub < costBudget * 1.05) && (BenefitsForCompanyPerProcentBobr > 0) && BenefitsForCompanyPerProcentBobr < WRITEOFFBOBER) {
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


            priceBLot1.setText(priceLoots1 + "");
            priceBLot2.setText(priceLoots2 + "");
            priceBLot3.setText(priceLoots3 + "");

            countLot1.setText(new BigDecimal((int) maxLoyality.get(number)[0]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot2.setText(new BigDecimal((int) maxLoyality.get(number)[1]).setScale(0, RoundingMode.UP).doubleValue() + "");
            countLot3.setText(new BigDecimal((int) maxLoyality.get(number)[2]).setScale(0, RoundingMode.UP).doubleValue() + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            stoimost1Lota.setText(price1BlackBox + "");
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");
            buyerValue.setText(price1BlackBox * maxSum + " Б. или " + price1BlackBox * maxSum * 2 + " руб.");

            countDiscount10.setText(maxLoyality.get(number)[3] + "");
            countDiscount20.setText(maxLoyality.get(number)[4] + "");
            countDiscount30.setText(maxLoyality.get(number)[5] + "");
            countDiscount40.setText(maxLoyality.get(number)[6] + "");
            likelihoodDiscount10.setText(new BigDecimal(maxLoyality.get(number)[3] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount20.setText(new BigDecimal(maxLoyality.get(number)[4] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount30.setText(new BigDecimal(maxLoyality.get(number)[5] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount40.setText(new BigDecimal(maxLoyality.get(number)[6] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");


        }
       /* else {
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    for (int k = 0; k < K; k++) {
                        int[] index = new int[3];
                        index[0] = i; // Лот 1
                        index[1] = j; // Лот 2
                        index[2] = k; // Лот 3


                        double totalRub3 = GetRealCost(index, pricesRub);
                        //double totalBobr= GetRealCost(index, pricesRub);

                        zatracheno = GetRealCost(index, pricesRub);

                        double BenefitsForCompanyBobr = ReceivedOnUsers(index, pricePer1BoxBobr) * 2 - totalRub3;
                        double BenefitsForCompanyPerProcentBobr = 100 * (BenefitsForCompanyBobr / totalRub3);


                        double trueness = getTruetness(costing, index);


                        if (totalRub < costBudget * 1.05 && (BenefitsForCompanyPerProcentBobr > 0) && BenefitsForCompanyPerProcentBobr < WRITEOFFBOBER ) {

                            double[] temp = maxLoyality.get(5);
                            double[] temp1 = maxLoyality.get(4);
                            double[] temp2 = maxLoyality.get(3);
                           // out.println("Зашел суда " + temp[7]);

                            if ((temp[8] <= BenefitsForCompanyPerProcentBobr)) {
                                System.arraycopy(temp1, 0, temp2, 0, temp.length);
                                System.arraycopy(temp, 0, temp1, 0, temp.length);

                                for (int o = 0; o < index.length; o++) { // запоминаем индексы (кол-во товаров)
                                    temp[o] = index[o];
                                }

                                temp[7] = trueness;
                                temp[8] = BenefitsForCompanyPerProcentBobr;
                                temp[9] = zatracheno;

                                maxLoyality.set(3, temp2);
                                maxLoyality.set(4, temp1);
                                maxLoyality.set(5, temp);

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
            priceBLot1.setText(priceLoots1 + "");
            priceBLot2.setText(priceLoots2 + "");
            priceBLot3.setText(priceLoots3 + "");

            countLot1.setText(((int) maxLoyality.get(number)[0]) + "");
            countLot2.setText(((int) maxLoyality.get(number)[1]) + "");
            countLot3.setText(((int) maxLoyality.get(number)[2]) + "");

            likelihoodLot1.setText(new BigDecimal(maxLoyality.get(number)[0] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot2.setText(new BigDecimal(maxLoyality.get(number)[1] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodLot3.setText(new BigDecimal(maxLoyality.get(number)[2] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            CountBoxInput.setText(maxSum + "");
            stoimost1Lota.setText(price1BlackBox + "");
            loyaltyValue.setText(new BigDecimal(maxLoyality.get(number)[7]).setScale(2, RoundingMode.UP).doubleValue() + "");
            benefitsValue.setText(new BigDecimal(maxLoyality.get(number)[8]).setScale(2, RoundingMode.UP).doubleValue() + "");
            ActualCostInput.setText(maxLoyality.get(number)[9] + "");
            buyerValue.setText(price1BlackBox * maxSum + " Б. или " + price1BlackBox * maxSum * 2 + " руб.");

            countDiscount10.setText((int) maxLoyality.get(number)[3] + "");
            countDiscount20.setText((int) maxLoyality.get(number)[4] + "");
            countDiscount30.setText((int) maxLoyality.get(number)[5] + "");
            countDiscount40.setText((int) maxLoyality.get(number)[6] + "");
            likelihoodDiscount10.setText(new BigDecimal(maxLoyality.get(number)[3] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount20.setText(new BigDecimal(maxLoyality.get(number)[4] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount30.setText(new BigDecimal(maxLoyality.get(number)[5] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");
            likelihoodDiscount40.setText(new BigDecimal(maxLoyality.get(number)[6] / maxSum).setScale(2, RoundingMode.UP).doubleValue() + "");

        }
*/
    }
}
