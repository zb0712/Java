package exer;

/**
 * 套餐类SetMeal
 * 变量：套餐名（如“套餐1”，“套餐2”等）
 * 套餐价格（double），炸鸡名，
 * 饮料类成员变量（具体是哪种饮料（啤酒还是果汁）取决了实际情况（多态））
 * 方法：覆写toString方法
 *
 *
 * @author 石致彬
 *  2020-11-05 20:48
 */
public class SetMeal {
    private String name;
    private double price;
    private String chickenName;
    private Drinks drink;

    public SetMeal() {
    }

    public SetMeal(String name, double price, String chickenName, Drinks drink) {
        this.name = name;
        this.price = price;
        this.chickenName = chickenName;
        this.drink = drink;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof SetMeal){
            SetMeal setMeal = (SetMeal)obj;
            if (this.name.equals(setMeal.getName())){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Drinks getDrink() {
        return drink;
    }
    public String getChickenName(){
        return chickenName;
    }

    @Override
    public String toString() {
        return  name + ":\t" +
                chickenName + "+" +
                drink.getName() + "\t"+
                "￥" + price ;
    }
}
