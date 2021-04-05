package Main;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public  double[] costs = new double[7];
    Main main = new Main();

    MainTest() throws IOException {
    }

    @Before
    public void initTest() {
        costs[0] = 850;
        costs[1] = 200;
        costs[2] = 61;
        costs[3] = 425;
        costs[4] = 14;
        costs[5] = 7;
        costs[6] = 26;
    }

    @After
    public void afterTest() {
       // costs.de
    }
    @org.junit.jupiter.api.Test
    void getTruetness() {
        //создаем список expected и заполняем его данными нашего метода

        //assertEquals(main.getTruetness(costs),44.8);
    }
}