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

public class Main {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel((LookAndFeel) Class.forName(UIManager.getCrossPlatformLookAndFeelClassName()).newInstance());
            CalcFrame frame = new CalcFrame(); //start  application
        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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


}
