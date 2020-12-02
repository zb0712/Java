package exer;

import java.time.LocalDate;

/**
 *
 * 测试SetMeal类的功能
 * @author 石致彬
 * @create 2020-11-22 8:26
 */
public class SetMealTest {
    public static void main(String[] args) {
        //测试构造器
        SetMeal meal1 = new SetMeal("套餐一",16.5,"原味香酥鸡",new Juice("可乐",7, LocalDate.now()));
        SetMeal meal2 = new SetMeal("套餐二",17.5,"蜜汁手扒鸡",new Beer("百威",6,LocalDate.now(),3.7f));
        SetMeal meal3 = new SetMeal("套餐一",18.5,"原味香酥鸡",new Juice("可乐",7, LocalDate.now()));
        //测试equals  套餐名相同即为true
        System.out.println(meal1.equals(meal2));//false
        System.out.println(meal1.equals(meal3));//true
        //测试toString
        System.out.println(meal1.toString());
        //测试get方法
        System.out.println(meal1.getName());
        System.out.println(meal1.getPrice());
        System.out.println(meal1.getDrink());
        System.out.println(meal1.getChickenName());
    }
}
