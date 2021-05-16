package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;


import static java.lang.System.out;

public class CalcFrame extends JFrame {

    public static String priceBfor1count = "Цена 1 шт. Б.";
    public static JTextField priceBLot1 = new JTextField(priceBfor1count);
    public static JTextField priceBLot2 = new JTextField(priceBfor1count);
    public static JTextField priceBLot3 = new JTextField(priceBfor1count);

    public static String textcount = "Кол-во";
    public static JTextField countLot1 = new JTextField(textcount);
    public static JTextField countLot2 = new JTextField(textcount);
    public static JTextField countLot3 = new JTextField(textcount);
    public static JTextField countDiscount10 = new JTextField(textcount);
    public static JTextField countDiscount20 = new JTextField(textcount);
    public static JTextField countDiscount30 = new JTextField(textcount);
    public static JTextField countDiscount40 = new JTextField(textcount);

    public static String likelihood = "Вероятность";
    public static JTextField likelihoodLot1 = new JTextField(likelihood);
    public static JTextField likelihoodLot2 = new JTextField(likelihood);
    public static JTextField likelihoodLot3 = new JTextField(likelihood);
    public static JTextField likelihoodDiscount10 = new JTextField(likelihood);
    public static JTextField likelihoodDiscount20 = new JTextField(likelihood);
    public static JTextField likelihoodDiscount30 = new JTextField(likelihood);
    public static JTextField likelihoodDiscount40 = new JTextField(likelihood);

    public static String textCountBox = "шт.";
    public static JTextField CountBoxInput = new JTextField(textCountBox);

    public static String priceBfor1count3 = "Б.";
    public static JTextField stoimost1Lota = new JTextField("Б.");
    public static JCheckBox fixscheck = new JCheckBox("фикс. цену");

    public static JLabel loyaltyValue = new JLabel("");
    public static JLabel benefitsValue = new JLabel("");

    public static String textActualCost = "руб.";
    public static JTextField ActualCostInput = new JTextField(textActualCost);
    public static JLabel buyerValue = new JLabel("");


    public static ArrayList<JTextField[]> listAboutSetkaForFirstLot = new ArrayList<>();
    public static ArrayList<JTextField[]> listAboutSetkaForSecondLot = new ArrayList<>();
    public static ArrayList<JTextField[]> listAboutSetkaForTherdLot = new ArrayList<>();


    public CalcFrame() {

        setTitle("Калькулятор БлэкБокс");

        getContentPane().add(createPanel());
        try {
            setIconImage(ImageIO.read(getClass().getResourceAsStream("/Icon/icon.png")));
        } catch (Exception ex) {
        }
        setResizable(false);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int weight = 530;
        int height = 500;
        int x = (int) ((dimension.getWidth() - weight) / 2);
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x, y, weight, height);
    }

    public JPanel createPanel() {
        JPanel panel = new JPanel();
        String pricefor1count = "Цена 1 шт. руб.";
        JTextField priceLot1 = new JTextField(pricefor1count);
        JTextField priceLot2 = new JTextField(pricefor1count);
        JTextField priceLot3 = new JTextField(pricefor1count);

        String textbudget = "Бюджет р.";
        JTextField budgetInput = new JTextField(textbudget);

        // Список компонентов формы
        JLabel lot1 = new JLabel("Лот 1");
        JLabel lot2 = new JLabel("Лот 2");
        JLabel lot3 = new JLabel("Лот 3");
        Font original;
        original = lot1.getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lot1.setFont(original.deriveFont(attributes));
        lot2.setFont(original.deriveFont(attributes));
        lot3.setFont(original.deriveFont(attributes));

        lot1.setToolTipText("Нажми, чтобы добавить ценовую сетку");
        lot2.setToolTipText("Нажми, чтобы добавить ценовую сетку");
        lot3.setToolTipText("Нажми, чтобы добавить ценовую сетку");


        lot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame("Ценновая сетка лота 1");
                // создаем  панель.
                JPanel p = new JPanel();
                frame.add(p);

                // к панели добавляем менеджер FlowLayout.
                p.setLayout(new FlowLayout());


                JButton button = new JButton("Добавить цену в категорию");
                JButton buttonOk = new JButton("Сетка готова");


                buttonOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("Сохраняем данные");
                        frame.setVisible(false);
                        for (int i = 0; i < listAboutSetkaForFirstLot.size(); i++) {
                            JTextField[] mas = listAboutSetkaForFirstLot.get(i);
                            for (int j = 0; j < 3; j++) {
                                out.println(mas[j].getText());
                            }
                            // обязательно в будущем добавить проверку на корректность

                        }
                    }
                });
                button.setSize(10, 10);
                p.add(button);
                p.add(buttonOk);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        out.println("Click buutoon");
                        JPanel panelTemp = new JPanel();
                        GridLayout layout = new GridLayout(2, 3, 5, 12);

                        panelTemp.setLayout(layout);

                        JLabel labelKolVo = new JLabel("Кол-во");
                        JLabel labeltemp = new JLabel("");

                        JLabel labelprice = new JLabel("Цена");

                        JTextField[] mas = new JTextField[3];
                        mas[0] = new JTextField("От");
                        mas[1] = new JTextField("До");
                        mas[2] = new JTextField("руб.");
                        listAboutSetkaForFirstLot.add(mas);

                        panelTemp.add(labelKolVo);
                        panelTemp.add(labeltemp);
                        panelTemp.add(labelprice);
                        panelTemp.add(mas[0]);
                        panelTemp.add(mas[1]);
                        panelTemp.add(mas[2]);
                        panelTemp.setBackground(new Color(215, 142, 135));
                        p.add(panelTemp);
                        p.updateUI();

                        Thread t = new Thread(() -> {

                            while (true) {
                                if (mas[0].hasFocus() && mas[0].getText().compareTo("От") == 0) {

                                    mas[0].setText("");
                                    mas[0].setForeground(Color.black);

                                } else if (mas[1].hasFocus() && mas[1].getText().compareTo("До") == 0) {

                                    mas[1].setText("");
                                    mas[1].setForeground(Color.black);

                                } else if (mas[2].hasFocus() && mas[2].getText().compareTo("руб.") == 0) {

                                    mas[2].setText("");
                                    mas[2].setForeground(Color.black);

                                } else if (!mas[0].hasFocus() && mas[0].getText().compareTo("") == 0) {

                                    mas[0].setText("От");
                                    mas[0].setForeground(Color.RED);

                                } else if (!mas[1].hasFocus() && mas[1].getText().compareTo("") == 0) {

                                    mas[1].setText("До");
                                    mas[1].setForeground(Color.RED);

                                } else if (!mas[2].hasFocus() && mas[2].getText().compareTo("") == 0) {

                                    mas[2].setText("руб.");
                                    mas[2].setForeground(Color.RED);

                                }

                            }
                        });
                        t.start();


                    }
                });

                frame.setVisible(true);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int weight = 430;
                int height = 350;
                int x = (int) ((dimension.getWidth() - weight) / 2);
                int y = (int) ((dimension.getHeight() - height) / 2);
                frame.setBounds(x, y, weight, height);
                System.out.println("clicked!");
            }

        });
        lot2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame("Ценновая сетка лота 2");
                // создаем  панель.
                JPanel p = new JPanel();
                frame.add(p);

                // к панели добавляем менеджер FlowLayout.
                p.setLayout(new FlowLayout());


                JButton button = new JButton("Добавить цену в категорию");
                JButton buttonOk = new JButton("Сетка готова");


                buttonOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("Сохраняем данные");
                        frame.setVisible(false);
                        for (int i = 0; i < listAboutSetkaForSecondLot.size(); i++) {
                            JTextField[] mas = listAboutSetkaForSecondLot.get(i);
                            for (int j = 0; j < 3; j++) {
                                out.println(mas[j].getText());
                            }
                            // обязательно в будущем добавить проверку на корректность

                        }
                    }
                });
                button.setSize(10, 10);
                p.add(button);
                p.add(buttonOk);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        out.println("Click buutoon");
                        JPanel panelTemp = new JPanel();
                        GridLayout layout = new GridLayout(2, 3, 5, 12);

                        panelTemp.setLayout(layout);

                        JLabel labelKolVo = new JLabel("Кол-во");
                        JLabel labeltemp = new JLabel("");

                        JLabel labelprice = new JLabel("Цена");

                        JTextField[] mas = new JTextField[3];
                        mas[0] = new JTextField("От");
                        mas[1] = new JTextField("До");
                        mas[2] = new JTextField("руб.");
                        listAboutSetkaForSecondLot.add(mas);

                        panelTemp.add(labelKolVo);
                        panelTemp.add(labeltemp);
                        panelTemp.add(labelprice);
                        panelTemp.add(mas[0]);
                        panelTemp.add(mas[1]);
                        panelTemp.add(mas[2]);
                        panelTemp.setBackground(new Color(215, 142, 135));
                        p.add(panelTemp);
                        p.updateUI();

                        Thread t = new Thread(() -> {

                            while (true) {
                                if (mas[0].hasFocus() && mas[0].getText().compareTo("От") == 0) {

                                    mas[0].setText("");
                                    mas[0].setForeground(Color.black);

                                } else if (mas[1].hasFocus() && mas[1].getText().compareTo("До") == 0) {

                                    mas[1].setText("");
                                    mas[1].setForeground(Color.black);

                                } else if (mas[2].hasFocus() && mas[2].getText().compareTo("руб.") == 0) {

                                    mas[2].setText("");
                                    mas[2].setForeground(Color.black);

                                } else if (!mas[0].hasFocus() && mas[0].getText().compareTo("") == 0) {

                                    mas[0].setText("От");
                                    mas[0].setForeground(Color.RED);

                                } else if (!mas[1].hasFocus() && mas[1].getText().compareTo("") == 0) {

                                    mas[1].setText("До");
                                    mas[1].setForeground(Color.RED);

                                } else if (!mas[2].hasFocus() && mas[2].getText().compareTo("") == 0) {

                                    mas[2].setText("руб.");
                                    mas[2].setForeground(Color.RED);

                                }

                            }
                        });
                        t.start();


                    }
                });

                frame.setVisible(true);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int weight = 430;
                int height = 350;
                int x = (int) ((dimension.getWidth() - weight) / 2);
                int y = (int) ((dimension.getHeight() - height) / 2);
                frame.setBounds(x, y, weight, height);
                System.out.println("clicked!");
            }

        });
        lot3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame("Ценновая сетка лота 3");
                // создаем  панель.
                JPanel p = new JPanel();
                frame.add(p);

                // к панели добавляем менеджер FlowLayout.
                p.setLayout(new FlowLayout());


                JButton button = new JButton("Добавить цену в категорию");
                JButton buttonOk = new JButton("Сетка готова");


                buttonOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        out.println("Сохраняем данные");
                        frame.setVisible(false);
                        for (int i = 0; i < listAboutSetkaForTherdLot.size(); i++) {
                            JTextField[] mas = listAboutSetkaForTherdLot.get(i);
                            for (int j = 0; j < 3; j++) {
                                out.println(mas[j].getText());
                            }
                            // обязательно в будущем добавить проверку на корректность

                        }
                    }
                });
                button.setSize(10, 10);
                p.add(button);
                p.add(buttonOk);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        out.println("Click buutoon");
                        JPanel panelTemp = new JPanel();
                        GridLayout layout = new GridLayout(2, 3, 5, 12);

                        panelTemp.setLayout(layout);

                        JLabel labelKolVo = new JLabel("Кол-во");
                        JLabel labeltemp = new JLabel("");

                        JLabel labelprice = new JLabel("Цена");

                        JTextField[] mas = new JTextField[3];
                        mas[0] = new JTextField("От");
                        mas[1] = new JTextField("До");
                        mas[2] = new JTextField("руб.");
                        listAboutSetkaForTherdLot.add(mas);

                        panelTemp.add(labelKolVo);
                        panelTemp.add(labeltemp);
                        panelTemp.add(labelprice);
                        panelTemp.add(mas[0]);
                        panelTemp.add(mas[1]);
                        panelTemp.add(mas[2]);
                        panelTemp.setBackground(new Color(215, 142, 135));
                        p.add(panelTemp);
                        p.updateUI();

                        Thread t = new Thread(() -> {

                            while (true) {
                                if (mas[0].hasFocus() && mas[0].getText().compareTo("От") == 0) {

                                    mas[0].setText("");
                                    mas[0].setForeground(Color.black);

                                } else if (mas[1].hasFocus() && mas[1].getText().compareTo("До") == 0) {

                                    mas[1].setText("");
                                    mas[1].setForeground(Color.black);

                                } else if (mas[2].hasFocus() && mas[2].getText().compareTo("руб.") == 0) {

                                    mas[2].setText("");
                                    mas[2].setForeground(Color.black);

                                } else if (!mas[0].hasFocus() && mas[0].getText().compareTo("") == 0) {

                                    mas[0].setText("От");
                                    mas[0].setForeground(Color.RED);

                                } else if (!mas[1].hasFocus() && mas[1].getText().compareTo("") == 0) {

                                    mas[1].setText("До");
                                    mas[1].setForeground(Color.RED);

                                } else if (!mas[2].hasFocus() && mas[2].getText().compareTo("") == 0) {

                                    mas[2].setText("руб.");
                                    mas[2].setForeground(Color.RED);

                                }

                            }
                        });
                        t.start();


                    }
                });

                frame.setVisible(true);
             //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int weight = 430;
                int height = 350;
                int x = (int) ((dimension.getWidth() - weight) / 2);
                int y = (int) ((dimension.getHeight() - height) / 2);
                frame.setBounds(x, y, weight, height);
                System.out.println("clicked!");
            }

        });

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
        JLabel stoimostBobr = new JLabel("Б.");
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
                try {


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

                    } else if ((likelihoodDiscount10.getText().compareTo("Вероятность") != 0)) {
                        progressBar.setIndeterminate(false);
                    }
                }
                catch (NullPointerException e){

                }
            }
        });
        t.start();
        JButton settings = new JButton("Настройки параметров");
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int m = Integer.parseInt(JOptionPane.showInputDialog(CalcFrame.this,
                            new String[]{"Целевое списание бобров",
                                    "Введите число целевого списания Б., по умолчанию оно равно 20:"},
                            "Назначить процент целевого списания бобров от бюджета",
                            JOptionPane.DEFAULT_OPTION));

                    Calculation.WRITEOFFBOBER = m;
                } catch (NumberFormatException ex) {
                    Calculation.WRITEOFFBOBER = 20;
                }
            }
        });


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int weight = 510;
        int height = 500;
        int x = (int) ((dimension.getWidth() - weight) / 2);
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x, y, weight, height);


        panel.setLayout(null);
        lot1.setBounds(30, 10, 50, 20);
        panel.add(lot1);
        lot2.setBounds(30, 40, 50, 20);
        panel.add(lot2);
        lot3.setBounds(30, 70, 50, 20);
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
        buyerValue.setBounds(220, 260, 390, 20);
        panel.add(buyerValue);

        settings.setBounds(90, 300, 180, 30);
        panel.add(settings);

        cbLoyalnost.setBounds(280, 290, 170, 30);
        panel.add(cbLoyalnost);
        cbBobrs.setBounds(280, 320, 170, 30);
        panel.add(cbBobrs);

        stoimost1Bobr.setBounds(340, 210, 230, 20);
        panel.add(stoimost1Bobr);
        stoimostBobr.setBounds(457, 210, 30, 20);
        panel.add(stoimostBobr);

        stoimost1Lota.setBounds(400, 210, 100, 20);
        panel.add(stoimost1Lota);
        fixscheck.setBounds(400, 225, 100, 20);
        panel.add(fixscheck);

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
                JOptionPane.showMessageDialog(CalcFrame.this,
                        new String[]{"Введите значения в поля:",
                                " Стоимость лота 1, 2, 3",
                                " Бюджета"},
                        "Заполните данные",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {


                    int costBudget = Integer.parseInt(budgetInput.getText());

                    int cost1 = Integer.parseInt(priceLot1.getText());
                    int cost2 = Integer.parseInt(priceLot2.getText());
                    int cost3 = Integer.parseInt(priceLot3.getText());

                    int[] valueOfDiscont = new int[8];
                    valueOfDiscont[0] = 500;// скидка в 10 % в рублях ср. знач
                    valueOfDiscont[1] = 1000;// скидка в 20 % в рублях ср. знач
                    valueOfDiscont[2] = 1500;// скидка в 30 % в рублях ср. знач
                    valueOfDiscont[3] = 2000;// скидка в 40 % в рублях ср. знач
                    valueOfDiscont[4] = 250;// скидка в 10 % в Б. ср. знач
                    valueOfDiscont[5] = 500;// скидка в 20 % в Б. ср. знач
                    valueOfDiscont[6] = 750;// скидка в 30 % в Б. ср. знач
                    valueOfDiscont[7] = 1000;// скидка в 40 % в Б. ср. знач

                    int[] Budget = new int[2];
                    Budget[0] = costBudget;
                    Budget[1] = costBudget / 2;

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
                    int[] lotPrices = new int[6];
                    lotPrices[0] = cost1;
                    lotPrices[1] = cost2;
                    lotPrices[2] = cost3;
                    lotPrices[3] = cost1Bobr;
                    lotPrices[4] = cost2Bobr;
                    lotPrices[5] = cost3Bobr;

                    InputData inputData = new InputData(lotPrices, valueOfDiscont, Budget, pricePer1BoxBobr);


                    if (cbBobrs.isSelected() && cbLoyalnost.isSelected()) {

                        out.println("Баланс найдем");
                        JOptionPane.showMessageDialog(CalcFrame.this,
                                new String[]{"Следует выбрать алгоритм расчета",
                                        " Чекбокс 1  выбран",
                                        " Чекбокс 2  выбран"},
                                "Выберите один тип",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (cbBobrs.isSelected()) {

                        out.println("Спишем макс. бобров");
                        progressBar.setIndeterminate(true);
                        Thread t2 = new Thread(() -> {

                            Calculation.FindMaxBenefValue(inputData);

                        });
                        t2.start();
                        solution.setEnabled(false);
                        solution.setText("Расчитано");

                    } else if (cbLoyalnost.isSelected()) {


                        out.println("Повысим лояльность");
                        progressBar.setIndeterminate(true);
                        Thread t2 = new Thread(() -> {


                            Calculation.FindValue(inputData);

                        });
                        t2.start();

                        solution.setEnabled(false);
                        solution.setText("Расчитано");
                    } else {


                        JOptionPane.showMessageDialog(CalcFrame.this,
                                new String[]{"Следует выбрать алгоритм расчета",
                                        " Чекбокс 1 не выбран",
                                        " Чекбокс 2 не выбран"},
                                "Выберите тип",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println(ex + " Главное искл в чек боксах");
                    JOptionPane.showMessageDialog(CalcFrame.this,
                            new String[]{"Значения следует ввести как числа",
                                    " Стоимости лота 1, 2, 3",
                                    " Бюджета"},
                            "Корректные данные введите",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        return panel;
    }
}
