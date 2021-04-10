package Main;

public class InputData {

    int[] lotPrices = new int[6]; // массив стоимости лотов 1-3 в руб. индексы 0-2 значение в руб. а индексы 3-5 в бобрах
    int[] valueOfDiscount = new int[8]; // массив значений скидок 10%-40% в руб. индексы 0-3 значение в руб. а индексы 3-7 в бобрах
    int[] costBudget = new int[2]; //допустимый бюджет в рублях
    InputData (int[] lotPrices, int[] valueOfDiscount, int[] costBudget){
        this.lotPrices = lotPrices;
        this.valueOfDiscount = valueOfDiscount;
        this.costBudget = costBudget;

    }

    public int[] getLotPrices() {
        return lotPrices;
    }

    public void setLotPrices(int[] lotPrices) {
        this.lotPrices = lotPrices;
    }

    public int[] getValueOfDiscount() {
        return valueOfDiscount;
    }

    public void setValueOfDiscount(int[] valueOfDiscount) {
        this.valueOfDiscount = valueOfDiscount;
    }

    public int[] getCostBudget() {
        return costBudget;
    }

    public void setCostBudget(int[] costBudget) {
        this.costBudget = costBudget;
    }
}
