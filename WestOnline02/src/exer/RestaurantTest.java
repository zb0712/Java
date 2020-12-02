package exer;

import java.util.Scanner;

/**
 * @author 石致彬
 * @create 2020-11-06 14:01
 */
public class RestaurantTest {
    public static void main(String[] args) {
        //构造器
        West2FriedChickenRestaurant restaurant = new West2FriedChickenRestaurant(1000);
        //测试进货方法purchase()
        try {
            for (int i = 0; i < 5; i++) {
                restaurant.purchase();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();//第四次进货时余额不足抛出异常
        }


        //前面进货了3次，每种Drink各30瓶，第31次售空，抛出异常
        for (int i = 0; i < 31; i++) {
            restaurant.saleSetMeal("套餐1");
        }
        for (int i = 0; i < 31; i++) {
            restaurant.saleSetMeal("套餐3");
        }

        System.out.println("*********************");
        restaurant.showMenu();
        System.out.println("请输入要购买的套餐名称：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();//输入套餐2，因为进货时都是过期的雪碧，use时会被删除，因此没有库存会抛出异常
        restaurant.saleSetMeal(str);

        System.out.println("*********************");
        restaurant.showMenu();
        System.out.println("请输入要购买的套餐名称：");
        str = scanner.next();//输入套餐4，因为进货时都是过期的罗斯福10号，use时会被删除，因此没有库存会抛出异常
        restaurant.saleSetMeal(str);

        System.out.println("*********************");
        restaurant.showMenu();
        System.out.println("请输入要购买的套餐名称：");
        str = scanner.next();//输入套餐5，套餐列表中无该套餐，输出对应提示信息
        restaurant.saleSetMeal(str);
    }
}
